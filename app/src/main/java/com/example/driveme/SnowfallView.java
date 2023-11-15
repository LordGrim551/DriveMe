package com.example.driveme;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class SnowfallView extends View {
    private static final int NUM_SNOWFLAKES = 100;
    private final Snowflake[] snowflakes = new Snowflake[NUM_SNOWFLAKES];
    private int viewWidth, viewHeight;

    public SnowfallView(Context context) {
        super(context);
        init();
    }

    public SnowfallView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            snowflakes[i] = new Snowflake();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
        for (Snowflake snowflake : snowflakes) {
            snowflake.reset();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT); // Limpiar el lienzo en cada dibujo

        for (Snowflake snowflake : snowflakes) {
            snowflake.draw(canvas);
        }
        postInvalidateOnAnimation();
    }

    private class Snowflake {
        private float x;
        private float y;
        private final Paint paint;
        private final Random random;

        public Snowflake() {
            random = new Random();
            paint = new Paint();
            paint.setColor(Color.WHITE);
        }

        public void reset() {
            x = random.nextInt(viewWidth);
            y = -random.nextInt(viewHeight); // Inicia los copos arriba de la pantalla
        }

        public void draw(Canvas canvas) {
            canvas.drawCircle(x, y, 5, paint);
            y += 5; // Ajusta la velocidad
            if (y > viewHeight) {
                reset();
            }
        }
    }
}
