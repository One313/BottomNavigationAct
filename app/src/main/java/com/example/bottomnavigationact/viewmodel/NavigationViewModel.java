package com.example.bottomnavigationact.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.bottomnavigationact.callback.CallbackNavigation;

public class NavigationViewModel extends ViewModel {

    private CallbackNavigation mCallbackNavigation;

    public void setCallbackNavigation(CallbackNavigation callbackNavigation) {
        mCallbackNavigation = callbackNavigation;
    }

    public void onClickListener() {
        mCallbackNavigation.onClickNavigation();
    }
}
