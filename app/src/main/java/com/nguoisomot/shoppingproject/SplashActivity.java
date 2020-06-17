package com.nguoisomot.shoppingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();

        SystemClock.sleep(1000);
        FirebaseUser current = firebaseAuth.getCurrentUser();
        ///// Chinh sua
        if (current == null) {
            Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
        ///// Chinh sua
//        Intent LoginIntent = new Intent(SplashActivity.this, RegisterActivity.class);
//        startActivity(LoginIntent);
//        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser current = firebaseAuth.getCurrentUser();

        if (current == null) {
            Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }
}
