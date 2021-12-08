import ConectarBD as coneccion
import mysql.connector
from mysql.connector import errorcode

def ConsultarBoleta(password, nombrebd, user):
    try:
        con = coneccion.conectar(password, nombrebd, user)
        cursor = con.cursor()
        q = "select bol_alu, app_alu, apm_alu, nom_alu from malumno"
        cursor.execute(q)
        data2 = cursor.fetchall()
        for p in data2:
            print("Boleta ", p[0], " Nombre: ", p[1], " ", p[2], " ", p[3])
        boleta = input("Ingresa la boleta a consultar")
        q = "select malumno.bol_alu, dkardex.cal_kdx, munidadaprendizaje.nom_ua , cespecialidad.des_esp, cnivel.des_niv, " \
            "cperiodoacreditacion.des_pa from malumno " \
            "INNER JOIN ekardex ON ekardex.bol_alu = malumno.bol_alu "\
            "INNER JOIN dkardex ON ekardex.id_ekd = dkardex.id_ekd " \
            "INNER JOIN cperiodoacreditacion ON cperiodoacreditacion.id_pa = dkardex.id_pa "\
            "INNER JOIN mmapacurricular ON dkardex.id_mc = mmapacurricular.id_mc " \
            "INNER JOIN cespecialidad ON cespecialidad.id_esp = mmapacurricular.id_esp " \
            "INNER JOIN munidadaprendizaje ON munidadaprendizaje.cla_ua = mmapacurricular.cla_ua "\
            "INNER JOIN cnivel ON cnivel.id_niv = mmapacurricular.id_niv " \
            "where malumno.bol_alu = %s " %boleta
        cursor.execute(q)
        data = cursor.fetchall()
        if(len(data) != 0):
            for b in data:
                print(b[0]," ", b[1]," ",  b[2], " ", b[3]," ",  b[4] )
        else:
            print("No hay información para mostrar del Kardex del alumno")
    except mysql.connector.Error as err:
        print(err)
    finally:
        cursor.close()
        coneccion.desconectar(con)