package cmsc355wideo.wideo;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class CameraEspressoTest extends ActivityInstrumentationTestCase2<CameraActivity> {
    public CameraEspressoTest(){
        super(CameraActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }
    public void testCameraPreviewIsDisplayed(){
        onView(withId(R.id.camera_preview))
                .check(matches(isDisplayed()));
    }
    public void testCaptureButtonIsDisplayed(){
        onView(withId(R.id.button_capture))
                .check(matches(isDisplayed()));
    }

}
