package com.example.lenovo.randomnumber;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.randomnumber.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int number;
    private EditText numberEditTxt;
    private Button checkBtn;
    private Button newNumBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
        numberEditTxt = (EditText) findViewById(R.id.numberEditTxt);
        checkBtn = (Button) findViewById(R.id.checkBtn);
        newNumBtn = (Button) findViewById(R.id.newNumBtn);
        numberEditTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return true;
            }
        });
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number == Integer.parseInt(numberEditTxt.getText().toString())){
                    Toast msg = Toast.makeText(getBaseContext(), "Congrats! you guessed it", Toast.LENGTH_SHORT);
                    msg.show();
                    newNumBtn.setVisibility(View.VISIBLE);
                }else if(number - 5 < Integer.parseInt(numberEditTxt.getText().toString()) && number > Integer.parseInt(numberEditTxt.getText().toString()) ){
                    Toast msg = Toast.makeText(getBaseContext(), "Very Close! Try Again!" , Toast.LENGTH_SHORT);
                    msg.show();
                }else if(number + 5 > Integer.parseInt(numberEditTxt.getText().toString()) && number < Integer.parseInt(numberEditTxt.getText().toString()) ){
                    Toast msg = Toast.makeText(getBaseContext(), "Very Close! Try Again!", Toast.LENGTH_SHORT);
                    msg.show();
                }else if(number < Integer.parseInt(numberEditTxt.getText().toString())) {
                    Toast msg = Toast.makeText(getBaseContext(), "Greater! Try Again!", Toast.LENGTH_SHORT);
                    msg.show();
                }else if(number > Integer.parseInt(numberEditTxt.getText().toString())){
                    Toast msg = Toast.makeText(getBaseContext(), "Smaller! Try Again!", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });
        newNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
                Toast msg = Toast.makeText(getBaseContext(), " New Game! ", Toast.LENGTH_LONG);
                msg.show();
                newNumBtn.setVisibility(View.GONE);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void generateRandomNumber(){
        Random random = new Random();
        number = random.nextInt(1000);
    }
}