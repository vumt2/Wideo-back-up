package cmsc355wideo.wideo;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Ahmed on 10/10/16.
 */

public class SettingsTest extends ActivityInstrumentationTestCase2<Settings> {

    public SettingsTest() {

        super(Settings.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testQualityButtonIsDisplayed() {
        onView(withId(R.id.buttonq))
                .check(matches(isDisplayed()));
    }

    public void testFlashButtonIsDisplayed() {
        onView(withId(R.id.buttonf))
                .check(matches(isDisplayed()));
    }

    public void testStorageButtonIsDisplayed() {
        onView(withId(R.id.buttons))
                .check(matches(isDisplayed()));
    }

    public void testVoiceButtonIsDisplayed() {
        onView(withId(R.id.buttonv))
                .check(matches(isDisplayed()));
    }

    public void testAboutButtonIsDisplayed() {
        onView(withId(R.id.buttona))
                .check(matches(isDisplayed()));
    }

    public void testFlashIsCorrectText() {
        onView(withId(R.id.buttonf))
                .check(matches(withText("flash")));
    }

    public void testQualityIsCorrectText() {
        onView(withId(R.id.buttonq))
                .check(matches(withText("quality")));
    }

    public void testStorageIsCorrectText() {
        onView(withId(R.id.buttons))
                .check(matches(withText("storage")));
    }

    public void testVoiceIsCorrectText() {
        onView(withId(R.id.buttonv))
                .check(matches(withText("voice recognition")));
    }

    public void testAboutIsCorrectText() {
        onView(withId(R.id.buttona))
                .check(matches(withText("about us")));
    }


}
