package cmsc355wideo.wideo;

import static android.content.ContentValues.TAG;

import android.content.Context;

import android.hardware.Camera;

import android.util.Log;

import android.view.SurfaceHolder;

import android.view.SurfaceView;

import java.io.IOException;




public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback  {
    private SurfaceHolder myHolder;
    private Camera myCamera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        myCamera = camera;


        myHolder = getHolder();
        myHolder.addCallback(this);
        myHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {

        try {
            myCamera.setPreviewDisplay(holder);
            myCamera.startPreview();
        } catch (IOException ex) {
            Log.d(TAG, "Error setting camera preview: " + ex.getMessage());
        }

    }

    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        if (myHolder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            myCamera.stopPreview();
        } catch (Exception ex) {
            Log.d(TAG, "Error stopping camera preview" + ex.getMessage());
        }

        // start preview with new settings
        try {
            myCamera.setPreviewDisplay(myHolder);
            myCamera.startPreview();

        } catch (Exception ex) {
            Log.d(TAG, "Error starting camera preview: " + ex.getMessage());
        }
    }

}

