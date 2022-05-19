package com.mirea.komintsev.mireaproject.ui.calculate;

import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        final Boolean[] lastNumaric = {false};
        final Boolean[] stateError = {false};
        final Boolean[] lastDot = {false};
        final Boolean[] num1ToNum2 = {false};

        final Boolean[] isAdd = {false};
        final Boolean[] isSub = {false};
        final Boolean[] isMul = {false};
        final Boolean[] isDiv = {false};

        TextView result = view.findViewById(R.id.result);
        TextView num1 = view.findViewById(R.id.Num1);
        TextView num2 = view.findViewById(R.id.Num2);
        TextView operation = view.findViewById(R.id.operation);

        Button one =  view.findViewById(R.id.one);
        Button two =  view.findViewById(R.id.two);
        Button three =  view.findViewById(R.id.three);
        Button four =  view.findViewById(R.id.four);
        Button five =  view.findViewById(R.id.five);
        Button six =  view.findViewById(R.id.six);
        Button seven =  view.findViewById(R.id.seven);
        Button eight =  view.findViewById(R.id.eight);
        Button nine =  view.findViewById(R.id.nine);

        Button divide =  view.findViewById(R.id.divide);
        Button multiply =  view.findViewById(R.id.multiply);
        Button subtract =  view.findViewById(R.id.subtract);
        Button decimal =  view.findViewById(R.id.decimal);
        Button zero =  view.findViewById(R.id.zero);
        Button clear =  view.findViewById(R.id.clear);
        Button add =  view.findViewById(R.id.add);
        Button enter =  view.findViewById(R.id.enter);

        enter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (num1ToNum2[0]){
                    num1ToNum2[0] = false;
                    if(isAdd[0]){
                        isAdd[0] = false;
                        double number1 = Double.parseDouble(num1.getText().toString());
                        double number2 = Double.parseDouble(num2.getText().toString());
                        double res = number1 + number2;
                        result.setText(Double.toString(res));
                    }
                    else if(isSub[0]){
                        isSub[0] = false;
                        double number1 = Double.parseDouble(num1.getText().toString());
                        double number2 = Double.parseDouble(num2.getText().toString());
                        double res = number1 - number2;
                        result.setText(Double.toString(res));
                    }
                    else if(isMul[0]){
                        isMul[0] = false;
                        double number1 = Double.parseDouble(num1.getText().toString());
                        double number2 = Double.parseDouble(num2.getText().toString());
                        double res = number1 * number2;
                        result.setText(Double.toString(res));
                    }
                    else if(isDiv[0]){
                        isDiv[0] = false;
                        double number1 = Double.parseDouble(num1.getText().toString());
                        double number2 = Double.parseDouble(num2.getText().toString());
                        double res = number1 / number2;
                        result.setText(Double.toString(res));
                    }
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("1");
                        stateError[0] = false;
                    }else {
                        num1.append("1");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("1");
                        stateError[0] = false;
                    }else {
                        num2.append("1");
                    }
                }
                lastNumaric[0] = true;

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("2");
                        stateError[0] = false;
                    }else {
                        num1.append("2");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("2");
                        stateError[0] = false;
                    }else {
                        num2.append("2");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("3");
                        stateError[0] = false;
                    }else {
                        num1.append("3");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("3");
                        stateError[0] = false;
                    }else {
                        num2.append("3");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("4");
                        stateError[0] = false;
                    }else {
                        num1.append("4");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("4");
                        stateError[0] = false;
                    }else {
                        num2.append("4");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("5");
                        stateError[0] = false;
                    }else {
                        num1.append("5");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("5");
                        stateError[0] = false;
                    }else {
                        num2.append("5");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("6");
                        stateError[0] = false;
                    }else {
                        num1.append("6");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("6");
                        stateError[0] = false;
                    }else {
                        num2.append("6");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("7");
                        stateError[0] = false;
                    }else {
                        num1.append("7");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("7");
                        stateError[0] = false;
                    }else {
                        num2.append("7");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("8");
                        stateError[0] = false;
                    }else {
                        num1.append("8");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("8");
                        stateError[0] = false;
                    }else {
                        num2.append("8");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("9");
                        stateError[0] = false;
                    }else {
                        num1.append("9");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("9");
                        stateError[0] = false;
                    }else {
                        num2.append("9");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(stateError[0])
                    {
                        num1.setText("0");
                        stateError[0] = false;
                    }else {
                        num1.append("0");
                    }
                }else {
                    if(stateError[0])
                    {
                        num2.setText("0");
                        stateError[0] = false;
                    }else {
                        num2.append("0");
                    }
                }
                lastNumaric[0] = true;
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!num1ToNum2[0]){
                    if(lastNumaric[0] && !stateError[0] && !lastDot[0])
                    {
                        num1.append(".");
                        lastNumaric[0] = false;
                        lastDot[0]=true;
                    }
                }else {
                    if(lastNumaric[0] && !stateError[0] && !lastDot[0])
                    {
                        num2.append(".");
                        lastNumaric[0] = false;
                        lastDot[0]=true;
                    }
                }

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(lastNumaric[0] && !stateError[0]) {
                    if (num1.getText().toString() != " ") {
                        operation.setText("+");
                        isAdd[0] = true;
                        isSub[0] = false;
                        isMul[0] = false;
                        isDiv[0] = false;
                        num1ToNum2[0] = true;
                        lastNumaric[0] = false;
                        lastDot[0] = false;
                    } else {
                        Toast.makeText(getContext(), "Введите число", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastNumaric[0] && !stateError[0]) {
                    if (num1.getText().toString() != "") {
                        operation.setText("/");
                        isAdd[0] = false;
                        isSub[0] = false;
                        isMul[0] = false;
                        isDiv[0] = true;
                        num1ToNum2[0] = true;
                        lastNumaric[0] = false;
                        lastDot[0] = false;
                    } else {
                        Toast.makeText(getContext(), "Введите число", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastNumaric[0] && !stateError[0]) {
                    if (num1.getText().toString() != "") {
                        operation.setText("*");
                        isAdd[0] = false;
                        isSub[0] = false;
                        isMul[0] = true;
                        isDiv[0] = false;
                        num1ToNum2[0] = true;
                        lastNumaric[0] = false;
                        lastDot[0] = false;
                    } else {
                        Toast.makeText(getContext(), "Введите число", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastNumaric[0] && !stateError[0]) {
                    if (num1.getText().toString() != "") {
                        operation.setText("-");
                        isAdd[0] = false;
                        isSub[0] = true;
                        isMul[0] = false;
                        isDiv[0] = false;
                        num1ToNum2[0] = true;
                        lastNumaric[0] = false;
                        lastDot[0] = false;
                    } else {
                        Toast.makeText(getContext(), "Введите число", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                num1.setText("");
                num2.setText("");
                operation.setText("");

                lastNumaric[0] = false;
                lastDot[0]=false;
                stateError[0] = false;
                num1ToNum2[0] = false;
                isAdd[0] = false;
                isSub[0] = false;
                isMul[0] = false;
                isDiv[0] = false;
            }
        });


        return view;
    }


}