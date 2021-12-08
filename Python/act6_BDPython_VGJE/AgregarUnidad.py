import ConectarBD as coneccion
import mysql.connector
from mysql.connector import errorcode
def agregar(password, nombrebd, user, codigo, nombre):
    try:
        con = coneccion.conectar(password, nombrebd, user)
        cursor = con.cursor()
        q = "insert into munidadaprendizaje (cla_ua, nom_ua) values (%s, %s)"
        valores = (codigo, nombre)
        cursor.execute(q, valores)
        con.commit()
        data = verespecialidades(cursor)
        esp = int(input("ingrese el numero la especialidad"))
        q = "select * from cnivel ORDER BY id_niv ASC"
        cursor.execute(q)
        data2 = cursor.fetchall()
        for p in data2:
            print(p[0],". ", p[1])
        niv = int(input("ingrese el numero del nivel"))
        q = "insert into mmapacurricular (cla_ua, id_esp, id_niv) values (%s, %s, %s)"
        valor=(codigo, esp, niv)
        cursor.execute(q, valor)
        con.commit()
        print("Se ha agregado la Unidad de Aprendizaje")
    except mysql.connector.Error as err:
        con.rollback()
        print(err)
    finally:
        cursor.close()
        coneccion.desconectar(con)

def verespecialidades(cursor):
    try:
        q = "select * from cespecialidad ORDER BY id_esp ASC"
        cursor.execute(q)
        data = cursor.fetchall()
        for p in data:
            print(p[0], ". ", p[1])
        return data
    except mysql.connector.Error as err:
        print(err)
        return None

