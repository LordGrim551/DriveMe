package com.example.driveme;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginScreen extends AppCompatActivity {
    String texto = "";
    AlertDialog alertDialog; // Declare AlertDialog as a member variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_screen);



        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        ImageView logoDVM = findViewById(R.id.imageView2);
        TextView nameDVM = findViewById(R.id.textView);
        logoDVM.setAnimation(animacion1);
        nameDVM.setAnimation(animacion2);

        SnowfallView snowfallView = findViewById(R.id.snowfallView);
        // Personaliza la vista si es necesario

        TextView textView = findViewById(R.id.recuperarBoton);

        // Crea un objeto TextInputLayout
        final TextInputLayout textInputLayout = new TextInputLayout(LoginScreen.this);
        textInputLayout.setHint("Email Address");

        // Crea un objeto TextInputEditText
        final TextInputEditText textInputEditText = new TextInputEditText(textInputLayout.getContext());
        textInputEditText.setTypeface(Typeface.create("sans-serif-light", Typeface.BOLD));
        textInputLayout.addView(textInputEditText);

        alertDialog = new MaterialAlertDialogBuilder(LoginScreen.this)
                .setTitle("INTRODUCE YOUR EMAIL ADDRESS")
                .setView(textInputLayout)  // Establece el TextInputLayout como la vista
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Usa MessageFormat.format() para formatear el texto
                        String emailAddress = textInputEditText.getText().toString();
                        Toast.makeText(LoginScreen.this, "SE HA ENVIADO EL CORREO CORRECTAMENTE", Toast.LENGTH_LONG).show();

                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show the AlertDialog when the TextView is clicked
                alertDialog.show();
            }
        });


    }

    public void changeRegister(View view) {
        Intent nIntent = new Intent(LoginScreen.this, RegisterScreen.class);
        startActivity(nIntent);
    }

    public void loginButton(View view) {
        Toast.makeText(LoginScreen.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
    }
}
