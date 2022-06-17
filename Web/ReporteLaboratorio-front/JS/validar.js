let expresionboleta = /^([0-9])*$/;
let expresioncontra = /^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$/;
let expresiononlytext = /^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ]+$/u;
let expresiontextnumber = /^[a-zA-Z0-9àáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,\. \? \¿]+$/;

function validarboleta(boleta){
    var validar = expresionboleta.test(boleta);
    if (!validar) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'La Boleta no es valida'
        });
    }else if(boleta.length !=10){
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'La Boleta no es valida'
        });
        validar = false
    }
    return validar;
}

function validarcontrasena(contrasena) {
    var validar = expresioncontra.test(contrasena);
    if (!validar) {
        Swal.fire({
            icon: 'error',
            title: 'Ingrese una contraseña valida',
            text: 'La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.'
        });
    }
    return validar;
}


function validarnombre(nombre) {
    var validar = expresiononlytext.test(nombre);
    if (!validar) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingrese un nombre valido (solo letras y espacios)'
        });
        return false;
    } else if (nombre.length > 80 || nombre.length == 0) {
        Swal.fire({
            icon: 'error',
            title: 'El tamaño del nombre no es correcto',
            text: 'El nombre tiene que medir entre 1 y 80 caracteres'
        });
        return false;
    } else {
        return true;
    }
}

function validartexto(texto) {
    var validar = expresiontextnumber.test(texto);
    if (texto.length > 200 || texto.length < 11) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Solo puedes ingresar como maximo 200 caracteres y minimo 10 caracteres'
        });
        return false;
    } else if (!validar) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Solo puedes ingresar letras y numeros en el campo'
        });
        return false;
    } else {
        return true;
    }
}

function validarIS(){
    var boleta = document.iniciar.boleta.value;
    var contra = document.iniciar.contra.value;
    if(validarboleta(boleta) && validarcontrasena(contra)){
        $.post('IniciarSesion', {
            boleta: boleta,
            contra: contra
            }, function(responseText) {
                    $('#cambiar').html(responseText);
            });
    }
}

function validarISA(){
    var contra= document.passadmin.pass.value;
    if(validarcontrasena(contra)){
        $.post('IniciarSesionAdmin', {
            boleta: boleta,
            contra: contra
            }, function(responseText) {
                    $('#cambiar1').html(responseText);
            });
    }
}

function CambiarContra(){
    var contra= document.changepass.contra.value;
    if(validarcontrasena(contra)){
        document.changepass.submit();
    }
}


function RealizarReporte(){
    var reporte = document.hacerreporte.reporte.value;
    if(validartexto(reporte)){
        document.hacerreporte.submit();
    }
}

function RegistrarEquipoN(){
    var numero = document.RegistrarEquipo.numero.value;
    var labo = document.RegistrarEquipo.labo.value;
    if(expresionboleta.test(numero) && numero.length< 8){
        $.post('Requipo', {
            numero: numero,
            labo: labo
            }, function(responseText) {
                    $('#cambiar1').html(responseText);
            });
    }
}

function RegistrarEstudianteN(){
    var nombre= document.RegistrarEstudiante.nombre.value;
    var boleta = document.RegistrarEstudiante.boleta.value;
    var grupo = document.RegistrarEstudiante.grupo.value;
    if(validarboleta(boleta)&&validarnombre(nombre)){
        $.post('ReEstudiante', {
            nombre: nombre,
            boleta: boleta,
            grupo: grupo
            }, function(responseText) {
                    $('#cambiar1').html(responseText);
            });
    }
}

function ResolverResporteN(){
    var solucion = document.resolvereporte.solucion.value;
    if(validartexto(solucion)){
        document.resolvereporte.submit();
    }
}

function AsignarMaquina(){
    var lab1 = document.Maquina.LBD.value;
    var lab2 = document.Maquina.LNV.value;
    var lab3 = document.Maquina.LDS.value;
    var lab4 = document.Maquina.Cuatro.value;

    if(parseInt(lab1)===0 &&parseInt(lab2)===0 &&parseInt(lab3)===0 &&parseInt(lab4)===0 ){
        Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Escoja almenos un equipo'
                });
    }else{
        document.Maquina.submit();
    }
}




