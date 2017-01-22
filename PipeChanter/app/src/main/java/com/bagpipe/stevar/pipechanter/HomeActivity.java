package com.bagpipe.stevar.pipechanter;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class HomeActivity extends AppCompatActivity {

    private ImmutableBool gCovered = new ImmutableBool(false);
    private ImmutableBool aCovered = new ImmutableBool(false);
    private ImmutableBool bCovered = new ImmutableBool(false);
    private ImmutableBool cCovered = new ImmutableBool(false);
    private ImmutableBool dCovered = new ImmutableBool(false);
    private ImmutableBool eCovered = new ImmutableBool(false);
    private ImmutableBool fCovered = new ImmutableBool(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setListeners();
    }

    private void setListeners() {

        Button gButton = (Button) findViewById(R.id.g_finger);
        gButton.setOnTouchListener(new MyOnTouchListener(gCovered));
//        gButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View button, MotionEvent event) {
//                switch(event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        gCovered = true;
//                        System.out.println("G down");
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        gCovered = false;
//                        System.out.println("G up");
//                        return true;
//                }
//                return false;
//            }
//        });

        Button aButton = (Button) findViewById(R.id.a_finger);
        aButton.setOnTouchListener(new MyOnTouchListener(aCovered));
//        aButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View button, MotionEvent event) {
//                switch(event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        aCovered = true;
//                        System.out.println("A " + aCovered);
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        aCovered = false;
//                        System.out.println("A " + aCovered);
//                        return true;
//                }
//                return false;
//            }
//        });
//        System.out.println("STARTING");
        Button bButton = (Button) findViewById(R.id.b_finger);
//        bButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View button, MotionEvent event) {
//                switch(event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        bCovered = true;
//                        System.out.println("B " + bCovered);
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        bCovered = false;
//                        System.out.println("B " + bCovered);
//                        return true;
//                }
//                return false;
//            }
//        });
        bButton.setOnTouchListener(new MyOnTouchListener(bCovered));

        Button cButton = (Button) findViewById(R.id.c_finger);
//        cButton.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View button, MotionEvent event) {
//                switch(event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        System.out.println("G " + gCovered.getValue());
//                        System.out.println("A " + aCovered.getValue());
//                        System.out.println("B " + bCovered.getValue());
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        System.out.println("G " + gCovered.getValue());
//                        System.out.println("A " + aCovered.getValue());
//                        System.out.println("B " + bCovered.getValue());
//                        return true;
//                }
//                return false;
//            }
//        });
        cButton.setOnTouchListener(new MyOnTouchListener(cCovered));

        Button dButton = (Button) findViewById(R.id.d_finger);
        dButton.setOnTouchListener(new MyOnTouchListener(dCovered));

        Button eButton = (Button) findViewById(R.id.e_finger);
        eButton.setOnTouchListener(new MyOnTouchListener(eCovered));


        Button fButton = (Button) findViewById(R.id.f_finger);
        fButton.setOnTouchListener(new MyOnTouchListener(fCovered));

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();

//        try {
//            for (int i = 0; i < 100; i++) {
//                wait(1000);
//                System.out.println("g is " + gCovered);
//            }
//
//        } catch (Exception e) {
//
//        }
        System.out.println("G is " + gCovered);
        System.out.println("WTF");
        // Here's where we're going to continually check the status of the buttons that are pressed.
    }


    class MyOnTouchListener implements View.OnTouchListener{
        ImmutableBool bool;
        public MyOnTouchListener(ImmutableBool bool) {
            this.bool = bool;
        }

        @Override
        public boolean onTouch(View button, MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    bool.setValue(true);
                    System.out.println(button.getId() +" is " + bool.getValue());
                    return true;
                case MotionEvent.ACTION_UP:
                    bool.setValue(false);
                    System.out.println(button.getId() +" is " + bool.getValue());
                    return true;
            }
            return false;
        }
    }

    class ImmutableBool {
        private boolean value;
        public ImmutableBool() {
            value = false;
        }

        public ImmutableBool(boolean val) {
            value = val;
        }

        public void setValue(boolean val) {
            value = val;
        }

        public boolean getValue() {
            return value;
        }

    }
}
