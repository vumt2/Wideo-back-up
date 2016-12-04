package cmsc355wideo.wideo;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cmsc355wideo.wideo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ShareTest {

    @Rule
    public ActivityTestRule<cmsc355wideo.wideo.MainActivity> mActivityTestRule = new ActivityTestRule<>(cmsc355wideo.wideo.MainActivity.class);

    @Test
    public void shareTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.button6), withText("maps"), isDisplayed()));
        appCompatButton.perform(click());

        pressBack();

        ViewInteraction button = onView(
                allOf(withId(R.id.sharebutton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.sharebutton), withText("Share video"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.sharebutton), withText("Share video"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button6), withText("maps"), isDisplayed()));
        appCompatButton4.perform(click());

        pressBack();

        ViewInteraction button2 = onView(
                allOf(withId(R.id.button6),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.button6), withText("maps"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(android.R.id.button1),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.map),
                                        0),
                                1),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.sharebutton), withText("Share video"), isDisplayed()));
        appCompatButton6.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
