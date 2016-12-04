package cmsc355wideo.wideo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

public class ShareActivityTest extends ActivityUnitTestCase<MainActivity> {
    public ShareActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testShare() throws Exception{
        final Intent videoToShare = new Intent();
        videoToShare.setType("video/*");
        videoToShare.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(Intent.createChooser(videoToShare,"Select"),null, null);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
