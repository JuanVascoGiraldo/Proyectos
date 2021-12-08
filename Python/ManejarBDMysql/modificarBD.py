import mysql.connector
from mysql.connector import errorcode

DB_HOST = '127.0.0.1' # dirección IP donde está montada la base de datos
DB_USER = 'root' # usuario válido para conectarse a la base de datos
DB_PASS = 'n0m3l0s3' # contraseña que se tengan en el PC donde reside la base de datos
DB_NAME = 'kardex'  # nombre de la base de datos a donde se quiere uno conectar

try:
    miconexion = mysql.connector.connect(user=DB_USER, password=DB_PASS,host=DB_HOST,database=DB_NAME)  # Conectar a la base de datos
    cursor = miconexion.cursor()  # Crear un cursor

    boleta = input ("Introduce la Boleta: ")
    nombre = input ("Da el cambio del nombre: ")

    # Peligro inyección SQL    query = "UPDATE malumno SET nom_alu = '"+nombre+"' WHERE bol_alu = '"+boleta+"'"
    query = "UPDATE malumno SET nom_alu = %s WHERE bol_alu = %s"
    valores = (nombre, boleta)

    try:
        # Ejecutamos el comando
        cursor.execute(query, valores)
        # Efectuamos los cambios en la base de datos
        miconexion.commit()

        print(cursor.rowcount, "Registro Modificado Satisfactoriamente")
    except:
        # Si se genero algun error revertimos la operación
        miconexion.rollback()
        print("La transacción no fue llevada a cabo")



except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("Error con el usuario o password")
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("La base de datos no existe")
    else:
        print(err)
finally:

    print("Se cerró la conexión a la base de datos")
    cursor.close()  # Cerrar el cursor
    miconexion.close()  # Cerrar la conexión

