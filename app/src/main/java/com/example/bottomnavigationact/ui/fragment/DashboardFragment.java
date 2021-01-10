package com.example.bottomnavigationact.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.bottomnavigationact.R;
import com.example.bottomnavigationact.databinding.FragmentDashboardBinding;
import com.example.bottomnavigationact.viewmodel.DashboardViewModel;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding mBinding;
    private DashboardViewModel dashboardViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_dashboard, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setDashboardViewModel(dashboardViewModel);

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            mBinding.textDashboard.setText(s);
        });
    }
}