package com.example.convertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button button;
    EditText input, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = findViewById(R.id.input);
                result=findViewById(R.id.value);
                if (input.length() > 3 || input.length() == 0) {
                    input.setError("Enter Only 3 digits Number!!");
                }

                else {
                    int num = Integer.parseInt(input.getText().toString());
                    result.setText(DigitConvertor(num));
                }
            }
        });

    }

    public String DigitConvertor(int num) {

        String number=""+num;
        String arr[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",};

        String two[]={"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String zero[]={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String tens[]={"Hundred" ,"Thousand"};

        if(number.length()==1)
        {
            Toast.makeText(MainActivity.this,number,Toast.LENGTH_LONG).show();
            return ""+arr[num];
        }
        if(number.length()==2)
        {
            int val1=num/10;
            int val2=num%10;
            Toast.makeText(MainActivity.this,"first="+val1+"last="+val2,Toast.LENGTH_LONG).show();
            if(val2==0)
            {
                return zero[val1-1];
            }
            else if(val1==1)
            {
                return two[val2-1];
            }
            else if(val1>1)
            {
                return zero[val1-1]+""+arr[val2];
            }
        }
        if(number.length()==3)
        {
            int val1=num/100;
            int val2=num%10;
            int val3=(num/10)%10;
            Toast.makeText(MainActivity.this,"First="+val1+"Mid"+val3+"last="+val2,Toast.LENGTH_LONG).show();
            if(val1>0 && val3>0 && val2>0)
            {

                return arr[val1]+""+tens[0]+zero[val3-1]+arr[val2];

            }
            else if(val1>0 && val3==0 && val2>0)
            {
                return arr[val1]+""+tens[0]+arr[val2];
            }
            else if(val1>0 && val3>0 && val2==0)
            {
                return arr[val1]+""+tens[0]+zero[val3-1];
            }
            else if(val1>0 && val3==0 && val2==0)
            {
                return arr[val1]+tens[0];
            }


        }

        return "Incorect Format!!";
    }


}












