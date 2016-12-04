package cmsc355wideo.wideo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

public class CameraIntentUnitTest extends ActivityUnitTestCase<MainActivity> {
    public CameraIntentUnitTest(){
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testCameraIntent() throws Exception{
        final Intent camera = new Intent(getInstrumentation().getTargetContext(), CameraActivity.class);
        startActivity(camera, null, null);
    }
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
