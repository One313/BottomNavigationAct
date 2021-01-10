package com.example.bottomnavigationact.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.bottomnavigationact.R;
import com.example.bottomnavigationact.databinding.FragmentNotificationsBinding;
import com.example.bottomnavigationact.viewmodel.NavigationViewModel;
import com.example.bottomnavigationact.viewmodel.NotificationsViewModel;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding mBinding;
    private NavController mNavController;
    private NotificationsViewModel notificationsViewModel;
    private NavigationViewModel mNavigationViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        mNavigationViewModel = new ViewModelProvider(this)
                .get(NavigationViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_notifications, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        mBinding.setNotificationsViewModel(notificationsViewModel);
        mBinding.setNavigationViewModel(mNavigationViewModel);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            mBinding.textNotifications.setText(s);
        });

        mNavigationViewModel.setCallbackNavigation(() -> {
            NavDirections directions = NotificationsFragmentDirections.actionNavigationNotificationsToCFragment();
            mNavController.navigate(directions);
        });
    }
}