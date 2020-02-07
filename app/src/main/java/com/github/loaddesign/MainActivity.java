package com.github.loaddesign;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.DecimalFormat;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    double goc,gos,d1,d2,n1,n2;
    double aic,ast,p,wos;

    EditText result;
    EditText result1;
    EditText result2;
    EditText result3;
    EditText length3;
    EditText length4;
    String[] sp1 = {"10 N/mm²","15 N/mm²","20 N/mm²","25 N/mm²","30 N/mm²","35 N/mm²","40 N/mm²","45 N/mm²","50 N/mm²","55 N/mm²","60 N/mm²","65 N/mm²","70 N/mm²","75 N/mm²","80 N/mm²"};
    String[] sp2 = {"250 N/mm²","415 N/mm²","500 N/mm²"};
    String[] sp3 = {"6 mm","8 mm","10 mm","12 mm","16 mm","20 mm","25 mm","28 mm","32 mm","36 mm","40 mm"};
    String[] sp4 = {"0","2","4","6","8","10","12","14","16","18","20"};
    String[] sp5 = {"6 mm","8 mm","10 mm","12 mm","16 mm","20 mm","25 mm","28 mm","32 mm","36 mm","40 mm"};
    String[] sp6 = {"0","2","4","6","8","10","12","14","16","18","20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main);


        final TextView length3View = (TextView) findViewById(R.id.length3);
        final TextView length4View = (TextView) findViewById(R.id.length4);
        length3 = (EditText) findViewById(R.id.length3value);
        length4 = (EditText) findViewById(R.id.length4value);
        result = (EditText) findViewById(R.id.resultValue);
        result1 = (EditText) findViewById(R.id.resultValue1);
        result2 = (EditText) findViewById(R.id.resultValue2);
        result3 = (EditText) findViewById(R.id.resultValue3);

        Button calculate = (Button) findViewById(R.id.calculatebutton);
        Button clear = (Button) findViewById(R.id.clearbutton);

        result.setEnabled(false);
        result1.setEnabled(false);
        result2.setEnabled(false);
        result3.setEnabled(false);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        Spinner spin2 = (Spinner) findViewById(R.id.spinner2);
        spin2.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp2);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(aa2);

        Spinner spin3 = (Spinner) findViewById(R.id.spinner3);
        spin3.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp3);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(aa3);

        Spinner spin4 = (Spinner) findViewById(R.id.spinner4);
        spin4.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa4 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp4);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(aa4);

        Spinner spin5 = (Spinner) findViewById(R.id.spinner5);
        spin5.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa5 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp5);
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin5.setAdapter(aa5);

        Spinner spin6 = (Spinner) findViewById(R.id.spinner6);
        spin6.setOnItemSelectedListener(this);

        ArrayAdapter<String> aa6 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sp6);
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin6.setAdapter(aa6);


        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double b;
                double d;
                DecimalFormat dFormat = new DecimalFormat("#.######");

                if(length3.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter the Breath! ",Toast.LENGTH_SHORT).show();
                }
                else if(length4.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter the Length!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    b = Double.parseDouble(length3.getText().toString());
                    d = Double.parseDouble(length4.getText().toString());
                    result = (EditText) findViewById(R.id.resultValue);
                    result1 = (EditText) findViewById(R.id.resultValue1);
                    result2 = (EditText) findViewById(R.id.resultValue2);
                    result3 = (EditText) findViewById(R.id.resultValue3);

                    aic = Double.valueOf(dFormat.format((b * d)));
                    ast = Double.valueOf(dFormat.format((n1*d1*d1*0.785398)+(n2*d2*d2*0.785398)));
                    p = Double.valueOf(dFormat.format((((0.4*b*d*goc)+(gos*ast*0.67))/(1000))));
                    wos = Double.valueOf(dFormat.format((((n1*d1*d1)/(162))+((n2*d2*d2)/(162)))));

                    result.setText(Double.toString(aic));
                    result1.setText(Double.toString(ast));
                    result2.setText(Double.toString(p));
                    result3.setText(Double.toString(wos));

                    result.setEnabled(false);
                    result1.setEnabled(false);
                    result2.setEnabled(false);
                    result3.setEnabled(false);

                }

            }


        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                length3.setText("");
                length3View.setText("Breadth :-");

                length4.setText("");
                length4View.setText("Depth :-");

                result.setText("");
                result1.setText("");
                result2.setText("");
                result3.setText("");

                result.setEnabled(false);
                result1.setEnabled(false);
                result2.setEnabled(false);
                result3.setEnabled(false);

            }
        });

    }

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

            if(arg0.getId() == R.id.spinner)
            {
                switch (position) {
                    case 0:                    goc = 10;

                        break;
                    case 1:                    goc = 15;

                        break;
                    case 2:                    goc = 20;

                        break;
                    case 3:                    goc = 25;

                        break;
                    case 4:                    goc = 30;

                        break;
                    case 5:                    goc = 35;

                        break;
                    case 6:                    goc = 40;

                        break;
                    case 7:                    goc = 45;

                        break;
                    case 8:                    goc = 50;

                        break;
                    case 9:                    goc = 55;

                        break;
                    case 10:                   goc = 60;

                        break;
                    case 11:                   goc = 65;

                        break;
                    case 12:                   goc = 70;

                        break;
                    case 13:                   goc = 75;

                        break;
                    case 14:                   goc = 80;

                        break;
                }             }

            if(arg0.getId() == R.id.spinner2)
            {
                switch (position) {
                    case 0:                    gos = 250;

                        break;
                    case 1:                    gos = 415;

                        break;
                    case 2:                    gos = 500;
                    break;
                }
            }

            if(arg0.getId() == R.id.spinner3)
            {
                switch (position) {
                    case 0:                    d1 = 6;

                        break;
                    case 1:                    d1 = 8;

                        break;
                    case 2:                    d1 = 10;

                        break;
                    case 3:                    d1 = 12;

                        break;
                    case 4:                    d1 = 16;

                        break;
                    case 5:                    d1 = 20;

                        break;
                    case 6:                    d1 = 25;

                        break;
                    case 7:                    d1 = 28;

                        break;
                    case 8:                    d1 = 32;

                        break;
                    case 9:                    d1 = 36;

                        break;
                    case 10:                    d1 = 40;

                        break;

                }
            }

            if(arg0.getId() == R.id.spinner4)
            {
                switch (position) {
                    case 0:                    n1 = 0;

                        break;
                    case 1:                    n1 = 2;

                        break;
                    case 2:                    n1 = 4;

                        break;
                    case 3:                    n1 = 6;

                        break;
                    case 4:                    n1 = 8;

                        break;
                    case 5:                    n1 = 10;

                        break;
                    case 6:                    n1 = 12;

                        break;
                    case 7:                    n1 = 14;

                        break;
                    case 8:                    n1 = 16;

                        break;
                    case 9:                    n1 = 18;

                        break;
                    case 10:                   n1 = 20;

                        break;

                }
            }

            if(arg0.getId() == R.id.spinner5)
            {
                switch (position) {
                    case 0:                    d2 = 6;

                        break;
                    case 1:                    d2 = 8;

                        break;
                    case 2:                    d2 = 10;

                        break;
                    case 3:                    d2 = 12;

                        break;
                    case 4:                    d2 = 16;

                        break;
                    case 5:                    d2 = 20;

                        break;
                    case 6:                    d2 = 25;

                        break;
                    case 7:                    d2 = 28;

                        break;
                    case 8:                    d2 = 32;

                        break;
                    case 9:                    d2 = 36;

                        break;
                    case 10:                   d2 = 40;

                        break;

                }
            }

            if(arg0.getId() == R.id.spinner6)
            {
                switch (position) {
                    case 0:                    n2 = 0;

                        break;
                    case 1:                    n2 = 2;

                        break;
                    case 2:                    n2 = 4;

                        break;
                    case 3:                    n2 = 6;

                        break;
                    case 4:                    n2 = 8;

                        break;
                    case 5:                    n2 = 10;

                        break;
                    case 6:                    n2 = 12;

                        break;
                    case 7:                    n2 = 14;

                        break;
                    case 8:                    n2 = 16;

                        break;
                    case 9:                    n2 = 18;

                        break;
                    case 10:                   n2 = 20;

                        break;

                }
            }


        }


        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }





}






