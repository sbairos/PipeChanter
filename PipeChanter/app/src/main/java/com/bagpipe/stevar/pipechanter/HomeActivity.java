package com.bagpipe.stevar.pipechanter;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private int gSound;
    private int aSound;

    MediaPlayer player;
    SoundPool sounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        player = MediaPlayer.create(HomeActivity.this, R.raw.arkells);
        sounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

        sounds.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status != 0 ) {
                    System.out.println("FAILED");
                } else {
                    System.out.println("WOrked");
                }
            }
        });


        aSound = sounds.load(HomeActivity.this, R.raw.arkells, 1);
        System.out.println("asound = " + aSound);
//        gSound = sounds.load(HomeActivity.this, R.raw.grouplove, 1);




        setListeners();
    }

    private void setListeners() {

        Button gButton = (Button) findViewById(R.id.g_finger);
        gButton.setOnTouchListener(new MyOnTouchListener(gCovered, aSound));
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
        aButton.setOnTouchListener(new MyOnTouchListener(aCovered, aSound));
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
        bButton.setOnTouchListener(new MyOnTouchListener(bCovered, aSound));

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
        cButton.setOnTouchListener(new MyOnTouchListener(cCovered, aSound));

        Button dButton = (Button) findViewById(R.id.d_finger);
        dButton.setOnTouchListener(new MyOnTouchListener(dCovered, aSound));

        Button eButton = (Button) findViewById(R.id.e_finger);
        eButton.setOnTouchListener(new MyOnTouchListener(eCovered, aSound));


        Button fButton = (Button) findViewById(R.id.f_finger);
        fButton.setOnTouchListener(new MyOnTouchListener(fCovered, aSound));

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


//        MediaPlayer player = MediaPlayer.create(HomeActivity.this, R.raw.arkells);
//        try {
//            wait(100);
//            if (gCovered.getValue()) {
//                System.out.println("playing");
//                player.start();
//            } else if (player.isPlaying()) {
//                System.out.println("stopping");
//                player.pause();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted");
//        }
        // Here's where we're going to continually check the status of the buttons that are pressed.
    }

    @Override
    protected void onStop() {
        super.onStop();
        sounds.release();
    }

    public void chooseNote() {
        /*
        This is tough to choose whether or not to choose the note from top down or do a divide and conquer thing?
        Since top down is at worst 9 if statements and the divide and conquer is average case 3.5 ifs but worst case
        would be more because of grace notes
         */
    }

    class MyOnTouchListener implements View.OnTouchListener{
        private ImmutableBool bool;
        private int mediaId;
        private int currStreamId = 0;

        public MyOnTouchListener(ImmutableBool bool, int mediaId) {
            this.bool = bool;
            System.out.println("ID = " + mediaId);
            this.mediaId = mediaId;
        }

        @Override
        public boolean onTouch(View button, MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    bool.setValue(true);
                    System.out.println(button.getId() +" is " + bool.getValue());
                    currStreamId = sounds.play(mediaId, 1, 1, 0, 0, 1);
                    return true;
                case MotionEvent.ACTION_UP:
                    bool.setValue(false);
                    System.out.println(button.getId() +" is " + bool.getValue());
                    sounds.stop(currStreamId);
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
