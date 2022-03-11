package com.mirea.komintsev.dialog;

import static android.app.ProgressDialog.STYLE_SPINNER;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new ProgressDialog(getActivity(),STYLE_SPINNER);
    }

}
