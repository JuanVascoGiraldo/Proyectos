import Operaciones as Operaciones
sumar = [ 1, 2, 3, 4]
restar = [1, -1, 3, -2]
multiplicarr= [2, 3]
su= Operaciones.Operaciones.realizarOperacion(sumar)
rest= Operaciones.Operaciones.realizarOperacion(restar)
mult= Operaciones.Operaciones.multiplicar.realizarOperacion(*multiplicarr)
print(su)
print(rest)
print(mult)
