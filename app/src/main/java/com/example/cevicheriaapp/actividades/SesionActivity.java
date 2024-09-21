package com.example.cevicheriaapp.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cevicheriaapp.R;

public class SesionActivity extends AppCompatActivity implements View.OnClickListener{
    EditText    txtUsuario, txtContra;
    Button  btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtUsuario = findViewById(R.id.logTxtUsuario);
        txtContra = findViewById(R.id.logTxtContrasena);
        btnIngresar = findViewById(R.id.logBtnIngresar);

        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.logBtnIngresar){
            iniciarSesion(txtUsuario.getText().toString(), txtContra.getText().toString(), false);

        }

    }

    private void iniciarSesion(String string, String string1, boolean b) {
        if(string.equals("omar@upn.pe") && string1.equals("Abc123$")){
            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("nombre", "Omar");
            startActivity(main);
            finish();
        }
        else{
            Toast.makeText(this,"Verificar cuenta",Toast.LENGTH_LONG).show();
        }
    }
}