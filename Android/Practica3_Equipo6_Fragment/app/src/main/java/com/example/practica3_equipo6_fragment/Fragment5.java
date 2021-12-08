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
 * Use the {@link Fragment5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment5 extends Fragment {

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

    public Fragment5() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment5.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment5 newInstance(String param1, String param2, int ac) {
        Fragment5 fragment = new Fragment5();
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
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        nombre = view.findViewById(R.id.Nombre5);
        des = view.findViewById(R.id.descripcion5);
        imagen = view.findViewById(R.id.imagen5);
        if(accion == 1){
            nombre.setText("Perro");
            des.setText("El gato (Canis familiaris o Canis lupus familiaris, dependiendo de si se lo considera una especie por derecho propio o una subespecie del lobo),  llamado perro doméstico o can, y en algunos lugares coloquialmente llamado chucho, tuso, choco,7 entre otros; ");
            imagen.setImageResource(R.drawable.perro);
        } else if(accion == 2){
            nombre.setText("Tritones");
            des.setText("Triturus es un género de anfibios caudados de la familia Salamandridae, compuesto por una serie de especies de Europa y Asia que se encuentran en cuerpos de agua, como estanques poco profundos, lagunas, arroyos y aguas profundas tranquilas; y terrestres, como páramos, pantanos y bosques.");
            imagen.setImageResource(R.drawable.triton);
        } else if(accion == 3){
            nombre.setText("Picozapato");
            des.setText("El picozapato2 (Balaeniceps rex) es una especie de ave pelecaniforme,3 la única de la familia Balaenicipitidae. Su nombre común alude a la forma de su enorme pico.\n" +
                    "El picozapato es un pájaro alto, con un rango de altura típico de 110 a 140 cm y algunos especímenes que alcanzan hasta 152 cm. ");
            imagen.setImageResource(R.drawable.picozapato);
        }
        return view;
    }
}