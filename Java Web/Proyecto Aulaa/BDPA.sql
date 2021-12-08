
create database Fitracker;
use Fitracker;

DROP table if exists clasificacion_eje;
create table clasificacion_eje (
id_ec int(8) NOT NULL AUTO_INCREMENT,
clasi_ec varchar(20) not null,
primary key (id_ec));
lock table clasificacion_eje write;
insert into clasificacion_eje values (1 , 'Baja'), (2,'Intermedia'), (3,'Alta');
unlock tables;

DROP table if exists clasificacion_die;
create table clasificacion_die (
id_cd int(8) NOT NULL AUTO_INCREMENT,
clasi_cd varchar(20) not null,
primary key (id_cd));
lock table clasificacion_die write;
insert into clasificacion_die values (1 , 'Con mucha verduras'), (2,'Sin Carne'), (3,'Alcalina'),
(4, 'Con Fibra'), (5, 'Con Proteinas'), (6, 'Baja en Colesterol'), (7, 'Libre de Gluten'), (8, 'Baja en Sal');
unlock tables;

DROP table if exists horario;
create table horario(
id_horario int(8) NOT NULL AUTO_INCREMENT,
des_horario varchar(20) not null,
primary key (id_horario));

lock table horario write;
insert into horario values (1 , 'Mañana'), (2,'Tarde'), (3,'Noche');
unlock tables;

DROP table if exists usuario;
create table usuario(
id_usu int(8) NOT NULL AUTO_INCREMENT,
contra_usu varchar(30) NOT NULL,
email_usu varchar(30) NOT NULL,
nom_usu varchar(30) NOT NULL,
permisos_usu int(1) NOT NULL,
activa int(1) NOT NULL,
primary key (id_usu),
key email_usu (email_usu));

insert into usuario (contra_usu, email_usu, nom_usu, permisos_usu, activa) 
values('admin123', 'admin@fitraker.com', 'Administrador', '1', '1');

insert into usuario (contra_usu, email_usu, nom_usu, permisos_usu, activa) 
values('juan123', 'juan@gmail.com', 'juan', '0', '1');

DROP table if exists ejercicio;
create table ejercicio(
id_eje int(8) NOT NULL auto_increment,
nom_eje varchar(20) NOT NULL,
calorias_eje double(10, 5) NOT NULL,
activa int(1) NOT NULL,
id_ec int(8) NOT NULL,
primary key(id_eje),
key nom_eje (nom_eje),
foreign key (id_ec) REFERENCES clasificacion_eje (id_ec));

DROP table if exists ejerciciousuario;
create table ejerciciousuario (
id_ejeusu int(8) NOT NULL auto_increment,
id_eje int (8) NOT NULL,
id_usu int (8) NOT NULL,
repeticiones_eje int(8) NOt NULL,
primary key(id_ejeusu),
foreign key (id_eje) references ejercicio (id_eje),
foreign key(id_usu) references usuario(id_usu));

DROP table if exists cantidadcaloria;
create table cantidadcaloria (
id_cc int(8) NOT NULL auto_increment,
id_usu int(8) NOT NULL,
cantidad double NOT NULL,
dia varchar(10) NOT NULL,
primary key(id_cc),
foreign key (id_usu) references usuario (id_usu));
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 65.3223, '1/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 23.23, '2/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 6.23, '3/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 22.223, '4/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 13.3, '5/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 32.23, '6/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 42.2, '7/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 54.7, '8/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 73.23, '9/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 82.2123, '10/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 31.3123, '11/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 31.323, '12/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 11.23, '13/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 43.23, '14/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 63, '15/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 86.23, '16/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 95.322323, '17/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 65.3212, '18/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 15.322233, '19/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 0 , '20/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 5.32323, '21/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 32.33, '22/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 53.23, '23/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 12.23, '24/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 43.23, '25/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 23.23, '26/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 22.22222, '27/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 32.31, '28/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 21.23, '29/5/2021');
insert into cantidadcaloria (id_usu, cantidad, dia) values (2, 22.32, '30/5/2021');

DROP table if exists dieta;
create table dieta(
id_die int(8) NOT NULL auto_increment,
nom_die varchar(20) NOT NULL,
des_die varchar(200) NOT NULL,
activa int(1) NOT NULL,
id_cd int(8) NOT NULL,
primary key(id_die),
key nom_die (nom_die),
foreign key (id_cd) REFERENCES clasificacion_die (id_cd));

DROP table if exists comida;
create table comida(
id_comida int(8) not null auto_increment,
nom_comi varchar(30) NOT NULL,
des_comi varchar(200) NOT NULL,
activa int(1) NOT NULL,
primary key(id_comida),
key nom_comi (nom_comi));

DROP table if exists encabezadodieta;
create table encabezadodieta(
id_endie int(8) not null auto_increment,
id_die int(8) not null,
primary key(id_endie),
foreign key (id_die) references dieta (id_die));

DROP table if exists comidadedieta;
create table comidadedieta (
id_cd int(8) NOT NULL auto_increment,
id_comida int(8) NOT NULL,
id_endie int(8) NOT NULL,
id_horario int(8) NOT NULL,
primary key(id_cd),
foreign key (id_comida) references comida(id_comida),
foreign key (id_horario) references horario (id_horario),
foreign key (id_endie) references encabezadodieta (id_endie));

DROP table if exists bibliotecadedieta;
create table bibliotecadedieta(
id_bli int(8) NOT NULL auto_increment,
id_usu int(8) NOT NULL,
id_endie int(8) NOT NULL,
primary key (id_bli),
foreign key (id_usu) references usuario(id_usu),
foreign key (id_endie) references encabezadodieta(id_endie)
);




