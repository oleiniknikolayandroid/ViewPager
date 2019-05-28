package com.example.viewpager;

import java.util.Random;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class firstF extends Fragment {

    static final String TAG = "myLogs";
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    static final String SAVE_PAGE_NUMBER = "save_page_number";
    int pageNumber;

    static firstF newInstance(int page) {
        firstF firstF = new firstF();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        firstF.setArguments(arguments);
        return firstF;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        Log.d(TAG, "onCreate: " + pageNumber);


        int savedPageNumber = -1;
        if (savedInstanceState != null) {
            savedPageNumber = savedInstanceState.getInt(SAVE_PAGE_NUMBER);
        }
        Log.d(TAG, "savedPageNumber = " + savedPageNumber);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);

        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        tvPage.setText("Page " + pageNumber);


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_PAGE_NUMBER, pageNumber);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + pageNumber);
    }
}