package com.example.cevicheriaapp.fragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;  // Añade esta importación
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;  // Añade esta importación
import com.example.cevicheriaapp.R;

public class ConfiguracionFragment extends Fragment {
    private LinearLayout btnTerminosCondiciones;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracion, container, false);

        // Encuentra el LinearLayout de términos y condiciones
        btnTerminosCondiciones = view.findViewById(R.id.btnTerminosCondiciones);

        // Configura el click listener
        btnTerminosCondiciones.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment terminosFragment = new TerminosFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction(); // Cambiado a getParentFragmentManager()
                transaction.replace(R.id.fragment_container, terminosFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}