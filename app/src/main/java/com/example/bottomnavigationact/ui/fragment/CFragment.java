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
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.bottomnavigationact.R;
import com.example.bottomnavigationact.databinding.FragmentCBinding;
import com.example.bottomnavigationact.viewmodel.NavigationViewModel;

public class CFragment extends Fragment {

    private FragmentCBinding mBinding;
    private NavController mNavController;
    private NavigationViewModel mViewModel;

    public CFragment() {
        // Required empty public constructor
    }

    public static CFragment newInstance() {
        CFragment fragment = new CFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(this)
                .get(NavigationViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_c, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        mBinding.setNavigationViewModel(mViewModel);

        mViewModel.setCallbackNavigation(() -> {
            NavDirections directions = CFragmentDirections.actionCFragmentToDFragment();
            mNavController.navigate(directions);
        });
    }
}