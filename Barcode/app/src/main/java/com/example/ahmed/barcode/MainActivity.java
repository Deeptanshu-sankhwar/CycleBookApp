package com.example.ahmed.barcode;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    Button startBtn;
    Button stopBtn;
    TextView countDown;
    private static final String FORMAT = "%02d:%02d:%02d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        final CountDownTimer timer =new CountDownTimer(14400000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDown.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                countDown.setText("done!");
            }

        };
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.start();
                startBtn.setEnabled(false);
                stopBtn.setEnabled(true);
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                countDown.setText("00:00:00");
                stopBtn.setEnabled(false);
                startBtn.setEnabled(true);
            }
        });
    }
    void getControls(){
        startBtn = (Button)findViewById(R.id.startbtn);
        stopBtn = (Button)findViewById(R.id.stopbtn);
        countDown =(TextView) findViewById(R.id.chronometer2);

    }
}
