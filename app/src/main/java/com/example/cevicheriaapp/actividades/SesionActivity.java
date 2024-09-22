package com.example.cevicheriaapp.actividades;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    CheckBox chkRecordar;

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

        chkRecordar = findViewById(R.id.logChkRecordar);


        // Inicializa SharedPreferences
       SharedPreferences sharedPreferences = getSharedPreferences("Sesion", MODE_PRIVATE);

        // Verificar si la sesión sigue activa
        if (sharedPreferences.getBoolean("sesionIniciada", false)) {
            // Si la sesión está activa, redirigir a MainActivity inmediatamente
            Intent main = new Intent(SesionActivity.this, MainActivity.class);
            startActivity(main);
            finish(); // Finaliza SesionActivity para evitar volver a esta pantalla
            return; // Termina la ejecución de onCreate
        }

        btnIngresar.setOnClickListener(this);

        cargarCredenciales();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.logBtnIngresar){
            boolean recordarSesion = chkRecordar.isChecked();
            iniciarSesion(txtUsuario.getText().toString(), txtContra.getText().toString(), recordarSesion);

        }

    }

    private void iniciarSesion(String string, String string1, boolean recordar) {
        if(string.equals("omar@upn.pe") && string1.equals("Abc123$")){

            if (recordar) {
                // Guardar credenciales en SharedPreferences
                guardarCredenciales(string, string1);
            }

            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("nombre", "Omar");
            startActivity(main);
            finish();
        }
        else{
            Toast.makeText(this,"Verificar cuenta",Toast.LENGTH_LONG).show();
        }
    }

    private void guardarCredenciales(String usuario, String contrasena) {
        SharedPreferences preferences = getSharedPreferences("Sesion", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario", usuario);
        editor.putString("contrasena", contrasena);
        editor.putBoolean("sesionIniciada", true);
        editor.apply();
    }


    private void cargarCredenciales() {
        SharedPreferences preferences = getSharedPreferences("Sesion", MODE_PRIVATE);
        String usuario = preferences.getString("usuario", null);
        String contrasena = preferences.getString("contrasena", null);

        if (usuario != null && contrasena != null) {
            txtUsuario.setText(usuario);
            txtContra.setText(contrasena);
            chkRecordar.setChecked(true);  // Marcamos el checkbox si se cargaron las credenciales
        }
    }

}