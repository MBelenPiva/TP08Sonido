package com.example.tpsonido;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    SoundPool soundPool;
    int sonido1,
            sonido2,
            sonido3;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObtenerReferencias();

        SetearListeners();
            if (Build.VERSION.SDK_INT
                    >= Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes
                        audioAttributes
                        = new AudioAttributes
                        .Builder()
                        .setUsage(
                                AudioAttributes
                                        .USAGE_ASSISTANCE_SONIFICATION)
                        .setContentType(
                                AudioAttributes
                                        .CONTENT_TYPE_SONIFICATION)
                        .build();
                soundPool
                        = new SoundPool
                        .Builder()
                        .setMaxStreams(3)
                        .setAudioAttributes(
                                audioAttributes)
                        .build();
            }
            else {
                soundPool
                        = new SoundPool(
                        3,
                        AudioManager.STREAM_MUSIC,
                        0);
            }
            sonido1
                    = soundPool
                    .load(
                            this,
                            R.raw.sonido1,
                            1);
            sonido2
                    = soundPool.load(
                    this,
                    R.raw.sonido2,
                    1);
            sonido3
                    = soundPool.load(
                    this,
                    R.raw.sonido3,
                    1);
        }
    public void playSound(View v)
    {
        switch (v.getId()) {

            case R.id.btn1:

                // This play function
                // takes five parameter
                // leftVolume, rightVolume,
                // priority, loop and rate.
                soundPool.play(
                        sonido1, 1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;

            case R.id.btn2:
                soundPool.play(
                        sonido2, 1, 1, 0, 0, 1);
                break;

            case R.id.btn3:
                soundPool.play(
                        sonido3, 1, 1, 0, 0, 1);
                break;
        }
    }
    private void ObtenerReferencias() {
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
    }

    private void SetearListeners() {
        btn1.setOnClickListener(btn1_Click);
        btn2.setOnClickListener(btn2_Click);
        btn3.setOnClickListener(btn3_Click);
    }

    private View.OnClickListener btn1_Click = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener btn2_Click = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener btn3_Click = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
};
}