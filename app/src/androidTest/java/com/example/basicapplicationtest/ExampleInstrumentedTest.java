package com.example.basicapplicationtest;


import static androidx.test.core.graphics.BitmapStorage.writeToTestStorage;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.screenshot.ViewInteractionCapture.captureToBitmap;
import java.io.IOException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public TestName nameRule = new TestName();

    @Test
    public void verifyHeaderText(){
        onView(withText("Select Preferred Coffee")).check(matches(isDisplayed()));
    }

    @Test
    public void selectEspressoAndVerifyText() {
        onView(withId(R.id.espresso)).perform(click());
        onView(withId(R.id.preferred_coffee)).check(matches(withText("Espresso")));
        }

    @Test
    public void selectCappicinoAndVerifyText() {
        onView(withId(R.id.cappicino)).perform(click());
        onView(withId(R.id.preferred_coffee)).check(matches(withText("Cappicino")));
    }

    @Test
    public void selectLatteAndVerifyText() {
        onView(withId(R.id.latte)).perform(click());
        onView(withId(R.id.preferred_coffee)).check(matches(withText("Latte")));
    }

    @Test
    public void selectMochaAndVerifyText() {
        onView(withId(R.id.mocha)).perform(click());
        onView(withId(R.id.preferred_coffee)).check(matches(withText("Mocha")));
    }

    @Test
    public void takeEspressoScreenshot() throws IOException{
        writeToTestStorage(captureToBitmap(onView(withId(R.id.espresso))), getClass().getSimpleName() + "_" + nameRule.getMethodName());
    }

    @Test
    public void takeRootScreenshot() throws IOException{
        writeToTestStorage(captureToBitmap(onView(isRoot())), getClass().getSimpleName() + "_" + nameRule.getMethodName());
    }

}