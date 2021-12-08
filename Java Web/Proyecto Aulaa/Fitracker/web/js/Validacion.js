function iniciosesion(){

    var correo = document.iniciarSesion.email.value;
    var contraseña = document.iniciarSesion.contra.value;
    let expresioncorreo = /\w+@\w+\.+[a-z]/; /*Expresión solamente para correo*/
    let expresioncontra =  /^[a-zA-Z0-9 ]+$/;
    /*Expresión loquísima para la contra xd*/
    var allvalid = true;
    if(correo === "" || contraseña === ""){
        alert("Todos los campos son obligatorios, no puedes iniciar sesión si no has ingresado tu correo y/o contraseña.");
        allvalid = false;
        return false;
    }
    else if(correo.length > 30){
        alert("El correo es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(contraseña.length > 30){
        alert("La contraseña es muy larga, ingrese una que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresioncorreo.test(correo)){
        alert("El correo ingresado no es válido, escriba por favor uno con la estructura: texto@texto.texto");
        allvalid = false;
        return false;
    }
    else if(!expresioncontra.test(contraseña)){
        alert("La contraseña ingresada no es válida");
        allvalid = false;
        return false;
    }
    
    if(!allvalid){
        alert("El inicio de sesión no fue realizado de forma correcta.");
        return false;
    }else{
        document.iniciarSesion.submit();
    }
} 

function registro(){
    var nombre = document.registrarse.nombre.value;
    var correo = document.registrarse.email.value;
    var contraseña = document.registrarse.contra.value;
    var confcontraseña = document.registrarse.confcontraseña.value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresioncorreo = /^\w+@\w+\.+[a-z]+$/; /*Expresión solamente para correo*/
    let expresioncontra =  /^[a-zA-Z0-9 ]+$/;
    /*Expresión loquísima para la contra xd*/
    var allvalid = true;
    
    if(nombre ==="" || correo === "" || contraseña === "" || confcontraseña === ""){
        alert("Todos los campos son obligatorios, no puedes registrarte si no has ingresado un nombre, correo o contraseña, \n\
        o si no confirmas tu contraseña.");
        allvalid = false;
    }
    else if(nombre.length > 20){
        alert("El nombre es muy largo, ingrese uno que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
    }
    else if(correo.length > 30){
        alert("El correo es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
    }
    else if(contraseña.length > 30){
        alert("La contraseña es muy larga, ingrese una que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
    }
    else if(confcontraseña.length > 30){
        alert("La confirmación de la contraseña es muy larga, ingrese una que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
    }
    else if(!expresioncorreo.test(correo)){
        alert("El correo ingresado no es válido, escriba por favor uno con la estructura: texto@texto.texto");
        allvalid = false;
    }
    else if(!expresioncontra.test(contraseña)){
        alert("La contraseña ingresada no es válida");
        allvalid = false;
    }
    else if(!expresioncontra.test(confcontraseña)){
        alert("La confirmación de la contraseña no es válida");
        allvalid = false;
    }
    else if(contraseña !== confcontraseña){
        alert("La confirmación de la contraseña no es igual a la contraseña, ingrese los mismos caractéres de la contraseña, por favor.");
        allvalid = false;
    }
    if(allvalid){
        document.registrarse.submit();
    }else{
        alert("El registro no fue realizado de forma correcta.");
    }
}

function agregarejercicio(agregareje){
    var nombre = document.agregareje.nombre.value;
    var calquemporrepe = document.agregareje.calorias.value;
    var select = document.agregareje.clasificacion;
    var clasificacion = select.options[select.selectedIndex].value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiononlynumber = /^\d*\.?\d+$/;
    var allvalid = true;
    if(nombre ==="" || calquemporrepe === "" || clasificacion === "Elige una clasificacion"){
        alert("Todos los campos son obligatorios, no puedes agregar un ejercicio si no has ingresado un nombre y/o \n\
        la cantidad de calorías quemadas por cada repetición.");
        allvalid = false;
        return false;
    }
    else if(nombre.length > 20){
        alert("El nombre es muy largo, ingrese uno que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(calquemporrepe.length > 20){
        alert("La cantidad de calorías quemadas por cada repetición es muy larga, ingrese una que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlynumber.test(calquemporrepe)){
        alert("La cantidad de calorías quemadas por cada repetición no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El agregar un ejercicio no fue realizado de forma correcta.");
        return false;
    }else{
        document.agregareje.submit();
    }
}

function modificarejercicioo(){
    var nombre = document.modificareje.nombre.value;
    var calquemporrepe = document.modificareje.calorias.value;
    var select = document.modificareje.clasificacion;
    var clasificacion = select.options[select.selectedIndex].value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiononlynumber = /^\d*\.?\d+$/;
    var allvalid = true;
    
    if(nombre ==="" || calquemporrepe === "" || clasificacion === "Elige una clasificacion"){
        alert("Todos los campos son obligatorios, no puedes modificar un ejercicio si no has ingresado un nombre y/o \n\
        la cantidad de calorías quemadas por cada repetición.");
        allvalid = false;
        return false;
    }
    else if(nombre.length > 20){
        alert("El nombre es muy largo, ingrese uno que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(calquemporrepe.length > 20){
        alert("La cantidad de calorías quemadas por cada repetición es muy larga, ingrese una que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlynumber.test(calquemporrepe)){
        alert("La cantidad de calorías quemadas por cada repetición no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El modificar un ejercicio no fue realizado de forma correcta.");
        return false;
    }else{
        document.modificareje.submit();
    }
}

function agregarcomida(){
    var nombre = document.agregarcomi.nombre.value;
    var descripción = document.agregarcomi.descripcion.value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiondescriptiontext = /^[a-zA-Z0-9 ]+$/; /*Expresión solamente para texto, números y espacios*/
    var allvalid = true;
    
    if(nombre ==="" || descripción === ""){
        alert("Todos los campos son obligatorios, no puedes agregar una comida si no has ingresado un nombre y/o \n\
        una descripción.");
        allvalid = false;
        return false;
    }
    else if(nombre.length > 30){
        alert("El nombre es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(descripción.length > 200){
        alert("La descripción es muy larga, ingrese una que contenga 200 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiondescriptiontext.test(descripción)){
        alert("La descripción no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El agregar una comida no fue realizado de forma correcta.");
        return false;
    }else{
        document.agregarcomi.submit();
    }
}

function modificarcomidas(){
    var nombre = document.modicomi.nombre.value;
    var descripción = document.modicomi.descripcion.value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiondescriptiontext = /^[a-zA-Z0-9 ]+$/; /*Expresión solamente para texto, números y espacios*/
    var allvalid = true;
    
    if(nombre ==="" || descripción === ""){
        alert("Todos los campos son obligatorios, no puedes modificar una comida si no has ingresado un nombre y/o \n\
        una descripción.");
        allvalid = false;
        return false;
    }
    else if(nombre.length > 30){
        alert("El nombre es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(descripción.length > 200){
        alert("La descripción es muy larga, ingrese una que contenga 200 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiondescriptiontext.test(descripción)){
        alert("La descripción no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El modificar una comida no fue realizado de forma correcta.");
        return false;
    }else{
        document.modicomi.submit();
    }
}

function agregarcomidaadieta(){
    var select2 = document.agregarcomiadieta.dieta;
    var dieta = select2.options[select2.selectedIndex].value;
    var select = document.agregarcomiadieta.horario;
    var horario = select.options[select.selectedIndex].value;
    var allvalid = true;
    
    if(dieta === "Elige una dieta"){
        alert("Selecciona una opción del menú de dieta por favor.");
        dieta.focus();
        allvalid = false;
        return false;
    }
    else if(horario === "Elige un horario"){
        alert("Selecciona una opción del menú de horario por favor.");
        horario.focus();
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El agregar una comida a una dieta no fue realizado de forma correcta.");
        return false;
    }else{
        document.agregarcomiadieta.submit();
    }
}

function agregardietas(){
    var nombre = document.agregardieta.nombre.value;
    var descripción = document.agregardieta.descripcion.value;
    var select = document.agregardieta.clasificacion;
    var clasificacion = select.options[select.selectedIndex].value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiondescriptiontext = /^[a-zA-Z0-9 ]+$/; /*Expresión solamente para texto, números y espacios*/
    var allvalid = true;
    
    if(nombre ==="" || descripción === ""){
        alert("Todos los campos son obligatorios, no puedes agregar una dieta si no has ingresado un nombre y/o \n\
        una descripción.");
        allvalid = false;
        return false;
    }
    else if(clasificacion === "Elige una clasificacion"){
        alert("Selecciona una opción del menú de clasificación por favor.");
        clasificación.focus();
        allvalid = false;
        return false;
    }
    else if(nombre.length > 30){
        alert("El nombre es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(descripción.length > 200){
        alert("La descripción es muy larga, ingrese una que contenga 200 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiondescriptiontext.test(descripción)){
        alert("La descripción no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El agregar una dieta no fue realizado de forma correcta.");
        return false;
    }else{
        document.agregardieta.submit();
    }
}

function modificardieta(){
    var nombre = document.modidieta.nombre.value;
    var descripción = document.modidieta.descripcion.value;
    var select = document.modidieta.clasificacion;
    var clasificacion = select.options[select.selectedIndex].value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresiondescriptiontext = /^[a-zA-Z0-9 ]+$/; /*Expresión solamente para texto, números y espacios*/
    var allvalid = true;
    
    if(nombre ==="" || descripción === ""){
        alert("Todos los campos son obligatorios, no puedes modificar una dieta si no has ingresado un nombre y/o \n\
        una descripción.");
        allvalid = false;
        return false;
    }
    else if(clasificacion === "Elige una clasificacion"){
        alert("Selecciona una opción del menú de clasificación por favor.");
        clasificación.focus();
        allvalid = false;
        return false;
    }
    else if(nombre.length > 30){
        alert("El nombre es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(descripción.length > 200){
        alert("La descripción es muy larga, ingrese una que contenga 200 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresiondescriptiontext.test(descripción)){
        alert("La descripción no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El modificar una dieta no fue realizado de forma correcta.");
        return false;
    }else{
        document.modidieta.submit();
    }
}

function modificarcomidadedieta(){
    var select = document.modiDieComi.horario;
    var horario = select.options[select.selectedIndex].value;
    var allvalid = true;
    
    if(horario === "Elige un horario") {
        alert("Selecciona una opción del menú de horario por favor.");
        horario.focus();
        allvalid = false;
        return false;
    }

    if(!allvalid){
        alert("El modificar una comieda de una dieta no fue realizado de forma correcta.");
        return false;
    }else{
        document.modiDieComi.submit();
    }
}

function agregarejercicioarutina(){
    var repeticiones = document.agregarejearutina.repeticiones.value;
    let expresiononlynumber = /^[0-9]+$/; /*Expresión solamente para números*/
    var allvalid = true;
    
    if(repeticiones ==="" || repeticiones === "0"){
        alert("Todos los campos son obligatorios, no puedes agregar un ejercicio a una rutina si no has ingresado\n\
        la cantidad de repeticiones que realizará del ejercicio.");
        allvalid = false;
        return false;
    }
    else if(repeticiones.length > 8){
        alert("La cantidad de repeticiones que realizará del ejercicio es muy larga, ingrese una que contenga 8 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlynumber.test(repeticiones)){
        alert("La cantidad de repeticiones que realizará del ejercicio no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El agregar una ejercicio a una rutina no fue realizado de forma correcta.");
        return false;
    }else{
        document.agregarejearutina.submit();
    }
}

function modificarcuenta(){
    var nombre = document.actuausu.nombre.value;
    var correo = document.actuausu.email.value;
    var contraseña = document.actuausu.contra.value;
    var confcontraseña = document.actuausu.confcontrasena.value;
    let expresiononlytext = /^[a-zA-Z ]+$/; /*Expresión solamente para texto y espacios*/
    let expresioncorreo = /^\w+@\w+\.+[a-z]+$/; /*Expresión solamente para correo*/
    let expresioncontra =  /^[a-zA-Z0-9 ]+$/;
    /*Expresión loquísima para la contra xd*/
    var allvalid = true;
    
    if(nombre ==="" || correo === "" || contraseña === "" || confcontraseña === ""){
        alert("Todos los campos son obligatorios, no puedes modificar tu cuenta si no has ingresado un nombre, correo o contraseña, \n\
        o si no confirmas tu contraseña.");
        allvalid = false;
        return false;
    }
    else if(nombre.length > 20){
        alert("El nombre es muy largo, ingrese uno que contenga 20 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(correo.length > 30){
        alert("El correo es muy largo, ingrese uno que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(contraseña.length > 30){
        alert("La contraseña es muy larga, ingrese una que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(confcontraseña.length > 30){
        alert("La confirmación de la contraseña es muy larga, ingrese una que contenga 30 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlytext.test(nombre)){
        alert("El nombre ingresado no es válido.");
        allvalid = false;
        return false;
    }
    else if(!expresioncorreo.test(correo)){
        alert("El correo ingresado no es válido, escriba por favor uno con la estructura: texto@texto.texto");
        allvalid = false;
        return false;
    }
    else if(!expresioncontra.test(contraseña)){
        alert("La contraseña ingresada no es válida");
        allvalid = false;
        return false;
    }
    else if(!expresioncontra.test(confcontraseña)){
        alert("La confirmación de la contraseña no es válida");
        allvalid = false;
        return false;
    }
    else if(contraseña !== confcontraseña){
        alert("La confirmación de la contraseña no es igual a la contraseña, ingrese los mismos caractéres de la contraseña, por favor.");
        allvalid = false;
        return false;
    }
    
    if(!allvalid){
        alert("El registro no fue realizado de forma correcta.");
        return false;
    }else{
        document.actuausu.submit();
    }
}

function modificarejerciciousuario(){
    var repeticiones = document.modiejeusu.repeticiones.value;
    let expresiononlynumber = /^[0-9]+$/; /*Expresión solamente para números*/
    var allvalid = true;
    
    if(repeticiones ==="" || repeticiones === "0"){
        alert("Todos los campos son obligatorios, no puedes modificar un ejercicio si no has ingresado\n\
        la cantidad de repeticiones que realizará del ejercicio.");
        allvalid = false;
        return false;
    }
    else if(repeticiones.length > 8){
        alert("La cantidad de repeticiones que realizará del ejercicio es muy larga, ingrese una que contenga 8 o menos caractéres, por favor.");
        allvalid = false;
        return false;
    }
    else if(!expresiononlynumber.test(repeticiones)){
        alert("La cantidad de repeticiones que realizará del ejercicio no es válida.");
        allvalid = false;
        return false;
    }
    if(!allvalid){
        alert("El modificar un ejercicio no fue realizado de forma correcta.");
        return false;
    }else{
        document.modiejeusu.submit();
    }
}