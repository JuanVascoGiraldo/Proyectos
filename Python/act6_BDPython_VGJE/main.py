import AgregarUnidad as AU
import ModificarEspecialidad as ME
import ConsultarBoleta as CB
import EliminarCarrera as EC
def recibirdatos(usu, passw, bdnom):

    try:
        print("Que acción desea hacer")
        print("1. Dar de alta una nueva unidad de aprendizaje propia de una de las carreras técnicas.")
        print("2. modificar la carrera a la que pertenece esa unidad de aprendizaje")
        print("3. Consulta de la boleta del alumno")
        print("4. Dar de baja una carrera que no tenga kardex")
        print("5. terminar")
        accion = int(input("ingresa el numero de la accion a realizar"))
        while accion !=5:
            if (accion == 1):
                Clave = input('ingresa la clave de la unidad')
                while len(Clave) > 5 or len(Clave) == 0:
                    print("Ingresa un valor menor a 6 caracteres y mayor de un caracter")
                    Clave = input('ingresa la clave de la unidad')
                Nombre = input('ingrese el nombre de la unidad')
                while len(Nombre) > 150 or len(Nombre) == 0:
                    print("Ingresa un valor menor a 150 caracteres y mayor de un caracter")
                    Nombre = input('ingrese el nombre de la unidad')
                AU.agregar(passw, bdnom, usu, Clave, Nombre)
            if (accion == 2):
                ME.Modificar(passw, bdnom, usu)
            if (accion == 3):
                CB.ConsultarBoleta(passw, bdnom, usu)
            if (accion == 4):
                EC.EliminarCarrera(passw, bdnom, usu)
            print("Que acción desea hacer")
            print("1. Dar de alta una nueva unidad de aprendizaje propia de una de las carreras técnicas.")
            print("2. modificar la carrera a la que pertenece esa unidad de aprendizaje")
            print("3. Consulta de la boleta del alumno")
            print("4. Dar de baja una carrera que no tenga kardex")
            print("5. terminar")
            accion = int(input("ingresa el numero de la accion a realizar"))
    except:
        print("error")
        recibirdatos(usuario, password, bdnombre)

usuario = input("ingresa usuario")
password = input("ingresa la contraseña")
bdnombre = input("ingresa el nombre de la base de datos")
recibirdatos(usuario, password, bdnombre)