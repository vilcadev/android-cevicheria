package com.example.cevicheriaapp.fragmentos;

import static com.example.cevicheriaapp.R.id.layoutTerminosCondiciones;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.FragmentTransaction;

import com.example.cevicheriaapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CuentaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CuentaFragment extends Fragment {

    private Button btnInformacionCuenta;
    private Button btnRestablecerContrasena;
    private LinearLayout layoutTerminosCondiciones;

    public CuentaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cuenta, container, false);

        // Encontrar los botones en el layout
        btnInformacionCuenta = view.findViewById(R.id.btnInformacionCuenta);
        btnRestablecerContrasena = view.findViewById(R.id.btnRestablecerContrasena);
        layoutTerminosCondiciones = view.findViewById(R.id.layoutTerminosCondiciones);

        // Configurar el listener para el botón de Información de la Cuenta
        btnInformacionCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargar el fragmento de InfoCuentaFragment
                Fragment infoCuentaFragment = new InfoCuentaFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, infoCuentaFragment); // Asegúrate de tener un contenedor para los fragmentos
                transaction.addToBackStack(null); // Permite volver al fragmento anterior
                transaction.commit();
            }
        });

        // Configurar el listener para el botón de Restablecer Contraseña
        btnRestablecerContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cargar el fragmento de ResetPasswordFragment
                Fragment resetPasswordFragment = new ResetPasswordFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, resetPasswordFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}