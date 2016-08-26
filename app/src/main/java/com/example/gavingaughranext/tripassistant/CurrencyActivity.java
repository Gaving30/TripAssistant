package com.example.gavingaughranext.tripassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity {
    EditText amount;
    TextView textViewCur;
    Button b1, b2;
    Double result;

    //private String finalUrl = "view-source:http://www.floatrates.com/daily/eur.xml";
    private String finalUrl = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    //private String finalUrl = "http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        textViewCur = (TextView) findViewById(R.id.textViewCurrencyAnswer);
        amount = (EditText) findViewById(R.id.editTextEnterEuroAmount);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.showAll);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*obj = new HandleXML(finalUrl);
                obj.fetchXML();

                while (obj.parsingComplete) ;
                textViewCur.setText(obj.getTitle());
                */
                Double x;
                String amString;

                amString = amount.getText().toString();

                if ("".equals(amString)) {

                    textViewCur.setText("Please Enter An Amount.");


                } else {

                    x = Double.parseDouble(amString);

                    result = 1.11*x;
                    //*****Should be: result = retrievedXMLrate(title)*amount;

                    String answerFormat =String.format("%.2f", result);
                    textViewCur.setText(answerFormat);

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(CurrencyActivity.this, ShowAll.class);
                startActivity(in);
            }
        });

        final Spinner currSpinner = (Spinner) findViewById(R.id.spinnerCurrency);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.currency_array,android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        currSpinner.setAdapter(staticAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
