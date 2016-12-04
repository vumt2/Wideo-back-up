package cmsc355wideo.wideo;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

public class FlashAndQualityIntentTest extends ActivityUnitTestCase<Settings> {
    public FlashAndQualityIntentTest(){
        super(Settings.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testFlashIntent(){
        final Intent flash = new Intent(getInstrumentation().getTargetContext(), Flash.class);
        startActivity(flash, null, null);
    }

    @UiThreadTest
    public void testQualityIntent(){
        final Intent quality = new Intent(getInstrumentation().getTargetContext(), Quality.class);
        startActivity(quality, null, null);
    }
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
