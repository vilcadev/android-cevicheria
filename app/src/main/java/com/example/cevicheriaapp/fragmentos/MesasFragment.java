package com.example.cevicheriaapp.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cevicheriaapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MesasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MesasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MesasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MesasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MesasFragment newInstance(String param1, String param2) {
        MesasFragment fragment = new MesasFragment();
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
        View view = inflater.inflate(R.layout.fragment_mesas, container, false);

        // Referencia al botón
        Button btnIrAOrden = view.findViewById(R.id.mesa1_button);

        // Configurar el listener del botón
        btnIrAOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Valor que quieres pasar
                String valorParaOrden = "# de la mesa";


                OrderFragment ordenFragment = OrderFragment.newInstance(valorParaOrden,valorParaOrden);


                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, ordenFragment)
                        .addToBackStack(null)  // Agregar a la pila para poder volver atrás
                        .commit();

//                // Reemplazar el fragmento actual con OrdenFragment
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragment_container, new OrderFragment());
//                transaction.addToBackStack(null); // Para que se pueda volver atrás
//                transaction.commit();
            }
        });

        return view;
    }
}