package cmsc355wideo.wideo;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class SettingIntent {
    @Rule
    public IntentsTestRule<MainActivity> mainActivityRule = new IntentsTestRule<>(MainActivity.class);
    @Test
    public void settingIntent(){
        onView(withId(R.id.button3)).perform(click());
        intended(toPackage("cmsc355wideo.wideo"));
    }
}
