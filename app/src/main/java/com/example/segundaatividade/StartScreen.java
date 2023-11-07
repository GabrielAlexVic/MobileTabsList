package com.example.segundaatividade;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartScreen extends AppCompatActivity {

    Handler mTextHandler;
    Runnable mTextRunnable;
    Handler mStartHandler;
    Runnable mStartRunnable;
    TextView mLoadingText;
    int mDotCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        mLoadingText = findViewById(R.id.loading_text);
        mDotCount = 0;

        mTextHandler = new Handler();
        mTextRunnable = new Runnable() {
            @Override
            public void run() {
                updateLoadingText();
                mTextHandler.postDelayed(mTextRunnable, 1000);
            }
        };

        mStartHandler = new Handler();
        mStartRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        mTextHandler.post(mTextRunnable);
        //splashscreen timer
        mStartHandler.postDelayed(mStartRunnable, 5000);
    }

    private void updateLoadingText() {
        mDotCount = (mDotCount % 3) + 1;
        String text = "Carregando";
        for (int i = 0; i < mDotCount; i++) {
            text += ".";
        }
        mLoadingText.setText(text);
    }
}
