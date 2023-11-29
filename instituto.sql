CREATE database instituto;
USE instituto;
 
CREATE  TABLE persona (
  cedula INT(8) NOT NULL ,
  nombre VARCHAR(15)  NOT NULL ,
  apellido VARCHAR(15)  NOT NULL ,
  PRIMARY KEY (cedula) 
);
