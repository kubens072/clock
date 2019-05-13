package s226939.kubens072;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zegar zegar = (Zegar) findViewById(R.id.zegar);

        Thread t = new Thread(new ClockThread(zegar, new Handler()));
        t.start();
    }
}

