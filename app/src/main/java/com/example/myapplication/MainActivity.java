package com.example.myapplication;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA=findViewById(R.id.editTextText1);
        editB=findViewById(R.id.editTextText2);
        editC=findViewById(R.id.editTextText3);
        editA.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editB.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editC.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        btn=findViewById(R.id.button);
        tv=findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSolve();
            }
        });

    }
    public void doSolve() {

        String strA = editA.getText().toString();
        String strB = editB.getText().toString();
        String strC = editC.getText().toString();
        Double a=Double.parseDouble(strA);
        Double b=Double.parseDouble(strB);
        Double c=Double.parseDouble(strC);
        Double discriminant = b*b-4*c*a;
        if (a!=0) {
            if (discriminant == 0) {
                double x=-b*2*a;
            } else if (discriminant>0) {
                double x_1=(-b+Math.sqrt(discriminant))/2*a;
                double x_2=(-b-Math.sqrt(discriminant))/2*a;
                tv.setText(String.format("x1 = 2.%f, x2 = 2.%f", x_1, x_2));
            } else {
                tv.setText("not solve");
            }
        } else {
            tv.setText("a should not be 0");
        }

    }

}