package com.wontonst.blindswordmaster.sound;

import android.R;
import android.media.MediaPlayer;

/**
 * Created by RoyZheng on 2/8/14.
 */
public class SoundManager {
	MediaPlayer right;
	MediaPlayer left;
	
	
    public void playSoundOnce(GameSound sound, Context context){
    	if (sound == GameSound.RIGHT_SLASH)
    	{
    		right.start();
    		right.stop();
    	}
    	
    	if (sound == GameSound.LEFT_SLASH)
    	{
    		left.start();
    		left.stop();
    	}
    }
    //Load all sound assets
    public void load(){
    	right = MediaPlayer.create(getApplicationContext(),R.raw.right);
    	left = MediaPlayer.create(getApplicationContext(), R.raw.left);

    }
}
