
package adae;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AAyU {
    
    GyLAAyU obj1= new GyLAAyU();
    ArrayList<Actividad> array1 = new ArrayList<Actividad>();
    ArrayList<Unidad> array2 = new ArrayList<Unidad>();
    Usuario ah= new Usuario();
    
    private void Leer(){
        array1= obj1.LeerActividad(getAh().getActividad());
        array2= obj1.LeerUnidad(getAh().getUnidad());
    }

    public ArrayList<Unidad> getArray2(Usuario ahh) {
        array2= obj1.LeerUnidad(ahh.getUnidad());
        return array2;
    }

    public ArrayList<Actividad> getArray1(Usuario ahh) {
        array2= obj1.LeerUnidad(ahh.getUnidad());
        return array1;
    }
    
    
    
    public String AgregarAct(String NomAct, String NomUni, String Fech, int por, int Parcial){
        Leer();
        String Seguir= "Si";
        String Seguir1= "No";
        String Seguir2= "No";
        for(int i=0; i<array1.size(); i++){
            if(NomAct.equals(array1.get(i).getNombre())&& NomUni.equals(array1.get(i).getNombUni())
                    && Parcial == array1.get(i).getParcial()){
                 Seguir= "No";
            }
        }
        
        
        if(Seguir.equals("Si")){
            
            Actividad AcT= new Actividad(NomUni, NomAct,Fech,0.0, por, Parcial);
            array1.add(AcT);
            obj1.GuardarActividad(array1, getAh().getActividad());
            Seguir2= "Si";
        }
        return Seguir2;
    }
    
    public String CalificarAct(String nomUni,String NomAct,int Parcial, int cali){
        Leer();
        String Seguir= "No";
        double ca= 0.0;
        for(int i=0; i<array1.size(); i++){
        
            if(NomAct.equals(array1.get(i).getNombre())&& array1.get(i).getNombUni().equals(nomUni)
                    && array1.get(i).getParcial()== Parcial){
                ca=cali*array1.get(i).getPorcentaje()/100;
                array1.get(i).setCalificacion(ca/10);
                Seguir= "Si";
                obj1.GuardarActividad(array1, getAh().getActividad());
                break;
            }
            
        }
        return Seguir;
    }
    
    public String ModificarAct(String NomAct,String Parametro, String Cambio){
        
        Leer();
        String Seguir= "No";
        
        for(int i=0; i<array1.size(); i++){
        
            if(NomAct.equals(array1.get(i).getNombre())){
                
                if(Parametro.equals("Unidad de Aprendizaje")){
                   
                    for(int j=0; j<array2.size(); j++){
        
                    if(Cambio.equals(array2.get(j).getNombUni())){
                         Seguir="Si";
                         array1.get(i).setNombUni(Cambio);
                         break;
                    }
                    }
                }
                if(Parametro.equals("Nombre")){
                    String ss= "Si";
                    for(int j=0; j<array1.size(); j++){
                        if(Cambio.equals(array1.get(j).getNombre())){
                         ss= "No";
                         JOptionPane.showMessageDialog(null,"El nombre ya ha sido registrado"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                         break;
                        }
                    }
                    if(ss.equals("Si")){
                        array1.get(i).setNombre(Cambio);
                        Seguir="Si";
                    }
                    break;
                }
               
                if(Parametro.equals("Fecha")){
                    array1.get(i).setFecha(Cambio);
                    Seguir="Si";
                }
                if(Parametro.equals("Porcentaje")){
                    try{
                        array1.get(i).setPorcentaje(Integer.valueOf(Cambio));
                        array1.get(i).setCalificacion(0);
                        Seguir="Si";
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Se ha introducido un valor no permitido"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                        Seguir= "No";
                    }
                }
                if(Parametro.equals("Eliminar")){
                    for(int j=0; j<array1.size(); j++){
                        if(NomAct.equals(array1.get(j).getNombre())){
                         Seguir="Si";
                         array1.remove(j);
                         JOptionPane.showMessageDialog(null,"La Actividad se ha eliminado"
                        , "Eliminacion exitosa",  JOptionPane.INFORMATION_MESSAGE);
                         break;
                        }
                    }
                }
                if(Parametro.equals("Parcial")){
                    try{
                    array1.get(i).setParcial(Integer.valueOf(Cambio));
                    Seguir="Si";}
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Se ha introducido un valor no permitido"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                        Seguir= "No";
                    }
                }
            }
        }
        obj1.GuardarActividad(array1, getAh().getActividad());
        return Seguir;
    }
    
    public String AgregarUnidad(String NomUni, int PPP,int PSP,int PTP){
        Leer();
        String seguir= "Si";
        for(int i=0; i<array2.size(); i++){
            
            if(NomUni.equals(array2.get(i).getNombUni())){
                JOptionPane.showMessageDialog(null,"El nuevo Nombre ya se ha registrado"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                seguir="No";
                break;
            }
        }
        
        if(seguir.equals("Si")){
            Unidad ob= new Unidad(NomUni, PPP, PSP, PTP);
            array2.add(ob);
            obj1.GuardarUnidad(array2, getAh().getUnidad());
        }
        return seguir;
    }
    
    public String ModificarUnidad(String NomUni, String Cambio, int PPP,int PSP,int PTP, String Tipo){
        Leer();
        String seguir= "No";
        String seguir2= "Si";
        String seguir3="No";
        for(int i=0; i<array2.size(); i++){
            
            if(NomUni.equals(array2.get(i).getNombUni())){
                seguir="Si";
                if(Tipo.equals("Nombre")){
                    for(int j=0; j<array2.size(); j++){
                
                        if(Cambio.equals(array2.get(j).getNombUni())){
                            seguir2= "No";
                            JOptionPane.showMessageDialog(null,"El nuevo Nombre ya se ha registrado"
                            , "Error",  JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                if(seguir2.equals("Si")){
            
                    seguir3= "Si";
                    for(int h=0; h<array2.size(); h++){

                    if(NomUni.equals(array2.get(h).getNombUni())){
                        array2.get(h).setNombUni(Cambio);
                        break;
                    }
                    }

                    for(int k=0; k<array1.size(); k++){
                        if(NomUni.equals(array1.get(k).getNombUni())){
                            array1.get(k).setNombUni(Cambio);
                        }
                    }
                       
                    obj1.GuardarUnidad(array2, getAh().getUnidad());
                    obj1.GuardarActividad(array1, getAh().getActividad());
                }
                    }
                    
                }
                if(Tipo.equals("Porcentajes")){
                    try{
                        seguir3= "Si";
                        array2.get(i).setPPP(PPP);
                        array2.get(i).setPPP(PSP);
                        array2.get(i).setPPP(PTP);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Se ha introducido un valor no permitido"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
                        seguir3= "No";
                    }
                }
                
            }
        }
        if(seguir.equals("No")){
            JOptionPane.showMessageDialog(null,"El nuevo Nombre no se ha registrado"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        
        }
        return seguir3;
    }
    
    public ArrayList<Actividad> ConsultarUnidad(String NomUni){
        Leer();
        String segui="No";
        ArrayList<Actividad> act= new ArrayList<Actividad> ();
        if(!NomUni.equals("Escoja La Unidad")){
        for(int i=0; i<array1.size();i++){
            
            if(NomUni.equals(array1.get(i).getNombUni())){
                act.add(array1.get(i));
                segui="Si";
            }
        }
        if(segui.equals("No")){
            JOptionPane.showMessageDialog(null,"No se encontraron actividades pertenecientes \n"
                    + "a la unidad ingresada"
                        , "Error",  JOptionPane.ERROR_MESSAGE);
        }
        }
       return act; 
    }

    public Usuario getAh() {
        return ah;
    }

    public void setAh(Usuario ah) {
        this.ah = ah;
    }
    
}
