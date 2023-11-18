-- BD-Empleados para ver mas funciones y operadores aritméticos
-- CREATE DATABASE EMPLEADOS_BBDD;
-- use EMPLEADOS_BBDD;

 CREATE TABLE DEPARTAMENTO(
	CODIGO        INT(3)  PRIMARY KEY,
	NOMBRE        VARCHAR(36) NOT NULL,
	NUMERO        INT(6));
    
INSERT INTO  DEPARTAMENTO VALUES 
(1,'CENTRO PROCESOS',10),
(2,'PLANIFICACION',20),
(3,'INFORMACION',30),
(4,'DESARROLLO',NULL),
(6,'FABRICACION',60),
(7,'ADMINISTRACION',NULL),
(5,'SERVICIOS',50),
(8,'OPERACIONES',90),
(9,'SOFTWARE',100);

CREATE TABLE EMPLEADO(
NUEMPL        INT(6)  PRIMARY KEY,
NOMBRE        VARCHAR(12)  NOT NULL, 
APELLIDO      VARCHAR(15) NOT NULL, 
FECHING       DATE   NOT NULL,  
CODDEP        INT (3)  NOT NULL,        
SEXO          CHAR(1) NOT NULL,          
FECHNAC       DATE,           
SALARIO       DECIMAL(9,2),
FOREIGN KEY(CODDEP) REFERENCES DEPARTAMENTO(CODIGO)          
 );
 
INSERT INTO EMPLEADO VALUES 
  (10,'CRISTINA','HERNANDEZ','1996-01-01',6,'M','1973-08-14',52750),
  (20,'MIGUEL','TAPIA','2003-10-10',6,'H','1988-02-02',41250),
  (30,'SALOME','KEMPES','2015-04-05',6,'M','1981-05-11',38250),
  (50,'JUAN','GARRIDO','1989-08-17',8,'H','1965-09-15',40175),
  (60,'ISIDRO','SUAREZ','2013-09-14',5,'H','1985-07-07',32250),
  (70,'EVA','PUENTE','2010-09-30',5,'M','1993-05-26',36170),
  (90,'ELENA','HERRANZ','2010-08-15',5,'M','1981-05-15',29452),
  (100,'TOMAS','SOLER','2014-06-19',4,'H','1996-12-18',26150),
  (110,'VICENTE','LUENGO','1998-05-16',8,'H','1969-11-05',46500),
  (120,'SIMON','OTERO','2003-12-05',8,'H','1982-10-18',29250),
  (130,'DOLORES','QUINTANA','2011-07-23',2,'M','1965-09-15',23800),
  (140,'HELIODORA','NIETO','2016-12-15',1,'M','1989-01-19',28420),
  (150,'BRUNO','ALVAREZ','2002-02-15',1,'H','1987-05-17',25280),
  (160,'ELISA','PINTO','2017-10-11',4,'M','1995-04-12',22250),
  (170,'MATEO','YARZA','2008-09-15',7,'H','1991-01-05',24680),
  (180,'MARINA','SANDOVAL','2013-07-07',3,'M','1989-02-21',31340),
  (190,'JAIME','WALKER','2014-07-27',3,'H','1992-06-25',20450),
  (200,'DAVID','BONDIA','2006-03-03',4,'H','1981-05-29',27740),
  (210,'WENCESLAO','JURADO','2009-04-11',2,'H','1993-02-23',18270),
  (220,'JIMENA','LUQUE','2008-08-19',5,'M','1988-03-19',29840),
  (230,'JAIME','JIMENEZ','2006-11-21',3,'H','1975-05-30',22180),
  (240,'SALVADOR','MARTINEZ','2017-12-05',5,'H','1994-03-15',28760),
  (250,'DANIEL','SIERRA','2009-10-30',2,'H','1962-11-30',19180),
  (260,'SUSANA','JUNQUERA','2015-09-11',2,'M','1976-10-05',17250),
  (270,'MARIA','PEREZ','2015-09-30',5,'M','1993-05-23',27380),
  (280,'ENGRACIA','SANCHEZ','2007-03-24',4,'M','1981-05-15',25987),
  (290,'JUAN','PALACIOS','2010-05-30',4,'H','1986-07-09',13806),
  (300,'PEDRO','SIERRA','2012-06-19',8,'H','1976-10-27',17750),
  (310,'MATILDE','SERNA','2004-09-12',3,'M','1971-04-12',15741),
  (320,'RAMON','MORAN','2005-07-07',5,'H','1972-08-11',19950),
 (330,'WILLY','LERMA','2016-02-13',5,'H','1981-07-18',25370),
 (340,'JAVIER','GIL','1987-05-05',4,'H','1966-05-17',23840),
 (341,'SARA','RUIZ','1987-05-06',2,'M','1976-07-18',18840);

#Visualizar los salarios de los empleados y como quedaría si les descontáramos 1000 pesos

select (Salario), Salario-1000 as SalarioDescuento 
from Empleado ;

#Visualizar los salarios actuales y aumentados en un 10% pero solamente de aquellos que ganan menos de 35000
select (Salario), Salario*1.10 as SalarioAumento 
from Empleado 
where (Salario<35000);

#Visualizar los datos de los empleados que ingresaron en el año 2010
SELECT * 
from Empleado
where year(FECHING)=2010;

#Visualizar los nombres, fecha de nacimiento y las edades aproximadas de los empleados
select NOMBRE,FECHNAC , year(NOW())-year(FECHNAC) as Edad_aprox 
from Empleado;

#Visualizar los nombres de los empleados en minúsculas
select lower(NOMBRE) 
from Empleado;
