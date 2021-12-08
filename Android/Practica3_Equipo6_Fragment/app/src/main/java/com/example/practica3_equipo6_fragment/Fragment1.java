package com.example.practica3_equipo6_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    private TextView nombre;
    private TextView des;
    private ImageView imagen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static String mParam1;
    private static int accion;
    private String mParam2;
    private String text;
    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2, int acc) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        accion = acc;
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
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        nombre = view.findViewById(R.id.miau);
        des = view.findViewById(R.id.descripcion1);
        imagen = view.findViewById(R.id.imagen);
        if(accion == 1){
            nombre.setText("Ballenas");
            des.setText("Las ballenas son los animales más grandes que jamás hayan existido. Pertenecen a un grupo de mamíferos marinos conocidos como cetáceos. No son peces porque tienen sangre caliente, respiran aire a través de pulmones y dan a luz a crías vivas que se alimentan de leche materna.");
            imagen.setImageResource(R.drawable.ballena);
        } else if(accion == 2){
            nombre.setText("Rana flecha venenosa azul ");
            des.setText("La Rana Flecha Azul puede presentar varios colores que van del azul claro a tonalidades púrpura. Es este color el que advierte a los depredadores de su toxicidad y una de sus características más destacadas. Además de ser hermosos, con mucha elegancia, extremadamente geniales y perfectos. ");
            imagen.setImageResource(R.drawable.uwu);
        } else if(accion == 3){
            nombre.setText("Pingüinos");
            des.setText("Los pingüinos son aquellas aves que se engloban dentro de la familia Spheniscidae y a su vez dentro del orden de los Sphenisciformes.\n" +
                    "Se trata de un grupo de aves marinas no voladoras, en el que se pueden diferenciar hasta 18 especies diferentes las cuales que se distribuyen -exceptuando el pingüino de las islas Galápagos- exclusivamente en el hemisferio sur. \n");
            imagen.setImageResource(R.drawable.pinguino);
        }
        return view;
    }
}