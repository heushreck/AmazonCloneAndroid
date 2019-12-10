package com.example.amazoncloneandroid.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.amazoncloneandroid.R;

public class TestFragment extends Fragment {
    TextView textView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        Bundle bundle = this.getArguments();
        String wo = "von nichts";
        if (bundle != null) {
            wo = bundle.getString("key", "von nichts");
        }
        textView = view.findViewById(R.id.text_test);
        textView.setText(wo);
        return view;
    }
}