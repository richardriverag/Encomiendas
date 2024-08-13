DROP DATABASE encomiendas;

CREATE DATABASE IF NOT EXISTS encomiendas;

USE encomiendas;

CREATE TABLE agencia (
    id_agencia INT PRIMARY KEY AUTO_INCREMENT,
    nombre_agencia VARCHAR(100) NOT NULL,
    ubicacion_agencia VARCHAR(100),
    codigo_postal VARCHAR(10),
    provincia_agencia VARCHAR(100),
    telefono_agencia VARCHAR(15),
    ciudad_agencia VARCHAR(100),
    estado_agencia BOOLEAN
);

CREATE TABLE usuario (
    cedula VARCHAR(10) PRIMARY KEY,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    rol VARCHAR(20),
    direccion VARCHAR(200),
    ciudad VARCHAR(100),
    telefono_adicional VARCHAR(15),
    tipo_licencia CHAR(1),
    activo BOOLEAN,
    id_agencia INT,
    FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia)
);

CREATE TABLE cuenta (
    id_cuenta INT PRIMARY KEY AUTO_INCREMENT,
    cedula VARCHAR(10),
    username VARCHAR(50) NOT NULL,
    contrasenia VARCHAR(50) NOT NULL,
    FOREIGN KEY (cedula) REFERENCES USUARIO(cedula)
);

CREATE TABLE transporte (
    transporte_id INT PRIMARY KEY AUTO_INCREMENT,
    capacidad_carga DOUBLE,
    modelo VARCHAR(100),
    anio_fabricacion INT,
    kilometraje DOUBLE,
    tipo_transporte VARCHAR(15),
    estado_transporte VARCHAR(20)
);

CREATE TABLE mantenimiento (
    id_mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    descripcion VARCHAR(150),
    transporte_id INT,
    FOREIGN KEY (transporte_id) REFERENCES TRANSPORTE(transporte_id)
);

CREATE TABLE ruta (
    ruta_id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(150),
    listaParadas VARCHAR(200),
    tipo_ruta BOOLEAN
);

CREATE TABLE encomienda (
    id_encomienda INT PRIMARY KEY AUTO_INCREMENT,
    id_agencia_origen INT,
    id_agencia_destino INT,
    cedula_receptor VARCHAR(10),
    cedula_emisor VARCHAR(10),
    fecha_envio DATE,
    fecha_llegada DATE,
    tipo_entrega VARCHAR(50),
    direccion_entrega VARCHAR(200),
    cod_postal_entrega VARCHAR(10),
    estado_encomienda VARCHAR(50),
    precio_encomienda FLOAT,
    FOREIGN KEY (id_agencia_origen) REFERENCES AGENCIA(id_agencia),
    FOREIGN KEY (id_agencia_destino) REFERENCES AGENCIA(id_agencia),
    FOREIGN KEY (cedula_receptor) REFERENCES USUARIO(cedula),
    FOREIGN KEY (cedula_emisor) REFERENCES USUARIO(cedula)
);

CREATE TABLE paquete (
    id_paquete INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(75),
    peso FLOAT,
    volumen FLOAT,
    isFragil BOOLEAN,
    precio FLOAT,
    id_encomienda INT,
    FOREIGN KEY (id_encomienda) REFERENCES ENCOMIENDA(id_encomienda)
);

CREATE TABLE factura (
    id_factura VARCHAR(50) PRIMARY KEY,
    fecha DATE,
    impuestos FLOAT,
    descuentos FLOAT,
    total FLOAT,
    id_encomienda INT,
    cedula_cliente VARCHAR(10),
    estado_factura BOOLEAN,
    FOREIGN KEY (id_encomienda) REFERENCES ENCOMIENDA(id_encomienda),
    FOREIGN KEY (cedula_cliente) REFERENCES USUARIO(cedula)
);

CREATE TABLE agencia_transporte (
    id_agencia INT,
    transporte_id INT,
    PRIMARY KEY (id_agencia, transporte_id),
    FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia),
    FOREIGN KEY (transporte_id) REFERENCES TRANSPORTE(transporte_id)
);

CREATE TABLE almacen (
    id_almacen INT PRIMARY KEY AUTO_INCREMENT,
    limite_superior_caducidad INT,
    nombre_almacen VARCHAR(100),
    id_agencia INT,
    FOREIGN KEY (id_agencia) REFERENCES AGENCIA(id_agencia)
);

CREATE TABLE seccion (
    id_seccion INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    capacidad INT,
    id_almacen INT,
    FOREIGN KEY (id_almacen) REFERENCES Almacen(id_almacen)
);

CREATE TABLE ficha_encomienda (
    id_ficha_encomienda INT PRIMARY KEY AUTO_INCREMENT,
    fecha_entrada DATE,
    fecha_salida DATE,
    estado_ficha BOOLEAN,
    id_seccion INT,
    id_encomienda INT,
    FOREIGN KEY (id_seccion) REFERENCES Seccion(id_seccion),
    FOREIGN KEY (id_encomienda) REFERENCES encomienda(id_encomienda)
);

