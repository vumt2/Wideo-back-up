package cmsc355wideo.wideo;

import org.junit.Test;
import android.hardware.Camera;
import android.os.Environment;

import static org.junit.Assert.*;

/**
 * Created by mantvu on 11/24/2016.
 */
public class CameraActivityTest {

    Camera myCamera;

    protected void setUp() throws Exception {
        getCameraInstance();
    }

    @Test
    public void onPause() throws Exception {
        cameraRelease();
        assertTrue(myCamera == null);
    }

    private void cameraRelease() throws Exception {
        if (myCamera != null) {
            myCamera.release();
            myCamera = null;
        }
    }

    public void getCameraInstance() throws Exception {
        myCamera = Camera.open();
    }

}