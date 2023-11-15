package com.example.driveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.time.Instant;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        ImageView logoDVM = findViewById(R.id.imageView2);
        TextView nameDVM = findViewById(R.id.textView);
        logoDVM.setAnimation(animacion1);
        nameDVM.setAnimation(animacion2);


        ImageView backgroundRegister = findViewById(R.id.backgroundRegister);
        Glide.with(this)
                .load("https://cdnb.20m.es/nilibreniocupado/files/madrid-noche.gif")
                .into(backgroundRegister);

    }
    public void registerButton (View view) {

        Toast.makeText(RegisterScreen.this,"REGISTER SUCCESS",Toast.LENGTH_SHORT).show();
    }
    public void changeLogin (View view) {
        Intent nIntent = new Intent(RegisterScreen.this, LoginScreen.class);
        startActivity(nIntent);
    }



}