package com.example.gpa_r01876070_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{

    Button btn1;
    TextView tv1, tv2, tv3, tv4, tv5, gpad;
    EditText et1, et2, et3, et4, et5, cr1, cr2, cr3, cr4, cr5;
    View bg1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.s1);
        tv2 = (TextView)findViewById(R.id.s2);
        tv3 = (TextView)findViewById(R.id.s3);
        tv4 = (TextView)findViewById(R.id.s4);
        tv5 = (TextView)findViewById(R.id.s5);
        et1 = (EditText)findViewById(R.id.t1);
        et2 = (EditText)findViewById(R.id.t2);
        et3 = (EditText)findViewById(R.id.t3);
        et4 = (EditText)findViewById(R.id.t4);
        et5 = (EditText)findViewById(R.id.t5);
        cr1 = (EditText)findViewById(R.id.r1);
        cr2 = (EditText)findViewById(R.id.r2);
        cr3 = (EditText)findViewById(R.id.r3);
        cr4 = (EditText)findViewById(R.id.r4);
        cr5 = (EditText)findViewById(R.id.r5);
        btn1 = (Button)findViewById(R.id.CalcButton);
        gpad = (TextView)findViewById(R.id.GPADisplay);
        bg1 = findViewById(R.id.bg);

        gpad.setTextSize(20);
        bg1.setBackgroundColor(Color.argb(255,255,255,255));

    }

    public void processClick(View view)
    {

        //Clear Text and Reset
        if ( btn1.getText() == "Clear Text" )
        {
            et1.setText(null);
            et2.setText(null);
            et3.setText(null);
            et4.setText(null);
            et5.setText(null);
            cr1.setText(null);
            cr2.setText(null);
            cr3.setText(null);
            cr4.setText(null);
            cr5.setText(null);

            String initial = "Calculate GPA";
            btn1.setText(initial);
            initial = "Your final GPA will appear here!";
            gpad.setText(initial);
            bg1.setBackgroundColor(Color.argb(255,255,255,255));
            gpad.setTextSize(20);
            return;
        }

        //Error checking for empty fields
        if (et1.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "A field was left empty!", Toast.LENGTH_LONG).show();
            return;
        }
        if (et2.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "A field was left empty!", Toast.LENGTH_LONG).show();
            return;
        }
        if (et3.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "A field was left empty!", Toast.LENGTH_LONG).show();
            return;
        }
        if (et4.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "A field was left empty!", Toast.LENGTH_LONG).show();
            return;
        }
        if (et5.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this, "A field was left empty!", Toast.LENGTH_LONG).show();
            return;
        }

        int a1,a2,a3,a4,a5,b1,b2,b3,b4,b5;

        //Variables for Grades
        a1 = Integer.parseInt(et1.getText().toString());
        a2 = Integer.parseInt(et2.getText().toString());
        a3 = Integer.parseInt(et3.getText().toString());
        a4 = Integer.parseInt(et4.getText().toString());
        a5 = Integer.parseInt(et5.getText().toString());

        //Variables for Credits
        b1 = Integer.parseInt(cr1.getText().toString());
        b2 = Integer.parseInt(cr2.getText().toString());
        b3 = Integer.parseInt(cr3.getText().toString());
        b4 = Integer.parseInt(cr4.getText().toString());
        b5 = Integer.parseInt(cr5.getText().toString());

        //Error checking for grade ranges
        if ( (a1 < 0 || a1 > 100) || (a2 < 0 || a2 > 100) || (a3 < 0 || a3 > 100) || (a4 < 0 || a4 > 100) || (a5 < 0 || a5 > 100) )
        {
            Toast.makeText(MainActivity.this, "Grades must be from 1 to 100!", Toast.LENGTH_LONG).show();
            return;
        }

        //Error checking for credit ranges
        if ( (b1 < 1 || b1 > 5) || (b2 < 1 || b2 > 5) || (b3 < 1 || b3 > 5) || (b4 < 1 || b4 > 5) || (b5 < 1 || b5 > 5) )
        {
            Toast.makeText(MainActivity.this, "Credits must be from 1 to 5!", Toast.LENGTH_LONG).show();
            return;
        }

        //Pushing the result
        int gpa = ( (a1*b1)+(a2*b2)+(a3*b3)+(a4*b4)+(a5*b5) ) / (b1+b2+b3+b4+b5);
        String x = String.valueOf( gpa );
        gpad.setText( x );
        gpad.setTextSize(100);

        //Changing the color of the background
        if ( gpa < 60 )
            bg1.setBackgroundColor(Color.argb(255,255,100,100)); //0xFF0000
        if ( gpa > 60 && gpa < 80 )
            bg1.setBackgroundColor(Color.argb(255,255,255,100)); //0xFFFF00
        if ( gpa >= 80 && gpa <= 100 )
            bg1.setBackgroundColor(Color.argb(255,100,255,100)); //0x00FF00

        //Changing the button text
        String y = "Clear Text";
        btn1.setText( y );

    }
}