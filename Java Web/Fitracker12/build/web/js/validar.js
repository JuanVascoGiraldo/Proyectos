var comprobar="qwertyuiopasdfghjklñzxcvbnm.QWERTYUIOPASDFGHJKLÑZXCVBNM";
var comprobar2= "1234567890.";
var comprobar3= comprobar + comprobar2;

function iniciarsesion(){
    var nombre= document.iniciarSesion.nombre.value;
    var contraseña= document.iniciarSesion.contraseña.value;
    var todo =nombre+contraseña;
    var seguir= true;
    for(var i=0; i<todo.length; i++){
        var caracter = todo.charAt(i);
        for(var j = 0; j < comprobar3.length; j++){
            if(caracter == comprobar3.charAt(j))
                break;
            if(j == comprobar3.length-1){
                seguir = false;
                break;
            }
        }
    }
    if(seguir == false){
        alert("se han introducido caracteres no validos");
    }else{
        alert("ha ingresado al sistema");
    }
}

function registro(){
    var nombre= document.registrar.nombre.value;
    var contraseña= document.registrar.contraseña.value;
    var contraseña2= document.registrar.contraseña2.value;
    var todo =nombre+contraseña+contraseña2;
    var seguir= true;
    if(contraseña === contraseña2){
        for(var i=0; i<todo.length; i++){
            var caracter = todo.charAt(i);
            for(var j = 0; j < comprobar3.length; j++){
                if(caracter == comprobar3.charAt(j))
                    break;
                if(j == comprobar3.length-1){
                    seguir = false;
                    break;
                }
            }
        }
        if(seguir == false){
            alert("se han introducido caracteres no validos");
        }else{
            alert("ha registrado");
        }
    }else{
        alert("las contraseñas no coinciden")
    }
}

function añadireje(){
    var nombre= document.aejercicio.nombre.value;
    var calorias= document.aejercicio.caloria.value;
    for(var i=0; i<nombre.length; i++){
        var caracter = nombre.charAt(i);
        for(var j = 0; j < comprobar3.length; j++){
            if(caracter == comprobar3.charAt(j))
                break;
            if(j == comprobar3.length-1){
                seguir = false;
                break;
            }
        }
    }
    for(var i=0; i<calorias.length; i++){
        var caracter = calorias.charAt(i);
        for(var j = 0; j < comprobar2.length; j++){
            if(caracter == comprobar2.charAt(j))
                break;
            if(j == comprobar2.length-1){
                seguir = false;
                break;
            }
        }
    }

    if(seguir == false){
        alert("se han introducido caracteres no validos");
    }else{
        alert("Se guardado el ejercicio");
    }
}

function añadirdieta(){

    var nombre= document.adieta.nombre.value;
    var descripcion= document.adieta.descripcion.value;
    var clasificacion= document.adieta.clasificacion.value;
    var cmañana= document.adieta.Mañana.value;
    var ctarde= document.adieta.Tarde.value;
    var cnoche= document.adieta.Noche.value;
    var todo = nombre+clasificacion;
    var seguir= true;
    for(var i=0; i<todo.length; i++){
        var caracter = todo.charAt(i);
        for(var j = 0; j < comprobar.length; j++){
            if(caracter == comprobar.charAt(j))
                break;
            if(j == comprobar.length-1){
                seguir = false;
                break;
            }
        }
    }

    todo = cmañana+ctarde+cnoche;
    for(var i=0; i<todo.length; i++){
        var caracter = todo.charAt(i);
        for(var j = 0; j < comprobar3.length; j++){
            if(caracter == comprobar3.charAt(j))
                break;
            if(j == comprobar3.length-1){
                seguir = false;
                break;
            }
        }
    }
    todo = descripcion;
    for(var i=0; i<todo.length; i++){
        var caracter = todo.charAt(i);
        for(var j = 0; j < comprobar.length; j++){
            if(caracter == comprobar.charAt(j))
                break;
            if(j == comprobar.length-1){
                seguir = false;
                break;
            }
        }
    }
    if(seguir == false){
        alert("se han introducido caracteres no validos");
    }else{
        alert("Se ha guardado la dieta");
    }
}

function modificareje(){
    var select = document.getElementById("Parametro");
    var selectedOperation = select.options[select.selectedIndex].value;
    var cambio = document.Mejercicio.cambio.value;
    var seguir= true;

    if(selectedOperation === "nombre"){
        for(var i=0; i<cambio.length; i++){
            var caracter = cambio.charAt(i);
            for(var j = 0; j < comprobar3.length; j++){
                if(caracter == comprobar3.charAt(j))
                    break;
                if(j == comprobar3.length-1){
                    seguir = false;
                    break;
                }
            }
        }
        if(seguir == false){
            alert("se han introducido caracteres no validos para el nombre");
        }else{
            alert("Se ha cambiado el nombre");
        }
    }
    if(selectedOperation === "clasificacion"){
        seguir= false;
        if(cambio === "baja" || cambio === "media" || cambio === "alta"){
            seguir=true;
        }

        if(seguir == false){
            alert("Para el parametro de Clasificación solo se permite las opciones baja, media y alta");
        }else{
            alert("Se ha cambiado la clasificacion");
        }
        
    }
    if(selectedOperation === "calorias"){
        for(var i=0; i<cambio.length; i++){
            var caracter = cambio.charAt(i);
            for(var j = 0; j < comprobar2.length; j++){
                if(caracter == comprobar2.charAt(j))
                    break;
                if(j == comprobar2.length-1){
                    seguir = false;
                    break;
                }
            }
        }
        if(seguir == false){
            alert("se han introducido caracteres no validos para las calorias");
        }else{
            alert("Se ha cambiado el nombre");
        }
    }
}

function modificardie(){
    var select = document.getElementById("Parametro");
    var selectedOperation = select.options[select.selectedIndex].value;
    var cambio = document.Mdie.cambio.value;
    var seguir= true;

    if(selectedOperation === "nombre" || selectedOperation === "clasificacion" || selectedOperation === "descripcion"){
        for(var i=0; i<cambio.length; i++){
            var caracter = cambio.charAt(i);
            for(var j = 0; j < comprobar.length; j++){
                if(caracter == comprobar.charAt(j))
                    break;
                if(j == comprobar.length-1){
                    seguir = false;
                    break;
                }
            }
        }
    }
    if(selectedOperation === "mañana"||selectedOperation === "tarde"||selectedOperation === "noche"){
        for(var i=0; i<cambio.length; i++){
            var caracter = cambio.charAt(i);
            for(var j = 0; j < comprobar3.length; j++){
                if(caracter == comprobar3.charAt(j))
                    break;
                if(j == comprobar3.length-1){
                    seguir = false;
                    break;
                }
            }
        }
        
    }
    if(seguir == false){
            alert("se han introducido caracteres no validos");
        }else{
            alert("Se ha cambiado el nombre");
        }
}