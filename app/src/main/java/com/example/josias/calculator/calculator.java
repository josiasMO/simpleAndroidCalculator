package com.example.josias.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity {

    Button buttons[] = new Button[16];
    TextView text;

    float op1, op2;
    String operator;
    boolean op1Load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        text = (TextView)findViewById(R.id.numberView);

        text.setText("");
        op1Load = false;

        buttons[0] = (Button)findViewById(R.id.button0);
        buttons[1] = (Button)findViewById(R.id.button1);
        buttons[2] = (Button)findViewById(R.id.button2);
        buttons[3] = (Button)findViewById(R.id.button3);
        buttons[4] = (Button)findViewById(R.id.button4);
        buttons[5] = (Button)findViewById(R.id.button5);
        buttons[6] = (Button)findViewById(R.id.button6);
        buttons[7] = (Button)findViewById(R.id.button7);
        buttons[8] = (Button)findViewById(R.id.button8);
        buttons[9] = (Button)findViewById(R.id.button9);
        buttons[10] = (Button)findViewById(R.id.buttonDiv);
        buttons[11] = (Button)findViewById(R.id.buttonMul);
        buttons[12] = (Button)findViewById(R.id.buttonMinus);
        buttons[13] = (Button)findViewById(R.id.buttonPlus);
        buttons[14] = (Button)findViewById(R.id.buttonEqual);
        buttons[15] = (Button)findViewById(R.id.buttonClear);

        handleButtons();

    }


    protected void handleButtons(){
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("0");
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("1");
            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("2");
            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("3");
            }
        });
        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("4");
            }
        });
        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("5");
            }
        });
        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("6");
            }
        });
        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("7");
            }
        });
        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("8");
            }
        });
        buttons[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.append("9");
            }
        });
        buttons[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadOperand();
                operator = "/";
            }
        });
        buttons[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadOperand();
                operator = "*";
            }
        });
        buttons[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadOperand();
                operator = "-";
            }
        });
        buttons[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadOperand();
                operator = "+";
            }
        });
        buttons[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadOperand();
                calculate();
            }
        });
        buttons[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
                op1Load = false;
                operator = "";
            }
        });

    }

    protected void loadOperand(){
        if(op1Load) {
            try {
                op2 = Integer.parseInt(text.getText().toString());
            }catch(NumberFormatException nfe){}
        }
        else {
            try {
                op1 = Integer.parseInt(text.getText().toString());
            }catch(NumberFormatException nfe){}
            op1Load = true;
        }
        text.setText("");
    }
    protected void calculate(){
        text.setText("");
        float result = 0;
        switch (operator){
            case "/":
                result = op1/op2;
                break;
            case "*":
                result = op1*op2;
                break;
            case "-":
                result = op1-op2;
                break;
            case "+":
                result = op1+op2;
                break;
            default:
                text.setText("#ERROR#");
        }
        op1 = result;
        operator = "";
        text.append(String.valueOf(result));
    }

}
