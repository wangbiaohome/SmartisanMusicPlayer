package com.yibao.music.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.yibao.music.model.CountdownBean;
import com.yibao.music.util.Constants;
import com.yibao.music.util.RxBus;
import com.yibao.music.util.StringUtil;

/**
 * @ Author: Luoshipeng
 * @ Name:   CountdownService
 * @ Email:  strangermy98@gmail.com
 * @ Time:   2019/1/2/ 22:49
 * @ Des:    倒计时服务
 */
public class CountdownService extends Service {

    private MusicTimer mMusicTimer;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long countdownTime = intent.getLongExtra(Constants.COUNTDOWN_TIME, 0);
        mMusicTimer = new MusicTimer(countdownTime, 1000);
        mMusicTimer.start();
        return START_NOT_STICKY;
    }


    private class MusicTimer extends CountDownTimer {
        private MusicTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String contdownTime = StringUtil.parseDuration((int) millisUntilFinished);
            RxBus.getInstance().post(new CountdownBean(contdownTime));
        }

        @Override
        public void onFinish() {
            cancel();
            sendColseMusicBroadcast();
            stopSelf();
        }

        private void sendColseMusicBroadcast() {
            Intent intent = new Intent(Constants.ACTION_MUSIC);
            intent.putExtra(Constants.BUTTON_ID, Constants.COUNTDOWN_fINISH);
            sendBroadcast(intent);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMusicTimer != null) {
            mMusicTimer.cancel();
            mMusicTimer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
