package com.dieam.reactnativepushnotification.helpers;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.dieam.reactnativepushnotification.BuildConfig;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

import javax.annotation.Nullable;

public class BubbleActivity extends Activity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    /**
     * Returns the name of the main module. Determines the URL used to fetch the JS bundle
     * from the packager server. It is only used when dev support is enabled.
     * This is the first file to be executed once the {@link ReactInstanceManager} is created.
     * e.g. "index.android"
     */
    protected String getJSMainModuleName() {
        return "index";
    }

    /**
     * Returns the name of the bundle in assets. If this is null, and no file path is specified for
     * the bundle, the app will only work with {@code getUseDeveloperSupport} enabled and will
     * always try to load the JS bundle from the packager server.
     * e.g. "index.android.bundle"
     */
    protected @Nullable String getBundleAssetName() {
        return "index.android.bundle";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                .setBundleAssetName(getBundleAssetName())
                .setJSMainModulePath(getJSMainModuleName())
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, getMainComponentName(), null);

        setContentView(mReactRootView);
    }

    protected String getMainComponentName() {
        return null;
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this);
        }
        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}