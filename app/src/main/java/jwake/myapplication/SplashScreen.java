package jwake.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences introFirstTime = getSharedPreferences("introInfo", Context.MODE_PRIVATE);
                Intent i;
                if(introFirstTime.getBoolean("introInfo", false) == true) {
                    i = new Intent(SplashScreen.this, HomeScreen.class);
                }

                else{
                    i = new Intent(SplashScreen.this, IntroScreen.class);
                }

                startActivity(i);
                finish();

            }
        }, 3000);
    }

}
