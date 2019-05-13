package s226939.kubens072;



import android.os.Handler;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockThread implements Runnable {

    private Handler handler;
    private Zegar zegar;

    public ClockThread(Zegar z, Handler h)
    {
        zegar = z;
        handler = h;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);

                Date date = new Date();
                Format fHour = new SimpleDateFormat("HH");
                Format fMinute = new SimpleDateFormat("mm");
                Format fSeconds = new SimpleDateFormat("ss");
                final String hour = fHour.format(date);
                final String minute = fMinute.format(date);
                final String seconds = fSeconds.format(date);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        zegar.refresh(hour, minute, seconds);
                        zegar.invalidate();
                    }
                });
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
