package com.xdxfw.sound;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import com.xdxfw.core.ScreenAdapter;
import java.util.HashMap;
import java.util.Map;

public class SoundManager implements ISoundManager {

    private Map<String, MediaPlayer> sounds;
    private ScreenAdapter context;

    public SoundManager(ScreenAdapter context) {
        sounds = new HashMap<>();
        this.context = context;
    }

    @Override
    public void put(String name, String soundName) {
        MediaPlayer player = new MediaPlayer();
        try {
            AssetManager assets = context.getView().getContext().getAssets();
            AssetFileDescriptor afd = assets.openFd(soundName);
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sounds.put(name, player);
    }

    @Override
    public void remove(String name) {
        sounds.get(name).stop();
        sounds.remove(name);
    }

    @Override
    public void start(String name) {
        try {
            sounds.get(name).prepare();
        } catch (Exception err) {
            err.printStackTrace();
        }
        sounds.get(name).start();
    }

    public void stop(String name) {
        sounds.get(name).stop();
    }

    @Override
    public void release() {
        for (String p : sounds.keySet()) {
            sounds.get(p).stop();
            sounds.get(p).release();
        }
    }

    @Override
    public MediaPlayer get(String name) {
        return sounds.get(name);
    }
}
