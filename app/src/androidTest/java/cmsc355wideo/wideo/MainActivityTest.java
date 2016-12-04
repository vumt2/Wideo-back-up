package cmsc355wideo.wideo;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest(){
        super(MainActivity.class);
    }
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }
    public void testRecordButtonIsDisplayed(){
        onView(withId(R.id.button))
                .check(matches(isDisplayed()));
    }
    public void testGalleryButtonIsDisplayed(){
        onView(withId(R.id.button2))
                .check(matches(isDisplayed()));
    }
    public void testSettingsButtonIsDisplayed(){
        onView(withId(R.id.button3))
                .check(matches(isDisplayed()));
    }
    public void testFriendlistButtonIsDisplayed(){
        onView(withId(R.id.button5))
                .check(matches(isDisplayed()));
    }
    public void testQuitButtonIsDisplayed(){
        onView(withId(R.id.button4))
                .check(matches(isDisplayed()));
    }

    public void testSettingsButtonIsCorrectText() {
        onView(withId(R.id.button3))
                .check(matches(withText("Settings")));
    }

    public void testGalleryButtonIsCorrectText() {
        onView(withId(R.id.button2))
                .check(matches(withText("Play Video")));
    }

    public void testRecordIsCorrectText() {
        onView(withId(R.id.button))
                .check(matches(withText("")));
    }

    public void testFriendlistButtonIsCorrectText() {
        onView(withId(R.id.button5))
                .check(matches(withText("Invite Friend")));
    }

    public void testQuitButtonIsCorrectText() {
        onView(withId(R.id.button4))
                .check(matches(withText("Exit")));
    }

// Third iteration tests
    public void testDeleteButtonIsDisplayed(){
        onView(withId(R.id.buttonDelete))
            .check(matches(isDisplayed()));
    }

    public void testDeleteButtonIsCorrectText(){
        onView(withId(R.id.buttonDelete))
                .check(matches(withText("Delete")));
    }

    public void testShareButtonIsDisplayed(){
        onView(withId(R.id.sharebutton))
                .check(matches(isDisplayed()));
    }

    public void testShareButtonIsCorrectText(){
        onView(withId(R.id.sharebutton))
                .check(matches(withText("Share Video")));
    }

    public void testMapButtonIsDisplayed(){
        onView(withId(R.id.button6))
                .check(matches(isDisplayed()));
    }

    public void testMapButtonIsCorrectText(){
        onView(withId(R.id.button6))
                .check(matches(withText("Map")));
    }

}
