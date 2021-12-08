import mysql.connector
from mysql.connector import errorcode

def conectar(password, nombrebd, user):
    host = '127.0.0.1'
    try:
        miconexion = mysql.connector.connect(user=user, password=password, host=host,
                                             database=nombrebd)
        print("la base de datos se conectó satisfactoriamente")
        return miconexion
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("Error con el usuario o password")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("La base de datos no existe")
        else:
            print(err)
        return None
def desconectar (miconexion):
    try:
        miconexion.close()  # Cerrar la conexión
        print("se desconecto satisfactoriamente de la base de datos")
    except:
        print("error al cerrar la conexion")
