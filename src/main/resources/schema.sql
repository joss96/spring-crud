    DROP TABLE IF EXISTS empleado;  
    CREATE TABLE empleado (  
    empleadoId INT AUTO_INCREMENT  PRIMARY KEY,  
    nombre VARCHAR(50) NOT NULL, 
    apellidos VARCHAR(50) NOT NULL, 
    edad INT NOT NULL, 
    salario DOUBLE NOT NULL  
    );  