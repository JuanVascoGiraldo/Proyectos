const http = require('http');
const hostname = '127.0.0.1';
const port = 3000;
const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hola Mundo');
});

server.listen(port, hostname, () => {
  console.log(`El servidor se está ejecutando en http://${hostname}:${port}/`);
});
const interface = require('readline-sync');
do{
    numero1 = interface.question('Ingrese el numero 1: ');
    numero2 = interface.question('Ingrese el numero 2: ');
    console.log("Michi calculadora. Elija la operación que desea realizar");
    console.log("1: Suma");
    console.log("2: Resta");
    console.log("3: Multiplicación");
    console.log("4: División");
    console.log("5: Salir")
    operacion = interface.question('Ingrese El numero de la operacion a realizar colocando el numero: ');
    if( operacion != "5"){
    try{
        switch (operacion) {
            case "1":
                console.log("El resultado de la operación es");
                console.log(parseFloat(numero1) + parseFloat(numero2));
                break;
            case "2":
                console.log("El resultado de la operación es");
                console.log(parseFloat(numero1) - parseFloat(numero2));
                break;
            case "3":
                console.log("El resultado de la operación es");
                console.log(parseFloat(numero1) * parseFloat(numero2));
                break;
            case "4":
                if(numero2 != "0"){
                    console.log("El resultado de la operación es");
                    console.log(parseFloat(numero1) / parseFloat(numero2));
                }else{
                    console.log("No se puede dividir entre 0");
                }
                break;
            default:
                console.log("La operación no es valida")
                break;
        }
    }catch(error){
        console.error(error);
        }
    }
}while(operacion != "5");