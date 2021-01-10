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
import com.example.bottomnavigationact.databinding.FragmentHomeBinding;
import com.example.bottomnavigationact.viewmodel.HomeViewModel;
import com.example.bottomnavigationact.viewmodel.NavigationViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mBinding;
    private NavController mNavController;
    private HomeViewModel homeViewModel;
    private NavigationViewModel mNavigationViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        mNavigationViewModel = new ViewModelProvider(this)
                .get(NavigationViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_home, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        mBinding.setHomeViewModel(homeViewModel);
        mBinding.setNavigationViewModel(mNavigationViewModel);

        homeViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            mBinding.textHome.setText(s);
        });

        mNavigationViewModel.setCallbackNavigation(() -> {
            NavDirections directions = HomeFragmentDirections.actionNavigationHomeToAFragment();
            mNavController.navigate(directions);
        });
    }
}