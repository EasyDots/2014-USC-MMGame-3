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
    public static final int i_left = R.raw.left;
    public static final int i_right = R.raw.right;
    public static final int i_leftsword = R.raw.leftsword;
    public static final int i_rightsword = R.raw.rightsword;
    public static final int i_caliberate = R.raw.caliberate;
    public static final int i_move_forward = R.raw.move_forward;
    public static final int i_hit = R.raw.hit;
    private static SoundPool soundPool;
    private static HashMap soundPoolMap;

    public SoundManager(Context c)
    {
        this.c = c;
    }


	
	
    public void playSoundOnce(GameSound sound){

        if(soundPool == null || soundPoolMap == null){
            load(c);
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

        if(sound == GameSound.CALIBERATE)
        {
            soundpool.play(i_caliberate, volume, volume, 1,0,1f);
        }

        if(sound == GameSound.MOVE_FORWARD)
        {
            soundpool.play(i_move_forward,volume, volume, 1,0,1f);
        }

        if(sound == GameSound.HIT)
        {
            soundpool.play(i_hit, volume, volume, 1, 0, 1f);
        }
    }
    //Load all sound assets
    public void load(){
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(7);
        soundPoolMap.put(i_right, soundPool.load(c, R.raw.right, 1) );
        soundPoolMap.put( i_left, soundPool.load(c, R.raw.left, 2) );
        soundPoolMap.put( i_leftsword, soundPool.load(c, R.raw.leftsword, 3) );
        soundPoolMap.put(i_rightsword,soundPool.load(c,R.raw.rightsword,4));
        soundPoolMap.put(i_caliberate,soundPool.load(c,R.raw.caliberate,5));
        soundPoolMap.put(i_move_forward,soundPool.load(c,R.raw.move_forward,6));
        soundPollMap.put(i_hit,soundPool.load(c,R.raw.hit,7));

    }

}
