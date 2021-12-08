package proyectoaula;

import java.io.Serializable;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuario extends registrarse implements Serializable {

    //Declaración de variables
    protected String nombreUsuario = jTextField2.getText();
    protected String contraseña = jPasswordField1.getText();

    //Método constructor
    public Usuario(JPasswordField jPasswordField1, JPasswordField jPasswordField2, JTextField jTextField1, JTextField jTextField2) {
        super(jPasswordField1, jPasswordField2, jTextField2);
    }

    Usuario(JPasswordField jPasswordField1, JPasswordField jPasswordField2, JTextField jTextField2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    

}
