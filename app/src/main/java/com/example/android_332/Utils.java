package com.example.android_332;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;

    public final static int THEME_BLACK = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.AppGreenTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppBlueTheme);
                break;
            case THEME_BLACK:
                activity.setTheme(R.style.AppBlackTheme);
        }
    }
}
