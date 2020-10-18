package com.example.brainboxtest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import android.os.StrictMode;


//brainbox packages
import java.util.ArrayList;

import brainboxes.io.connection.IConnection;
import brainboxes.io.connection.TCPConnection;
import brainboxes.io.device.*;
import brainboxes.io.protocol.ASCIIProtocol;

public class MainActivity extends AppCompatActivity {

    Button connectButton;
    ArrayList<Button> devButtons = new ArrayList<Button>();
    ArrayList<EDDevice> devices = new ArrayList<EDDevice>();
    ArrayList<IConnection> addresses = new ArrayList<IConnection>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Constants.instantiateRunStatus();
        InitializeUI();
        InitializeBrainBoxes();
        ButtonOnClickListeners();
        connect();

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

    public void ButtonOnClickListeners() {
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        connect();
                        Snackbar.make(view, "Done.", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
            }

        });

        devButtons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(0).IsConnected())
                {
                    devices.get(0).Disconnect();
                    startActivity(new Intent(MainActivity.this, Box1Activity.class));
                }

            }
        });

        devButtons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if(devices.get(1).IsConnected())
                {
                    devices.get(1).Disconnect();
                    startActivity(new Intent(MainActivity.this, box2.class));
                }
            }

        });

        devButtons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(2).IsConnected())
                {
                    devices.get(2).Disconnect();
                    startActivity(new Intent(MainActivity.this, box3.class));
                }
            }
        });

        devButtons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(3).IsConnected())
                {
                    devices.get(3).Disconnect();
                    startActivity(new Intent(MainActivity.this, box4.class));
                }
            }
        });

        devButtons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(4).IsConnected())
                {
                    devices.get(4).Disconnect();
                    startActivity(new Intent(MainActivity.this, box5.class));
                }
            }
        });

        devButtons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(5).IsConnected())
                {
                    devices.get(5).Disconnect();
                    startActivity(new Intent(MainActivity.this, box6.class));
                }
            }
        });

        devButtons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(6).IsConnected())
                {
                    devices.get(6).Disconnect();
                    startActivity(new Intent(MainActivity.this, box7.class));
                }
            }
        });

        devButtons.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(7).IsConnected())
                {
                    devices.get(7).Disconnect();
                    startActivity(new Intent(MainActivity.this, box8.class));
                }
            }
        });

        devButtons.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(8).IsConnected())
                {
                    devices.get(8).Disconnect();
                    startActivity(new Intent(MainActivity.this, box9.class));
                }
            }
        });

        devButtons.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(9).IsConnected())
                {
                    devices.get(9).Disconnect();
                    startActivity(new Intent(MainActivity.this, box10.class));
                }
            }
        });

        devButtons.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(10).IsConnected())
                {
                    devices.get(10).Disconnect();
                    startActivity(new Intent(MainActivity.this, box11.class));
                }
            }
        });

        devButtons.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(devices.get(11).IsConnected())
                {
                    devices.get(11).Disconnect();
                    startActivity(new Intent(MainActivity.this, box12.class));
                }
            }
        });
    }

    public void InitializeUI() {
        connectButton = (Button) findViewById(R.id.connectButton);
        devButtons.add((Button) findViewById(R.id.bboxbutton1));
        devButtons.add((Button) findViewById(R.id.bboxbutton2));
        devButtons.add((Button) findViewById(R.id.bboxbutton3));
        devButtons.add((Button) findViewById(R.id.bboxbutton4));
        devButtons.add((Button) findViewById(R.id.bboxbutton5));
        devButtons.add((Button) findViewById(R.id.bboxbutton6));
        devButtons.add((Button) findViewById(R.id.bboxbutton7));
        devButtons.add((Button) findViewById(R.id.bboxbutton8));
        devButtons.add((Button) findViewById(R.id.bboxbutton9));
        devButtons.add((Button) findViewById(R.id.bboxbutton10));
        devButtons.add((Button) findViewById(R.id.bboxbutton11));
        devButtons.add((Button) findViewById(R.id.bboxbutton12));

    }

    public void setButtonCompletionStatus(int buttonNum)
    {
        for(int i = 0; i < 15; i++)
        {
            if(!Constants.getRunStatus(buttonNum, i))
            {
                return;
            }
        }
        devButtons.get(buttonNum).setBackgroundColor((0xFF696969));
    }

    public void InitializeBrainBoxes()
    {
        //connections
        addresses.add(new TCPConnection("10.0.0.4", 9500));
        addresses.add(new TCPConnection("10.0.0.5", 9500));
        addresses.add(new TCPConnection("10.0.0.6", 9500));
        addresses.add(new TCPConnection("10.0.0.7", 9500));
        addresses.add(new TCPConnection("10.0.0.8", 9500));
        addresses.add(new TCPConnection("10.0.0.9", 9500));
        addresses.add(new TCPConnection("10.0.0.10", 9500));
        addresses.add(new TCPConnection("10.0.0.11", 9500));
        addresses.add(new TCPConnection("10.0.0.12", 9500));
        addresses.add(new TCPConnection("10.0.0.13", 9500));
        addresses.add(new TCPConnection("10.0.0.14", 9500));
        addresses.add(new TCPConnection("10.0.0.15", 9500));

        //device objects
        devices.add(new EDDevice(addresses.get(0), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(1), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(2), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(3), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(4), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(5), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(6), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(7), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(8), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(9), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(10), new ASCIIProtocol()));
        devices.add(new EDDevice(addresses.get(11), new ASCIIProtocol()));
    }

    public void connect(){
        //set to gray
        for(int j = 0; j < 12; j++)
        {
            devButtons.get(j).setBackgroundColor((0xFF2D2D2D));
        }

        //connect to each device and set colors based on reachability status
        for(int i = 0; i < 12; i++)
        {
            try{
                System.out.println("Connecting...");
                devices.get(i).Connect();
                System.out.println("Connected");
            } catch (Exception e){
                System.out.println("Error Connecting: " + e.getMessage());
            }
            if(devices.get(i).IsConnected())
            {
                devButtons.get(i).setBackgroundColor((0xFF00FF00));
                setButtonCompletionStatus(i);
            }
            else
            {
                devButtons.get(i).setBackgroundColor((0xFFFF0000));
            }
        }
    }
}


