package com.example.gavingaughranext.tripassistant;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeActivity extends AppCompatActivity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView irishTime = (TextView) findViewById(R.id.irelandTimeText);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+01:00"), Locale.getDefault());
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+01:00"));
        String localTime = date.format(currentLocalTime);
        irishTime.setText(localTime);

        TextView displayTime = (TextView) findViewById(R.id.displayTimeText);
        final Spinner mySpinner = (Spinner) findViewById(R.id.countryNamesSpinner);
        Button timeButton = (Button) findViewById(R.id.getTimeButton);

        //Initially I hide the elements until it is returning a correct time using user input settings
        displayTime.setVisibility(View.INVISIBLE);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.time_country_array,android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        mySpinner.setAdapter(staticAdapter);

        timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timeSet();
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)

    public void timeSet(){
        TextView displayTime = (TextView) findViewById(R.id.displayTimeText);
        Spinner mySpinner = (Spinner) findViewById(R.id.countryNamesSpinner);

        displayTime.setVisibility(View.VISIBLE);

        String text = mySpinner.getSelectedItem().toString();

        if (text.equals("France") || text.equals("Spain") || text.equals("Italy") || text.equals("Germany") || text.equals("Poland") || text.equals("Netherlands")){

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+02:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        } else if (text.equals("China") || text.equals("Malaysia") || text.equals("Singapore")) {

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        }else if (text.equals("Turkey") || text.equals("Russia") || text.equals("Ukraine") || text.equals("Saudi Arabia") || text.equals("Greece")){

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+03:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        }else if (text.equals("UK")){

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+01:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+01:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        }else if (text.equals("Mexico")){

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-07:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT-07:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        }else if (text.equals("Australia")){

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+11:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+11:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in " + text);

        }else {

            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+07:00"), Locale.getDefault());
            Date currentLocalTime = cal.getTime();
            DateFormat date = new SimpleDateFormat("HH:mm a");
            date.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
            String localTime = date.format(currentLocalTime);
            displayTime.setText(localTime + " in Thailand");

        }
    }
}
