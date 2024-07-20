CREATE DATABASE IF NOT EXISTS ENCOMIENDAS;

USE ENCOMIENDAS;

CREATE TABLE AGENCIA (
                         id_agencia INT PRIMARY KEY AUTO_INCREMENT,
                         nombre_agencia VARCHAR(100) NOT NULL,
                         ubicacion_agencia VARCHAR(100),
                         codigo_postal INT,
                         provincia_agencia VARCHAR(100),
                         telefono_agencia VARCHAR(10),
                         ciudad_agencia VARCHAR(100),
                         estado_agencia BOOLEAN
);

CREATE TABLE USUARIO (
                         cedula VARCHAR(10) PRIMARY KEY,
                         nombres VARCHAR(100) NOT NULL,
                         apellidos VARCHAR(100) NOT NULL,
                         correo VARCHAR(100) NOT NULL,
                         telefono VARCHAR(10),
                         rol VARCHAR(20),
                         direccion VARCHAR(200),
                         ciudad VARCHAR(100),
                         telefono_adicional VARCHAR(10),
                         tipo_licencia CHAR(1),
                         estado_usuario BOOLEAN,
                         id_agencia INT,
                         FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia)
);

CREATE TABLE CUENTA (
                        id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
                        cedula VARCHAR(10),
                        username VARCHAR(50) NOT NULL,
                        contrasenia VARCHAR(50) NOT NULL,
                        FOREIGN KEY (cedula) REFERENCES USUARIO(cedula)
);

CREATE TABLE TRANSPORTE (
                            transporte_id INT PRIMARY KEY AUTO_INCREMENT,
                            capacidad_carga DOUBLE,
                            modelo VARCHAR(100),
                            anio_fabricacion INT,
                            kilometraje DOUBLE,
                            tipo_transporte VARCHAR(15),
                            estado_transporte BOOLEAN
);

CREATE TABLE MANTENIMIENTO (
                               id_mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
                               fecha DATE,
                               descripcion VARCHAR(150),
                               transporte_id INT,
                               FOREIGN KEY (transporte_id) REFERENCES TRANSPORTE(transporte_id)
);

CREATE TABLE RUTA (
                      ruta_id INT PRIMARY KEY AUTO_INCREMENT,
                      descripcion VARCHAR(150),
                      listaParadas VARCHAR(200),
                      tipo_ruta BOOLEAN,
                      direccion_entrega VARCHAR(255)
);

CREATE TABLE ENCOMIENDA (
                            id_encomienda INT PRIMARY KEY AUTO_INCREMENT,
                            id_agencia_origen INT,
                            id_agencia_destino INT,
                            cedula_receptor VARCHAR(10),
                            cedula_emisor VARCHAR(10),
                            fecha_envio DATE,
                            fecha_llegada DATE,
                            tipo_entrega VARCHAR(50),
                            direccion_entrega VARCHAR(200),
                            cod_postal_entrega INT,
                            estado_encomienda VARCHAR(50),
                            FOREIGN KEY (id_agencia_origen) REFERENCES AGENCIA(id_agencia),
                            FOREIGN KEY (id_agencia_destino) REFERENCES AGENCIA(id_agencia),
                            FOREIGN KEY (cedula_receptor) REFERENCES USUARIO(cedula),
                            FOREIGN KEY (cedula_emisor) REFERENCES USUARIO(cedula)
);

CREATE TABLE PAQUETE (
                         id_paquete INT PRIMARY KEY AUTO_INCREMENT,
                         peso FLOAT,
                         volumen FLOAT,
                         isFragil BOOLEAN,
                         id_encomienda INT,
                         FOREIGN KEY (id_encomienda) REFERENCES ENCOMIENDA(id_encomienda)
);

CREATE TABLE FACTURA (
                         id_factura INT PRIMARY KEY AUTO_INCREMENT,
                         fecha_factura DATE,
                         impuestos FLOAT,
                         descuentos FLOAT,
                         total FLOAT,
                         id_encomienda INT,
                         cedula_cliente VARCHAR(10),
                         FOREIGN KEY (id_encomienda) REFERENCES ENCOMIENDA(id_encomienda),
                         FOREIGN KEY (cedula_cliente) REFERENCES USUARIO(cedula)
);

CREATE TABLE AGENCIA_TRANSPORTE (
                                    id_agencia INT,
                                    transporte_id INT,
                                    PRIMARY KEY (id_agencia, transporte_id),
                                    FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia),
                                    FOREIGN KEY (transporte_id) REFERENCES TRANSPORTE(transporte_id)
);

CREATE TABLE AGENCIA_RUTA (
                              agencia_id INT,
                              ruta_id INT,
                              PRIMARY KEY (agencia_id, ruta_id),
                              FOREIGN KEY (agencia_id) REFERENCES AGENCIA(id_agencia),
                              FOREIGN KEY (ruta_id) REFERENCES RUTA(ruta_id)
);

CREATE TABLE Almacen (
                         id_almacen INT PRIMARY KEY AUTO_INCREMENT,
                         limite_superior_caducidad INT,
                         nombre_almacen VARCHAR(100),
                         id_agencia INT,
                         FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia)
);

CREATE TABLE Seccion (
                         id_seccion INT PRIMARY KEY AUTO_INCREMENT,
                         nombre_seccion VARCHAR(100),
                         capacidad INT,
                         id_almacen INT,
                         FOREIGN KEY (id_almacen) REFERENCES Almacen(id_almacen)
);

CREATE TABLE FichaEncomienda (
                                 id_ficha_encomienda INT PRIMARY KEY AUTO_INCREMENT,
                                 fecha_entrada DATE,
                                 fecha_salida DATE,
                                 estado_ficha BOOLEAN,
                                 id_seccion INT,
                                 id_encomienda INT,
                                 FOREIGN KEY (id_seccion) REFERENCES Seccion(id_seccion),
                                 FOREIGN KEY (id_encomienda) REFERENCES ENCOMIENDA(id_encomienda)
);
