package com.example.android_332;

import android.app.Activity;
import android.content.Intent;

public class Utils {
    private static int sTheme;
    private static int sMargin;

    public final static int THEME_BLACK = 0;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;
    public final static int MARGIN_SMALL = 0;
    public final static int MARGIN_MEDIUM = 1;
    public final static int MARGIN_LARGE = 2;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void changeMargin(Activity activity, int margin) {
        sMargin = margin;
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

    public static void onActivityCreateSetMargin(Activity activity) {
        switch (sMargin) {
            default:
                activity.setTheme(R.style.AppTheme);
                break;
            case MARGIN_SMALL:
                activity.setTheme(R.style.MarginSmall);
                break;
            case MARGIN_MEDIUM:
                activity.setTheme(R.style.MarginMedium);
                break;
            case MARGIN_LARGE:
                activity.setTheme(R.style.MarginLarge);
        }
    }
}
