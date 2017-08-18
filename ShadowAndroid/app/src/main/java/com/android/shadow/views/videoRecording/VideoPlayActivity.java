package com.android.shadow.views.videoRecording;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.VideoView;

import com.android.shadow.R;
import com.android.shadow.views.core.BaseActivity;

public class VideoPlayActivity extends BaseActivity implements View.OnClickListener {

    private VideoView mVideoView;
    private ProgressDialog progDailog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_play;
    }

    @Override
    protected void initViews() {
        final String videoPath = getIntent().getStringExtra("video_url");
        mVideoView = (VideoView) findViewById(R.id.video_view);

        findViewById(R.id.iv_back).setOnClickListener(this);
        showDialog();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                mVideoView.setVideoURI(Uri.parse(videoPath));
                mVideoView.requestFocus();
                mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                            @Override
                            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        hideDialog();
                                    }
                                });
                            }
                        });

                    }
                });

                mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                hideDialog();
                                finish();
                            }
                        });

                        return false;
                    }
                });
                mVideoView.start();
            }
        });
    }

    @Override
    public void dispose() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}