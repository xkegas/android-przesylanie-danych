package com.example.zadanko;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class UserInfoActivity extends AppCompatActivity {
    public static final String Imie = "imie";
    public static final String Nazwisko = "nazwisko";
    public static final String Email = "mail@host.pl";
    public static final String Haslo = "haslo";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Intent intent = getIntent();

        TextView imieText = findViewById(R.id.imieTekst);
        TextView nazwiskoText = findViewById(R.id.nazwiskoTekst);
        TextView EmailText = findViewById(R.id.emailTekst);
        TextView HasloText = findViewById(R.id.hasloTekst);

        String imie = intent.getStringExtra(Imie);
        imieText.setText("Imie: " + imie);

        String nazwisko = intent.getStringExtra(Nazwisko);
        nazwiskoText.setText("Nazwisko: " + nazwisko);

        String email = intent.getStringExtra(Email);
        EmailText.setText("Email: " + email);

        String haslo = intent.getStringExtra(Haslo);
        StringBuilder hasloZamienione = new StringBuilder();
        for(int i = 0; i < Objects.requireNonNull(haslo).length(); i++)
        {
            hasloZamienione.append("*");
        }
        HasloText.setText("Haslo: " + hasloZamienione);

    }
}