package com.example.cevicheriaapp.fragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast; // Importa Toast para mostrar mensajes
import androidx.fragment.app.FragmentTransaction;

import com.example.cevicheriaapp.R;

public class DeliveryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DeliveryFragment() {
        // Required empty public constructor
    }

    public static DeliveryFragment newInstance(String param1, String param2) {
        DeliveryFragment fragment = new DeliveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        View cardView = view.findViewById(R.id.pedido1); // Cambia "cardViewId" por el ID real de tu CardView


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega al OrderDetailsFragment
                Fragment orderDetailsFragment = new DetallePedidoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, orderDetailsFragment); // Cambia "fragment_container" por el ID real de tu contenedor de fragmentos
                transaction.addToBackStack(null); // Agrega a la pila de retroceso
                transaction.commit();
            }
        });

        View cardViewPedido2 = view.findViewById(R.id.pedido2); // Asegúrate de que el ID sea correcto
        cardViewPedido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment detallePedidoFragment = new DetallePedidoFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, detallePedidoFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
