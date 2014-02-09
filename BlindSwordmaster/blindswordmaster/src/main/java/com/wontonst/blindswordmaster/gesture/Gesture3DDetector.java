package com.wontonst.blindswordmaster.gesture;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.google.common.collect.EvictingQueue;
import com.wontonst.blindswordmaster.game.constants.CombatConstant;
import com.wontonst.blindswordmaster.game.controller.CommandVerifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by jack on 2/8/14.
 */
public class Gesture3DDetector implements SensorEventListener {
    private static final String TAG = "Gesture3DDetector";
    private static final int SAMPLING_RATE = SensorManager.SENSOR_DELAY_GAME;
    private static final float GRAVITY_THRESHOLD = SensorManager.STANDARD_GRAVITY / 2.0f;
    private static int[] sensorTypes =  { Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_ROTATION_VECTOR, Sensor.TYPE_GRAVITY };
    private static final float MOVEMENT_THRESHOLD = 2.0f;

    private SensorManager sensorManager;
    private CommandVerifier commandVerifier;
    private Map<Sensor, Integer> sensorAccuracies = new HashMap<Sensor, Integer>(3);

    private boolean calibrating = false;
    private float[] referenceMatrix;
    private int phoneOrientation = 1;
    private EvictingQueue<Gesture3D> lastMovements = EvictingQueue.create(9);

    public Gesture3DDetector(Context context, CommandVerifier commandVerifier) {
        sensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        this.commandVerifier = commandVerifier;

        for (int type : sensorTypes) {
            sensorAccuracies.put(sensorManager.getDefaultSensor(type),
                    SensorManager.SENSOR_STATUS_UNRELIABLE);
        }
        Log.i(TAG, "Created");
    }

    public void startDetecting() {
        for (Sensor sensor : sensorAccuracies.keySet()) {
            sensorManager.registerListener(this, sensor, SAMPLING_RATE);
        }
        Log.i(TAG, "Detection started");
    }

    public void calibrate() {
        calibrating = true;
    }

    public void stopDetecting() {
        sensorManager.unregisterListener(this);
        Log.i(TAG, "Detection stopped");
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                int newOrientation;
                if (event.values[2] >= GRAVITY_THRESHOLD) {
                    newOrientation = 1;
                } else if (event.values[2] <= -GRAVITY_THRESHOLD) {
                    newOrientation = -1;
                } else {
                    newOrientation = 0;
                }
                if (newOrientation != phoneOrientation) {
                    Log.i(TAG, "Orientation changed: " + newOrientation);
                    phoneOrientation = newOrientation;
                }
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                float[] rotationMatrix = new float[16];
                SensorManager.getRotationMatrixFromVector(rotationMatrix,
                        event.values);
                if (calibrating) {
                    referenceMatrix = rotationMatrix;
                    calibrating = false;
                }
                break;
            case Sensor.TYPE_LINEAR_ACCELERATION:
                float[] a = event.values.clone();
                Set<Gesture3D> gestures = accelerationsToGesture3Ds(a, phoneOrientation);
                if (gestures.isEmpty()) {
                } else {
                    for (Gesture3D gesture : gestures) {
                        lastMovements.add(gesture);
                    }
                }

                Gesture3D actualGesture = null;
                if (lastMovements.remainingCapacity() == 0) {
                    // Make sure lastMovements has all of the same gesture
                    Gesture3D foo = null;
                    Iterator<Gesture3D> itr = lastMovements.iterator();
                    while (itr.hasNext()) {
                        Gesture3D bar = itr.next();
                        if (foo == null) {
                            foo = bar;
                        } else if (foo != bar) {
                            break;
                        } else if (!itr.hasNext()) {
                            actualGesture = bar;
                        }
                    }
                }
                if (actualGesture != null && gestures.contains(actualGesture)) {
                    Log.i(TAG, actualGesture.toString());
                    CombatConstant action;
                    switch (actualGesture) {
                        case SLASH_LEFT:
                            action = CombatConstant.SLASH_LEFT;
                            break;
                        case SLASH_RIGHT:
                            action = CombatConstant.SLASH_RIGHT;
                            break;
                        case SLASH_UP:
                            action = CombatConstant.SLASH_UP;
                            break;
                        case SLASH_DOWN:
                            action = CombatConstant.SLASH_DOWN;
                            break;
                        case BLOCK_LEFT:
                            action = CombatConstant.BLOCK_LEFT;
                            break;
                        case BLOCK_RIGHT:
                            action = CombatConstant.BLOCK_RIGHT;
                            break;
                        case BLOCK_UP:
                            action = CombatConstant.BLOCK_UP;
                            break;
                        case BLOCK_DOWN:
                            action = CombatConstant.BLOCK_DOWN;
                            break;
                        default:
                            action = CombatConstant.IDLE;
                    }
                    commandVerifier.combatActionDetected(action);
                }
                break;
        }
    }

    private static Set<Gesture3D> accelerationsToGesture3Ds(float[] acceleration, int orientation) {
        Set<Gesture3D> gestures = new HashSet<Gesture3D>(2);
        int[] ternary = analogToBalancedTernaryFilter(acceleration, MOVEMENT_THRESHOLD);
        if (orientation != 0) {
            // Slash orientation
            int[] adjusted = scalarMultiplication(orientation, ternary);
            if (adjusted[0]  > 0) {
                gestures.add(Gesture3D.SLASH_RIGHT);
            } else if (ternary[0] < 0) {
                gestures.add(Gesture3D.SLASH_LEFT);
            }
            if (adjusted[1] > 0) {
                gestures.add(Gesture3D.SLASH_UP);
            } else if (ternary[1] < 0) {
                gestures.add(Gesture3D.SLASH_DOWN);
            }
        } else {
            // Block orientation
            if (ternary[0] > 0) {
                gestures.add(Gesture3D.BLOCK_RIGHT);
            } else if (ternary[0] < 0) {
                gestures.add(Gesture3D.BLOCK_LEFT);
            }
            if (ternary[1] > 0) {
                gestures.add(Gesture3D.BLOCK_UP);
            } else if (ternary[1] < 0) {
                gestures.add(Gesture3D.BLOCK_DOWN);
            }
        }
        return gestures;
    }

    private static int[] scalarMultiplication(int scalar, int[] vector) {
        int[] product = new int[vector.length];
        for (int i = 0; i < vector.length; ++i) {
            product[i] = scalar * vector[i];
        }
        return product;
    }

    private static int[] analogToBalancedTernaryFilter(float[] analog, float threshold) {
        int[] ternary = new int[analog.length];

        for (int i = 0; i < analog.length; ++i) {
            if (analog[i] > threshold) {
                ternary[i] = 1;
            } else if (analog[i] < -threshold) {
                ternary[i] = -1;
            }
            // else analog[i] is left as 0
        }
        return ternary;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        sensorAccuracies.put(sensor, accuracy);
    }

    private class SensorData {
        private final Sensor sensor;
        private int accuracy;

        private SensorData(Sensor sensor) {
            this.sensor = sensor;
            accuracy = SensorManager.SENSOR_STATUS_UNRELIABLE;
        }
    }
}
