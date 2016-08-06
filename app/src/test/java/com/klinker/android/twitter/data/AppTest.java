package com.klinker.android.twitter.data;

import android.app.ActionBar;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.klinker.android.twitter.BuildConfig;
import com.klinker.android.twitter.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AppTest {

    private ActivityController<TestMainActivity> controller;

    @Before
    public void beforeEachTest() {
        StaticStateUtils.resetStaticState();
        controller = buildActivity(TestMainActivity.class);
    }

    @Test
    public void mainActivity_creates() {
        controller.create();
    }

    @Test
    public void mainActivity_setsDisplayedUpgradeMessagePreference() {
        final String preferenceName = "com.klinker.android.twitter_world_preferences";
        final String key = "displayed_upgrade_message";

        controller.create();

        final SharedPreferences preferences = RuntimeEnvironment.application.getSharedPreferences(preferenceName, 0);
        assertThat(preferences.contains(key)).isTrue();
        final boolean preference = preferences.getBoolean(key, false);
        assertThat(preference).isTrue();
    }

    @Test
    public void mainActivity_resumes() {
        controller.create().start().resume();
    }

    public static class TestMainActivity extends MainActivity {
        @Nullable
        @Override
        public ActionBar getActionBar() {
            return Mockito.mock(ActionBar.class);
        }
    }
}