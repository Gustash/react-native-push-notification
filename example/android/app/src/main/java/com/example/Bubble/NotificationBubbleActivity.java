package com.example.Bubble;

import com.dieam.reactnativepushnotification.helpers.BubbleActivity;

public class NotificationBubbleActivity extends BubbleActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "bubble";
    }
}