
package adae;

import java.util.ArrayList;


public class CrearUsuario {
    
    
    ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
    GuardaryLeerArchivoUsuario obj1= new GuardaryLeerArchivoUsuario();
    public CrearUsuario() {
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String crearUsuario(String unNombre, String unaContraseña){
        obj1.leer();
        setUsuarios(obj1.getUsuarios());
        String continuar= "Si";
        for(int i=0; i<usuarios.size(); i++){
            
            if(unNombre.equals(usuarios.get(i).getNombre())){
                continuar= "No";
                break;
            }
        }
        if(continuar.equals("Si")){
           Usuario nuevo= new Usuario(unNombre, unaContraseña); 
           usuarios.add(nuevo); 
           obj1.Guardar(usuarios);
        }
        
        return continuar;
    }
    
    
}
