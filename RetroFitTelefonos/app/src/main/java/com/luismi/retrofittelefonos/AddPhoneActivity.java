package com.luismi.retrofittelefonos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AddPhoneActivity extends AppCompatActivity {
    Button btnVolver;
    EditText edNombre;
    EditText edColor;
    EditText edCapacidad;
    EditText edPrecio;
    EditText edGeneracion;
    EditText edYear;
    EditText edModelocpu;
    EditText edsizeDds;
    EditText edColorDisgn;
    EditText edTamanio;
    EditText edDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone);
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            // Limpiamos la pila de actividad
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        });

    }
}