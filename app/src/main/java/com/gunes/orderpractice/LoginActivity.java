package com.gunes.orderpractice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

/**
 * Created by MGunes on 2019-09-18.
 */
public class LoginActivity extends AppCompatActivity {


    private TextInputEditText username;
    private TextInputEditText pass;
    private Switch rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        username.setText("kariyer");
        pass = findViewById(R.id.login_password);
        pass.setText("2019ADev");
        rememberMe = findViewById(R.id.login_rememberme);
        rememberMe.setChecked(true);
    }

    public void login(View view) {
        if (username.getText().toString().isEmpty()) {
            Toast.makeText(this, "Kullanıcı Adı Boş Olamaz.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.getText().toString().isEmpty()) {
            Toast.makeText(this, "Şifre Boş Olamaz.", Toast.LENGTH_SHORT).show();
            return;
        }


        if (username.getText().toString().equals("kariyer") && pass.getText().toString().equals("2019ADev")) {

            if (rememberMe.isChecked()) {
                SharedPreferences sharedPreferences = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("rememberme",true);
                editor.apply();
                editor.commit();
            }

            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Kullanıcı Bilgileri Hatalı.", Toast.LENGTH_SHORT).show();
        }


    }

}
