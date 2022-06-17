
package Control;

import Modelo.CCatalogo;
import Modelo.MEquipo;
import Modelo.MReporte;
import Modelo.MUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


public class Acciones {
    
    public static boolean RegistrarEstudiante(MUsuario usu){
        boolean resultado=false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select * from MUsuario";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(rs.next());
            boolean seguir = true;
            while(rs.next()){
               if(rs.getLong("boleta_usu")== usu.getBoleta())seguir = false;
            }
            if(seguir){
                    String sql2 = "insert into MUsuario (boleta_usu, nombre_usu, grupo, rol, contra_usu) values(?,?,?,?,?)";
                    ps = con.prepareStatement(sql2);
                    ps.setLong(1, usu.getBoleta());
                    ps.setString(2, usu.getNombre());
                    ps.setInt(3, usu.getId_grupo());
                    ps.setInt(4, 1);
                    ps.setString(5, usu.getContra());
                    int Estatus = ps.executeUpdate();
                    if(Estatus > 0){
                        resultado= true;
                    }
               }
        }catch(Exception e){
            System.out.println(e.getMessage());
            resultado = false;
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return resultado;
    }
    
    public static MUsuario IniciarSesion(long boleta, String contra){
        MUsuario usu = new MUsuario();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select MUsuario.id_usu , MUsuario.boleta_usu, MUsuario.nombre_usu, MUsuario.rol, CGrupo.des_Grupo from MUsuario "
                    + "INNER JOIN CGrupo ON MUsuario.grupo = CGrupo.id_Grupo "
                    + "where MUsuario.boleta_usu = ? and MUsuario.contra_usu = ?"; 
            ps = con.prepareStatement(sql);
            ps.setLong(1, boleta);
            ps.setString(2, contra);
            rs = ps.executeQuery();
            if(rs.next()){
                usu.setId(rs.getInt("id_usu"));
                usu.setGrupo(rs.getString("des_Grupo"));
                usu.setNombre(rs.getString("nombre_usu"));
                usu.setRol(rs.getInt("rol"));
                usu.setBoleta(rs.getLong("boleta_usu"));
            }else{
                usu.setNombre("no encontrado");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            usu.setNombre("no encontrado");
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return usu;
    }
    
    public static List<MEquipo> VermiEquipos(int id){
        List<MEquipo> equipos = new ArrayList<MEquipo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select CMateria.des_materia, MMaquina.id_Maquina, MMaquina.num_maquina, CEstado.des_estado, CLabo.des_labo from DMaquinaAlumno\n" +
                "INNER JOIN CMateria ON DMaquinaAlumno.id_materia = CMateria.idCMateria " +
                "INNER JOIN MMaquina ON DMaquinaAlumno.id_maquina = MMaquina.id_Maquina " +
                "INNER JOIN CLabo ON MMaquina.labo = CLabo.id_Labo " +
                "INNER JOIN CEstado ON MMaquina.estado = CEstado.id_Estado where DMaquinaAlumno.id_usu = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                MEquipo equi = new MEquipo();
                equi.setDes_estado(rs.getString("des_estado"));
                equi.setDes_materia(rs.getString("des_materia"));
                equi.setId(rs.getInt("id_Maquina"));
                equi.setNumero(rs.getInt("num_maquina"));
                equi.setDes_labo(rs.getString("des_labo"));
                equipos.add(equi);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return equipos;
    }
    
    public static MEquipo ConsultarEquipo(int id){
        MEquipo eq = new MEquipo();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select MMaquina.id_Maquina, MMaquina.num_maquina, CEstado.des_estado, CLabo.des_labo from MMaquina " +
                "INNER JOIN CLabo ON MMaquina.labo = CLabo.id_Labo " +
                "INNER JOIN CEstado ON MMaquina.estado = CEstado.id_Estado where MMaquina.id_Maquina = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                eq.setDes_estado(rs.getString("des_estado"));
                eq.setId(rs.getInt("id_Maquina"));
                eq.setNumero(rs.getInt("num_maquina"));
                eq.setDes_labo(rs.getString("des_labo"));
                eq.setId_estado(1);
            }else{
                eq.setId_estado(0);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            eq.setId_estado(0);
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return eq;
    }
    
    public static boolean HacerReporte(MReporte re){
        boolean resul = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String sql = "insert into MReporte (id_usu, id_maquina, fecha_reporte, des_reporte, hora_reporte, des_solucion, fecha_solucion, hora_solucion) values (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, re.getId_usu());
            ps.setInt(2, re.getId_maquina());
            ps.setString(3, re.getFecha_re());
            ps.setString(4, re.getReporte());
            ps.setString(5, re.getHora_re());
            ps.setString(6, "Esperando Solución");
            ps.setString(7, "Esperando Solución");
            ps.setString(8, "Esperando Solución");
            int Estatus = ps.executeUpdate();
            if(Estatus > 0){
                resul= true;
                }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            resul = false;
        }finally{
            try{
                con.close();
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return resul;
    }
    
    public static boolean DarSolucion(MReporte so){
        boolean result  = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String sql = "update MReporte set des_solucion = ? , fecha_solucion = ?, hora_solucion = ? where id_Reporte = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, so.getSolucion());
            ps.setString(2, so.getFecha_so());
            ps.setString(3, so.getHora_so());
            ps.setInt(4,so.getId());
            int Estatus = ps.executeUpdate();
            if(Estatus > 0){
                result= true;
                }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }finally{
            try{
                con.close();
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return result;
    }
    
    public static boolean ActualizarEstado(int id_maquina, int estado){
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String sql = "update MMaquina set estado = ? where id_Maquina = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_maquina);
            int Estatus = ps.executeUpdate();
            if(Estatus > 0){
                result= true;
                }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }finally{
            try{
                con.close();
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return result;
    }
    
    public static List<MReporte> ConsultarReportes(int id){
        List<MReporte> reporte = new ArrayList<MReporte>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select MReporte.id_reporte, MReporte.fecha_reporte, MReporte.des_reporte, MReporte.hora_reporte, MReporte.des_solucion, MReporte.fecha_solucion, MReporte.hora_solucion, " +
                "MUsuario.boleta_usu, MUsuario.nombre_usu from MReporte " +
                "INNER JOIN MUsuario ON MReporte.id_usu = MUsuario.id_usu where MReporte.id_maquina = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                MReporte re = new MReporte();
                re.setId(rs.getInt("id_reporte"));
                re.setFecha_re(rs.getString("fecha_reporte"));
                re.setReporte(rs.getString("des_reporte"));
                re.setHora_re(rs.getString("hora_reporte"));
                re.setFecha_so(rs.getString("fecha_solucion"));
                re.setHora_so(rs.getString("hora_solucion"));
                re.setSolucion(rs.getString("des_solucion"));
                re.setBoleta(rs.getLong("boleta_usu"));
                re.setNom_usu(rs.getString("nombre_usu"));
                reporte.add(re);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return reporte;
    }
    
    public static boolean CambiarContra(int id, String contra){
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String sql = "update MUsuario set contra_usu = ? where id_usu = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, contra);
            ps.setInt(2, id);
            int Estatus = ps.executeUpdate();
            if(Estatus > 0){
                result= true;
                }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }finally{
            try{
                con.close();
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return result;
    }
    
    public static boolean AgregarEquipo(MEquipo eq){
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select * from MMaquina where labo = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, eq.getId_labo());
            rs = ps.executeQuery();
            boolean seguir = true;
            while(rs.next()){
                if(rs.getInt("num_maquina")==eq.getNumero())seguir = false;
            }
            if(seguir){
                String sql2 = "insert into MMaquina (labo, estado, num_maquina) values (?,?,?)";
                    ps = con.prepareStatement(sql2);
                    ps.setInt(1,eq.getId_labo());
                    ps.setInt(2,1);
                    ps.setInt(3,eq.getNumero());
                    int Estatus = ps.executeUpdate();
                    if(Estatus > 0){
                        result= true;
                        }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return result;
    }
    
    public static List<MEquipo> ConsultarEquipos(){
        List<MEquipo> equipos = new ArrayList<MEquipo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select MMaquina.id_Maquina, MMaquina.num_maquina, CEstado.des_estado, CEstado.id_Estado, CLabo.des_labo from MMaquina " +
                "INNER JOIN CLabo ON MMaquina.labo = CLabo.id_Labo " +
                "INNER JOIN CEstado ON MMaquina.estado = CEstado.id_Estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                MEquipo eq = new MEquipo();
                eq.setDes_estado(rs.getString("des_estado"));
                eq.setId(rs.getInt("id_Maquina"));
                eq.setNumero(rs.getInt("num_maquina"));
                eq.setDes_labo(rs.getString("des_labo"));
                eq.setId_estado(rs.getInt("CEstado.id_Estado"));
                equipos.add(eq);
            }
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return equipos;
    }
    
    public static List<MUsuario> ConsultarEstudiantes(){
        List<MUsuario> estudiantes = new ArrayList<MUsuario>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select MUsuario.id_usu, MUsuario.boleta_usu, MUsuario.nombre_usu, CGrupo.des_Grupo from MUsuario "
                    + "INNER JOIN CGrupo ON MUsuario.grupo = CGrupo.id_Grupo "
                    + "where MUsuario.rol = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while(rs.next()){
                MUsuario est = new MUsuario();
                est.setId(rs.getInt("id_usu"));
                est.setBoleta(rs.getLong("boleta_usu"));
                est.setNombre(rs.getString("nombre_usu"));
                est.setGrupo(rs.getString("des_Grupo"));
                estudiantes.add(est);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return estudiantes;
    }
    
    public static MUsuario ConUsuario(int id){
        MUsuario usu = new MUsuario();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select CGrupo.des_Grupo from MUsuario "
                    + "INNER JOIN CGrupo ON MUsuario.grupo = CGrupo.id_Grupo "
                    + "where MUsuario.id_usu = ? "; 
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                usu.setGrupo(rs.getString("des_Grupo"));
                usu.setNombre("encontrado");
            }else{
                usu.setNombre("no encontrado");
            }  
        }catch(Exception e){
            System.out.println(e.getMessage());
            usu.setNombre("no encontrado");
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        
        return usu;
    }
    
    public static List<CCatalogo> MateriasAsginadas(int id, String grupo){
        List<CCatalogo> mate = new ArrayList<CCatalogo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String[] partes = grupo.split("I");
            con = Conexion.getConnection();
            String sql = "select * from CMateria where id_semestre = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.valueOf(partes[0]));
            rs = ps.executeQuery();
            while(rs.next()){
                CCatalogo mat = new CCatalogo();
                mat.setId(rs.getInt("idCMateria"));
                mat.setDes(rs.getString("des_materia"));
                mate.add(mat);
            }
            String sql2 = "select * from DMaquinaAlumno where id_usu = ?";
            ps = con.prepareStatement(sql2);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                int i = 0;
                boolean se = false;
                for(CCatalogo m:mate){
                    if(m.getId() == rs.getInt("id_materia")){
                        se = true;
                        break;
                    }
                    i++;
                }
                if(se)mate.remove(i);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        
        return mate;
    }
    
    public static boolean Asignarcomputadora(int id, int maquina, int materia){
        boolean result = false;
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = Conexion.getConnection();
            String sql = "insert into DMaquinaAlumno (id_usu, id_maquina, id_materia) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2,maquina);
            ps.setInt(3, materia);
            int Estatus = ps.executeUpdate();
            if(Estatus > 0){
                result= true;
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }finally{
            try{
                con.close();
                ps.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return result;
    }
    
    public static List<CCatalogo> MaquinasLabo(int labo, String grupo, int materia){
        List<CCatalogo> maquinas = new ArrayList<CCatalogo>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = Conexion.getConnection();
            String sql = "select * from MMaquina where labo = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, labo);
            rs = ps.executeQuery();
             List<CCatalogo> maqui = new ArrayList<CCatalogo>();
            while(rs.next()){
                CCatalogo compus = new CCatalogo();
                compus.setId(rs.getInt("id_Maquina"));
                compus.setMaquina(rs.getInt("num_maquina"));
                maqui.add(compus);
            }
            String sql2 = "select * from DMaquinaAlumno " +
                "INNER JOIN MUsuario ON DMaquinaAlumno.id_usu = MUsuario.id_usu " +
                "INNER JOIN CGrupo ON MUsuario.grupo = CGrupo.id_Grupo " +
                "where DMaquinaAlumno.id_materia = ? AND CGrupo.des_Grupo = ? ";
            ps = con.prepareStatement(sql2);
            ps.setInt(1, materia);
            ps.setString(2, grupo);
            rs = ps.executeQuery();
            List<CCatalogo> co = new ArrayList<CCatalogo>();
            while(rs.next()){
                CCatalogo compus = new CCatalogo();
                compus.setId(rs.getInt("id_maquina"));
                compus.setDes(rs.getString("CGrupo.des_Grupo"));
                co.add(compus);
            }
            for(CCatalogo m:maqui){
                boolean seguir = true;
                for(CCatalogo mm:co){
                    if(mm.getId()==m.getId()){
                        seguir=false;
                        break;
                    }
                }
                if(seguir)maquinas.add(m);
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                con.close();
                ps.close();
                rs.close();
            }
            catch(Exception error){
                System.out.println("Error a cerrar la conexion");
                System.out.println(error);
            }
        }
        return maquinas;
    }
    
    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";
    
    public static String getFecha(){
        TimeZone timeZone = TimeZone.getTimeZone("America/Mexico_City");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(timeZone);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

        SimpleDateFormat formatterWithTimeZone = new SimpleDateFormat(DATE_FORMAT);
        formatterWithTimeZone.setTimeZone(timeZone);
        return formatterWithTimeZone.format(calendar.getTime());
    }
    
}
