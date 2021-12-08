import ConectarBD as coneccion
import mysql.connector
from mysql.connector import errorcode
import AgregarUnidad as AU

def Modificar(password, nombrebd, user):
    try:
        con = coneccion.conectar(password, nombrebd, user)
        cursor = con.cursor()
        q = "select id_mc, munidadaprendizaje.nom_ua, cespecialidad.des_esp from mmapacurricular " \
            "INNER JOIN cespecialidad ON cespecialidad.id_esp = mmapacurricular.id_esp "\
            "INNER JOIN munidadaprendizaje ON munidadaprendizaje.cla_ua = mmapacurricular.cla_ua"
        cursor.execute(q)
        data2 = cursor.fetchall()
        for p in data2:
            print("ID" , p[0], " ,", p[1], " ,", p[2])
        id = int(input("ingrese el id de la unidad que deseas cambiar"))
        data = AU.verespecialidades(cursor)
        esp = int(input("ingrese el numero la especialidad"))
        q = "UPDATE mmapacurricular SET id_esp = %s WHERE id_mc = %s"
        valores = (esp, id)
        cursor.execute(q, valores)
        con.commit()
        print("Modificado con exito")
    except mysql.connector.Error as err:
        con.rollback()
        print(err)
    finally:
        cursor.close()
        coneccion.desconectar(con)