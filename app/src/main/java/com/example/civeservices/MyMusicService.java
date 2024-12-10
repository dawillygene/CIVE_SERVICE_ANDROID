package com.example.civeservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class MyMusicService extends Service {

    MediaPlayer music;

    public MyMusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        music = MediaPlayer.create(MyMusicService.this, Settings.System.DEFAULT_RINGTONE_URI);
        music.setLooping(true);
        music.start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        music.stop();

    }
}