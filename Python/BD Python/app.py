#Importación de librerías
import mysql.connector
from mysql.connector import errorcode
from numpy import *
import matplotlib.pyplot as plt
from flask import Flask, render_template, request, redirect, url_for
import traceback
import random

#Definir variables para conexión con la base de datos
DB_HOST = '127.0.0.1'
DB_USER = 'root'
DB_PASS = '03042021'
DB_NAME = 'fitracker'

#Definir app web
app = Flask(__name__)

#Ruta predeterminada para acceder al inicio de sesión
@app.route('/')
def login():
    return render_template('login.html')

#Ruta predeterminada para acceder al registro
@app.route('/registrarse')
def regist():
    return render_template('registro.html')

#Método para registrar usuario
@app.route('/registrarusuario')
def getRegistRequest():
    
    try:
        #Abrir conexión con la base de datos
        con = mysql.connector.connect(user=DB_USER, password=DB_PASS,host=DB_HOST,database=DB_NAME)
        #Definir entrada del cursor
        cur = con.cursor()
        print("Conectado a la base de datos.")
        #Definir sentencias SQL para registrar un usuario
        query_registro = "INSERT INTO usuarios(nom_usu, pass_usu) VALUES ("+request.args.get('user')+", "+request.args.get('password')+")"
        query_verificacion = "select * from usuarios where nom_usu="+request.args.get('user')+""
        try:
            # Ejecutar el comando de verificación
            cur.execute(query_verificacion)
            verificar = cur.fetchall()

            #Verificar si el usuario existe
            if len(verificar) == 1:
                return "El nombre de usuario ya está registrado."

            else:
                #Ejecutar comando de registro
                cur.execute(query_registro)
                # Efectuar los cambios en la base de datos
                con.commit()
                return "Registro exitoso."
        
        except:
            #Revertir los cambios en caso de error
            con.rollback()
            return "Registro fallido."

    
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            return "Acceso denegado."
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("No se ha encontrado la base de datos.")
        else:
            print(err)


    finally:
        cur.close()
        con.close()

#Método para iniciar sesión
@app.route('/login')
def getLoginRequest():

    try:
        #Abrir conexión con la base de datos
        con = mysql.connector.connect(user=DB_USER, password=DB_PASS,host=DB_HOST,database=DB_NAME)
        #Definir entrada del cursor
        cur = con.cursor()
        print("Conectado a la base de datos.")

        #Definir sentencia SQL para iniciar sesión
        query = "select * from usuarios where nom_usu="+request.args.get('user')+" and pass_usu="+request.args.get('password')+""

        try:
            
            # Ejecutar el comando
            cur.execute(query)
            resultados = cur.fetchall()
            if len(resultados) == 1:
                return redirect(url_for('consultar'))

            else:
                return "Usuario y/o contraseña incorrectos."
        
        except:
            
            #Revertir los cambios en caso de error
            con.rollback()
            return "Error al iniciar sesión."

    
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("Acceso denegado.")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("No se ha encontrado la base de datos.")
        else:
            print(err)


    finally:
        cur.close()
        con.close()




def beta1(x,y):
    termino1 = x-average(x)
    termino2= y-average(y)
    Sxy = sum(termino1*termino2)
    Sxx = sum(termino1*termino1)
    return Sxy/Sxx

def beta0(x,y):
    return average(y)-beta1(x,y)*average(x)

def plot_recta(x,y):
    b1 = beta1(x,y)
    b0 = beta0(x,y)
    puntos_x = linspace(x[0],x[-1],100)
    puntos_y = b0 + b1 * puntos_x
    plt.plot(puntos_x,puntos_y)
    plt.plot(x,y,'r*')
    plt.savefig('grafica_calorias_mes.png')

x = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
y = (334,2203,9993,4626,3961,3943,938,4744,4881,5624,675,8091,3680,4090,66,9479,9117,2759,7270,7849,1093,7508,2737,5062,3032,2541,9445,4440,7192,6746)

num_y = int(len(y))

if num_y >= 10:
    plot_recta(x,y)


else:
    print("Debes tener más de 10 registros para hacer la predicción")


if __name__ == '__main__':
    app.run()