package cmsc355wideo.wideo;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class CameraActivity extends Activity {
    private Camera myCamera;
    private CameraPreview myPreview;
    private MediaRecorder myMediaRecorder;
    private boolean isRecording = false;
    public static final int MEDIA_VIDEO = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_preview);

        myCamera = getCameraInstance();
        myPreview = new CameraPreview(this, myCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(myPreview);
        ImageButton record = (ImageButton) findViewById(R.id.button_capture);
        final TransitionDrawable drawable = (TransitionDrawable) record.getDrawable();
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRecording) {
                    myMediaRecorder.stop();
                    releaseMediaRecorder();
                    myCamera.lock();
                    drawable.reverseTransition(0);
                    isRecording = false;
                } else {
                    if (prepareVideoRecorder()) {
                        myMediaRecorder.start();
                        drawable.startTransition(0);
                        isRecording = true;
                    } else {
                        releaseMediaRecorder();
                    }
                }
            }
        });

    }

    public void onPause() {
        super.onPause();
        releaseMediaRecorder();
        cameraRelease();
    }

    public void onResume() {
        super.onResume();
        if (myCamera == null) {
            myCamera = getCameraInstance();
            myPreview = new CameraPreview(this, myCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(myPreview);
        }
    }

    private void cameraRelease() {
        if (myCamera != null) {
            myCamera.release();
            myCamera = null;
        }
    }

    public static Camera getCameraInstance() {
        Camera cam = null;
        try {
            cam = Camera.open();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cam;
    }

    private boolean prepareVideoRecorder() {
        myMediaRecorder = new MediaRecorder();
        myCamera.unlock();
        myMediaRecorder.setCamera(myCamera);

        myMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
        myMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

        myMediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));
        if (getOutputMediaFile(MEDIA_VIDEO) == null) {
            Log.d(TAG, "Cannot get output file.");
            return false;
        }
        myMediaRecorder.setOutputFile(getOutputMediaFile(MEDIA_VIDEO).toString());

        myMediaRecorder.setPreviewDisplay(myPreview.getHolder().getSurface());

        try {
            myMediaRecorder.prepare();
        } catch (IllegalStateException ex) {
            Log.d(TAG, "IllegalStateException preparing MediaRecorder: " + ex.getMessage());
            releaseMediaRecorder();
            return false;
        } catch (IOException ex) {
            Log.d(TAG, "IOException preparing MediaRecorder: " + ex.getMessage());
            releaseMediaRecorder();
            return false;
        }
        return true;
    }

    private void releaseMediaRecorder() {
        if (myMediaRecorder != null) {
            myMediaRecorder.reset();
            myMediaRecorder.release();
            myMediaRecorder = null;
            myCamera.lock();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    private Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private File getOutputMediaFile(int type) {
        if (!isExternalStorageWritable()) {
            return null;
        }
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "wideo");
        if (! mediaStorageDir.exists()) {
            if (! mediaStorageDir.mkdirs()) {
                Log.d("wideo", "failed to create directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        File mediaFile;
        if (type == MEDIA_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath()
                    + File.separator + "VID_" + timeStamp + ".mp4");
        } else {
            return null;

        }
        return mediaFile;
    }

}