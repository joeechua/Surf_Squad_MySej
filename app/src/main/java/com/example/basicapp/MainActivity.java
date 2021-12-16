package com.example.basicapp;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Context self = this;

        CardView cv = findViewById(R.id.showQR);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });

        CardView cv2 = findViewById(R.id.scanQR);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your second action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        closeButton = (Button) findViewById(R.id.button4);
        builder = new AlertDialog.Builder(this);
        CardView cv3 = findViewById(R.id.cardView3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage("Are you still in Restaurant OKOK?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Next reminder will be in 1 minute(s)",
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                closeButton.setText("checked-out");
                                Toast.makeText(getApplicationContext(),"You have been checked out of Restaurant OKOK",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Check-out Reminder");
                alert.show();
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
            Intent settings = new Intent(getApplicationContext(), SettingsPage.class);
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}