package com.example.eslamwael74.librangedate;

/**
 * Created by eslamwael74 on 12/09/17.
 */

import android.util.Log;

/** Log utility class to handle the log tag and DEBUG-only logging. */
final class Logr {
    public static void d(String message) {
        if (BuildConfig.DEBUG) {
            Log.d("TimesSquare", message);
        }
    }

    public static void d(String message, Object... args) {
        if (BuildConfig.DEBUG) {
            d(String.format(message, args));
        }
    }
}