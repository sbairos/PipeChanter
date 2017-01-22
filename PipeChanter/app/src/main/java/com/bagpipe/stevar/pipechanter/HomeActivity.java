package com.bagpipe.stevar.pipechanter;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class HomeActivity extends AppCompatActivity {

    private boolean gCovered = false;
    private boolean aCovered = false;
    private boolean bCovered = false;
    private boolean cCovered = false;
    private boolean dCovered = false;
    private boolean eCovered = false;
    private boolean fCovered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button gButton = (Button) findViewById(R.id.g_finger);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Here's where we're going to continually check the status of the buttons that are pressed.
    }

}
