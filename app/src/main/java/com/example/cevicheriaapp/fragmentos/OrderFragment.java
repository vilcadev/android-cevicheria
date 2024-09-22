package com.example.cevicheriaapp.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cevicheriaapp.R;

public class OrderFragment extends Fragment {

    private static final String ARG_MESA_NUMERO = "mesa_numero";  // Llave para pasar el número de mesa

    private int mesaNumero;  // Variable para guardar el número de mesa

    public OrderFragment() {
        // Constructor vacío requerido
    }

    // Método estático para instanciar el fragmento y recibir el número de mesa
    public static OrderFragment newInstance(int mesaNumero) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_MESA_NUMERO, mesaNumero);  // Pasar el número de mesa
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Obtener el número de mesa del Bundle
            mesaNumero = getArguments().getInt(ARG_MESA_NUMERO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar la vista para este fragmento
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener el TextView de la interfaz
        TextView mesaNumeroTextView = view.findViewById(R.id.tableNumber);

        // Mostrar el número de mesa en el TextView
        mesaNumeroTextView.setText("Mesa: " + mesaNumero);
    }
}
