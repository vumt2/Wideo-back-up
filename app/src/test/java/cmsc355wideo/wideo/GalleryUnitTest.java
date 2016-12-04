package cmsc355wideo.wideo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

public class GalleryUnitTest extends ActivityUnitTestCase<MainActivity> {
    public GalleryUnitTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testGallery() throws Exception{
        final Intent gallery = new Intent();
        gallery.setType("video/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(Intent.createChooser(gallery,"Select"),null, null);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
