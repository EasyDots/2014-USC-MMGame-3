package com.wontonst.blindswordmaster.sound;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.wontonst.blindswordmaster.R;

import java.util.HashMap;


/**
 * Created by RoyZheng on 2/8/14.
 */
public class SoundManager {
	SoundPool right;
	SoundPool left;
    Context c;
    public static final int i_left = R.raw.left1;
    public static final int i_right = R.raw.right1;
    public static final int i_leftsword = R.raw.leftsword1;
    public static final int i_rightsword = R.raw.rightsword1;
    public static final int i_caliberate = R.raw.caliberate1;
    public static final int i_move_forward = R.raw.forward1;
    public static final int i_hit = R.raw.hit1;
    public static final int i_center= R.raw.center1;
    private static SoundPool soundPool;
    private static HashMap soundPoolMap;

    public SoundManager(Context c)
    {
        this.c = c;
    }


	
	
    public void playSoundOnce(GameSound sound){

        if(soundPool == null || soundPoolMap == null){
            load();
            System.out.print("Not finished loading yet");
        }

        float volume = 1f;

    	if (sound == GameSound.RIGHT_SLASH)
    	{
            soundPool.play(1, volume, volume, 1, 0, 1f);
    	}
    	
    	if (sound == GameSound.LEFT_SLASH)
    	{
            soundPool.play(2,volume, volume, 1, 0, 1f);
    	}

        if (sound == GameSound.LEFT_HIT)
        {
            soundPool.play(3,volume,volume,1,0,1f);
        }

        if(sound == GameSound.RIGHT_HIT)
        {
            soundPool.play(4,volume,volume,1,0,1f);
        }

        if(sound == GameSound.CALIBERATE)
        {
            soundPool.play(5, volume, volume, 1,0,1f);

        }

        if(sound == GameSound.MOVE_FORWARD)
        {
            soundPool.play(6,volume, volume, 1,0,1f);
        }

        if(sound == GameSound.HIT)
        {
            soundPool.play(7, volume, volume, 1, 0, 1f);
        }

        if(sound == GameSound.CENTER)
        {
            soundPool.play(8, volume, volume, 1, 0, 1f);
        }


    }
    //Load all sound assets
    public void load(){
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(8);
        soundPoolMap.put(i_right, soundPool.load(c, R.raw.right1, 1) );
        soundPoolMap.put( i_left, soundPool.load(c, R.raw.left1, 2) );
        soundPoolMap.put( i_leftsword, soundPool.load(c, R.raw.leftsword1, 3) );
        soundPoolMap.put(i_rightsword,soundPool.load(c,R.raw.rightsword1,4));
        soundPoolMap.put(i_caliberate,soundPool.load(c,R.raw.caliberate1,5));
        soundPoolMap.put(i_move_forward,soundPool.load(c,R.raw.forward1,6));
        soundPoolMap.put(i_hit,soundPool.load(c,R.raw.hit1,7));
        soundPoolMap.put(i_center, soundPool.load(c,R.raw.center1,8));

    }

}
