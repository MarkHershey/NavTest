package com.example.mynavtest.ui.analytics;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mynavtest.R;

public class AnalyticsFragment extends Fragment {

    private AnalyticsViewModel analyticsViewModel;

    TextView text_analytics;

    public static AnalyticsFragment newInstance() {
        return new AnalyticsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_analytics, container, false);
        text_analytics = root.findViewById(R.id.text_analytics);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        analyticsViewModel = new ViewModelProvider(this).get(AnalyticsViewModel.class);
        // TODO: Use the ViewModel
        analyticsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>(){

            @Override
            public void onChanged(String s) {
                text_analytics.setText(s);
            }
        });
    }

}