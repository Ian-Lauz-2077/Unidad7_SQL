CREATE database instituto;
USE instituto;
 
CREATE  TABLE persona (
  cedula INT(8) NOT NULL ,
  nombre VARCHAR(15)  NOT NULL ,
  apellido VARCHAR(15)  NOT NULL ,
  PRIMARY KEY (cedula) 
);
CREATE TABLE alumno (
  cedula INT(8) NOT NULL ,
  grupo VARCHAR(3) NOT NULL ,
  PRIMARY KEY (cedula) ,
  FOREIGN KEY (cedula) REFERENCES persona (cedula)
);
delete from persona where cedula=20;
select * from persona ;
select * from alumno ;
