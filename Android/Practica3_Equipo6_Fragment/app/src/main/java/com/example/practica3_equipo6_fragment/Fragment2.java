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
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    private TextView nombre;
    private TextView des;
    private ImageView imagen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private static int accion;
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2, int ac) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        accion = ac;
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
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        nombre = view.findViewById(R.id.Nombre2);
        des = view.findViewById(R.id.descripcion2);
        imagen = view.findViewById(R.id.imagen2);
        if(accion == 1){
            nombre.setText("Caballos");
            des.setText("El caballo (Equus ferus caballus)12 es un mamífero perisodáctilo domesticado de la familia de los équidos. Es un herbívoro perisodáctilo de gran porte, y cuello largo y arqueado poblado por largas crines.");
            imagen.setImageResource(R.drawable.caballo);
        } else if(accion == 2){
            nombre.setText("Axolote");
            des.setText("El axolote mexicano (pronunciado ajolote) es una salamandra con la característica poco habitual de conservar sus rasgos larvales en su vida adulta. Esta condición, que se conoce como neotenia, significa que conserva su aleta dorsal de renacuajo -que recorre casi la totalidad de su cuerpo- y sus branquias externas, que sobresalen de la parte trasera de su ancha cabeza en forma de plumas.");
            imagen.setImageResource(R.drawable.axolote);
        } else if(accion == 3){
            nombre.setText("Pavoreal");
            des.setText("El pavo real común2 (Pavo cristatus), también conocido como pavo real de la India o pavo real de pecho azul, es una especie de ave galliforme de la familia Phasianidae, una de las dos especies del género Pavo, que desde tiempos antiguos destacó entre los animales admirados por el hombre a causa del extraordinario abanico policromado que constituye la cola de los machos.");
            imagen.setImageResource(R.drawable.pavoreal);
        }
        return view;
    }
}