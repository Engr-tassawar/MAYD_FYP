package simpleActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mayd.R;

public class splash_screen extends AppCompatActivity {
ImageView imgLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //getSupportActionBar().hide();
        imgLogo =findViewById(R.id.logo);

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                  Intent intent=new Intent(splash_screen.this, home1.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}