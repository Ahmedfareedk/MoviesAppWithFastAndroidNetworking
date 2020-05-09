package com.example.workingwithapis.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.workingwithapis.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ModalBottomSheet extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.modal_bottom_sheet_layout, container, false);

        return view;
    }
}
