import mysql.connector
from mysql.connector import errorcode

def IniciarConeccion():
    host = '127.0.0.1'
    contraseña = ''
    BasedeDatos = ''
    usuario = 'root'
    try:
        miconexion = mysql.connector.connect(user=usuario, password=contraseña, host=host,
                                             database=BasedeDatos)
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
def IngresarDatos():
    print("1. Ingresar Una Nueva Unidad de Aprendizaje")
    print("2. Modificar Escepcialidad a la que pertenece una Unidad de Aprendizaje")
    print("3. Consultar Kardex de un estudiante por la boleta")
    print("4. Eliminar una Especialidad que no tenga Kardex")
    print("5. Terminar Proceso")
    try:
        opcion = int(input("Ingresa El numero de la accion a realizar"))
        while opcion != 5:
            if opcion == 1:
                RegistrarUnidad()
            elif opcion == 2:
                ModificarEspecialidad()
            elif opcion == 3:
                ConsultarBoleta()
            elif opcion == 4:
                EliminarEspecialidad()
            else:
                print("Ingresa una opcion Valida")
            print("1. Ingresar Una Nueva Unidad de Aprendizaje")
            print("2. Modificar Escepcialidad a la que pertenece una Unidad de Aprendizaje")
            print("3. Consultar Kardex de un estudiante por la boleta")
            print("4. Eliminar una Especialidad que no tenga Kardex")
            print("5. Terminar Proceso")
            opcion = int(input("Ingresa El numero de la accion a realizar"))
    except:
        print("Ingresa Solo numeros")

def RegistrarUnidad ():
    try:
        cla_ua= input("Ingresa la clave de la unidad")
        nom_au= input("Ingresa El nombre de la unidad")
        miconexion = IniciarConeccion()
        cursor = miconexion.cursor()
        query = "INSERT INTO munidadaprendizaje (cla_ua, nom_ua) " \
                "VALUES (%s, %s)"
        v = (cla_ua, nom_au)
        cursor.execute(query , v)
        miconexion.commit()
        query = "SELECT * FROM cespecialidad"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        id_esp = input("ingrese el id de la especialidad")
        query = "SELECT * FROM cnivel"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        id_niv = input("ingrese el id del nivel al que pertenece")
        query = "INSERT INTO mmapacurricular (cla_ua, id_esp, id_niv) " \
                "VALUES (%s, %s, %s)"
        v = (cla_ua, id_esp, id_niv)
        cursor.execute(query, v)
        miconexion.commit()
        print("Se ha guardado la unidad")
    except:
        miconexion.rollback()
        print("Ha ocurrido un error")
    finally:
        cursor.close()
        miconexion.close()
def ModificarEspecialidad():
    try:
        miconexion = IniciarConeccion()
        cursor = miconexion.cursor()
        query = "SELECT id_mc, munidadaprendizaje.nom_ua, cespecialidad.des_esp from mmapacurricular " \
                "INNER JOIN munidadaprendizaje ON mmapacurricular.cla_ua = munidadaprendizaje.cla_ua "\
                "INNER JOIN cespecialidad ON  mmapacurricular.id_esp = cespecialidad.id_esp"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        id_mc = input("Ingresa El id de la relacion entre la unidad y la especialidad")
        query = "SELECT * FROM cespecialidad"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        id_esp = input("ingrese el id de la especialidad")
        query = "UPDATE mmapacurricular SET id_esp = %s WHERE id_mc = %s"
        v = (id_esp , id_mc)
        cursor.execute(query, v)
        miconexion.commit()
        print("Registrar Unidad")
    except:
        miconexion.rollback()
        print("Ha ocurrido un error")
    finally:
        cursor.close()
        miconexion.close()

def ConsultarBoleta():
    try:
        miconexion = IniciarConeccion()
        cursor = miconexion.cursor()
        query = "SELECT bol_alu From malumno"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        bol_alu= input("Ingrese La boleta del alumno")
        query = "SELECT malumno.bol_alu, munidadaprendizaje.nom_ua , cespecialidad.des_esp, cnivel.des_niv, " \
                "cperiodoacreditacion.des_pa, dkardex.cal_kdx FROM malumno " \
                "INNER JOIN ekardex ON ekardex.bol_alu = malumno.bol_alu "\
                "INNER JOIN dkardex ON ekardex.id_ekd = dkardex.id_ekd " \
                "INNER JOIN cperiodoacreditacion ON cperiodoacreditacion.id_pa = dkardex.id_pa "\
                "INNER JOIN mmapacurricular ON dkardex.id_mc = mmapacurricular.id_mc " \
                "INNER JOIN cnivel ON cnivel.id_niv = mmapacurricular.id_niv " \
                "INNER JOIN munidadaprendizaje ON munidadaprendizaje.cla_ua = mmapacurricular.cla_ua " \
                "INNER JOIN cespecialidad ON cespecialidad.id_esp = mmapacurricular.id_esp " \
                "where malumno.bol_alu = %s "
        v = (bol_alu,)
        cursor.execute(query, v)
        respuesta = cursor.fetchall()
        for i in range(len(respuesta)):
            print(respuesta[i])
        print("Boleta Consultada")
        print("Numero totales de Registros del estudiante en el Kardex", len(respuesta))
    except:
        print("Ha ocurrido un error")
    finally:
        cursor.close()
        miconexion.close()

def EliminarEspecialidad():
    try:
        miconexion = IniciarConeccion()
        cursor = miconexion.cursor()
        query = "SELECT * FROM cespecialidad"
        cursor.execute(query)
        respuesta = cursor.fetchall()
        query = "SELECT DISTINCT mmapacurricular.id_esp  FROM dkardex " \
                "INNER JOIN mmapacurricular ON dkardex.id_mc = mmapacurricular.id_mc "
        cursor.execute(query)
        respuesta2 = cursor.fetchall()
        print("Las Especialidades que no tienen ningun kardex Registrados son")
        for i in range(len(respuesta)):
            seguir = True
            p = (respuesta[i])[0]
            for j in range(len(respuesta2)):
                if (respuesta2[j])[0] == p:
                    seguir = False
                    break
            if seguir == True:
                print(respuesta[i])
        id_esp = input("Selecciona El id de la especialidad a eliminar")
        seguir2 = False
        while seguir2 != True:
            seguir2 = True
            for i in range(len(respuesta2)):
                if (respuesta2[i])[0] == int(id_esp):
                    seguir2 = False
                    break
            if seguir2 == False:
                print("Selecciona una especialidad que no tenga registros en el kardex")
                id_esp = input("Selecciona El id de la especialidad a eliminar")
        query = "DELETE FROM mmapacurricular WHERE id_esp = %s"
        v = (id_esp,)
        cursor.execute(query, v)
        miconexion.commit()
        query = "DELETE FROM cespecialidad WHERE id_esp =  %s"
        v = (id_esp,)
        cursor.execute(query, v)
        miconexion.commit()
        print("Se ha eliminado la especialidad")
    except:
        miconexion.rollback()
        print("Ha ocurrido un error")
    finally:
        cursor.close()
        miconexion.close()

IngresarDatos()