-- INSERCIONES DE DATOS

-- Insertar datos en la tabla AGENCIA
INSERT INTO agencia (nombre_agencia, ubicacion_agencia, codigo_postal, provincia_agencia, telefono_agencia, ciudad_agencia, estado_agencia)
VALUES
('Agencia Centro', 'Calle Central 123', '10001', 'Provincia A', '1234567890', 'Ciudad A', TRUE),
('Agencia Norte', 'Avenida Norte 456', '20002', 'Provincia B', '2345678901', 'Ciudad B', TRUE);

-- Insertar datos en la tabla USUARIO
INSERT INTO usuario (cedula, nombres, apellidos, correo, telefono, rol, direccion, ciudad, telefono_adicional, tipo_licencia, activo, id_agencia)
VALUES
('V12345673', 'Michael', 'Trocellier', 'michael@example.com', '1234567890', 'Administrador', 'Av. Ejemplo 1', 'Ciudad A', '0987654321', 'A', TRUE, 1),
('V12345678', 'Juan', 'Pérez', 'juan.perez@example.com', '1234567890', 'Empleado', 'Av. Ejemplo 1', 'Ciudad A', '0987654321', 'A', TRUE, 1),
('V87654321', 'Ana', 'Gómez', 'ana.gomez@example.com', '2345678901', 'Cliente', 'Av. Ejemplo 2', 'Ciudad B', '0123456789', 'B', TRUE, 2);

-- Insertar datos en la tabla CUENTA
INSERT INTO cuenta (cedula, username, contrasenia)
VALUES
('V12345673', 'micos', 'password123'),
('V12345678', 'juanperez', 'password123'),
('V87654321', 'anagomez', 'password456');



-- Insertar datos en la tabla TRANSPORTE
INSERT INTO transporte (capacidad_carga, modelo, anio_fabricacion, kilometraje, tipo_transporte, estado_transporte)
VALUES
(5000.0, 'Camión A', 2015, 120000.0, 'Camión', 'DISPONIBLE'),
(3000.0, 'Furgoneta B', 2018, 80000.0, ',Moto', 'EN_MANTENIMIENTO');

-- Insertar datos en la tabla MANTENIMIENTO
INSERT INTO mantenimiento (fecha, descripcion, transporte_id)
VALUES
('2024-07-20', 'Cambio de aceite', 1),
('2024-07-21', 'Revisión de frenos', 2);

-- Insertar datos en la tabla RUTA
INSERT INTO ruta (descripcion, listaParadas, tipo_ruta)
VALUES
('Ruta 1', 'Parada 1, Parada 2, Parada 3', TRUE),
('Ruta 2', 'Parada A, Parada B, Parada C', FALSE);

-- Insertar datos en la tabla ENCOMIENDA
INSERT INTO encomienda (id_agencia_origen, id_agencia_destino, cedula_receptor, cedula_emisor, fecha_envio, fecha_llegada, tipo_entrega, direccion_entrega, cod_postal_entrega, estado_encomienda)
VALUES
(1, 2, 'V87654321', 'V12345678', '2024-07-20', '2024-07-22', 'Domicilio', 'Av. Entrega 1', '30001', 'En bodega'),
(2, 1, 'V12345678', 'V87654321', '2024-07-21', '2024-07-23', 'Agencia', NULL, NULL, 'En bodega');

-- Insertar datos en la tabla PAQUETE
INSERT INTO paquete (peso, volumen, isFragil, id_encomienda)
VALUES
(10.5, 0.5, TRUE, 1),
(5.0, 0.3, FALSE, 2);

-- Insertar datos en la tabla FACTURA
INSERT INTO factura (id_factura, fecha, impuestos, descuentos, total, id_encomienda, cedula_cliente, estado_factura)
VALUES
('F001', '2024-07-20', 5.0, 0.0, 50.0, 1, 'V87654321', TRUE),
('F002', '2024-07-21', 7.5, 2.0, 75.0, 2, 'V12345678', TRUE);

-- Insertar datos en la tabla AGENCIA_TRANSPORTE
INSERT INTO agencia_transporte (id_agencia, transporte_id)
VALUES
(1, 1),
(2, 2);

-- Insertar datos en la tabla Almacen
INSERT INTO almacen (limite_superior_caducidad, nombre_almacen, id_agencia)
VALUES
(12, 'Almacén Principal', 1),
(24, 'Almacén Secundario', 2);

-- Insertar datos en la tabla Seccion
INSERT INTO seccion (nombre, capacidad, id_almacen)
VALUES
('Sección A', 100, 1),
('Sección B', 50, 2);

-- Insertar datos en la tabla FichaEncomienda
INSERT INTO ficha_encomienda (fecha_entrada, fecha_salida, estado_ficha, id_seccion, id_encomienda)
VALUES
('2024-07-20', '2024-07-21', TRUE, 1, 1),
('2024-07-21', '2024-07-22', TRUE, 2, 2);


select * from encomiendas.paquete;
