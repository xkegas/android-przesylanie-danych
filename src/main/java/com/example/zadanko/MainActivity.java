package com.example.zadanko;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Register(View view) {
        EditText imie = findViewById(R.id.imie);
        EditText nazwisko = findViewById(R.id.nazwisko);
        EditText email = findViewById(R.id.email);
        EditText haslo = findViewById(R.id.haslo);
        EditText potwierdzHaslo = findViewById(R.id.potwierdzHaslo);

        if(imie.getText().toString().isEmpty() || nazwisko.getText().toString().isEmpty() || email.getText().toString().isEmpty() || haslo.getText().toString().isEmpty() || potwierdzHaslo.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Pola nie mogą być puste!", Toast.LENGTH_LONG).show();
        }
        else if(!email.getText().toString().contains("@") && !email.getText().toString().contains("."))
        {
            Toast.makeText(getApplicationContext(), "Wpisz poprawny adres E-Mail!", Toast.LENGTH_LONG).show();
        }
        else if(!haslo.getText().toString().equals(potwierdzHaslo.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Hasła nie są takie same!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(this, UserInfoActivity.class);
            intent.putExtra(UserInfoActivity.Imie, imie.getText().toString());
            intent.putExtra(UserInfoActivity.Nazwisko, nazwisko.getText().toString());
            intent.putExtra(UserInfoActivity.Email, email.getText().toString());
            intent.putExtra(UserInfoActivity.Haslo, haslo.getText().toString());
            startActivity(intent);
        }
    }
}