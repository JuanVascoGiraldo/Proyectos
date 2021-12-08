import ConectarBD as coneccion
import mysql.connector
from mysql.connector import errorcode
import AgregarUnidad as AU

def EliminarCarrera(password, nombrebd, user):
    try:
        con = coneccion.conectar(password, nombrebd, user)
        cursor = con.cursor()
        data = AU.verespecialidades(cursor)
        esp = int(input("ingrese el numero la especialidad"))
        p = "select DISTINCT cespecialidad.id_esp  from dkardex " \
            "INNER JOIN mmapacurricular ON dkardex.id_mc = mmapacurricular.id_mc " \
            "INNER JOIN cespecialidad ON cespecialidad.id_esp = mmapacurricular.id_esp "
        cursor.execute(p)
        data2 = cursor.fetchall()
        confirmar = True
        for d in data2:
            if d[0] == esp:
                confirmar = False
        if confirmar == True:
            query = "DELETE FROM mmapacurricular WHERE id_esp = %s" %esp
            cursor.execute(query)
            con.commit()
            query = "DELETE FROM cespecialidad WHERE id_esp =  %s" %esp
            cursor.execute(query)
            con.commit()
        else:
            print("No se puede eliminar porque tiene registro en el kardex")
    except mysql.connector.Error as err:
        con.rollback()
        print(err.msg)
    finally:
        cursor.close()
        coneccion.desconectar(con)