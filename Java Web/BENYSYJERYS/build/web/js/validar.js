var comprobar="qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM ";
var comprobar2= "1234567890";
var comprobar3= comprobar + comprobar2;

function validardatos(){
    var nombre = document.agregarproducto.Nombre.value;
    var seguir = true;
    if(nombre.length >= 5){
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
        
        if(seguir == false){
            alert("se han introducido caracteres no validos para el nombre");
        }else{
            var precio = document.agregarproducto.Precio.value;
            if(precio.length < 1){
                alert("El campo Precio Esta Vacio");
            }
            else{
                var select = document.agregarproducto.sabores;
                var Sabor = select.options[select.selectedIndex].value;
                if(Sabor === "Elige el Sabor"){
                    alert("Elige un Sabor");
                }
                else{
                    var select2 = document.agregarproducto.icono;
                    var Imagen = select2.options[select2.selectedIndex].value;
                    if(Imagen === "Elige El icono"){
                        alert("Elige una imagen");
                    }else{
                        document.agregarproducto.submit();
                    }
                }
            }
        }
    }else{
        if(nombre.length > 0){
            alert("Introduce mas de 5 caracteres");
        }
        else{
            alert("El campo Nombre Esta Vacio");
        }
    }
}

function validardatos2(){
    var nombre = document.modificarproducto.Nombre.value;
    var seguir = true;
    if(nombre.length >= 5){
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
        
        if(seguir == false){
            alert("se han introducido caracteres no validos para el nombre");
        }else{
            var precio = document.modificarproducto.Precio.value;
            if(precio.length < 1){
                alert("El campo Precio Esta Vacio");
            }
            else{
                document.modificarproducto.submit(); 
            }
        }
    }else{
        if(nombre.length > 0){
            alert("Introduce mas de 5 caracteres");
        }
        else{
            alert("El campo Nombre Esta Vacio");
        }
    }
}