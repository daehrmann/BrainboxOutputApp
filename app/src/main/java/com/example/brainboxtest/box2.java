package com.example.brainboxtest;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import brainboxes.io.connection.IConnection;
import brainboxes.io.connection.TCPConnection;
import brainboxes.io.device.*;
import brainboxes.io.protocol.ASCIIProtocol;

public class box2 extends AppCompatActivity {

    ArrayList<Button> outButtons = new ArrayList<Button>();
    ArrayList<Integer> tapCounters = new ArrayList<Integer>();
    Button backButton;
    EDDevice EDDevice1;
    String response = "";
    final Handler handler = new Handler();
    final int brainBoxNum = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        InitializeUI();
        InitializeBrainBoxes();
        buttonOnClickListeners();
        connect();
        setButtonCompletionStatus();

    }

    public void buttonOnClickListeners() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacksAndMessages(null);
                turnOffAllPorts();
                EDDevice1.Disconnect();
                startActivity(new Intent(box2.this, MainActivity.class));
            }
        });


        //button 1
        outButtons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(0, tapCounters.get(0) + 1);

                if (tapCounters.get(0) == 1) {
                    outButtons.get(0).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(0) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A001");
                    System.out.println("Reponse: " + response);
                    outButtons.get(0).setBackgroundColor((0xFFB6610B));


                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A000");
                            System.out.println("Reponse: " + response);
                            outButtons.get(0).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 0, true);
                            tapCounters.set(0, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 2
        outButtons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(1, tapCounters.get(1) + 1);

                if (tapCounters.get(1) == 1) {
                    outButtons.get(1).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(1) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A101");
                    System.out.println("Reponse: " + response);
                    outButtons.get(1).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A100");
                            System.out.println("Reponse: " + response);
                            outButtons.get(1).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 1, true);
                            tapCounters.set(1, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 3
        outButtons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(2, tapCounters.get(2) + 1);

                if (tapCounters.get(2) == 1) {
                    outButtons.get(2).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(2) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A201");
                    System.out.println("Reponse: " + response);
                    outButtons.get(2).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A200");
                            System.out.println("Reponse: " + response);
                            outButtons.get(2).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 2, true);
                            tapCounters.set(2, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 4
        outButtons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(3, tapCounters.get(3) + 1);

                if (tapCounters.get(3) == 1) {
                    outButtons.get(3).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(3) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A301");
                    System.out.println("Reponse: " + response);
                    outButtons.get(3).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A300");
                            System.out.println("Reponse: " + response);
                            outButtons.get(3).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 3, true);
                            tapCounters.set(3, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 5
        outButtons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(4, tapCounters.get(4) + 1);

                if (tapCounters.get(4) == 1) {
                    outButtons.get(4).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(4) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A401");
                    System.out.println("Reponse: " + response);
                    outButtons.get(4).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A400");
                            System.out.println("Reponse: " + response);
                            outButtons.get(4).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 4, true);
                            tapCounters.set(4, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 6
        outButtons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(5, tapCounters.get(5) + 1);

                if (tapCounters.get(5) == 1) {
                    outButtons.get(5).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(5) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A501");
                    System.out.println("Reponse: " + response);
                    outButtons.get(5).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A500");
                            System.out.println("Reponse: " + response);
                            outButtons.get(5).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 5, true);
                            tapCounters.set(5, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 7
        outButtons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(6, tapCounters.get(6) + 1);

                if (tapCounters.get(6) == 1) {
                    outButtons.get(6).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(6) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A601");
                    System.out.println("Reponse: " + response);
                    outButtons.get(6).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A600");
                            System.out.println("Reponse: " + response);
                            outButtons.get(6).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 6, true);
                            tapCounters.set(6, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 8
        outButtons.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(7, tapCounters.get(7) + 1);

                if (tapCounters.get(7) == 1) {
                    outButtons.get(7).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(7) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01A701");
                    System.out.println("Reponse: " + response);
                    outButtons.get(7).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01A700");
                            System.out.println("Reponse: " + response);
                            outButtons.get(7).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 7, true);
                            tapCounters.set(7, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 9
        outButtons.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(8, tapCounters.get(8) + 1);

                if (tapCounters.get(8) == 1) {
                    outButtons.get(8).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(8) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B001");
                    System.out.println("Reponse: " + response);
                    outButtons.get(8).setBackgroundColor((0xFFB6610B));


                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B000");
                            System.out.println("Reponse: " + response);
                            outButtons.get(8).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 8, true);
                            tapCounters.set(8, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 10
        outButtons.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(9, tapCounters.get(9) + 1);

                if (tapCounters.get(9) == 1) {
                    outButtons.get(9).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(9) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B101");
                    System.out.println("Reponse: " + response);
                    outButtons.get(9).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B100");
                            System.out.println("Reponse: " + response);
                            outButtons.get(9).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 9, true);
                            tapCounters.set(9, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 11
        outButtons.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(10, tapCounters.get(10) + 1);

                if (tapCounters.get(10) == 1) {
                    outButtons.get(10).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(10) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B201");
                    System.out.println("Reponse: " + response);
                    outButtons.get(10).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B200");
                            System.out.println("Reponse: " + response);
                            outButtons.get(10).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 10, true);
                            tapCounters.set(10, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 12
        outButtons.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(11, tapCounters.get(11) + 1);

                if (tapCounters.get(11) == 1) {
                    outButtons.get(11).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(11) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B301");
                    System.out.println("Reponse: " + response);
                    outButtons.get(11).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B300");
                            System.out.println("Reponse: " + response);
                            outButtons.get(11).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 11, true);
                            tapCounters.set(11, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 13
        outButtons.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(12, tapCounters.get(12) + 1);

                if (tapCounters.get(12) == 1) {
                    outButtons.get(12).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(12) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B401");
                    System.out.println("Reponse: " + response);
                    outButtons.get(12).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B400");
                            System.out.println("Reponse: " + response);
                            outButtons.get(12).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 12, true);
                            tapCounters.set(12, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 14
        outButtons.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(13, tapCounters.get(13) + 1);

                if (tapCounters.get(13) == 1) {
                    outButtons.get(13).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(13) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B501");
                    System.out.println("Reponse: " + response);
                    outButtons.get(13).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B500");
                            System.out.println("Reponse: " + response);
                            outButtons.get(13).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 13, true);
                            tapCounters.set(13, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 15
        outButtons.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(14, tapCounters.get(14) + 1);

                if (tapCounters.get(14) == 1) {
                    outButtons.get(14).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(14) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B601");
                    System.out.println("Reponse: " + response);
                    outButtons.get(14).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B600");
                            System.out.println("Reponse: " + response);
                            outButtons.get(14).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 14, true);
                            tapCounters.set(14, 0);
                        }
                    }, 4000);
                }
            }
        });

        //button 16
        outButtons.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tapCounters.set(15, tapCounters.get(15) + 1);

                if (tapCounters.get(15) == 1) {
                    outButtons.get(15).setBackgroundColor((0xFFFFA500));
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 250);
                } else if (tapCounters.get(15) == 2) {
                    //on
                    response = EDDevice1.SendCommand("#01B701");
                    System.out.println("Reponse: " + response);
                    outButtons.get(15).setBackgroundColor((0xFFB6610B));

                    //wait
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //off
                            response = EDDevice1.SendCommand("#01B700");
                            System.out.println("Reponse: " + response);
                            outButtons.get(15).setBackgroundColor((0xFF696969));
                            Constants.setRunStatus(brainBoxNum, 15, true);
                            tapCounters.set(15, 0);
                        }
                    }, 4000);
                }
            }
        });


    }

    public void InitializeUI() {
        backButton = (Button) findViewById(R.id.backButton);
        outButtons.add((Button) findViewById(R.id.bb2b1));
        outButtons.add((Button) findViewById(R.id.bb2b2));
        outButtons.add((Button) findViewById(R.id.bb2b3));
        outButtons.add((Button) findViewById(R.id.bb2b4));
        outButtons.add((Button) findViewById(R.id.bb2b5));
        outButtons.add((Button) findViewById(R.id.bb2b6));
        outButtons.add((Button) findViewById(R.id.bb2b7));
        outButtons.add((Button) findViewById(R.id.bb2b8));
        outButtons.add((Button) findViewById(R.id.bb2b9));
        outButtons.add((Button) findViewById(R.id.bb2b10));
        outButtons.add((Button) findViewById(R.id.bb2b11));
        outButtons.add((Button) findViewById(R.id.bb2b12));
        outButtons.add((Button) findViewById(R.id.bb2b13));
        outButtons.add((Button) findViewById(R.id.bb2b14));
        outButtons.add((Button) findViewById(R.id.bb2b15));
        outButtons.add((Button) findViewById(R.id.bb2b16));
        for(int j = 0; j < 16; j++)
        {
            tapCounters.add(0);
        }
    }

    public void InitializeBrainBoxes()
    {
        //connections
        IConnection tcpConnection1 = new TCPConnection("10.0.0.5", 9500);

        //device objects
        EDDevice1 = new EDDevice(tcpConnection1, new ASCIIProtocol());
    }

    public void connect()
    {
        try{
            System.out.println("Connecting...");
            EDDevice1.Connect();
            System.out.println("Connected");
        } catch (Exception e){
            System.out.println("Error Connecting: " + e.getMessage());
        }

        //setting button colors
        if(EDDevice1.IsConnected())
        {
            for(Button b : outButtons)
            {
                b.setBackgroundColor((0xFF00FF00));
            }
        }
        else
        {
            for(Button b : outButtons)
            {
                startActivity(new Intent(box2.this, MainActivity.class));
            }
        }
    }

    public void turnOffAllPorts()
    {
        //first 0-7
        for(int i = 0; i < 8; i++)
        {
            EDDevice1.SendCommand("#01A" + i + "00");
        }
        //last 8-15
        for(int i = 0; i < 8; i++)
        {
            EDDevice1.SendCommand("#01B" + i + "00");
        }
    }

    public void setButtonCompletionStatus()
    {
        for(int i = 0; i < 16; i++)
        {
            if(Constants.getRunStatus(brainBoxNum, i) == false)
            {
                outButtons.get(i).setBackgroundColor((0xFF00FF00));
            }
            else
            {
                outButtons.get(i).setBackgroundColor((0xFF696969));
            }
        }
    }
}