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
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {

    private TextView nombre;
    private TextView des;
    private ImageView imagen;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static int accion;
    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2, int ac) {
        Fragment3 fragment = new Fragment3();
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
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        nombre = view.findViewById(R.id.Nombre3);
        des = view.findViewById(R.id.descripcion3);
        imagen = view.findViewById(R.id.imagen3);
        if(accion == 1){
            nombre.setText("Gatos");
            des.setText("El nombre actual en muchas lenguas proviene del latín vulgar catus. Irónicamente, catus aludía a los gatos salvajes, mientras que los gatos domésticos, en latín, eran llamados felis.");
            imagen.setImageResource(R.drawable.gato);
        } else if(accion == 2){
            nombre.setText("Salamandra");
            des.setText("La salamandra común (Salamandra salamandra) es una especie de anfibio urodelo de la familia Salamandridae. Es el más común de los urodelos en Europa. De hábitos terrestres, únicamente entra en el agua para parir, y muchas subespecies lo hacen en tierra");
            imagen.setImageResource(R.drawable.salamandra);
        } else if(accion == 3){
            nombre.setText("Cisne");
            des.setText("Cisne es el nombre común de varias aves anseriformes de la familia Anatidae. Son aves acuáticas de gran tamaño. La mayoría de las especies pertenecen al género Cygnus.\n" +
                    "El cisne era un ave consagrada a Apolo, como dios de la música, porque se creía que el cisne poco antes de morir cantaba melodiosamente.");
            imagen.setImageResource(R.drawable.cisne);
        }
        return view;
    }
}