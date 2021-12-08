console.log("Hola Yo soy el Proceso Padre :3, Me llamo Gutierrez Bueno Elizabeth Andrea :3");
var proceso = require("child_process").fork;
var sup1 = proceso("subproceso1.js");
var sup2 = proceso("subproceso2.js");
var sup3 = proceso("subproceso3.js");