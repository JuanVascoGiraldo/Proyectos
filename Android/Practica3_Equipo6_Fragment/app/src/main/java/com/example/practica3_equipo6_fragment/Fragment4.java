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
 * Use the {@link Fragment4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment4 extends Fragment {

    private TextView nombre;
    private TextView des;
    private ImageView imagen;
    private static int accion;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment4 newInstance(String param1, String param2, int ac) {
        Fragment4 fragment = new Fragment4();
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
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        nombre = view.findViewById(R.id.Nombre4);
        des = view.findViewById(R.id.descripcion4);
        imagen = view.findViewById(R.id.imagen4);
        if(accion == 1){
            nombre.setText("Leon");
            des.setText("El león (Panthera leo) es un mamífero carnívoro de la familia de los félidos y una de las cinco especies del género Panthera. Los leones salvajes viven en poblaciones cada vez más dispersas y fragmentadas del África subsahariana (a excepción de las regiones selváticas de la costa del Atlántico y la cuenca del Congo) y una pequeña zona del noroeste de India (una población en peligro crítico en el parque nacional del Bosque de Gir y alrededores)");
            imagen.setImageResource(R.drawable.leon);
        } else if(accion == 2){
            nombre.setText("Sapo");
            des.setText("Los bufónidos (Bufonidae) son una familia del orden Anura, un grupo de los anfibios conocidos. Muchas de sus especies se conocen con el nombre común de sapos; no obstante, numerosas especies pertenecientes a otras familias también son comúnmente denominados sapos");
            imagen.setImageResource(R.drawable.sapo);
        } else if(accion == 3){
            nombre.setText("Guacamayo azul");
            des.setText("El guacamayo jacinto (Anodorhynchus hyacinthinus) es una especie de ave psitaciforme de la familia de los loros (Psittacidae). Habita en las selvas de buena parte de Brasil, Bolivia y el norte de Paraguay. Es la especie de guacamayo de mayor tamaño. En estado de vulnerabilidad, estas aves son codiciadas por su alto precio en el mercado. En Brasil se conoce como “arara azul”.");
            imagen.setImageResource(R.drawable.guacamayo);
        }
        return view;
    }
}