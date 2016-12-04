package cmsc355wideo.wideo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

public class DeleteIntentUnitTest extends ActivityUnitTestCase<MainActivity> {
    public DeleteIntentUnitTest(){
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testDeleteIntent(){
        final Intent delete = new Intent();
        delete.setType("video/*");
        delete.setAction(Intent.ACTION_GET_CONTENT);
        startActivity(delete, null, null);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
