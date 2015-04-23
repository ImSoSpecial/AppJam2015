package jwake.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;


public class SplashScreen extends Activity {

    ImageView iv1;
    AnimationDrawable Anim;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mp = MediaPlayer.create(SplashScreen.this, R.raw.splashsound);
        iv1 = (ImageView) findViewById(R.id.splashView);
        iv1.setBackgroundResource(R.drawable.animatesplash);

        Anim = (AnimationDrawable) iv1.getBackground(); //new AnimationDrawable();
        Anim.start();
        mp.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences introFirstTime = getSharedPreferences("introInfo", Context.MODE_PRIVATE);
                Intent i;
                if (introFirstTime.getBoolean("introInfo", false) == true) {
                    i = new Intent(SplashScreen.this, StruggleQuestionScreen.class);
                } else {
                    i = new Intent(SplashScreen.this, IntroductionScreen.class);
                }
                startActivity(i);
                finish();

            }
        }, 3000);
    }
}
