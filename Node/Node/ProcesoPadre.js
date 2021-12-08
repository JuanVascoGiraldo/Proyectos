console.log("Hola Yo soy el Proceso Padre :3, Me llamo Vasco Giraldo Juan Esteban :3");
var proceso = require("child_process").fork;
var sup1 = proceso("subpro1.js");
sup1.send({msg:"Hola desde el subproceso 1 con la clase child, Mi numero de boleta es 2020090180"})
var sup2 = proceso("subpro2.js");
sup2.send({msg:"Hola desde el subproceso 2 con la clase child, Soy del grupo 5IV7"})
var sup3 = proceso("subpro3.js");
sup3.send({msg:"Hola desde el subproceso 3 con la clase child, Me Gustan los Gatitos y quiero" +
 "Aprender Node para hacer Apis :3 "})