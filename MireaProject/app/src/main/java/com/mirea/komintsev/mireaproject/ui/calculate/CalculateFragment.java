package com.mirea.komintsev.mireaproject.ui.calculate;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mirea.komintsev.mireaproject.R;

public class CalculateFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);

        EditText el1 = view.findViewById(R.id.num1);
        EditText el2 = view.findViewById(R.id.num2);
        TextView result = view.findViewById(R.id.result);
        Button buttonSum = view.findViewById(R.id.sum);
        Button buttonSub = view.findViewById(R.id.subtraction);
        Button buttonMult = view.findViewById(R.id.mult);
        Button buttonDiv = view.findViewById(R.id.division);


        buttonSum.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(el1.getText().toString());
                int num2 = Integer.parseInt(el2.getText().toString());
                int res = num1 + num2;
                result.setText(Integer.toString(res));
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(el1.getText().toString());
                int num2 = Integer.parseInt(el2.getText().toString());
                int res = num1 - num2;
                result.setText(Integer.toString(res));
            }
        });

        buttonMult.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(el1.getText().toString());
                int num2 = Integer.parseInt(el2.getText().toString());
                int res = num1 * num2;
                result.setText(Integer.toString(res));
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                float num1 = Integer.parseInt(el1.getText().toString());
                float num2 = Integer.parseInt(el2.getText().toString());
                float res = num1 / num2;
                result.setText(Float.toString(res));
            }
        });


        return view;
    }


}