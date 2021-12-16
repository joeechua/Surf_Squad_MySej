package com.example.basicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Timer extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //numpicker
        NumberPicker numPickerHo = findViewById((R.id.timerHour));
        numPickerHo.setMinValue(0);
        numPickerHo.setMaxValue(12);

        NumberPicker numPickerMin = findViewById((R.id.timerMin));
        numPickerMin.setMinValue(1);
        numPickerMin.setMaxValue(59);


        //Switch
        Switch checkOut = findViewById(R.id.checkOutNoti);


        Button confirm = findViewById(R.id.button2);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mins = numPickerMin.getValue();
                int hours = numPickerHo.getValue();
                Snackbar.make(view, "Reminder set to every" + hours + " hours and " + mins + " minutes.", Snackbar.LENGTH_LONG).show();
            }
        });


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