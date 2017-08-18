package com.android.shadow.views.videoRecording;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.ShadowApp;
import com.android.shadow.utils.FileUtils;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static android.hardware.Camera.CameraInfo.CAMERA_FACING_BACK;
import static android.hardware.Camera.CameraInfo.CAMERA_FACING_FRONT;

/**
 * Created by singhgharjyot on 7/10/2017.
 */
public class CameraUploadActivity extends BaseActivity implements View.OnClickListener, TextureView.SurfaceTextureListener,
        View.OnTouchListener {

    private static final int IMAGE_EDITER = 155;
    SurfaceTexture surfaceTexture;
    ImageView flipImageView,  flashImageView, takePictureImageView;
    TextureView textureView;
    TextView closeBtn;
    Camera camera;
    boolean isFlashOn = false;
    private boolean upCalled = false;
    File imageFile;
    boolean cameraStarted = false/*, cameraIsFront = false*/;
    String tempFileName, PictureFilePath = null;
    private int frontCamera = -1;
    private int rearCamera = -1;
    private int currentCamera = 0;

    //  private ProgressBar photo_saving_progress;


    private int count_time;
    private MediaRecorder media_recorder;
    private boolean isVideoRecording;
    private Timer timer;
    private TextView timerTextView;

    String minutes="00";
    String seconds ="00";
    private FFmpeg ffmpeg;
    @Override
    public void dispose() {
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_camera;
    }

    @Override
    protected void initViews() {
        //DIRECTLY_UPLOADED_SUCEESS = false;
        closeBtn = (TextView) findViewById(R.id.close);
        closeBtn.setOnClickListener(this);


        // photo_saving_progress = (ProgressBar) findViewById(R.id.photo_saving_progress);

        takePictureImageView = (ImageView) findViewById(R.id.picture);
        takePictureImageView.setOnClickListener(this);
        flipImageView = (ImageView) findViewById(R.id.flip);
        flipImageView.setImageResource(R.drawable.flipcamera);
        flashImageView = (ImageView) findViewById(R.id.flash);
        /*  if (camera == null)
            camera = Camera.open(0);
        camera.setDisplayOrientation(90);*/
        timerTextView = (TextView) findViewById(R.id.timer);
        textureView = (TextureView) findViewById(R.id.textureView);
        textureView.setSurfaceTextureListener(this);

        takePictureImageView.setOnTouchListener(this);
        flashImageView.setOnClickListener(this);
        flipImageView.setOnClickListener(this);


    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        surfaceTexture = surface;

        Camera.CameraInfo camInfo = new Camera.CameraInfo();
        for (int camId = 0; camId < Camera.getNumberOfCameras(); camId++) {
            Camera.getCameraInfo(camId, camInfo);
            if (camInfo.facing == CAMERA_FACING_FRONT) {
                frontCamera = camId;
            }
            if (camInfo.facing == CAMERA_FACING_BACK) {
                rearCamera = camId;
            }
        }
        currentCamera = rearCamera;
        camera = Camera.open(currentCamera);
        //camera.open(0);
        //if (isPreviewRunning) {
        try {
            camera.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //}
        FileUtils.setCameraDisplayOrientation(this, currentCamera, camera);
        textureView.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        startPreview();
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
        return true;
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }


    private void startPreview() {
        try {

            if (camera == null) {
                camera = Camera.open(currentCamera);
                FileUtils.setCameraDisplayOrientation(this, currentCamera, camera);
            }
            camera.setPreviewTexture(surfaceTexture);
            camera.startPreview();

            takePictureImageView.setImageResource(R.drawable.ic_camerabutton);
            flipImageView.setImageResource(R.drawable.flipcamera);
            flipImageView.setVisibility(View.VISIBLE);

            flashImageView.setVisibility(View.VISIBLE);

            cameraStarted = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                ShadowApp.recordedVideoPath ="";
                finish();
                break;
            case R.id.flash:
                if (isFlashOn == true) {
                    FlashModeOff();
                    isFlashOn = false;
                } else {
                    FlashModeOn();
                    isFlashOn = true;
                }
                break;
            case R.id.flip:
                flipCamera();
                break;

            default:
                break;
        }
    }
    private void flipCamera() {
        if (currentCamera == frontCamera && rearCamera != -1) {
            if (camera != null) {
                camera.stopPreview();
                camera.release();
                camera = null;
            }
            camera = Camera.open(rearCamera);
            currentCamera = rearCamera;
            FileUtils.setCameraDisplayOrientation(this, currentCamera, camera);//setCameraOrientation(mWidth, mHeight);
            //textureView.setLayoutParams(new RelativeLayout.LayoutParams(mWidth, mHeight));
            startPreview();
        } else if (frontCamera != -1) {
            if (camera != null) {
                camera.stopPreview();
                camera.release();
                camera = null;
            }
            camera = Camera.open(frontCamera);
            FlashModeOff();
            isFlashOn = false;
            currentCamera = frontCamera;
            FileUtils.setCameraDisplayOrientation(this, currentCamera, camera);//setCameraOrientation(mWidth, mHeight);
            //textureView.setLayoutParams(new RelativeLayout.LayoutParams(mWidth, mHeight));
            startPreview();
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Float dx = 0.0f;
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                v.animate().translationX(0).setDuration(100).start();
                takePictureImageView.setImageResource(R.drawable.ic_camerabutton);
                if(isFlashOn == true){
                    isFlashOn = false;
                    FlashModeOff();
                }

                flashImageView.setVisibility(View.VISIBLE);
                closeBtn.setVisibility(View.VISIBLE);
                flipImageView.setVisibility(View.VISIBLE);
                if (isVideoRecording ) {
                    stopTimer();
                }
                break;

            case MotionEvent.ACTION_DOWN:
                try {

                    recordVideo();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("IO exce--",e.getMessage());

                }
                /*else if (btnMode.equals("camera")) {
                    upCalled = false;
                    setCaptureTiming();
                }*/
                break;

            case MotionEvent.ACTION_CANCEL:
                Toast.makeText(this, "action cancel", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private void stopTimer() {
        try {
            timer.cancel();
            timer = null;
            if (count_time <= 10) {
                timerTextView.setText("00:00");
                stopVideoRecording(false);
            }
            if (count_time >= 11) {
                stopVideoRecording(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private void setTiming() {
        try {
            if (timer == null) {
                timerTextView.setVisibility(View.VISIBLE);
                timerTextView.setText("00:00");
                count_time = 0;
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        count_time++;
                        CameraUploadActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(count_time<=9){
                                    minutes = "00";
                                    seconds = "0"+count_time;
                                }else if(count_time>9 && count_time<60){
                                    minutes="00";
                                    seconds = String.valueOf(count_time) ;
                                    if(count_time == 59) {

                                        timer.cancel();
                                        timer = null;
                                        stopVideoRecording(true);
                                    }
                                }
                                timerTextView.setText(minutes +":"+seconds);

                              /*  if (count_time == 59) {
                                    timerTextView.setText("00:" + count_time);
                                    timer.cancel();
                                    timer = null;
                                    stopVideoRecording(true);
                                } else {
                                    timerTextView.setText("00:0" + count_time);
                                }*/
                            }
                        });
                    }
                }, 0, 1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopVideoRecording(boolean flag) {
        try {
            count_time = 0;
            if (flag == false) {
                Utilities.showlongToast(CameraUploadActivity.this, "Video length should be more than 10 seconds");
                media_recorder.stop();
                media_recorder.release();
                timerTextView.setVisibility(View.VISIBLE);
                takePictureImageView.setImageResource(R.drawable.ic_camerabutton);
                File file = new File(ShadowApp.recordedVideoPath);
                boolean deleted = file.delete();
                ShadowApp.recordedVideoPath = "";
                //Camera.Lock();

                if(isFlashOn == true){
                    isFlashOn = false;
                    FlashModeOff();
                }

                flashImageView.setVisibility(View.VISIBLE);
                closeBtn.setVisibility(View.VISIBLE);
                flipImageView.setVisibility(View.VISIBLE);
            } else {
                if (media_recorder != null)//&& isVideoRecording == true)
                {
                    media_recorder.stop();
                    media_recorder.release();
                    media_recorder = null;
                    //isVideoRecording = false;

                    takePictureImageView.setImageResource(R.drawable.ic_camerabutton);
                    timerTextView.setVisibility(View.VISIBLE);
                    timerTextView.setText("00:00");
                    //pass intent for recordplay with video path
                    if (ShadowApp.recordedVideoPath == null || ShadowApp.recordedVideoPath.equals("")) {
                        return;
                    }else
                    {
                        Intent intent = new Intent(this, RecordedVideoPlayActivity.class);
                        //intent.putExtra("profile_response", profileResponse);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FlashModeOn() {
        try {
            if (currentCamera == frontCamera) {
                flashImageView.setImageResource(R.drawable.noflash);
                isFlashOn = false;
            } else {
                //chng to flash image
                flashImageView.setImageResource(R.drawable.circle);
                Camera.Parameters parameters = camera.getParameters();

                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void FlashModeOff() {
        try {
            flashImageView.setImageResource(R.drawable.noflash);
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recordVideo() throws IOException {
        createDirInSdCard();
        media_recorder = new MediaRecorder();
        camera.unlock();
        media_recorder.setCamera(camera);
        // set for record voice as well as music player voice
        media_recorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        //set for record voice
        //media_recorder.SetAudioSource(AudioSource.Camcorder);
        media_recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        CamcorderProfile cpLow = CamcorderProfile.get(CamcorderProfile.QUALITY_LOW);
        media_recorder.setProfile(cpLow);
        if (ShadowApp.recordedVideoPath == null || ShadowApp.recordedVideoPath.equals("")) {
            return;
        }
        media_recorder.setOutputFile(ShadowApp.recordedVideoPath);
        if (currentCamera == frontCamera) {
            media_recorder.setOrientationHint(270);
        } else {
            media_recorder.setOrientationHint(90);
        }

        media_recorder.setMaxDuration(60000);
        //media_recorder.setPreviewDisplay(textureView.getSurfaceTexture());//SetPreviewDisplay(surface.Holder.Surface);
        media_recorder.prepare();
        media_recorder.start();
        setTiming();
        isVideoRecording = true;
        takePictureImageView.setImageResource(R.drawable.play_video_icon);
        closeBtn.setVisibility(View.INVISIBLE);
        flipImageView.setVisibility(View.INVISIBLE);
        flashImageView.setVisibility(View.INVISIBLE);
        cameraStarted = false;
    }


    private void createDirInSdCard() {
        // making folder to store videos (Directory)
        File rootPath = Environment.getExternalStorageDirectory();
        File savingFile = new File(rootPath + "/Android/data/com.Android.Ten/Videos/");
        if (!savingFile.exists()) {
            savingFile.mkdir();
        }
        String date_time = System.currentTimeMillis() + "";// UtilitiesClass.GetCurrentMilliseconds().ToString();
        tempFileName = "tempid" + "_" + date_time;
        ShadowApp.recordedVideoPath = savingFile + "/" + tempFileName + ".mp4";

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }



}
