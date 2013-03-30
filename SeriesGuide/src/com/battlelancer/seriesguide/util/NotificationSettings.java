
package com.battlelancer.seriesguide.util;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Access settings related to the notification service.
 */
public class NotificationSettings {
    public static final String KEY_ENABLED = "com.battlelancer.seriesguide.notifications";

    public static final String KEY_FAVONLY = "com.battlelancer.seriesguide.notifications.favonly";

    public static final String KEY_THRESHOLD = "com.battlelancer.seriesguide.notifications.threshold";

    public static final String KEY_LATEST_NOTIFIED = "com.battlelancer.seriesguide.notifications.latestnotified";

    public static final String KEY_NEXT_TO_NOTIFY = "com.battlelancer.seriesguide.notifications.next";

    public static final String KEY_RINGTONE = "com.battlelancer.seriesguide.notifications.ringtone";

    public static final String KEY_VIBRATE = "com.battlelancer.seriesguide.notifications.vibrate";

    public static boolean isNotificationsEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_ENABLED, false);
    }

    public static boolean isNotifyAboutFavoritesOnly(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_FAVONLY, true);
    }

    /**
     * How far into the future to include upcoming episodes in minutes.
     */
    public static int getLatestToIncludeTreshold(Context context) {
        int threshold = 60;

        try {
            threshold = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context)
                    .getString(KEY_THRESHOLD, "60"));
        } catch (NumberFormatException ignored) {
        }

        return threshold;
    }

    /**
     * Get the air time of the next episode we plan to notify about.
     */
    public static long getNextToNotifyAbout(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getLong(KEY_NEXT_TO_NOTIFY, 0);
    }

    /**
     * Get the air time of the latest episode we notified about last.
     */
    public static long getLastNotifiedAbout(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getLong(KEY_LATEST_NOTIFIED, 0);
    }

    public static String getNotificationsRingtone(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(KEY_RINGTONE,
                        "content://settings/system/notification_sound");
    }

    public static boolean isNotificationVibrating(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_VIBRATE, false);
    }
}
