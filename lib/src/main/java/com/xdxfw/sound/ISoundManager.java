package com.xdxfw.sound;

import android.media.MediaPlayer;

public interface ISoundManager {

    public void put(String name, String soundName);

    public void remove(String name);

    public void start(String name);

    public void stop(String name);

    public void release();

    public MediaPlayer get(String name);
}
