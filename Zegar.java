package s226939.kubens072;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Zegar extends View
{
    private Paint p;
    private Paint godziny;
    private Paint minuty;
    private Paint sekundy;

    private int hour = 0;
    private int minute = 0;
    private int seconds = 0;

    public Zegar(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.WHITE);

        godziny = new Paint(Paint.ANTI_ALIAS_FLAG);
        godziny.setColor(Color.GREEN);
        godziny.setStrokeWidth(10);

        minuty = new Paint(Paint.ANTI_ALIAS_FLAG);
        minuty.setColor(Color.BLACK);
        minuty.setStrokeWidth(5);

        sekundy = new Paint(Paint.ANTI_ALIAS_FLAG);
        sekundy.setColor(Color.RED);
        sekundy.setStrokeWidth(5);
    }

    public Point getMinutePos(int minute)
    {
        int xminute = (int) (Math.cos(minute * 3.14f / 30 - 3.14f / 2) * 100 + 100);
        int yminute = (int) (Math.sin(minute * 3.14f / 30 - 3.14f / 2) * 100 + 100);
        return new Point(xminute, yminute);
    }

    public Point getHourPos(int hour, int minute)
    {
        int xhour = (int) (Math.cos((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + 100);
        int yhour = (int) (Math.sin((hour * 30 + minute / 2) * 3.14f / 180 - 3.14f / 2) * 80 + 100);
        return new Point(xhour, yhour);
    }

    public void refresh(String h, String m, String s)
    {
        hour = Integer.parseInt(h);
        minute = Integer.parseInt(m);
        seconds = Integer.parseInt(s);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(100,100,100,p);
        canvas.drawLine(100, 100, getHourPos(hour, minute).x, getHourPos(hour, minute).y, godziny);
        canvas.drawLine(100, 100, getMinutePos(minute).x, getMinutePos(minute).y, minuty);
        canvas.drawLine(100, 100, getMinutePos(seconds).x, getMinutePos(seconds).y, sekundy);
    }
}
