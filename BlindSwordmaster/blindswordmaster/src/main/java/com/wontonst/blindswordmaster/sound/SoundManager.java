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
    public static final int i_left = R.raw.left;
    public static final int i_right = R.raw.right;
    public static final int i_leftsword = R.raw.leftsword;
    public static final int i_rightsword = R.raw.rightsword;
    private static SoundPool soundPool;
    private static HashMap soundPoolMap;


	
	
    public void playSoundOnce(GameSound sound, Context context){

        if(soundPool == null || soundPoolMap == null){
            load(context);
        }

        float volume = 0.9f;

    	if (sound == GameSound.RIGHT_SLASH)
    	{
            soundPool.play(i_right, volume, volume, 1, 0, 1f);
    	}
    	
    	if (sound == GameSound.LEFT_SLASH)
    	{
            soundPool.play(i_left,volume, volume, 1, 0, 1f);
    	}

        if (sound == GameSound.LEFT_HIT)
        {
            soundPool.play(i_leftsword,volume,volume,1,0,1f);
        }

        if(sound == GameSound.RIGHT_HIT)
        {
            soundPool.play(i_rightsword,volume,volume,1,0,1f);
        }
    }
    //Load all sound assets
    public void load(Context context){
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(3);
        soundPoolMap.put(i_right, soundPool.load(context, R.raw.right, 1) );
        soundPoolMap.put( i_left, soundPool.load(context, R.raw.left, 2) );
        soundPoolMap.put( i_leftsword, soundPool.load(context, R.raw.leftsword, 3) );
        soundPoolMap.put(i_rightsword,soundPool.load(context,R.raw.rightsword,4));

    }

}
