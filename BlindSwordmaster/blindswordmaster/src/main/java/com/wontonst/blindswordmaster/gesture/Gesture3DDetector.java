package com.wontonst.blindswordmaster.gesture;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by jack on 2/8/14.
 */
public class Gesture3DDetector implements SensorEventListener {
    private static final int RATE = SensorManager.SENSOR_DELAY_GAME;

    private SensorManager sensorManager;
    private Sensor linearAccelerationSensor;
    private Sensor rotationVectorSensor;

    public Gesture3DDetector(Context context) {
        sensorManager = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        linearAccelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        Log.i("Gesture3DDetector", "created");
    }

    public void startDetecting() {
        Log.i("Gesture3DDetector", "started");
        sensorManager.registerListener(this, linearAccelerationSensor, RATE);
        sensorManager.registerListener(this, rotationVectorSensor, RATE);
    }

    public void stopDetecting() {
        Log.i("Gesture3DDetector", "stopped");
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.i("Gesture3DDetector: " + sensorEvent.sensor.getName(), Arrays.toString(sensorEvent.values));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // Method intentionally left blank
    }
}
