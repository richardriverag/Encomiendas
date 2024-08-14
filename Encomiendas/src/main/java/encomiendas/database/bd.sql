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
    fotoPerfil LONGBLOB,
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
    numeroSecciones INT,
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

select * from usuario;

-- Tabla: agencia
INSERT INTO agencia (nombre_agencia, ubicacion_agencia, codigo_postal, provincia_agencia, telefono_agencia, ciudad_agencia, estado_agencia) VALUES
('Agencia Quito Central', 'Av. Amazonas N23-45', '170102', 'Pichincha', '022345678', 'Quito', TRUE),
('Agencia Guayaquil Norte', 'Av. Francisco de Orellana', '090101', 'Guayas', '042345678', 'Guayaquil', TRUE),
('Agencia Cuenca', 'Av. Solano 1-23', '010150', 'Azuay', '072345678', 'Cuenca', TRUE),
('Agencia Manta', 'Av. Malecón', '130802', 'Manabí', '052345678', 'Manta', TRUE),
('Agencia Loja', 'Av. Universitaria', '110101', 'Loja', '072245678', 'Loja', TRUE),
('Agencia Ambato', 'Av. Cevallos', '180101', 'Tungurahua', '032345678', 'Ambato', TRUE),
('Agencia Santo Domingo', 'Av. Quito', '230103', 'Santo Domingo', '022545678', 'Santo Domingo', TRUE),
('Agencia Riobamba', 'Av. Daniel León', '060150', 'Chimborazo', '032545678', 'Riobamba', TRUE),
('Agencia Esmeraldas', 'Av. Simón Bolívar', '080150', 'Esmeraldas', '062345678', 'Esmeraldas', TRUE),
('Agencia Machala', 'Av. 25 de Junio', '070150', 'El Oro', '072345678', 'Machala', TRUE);

-- Tabla: usuario
INSERT INTO usuario (cedula, nombres, apellidos, correo, telefono, rol, direccion, ciudad, telefono_adicional, tipo_licencia, activo, id_agencia, fotoPerfil) VALUES
('1112131415', 'Luis', 'Torres', 'luis.torres@example.com', '0992233445', 'Empleado', 'Av. República 456', 'Quito', NULL, 'B', TRUE, 1, NULL),
('1213141516', 'Andrea', 'Pacheco', 'andrea.pacheco@example.com', '0993344556', 'Empleado', 'Calle Alborada', 'Guayaquil', '0987744556', 'C', TRUE, 2, NULL),
('1314151617', 'Fernando', 'Castro', 'fernando.castro@example.com', '0994455667', 'Empleado', 'Av. Remigio Crespo', 'Cuenca', NULL, 'D', TRUE, 3, NULL),
('0102030405', 'Juan', 'Pérez', 'juan.perez@example.com', '0991234567', 'Administrador', 'Calle Falsa 123', 'Quito', '0987654321', 'B', TRUE, 1, NULL),
('0203040506', 'María', 'Gómez', 'maria.gomez@example.com', '0992345678', 'Cliente', 'Calle 1 de Mayo', 'Guayaquil', NULL, 'C', TRUE, 2, NULL),
('0304050607', 'Carlos', 'Rodríguez', 'carlos.rodriguez@example.com', '0993456789', 'Conductor', 'Calle Sucre', 'Cuenca', NULL, 'D', TRUE, 3, NULL),
('0405060708', 'Ana', 'Martínez', 'ana.martinez@example.com', '0994567890', 'Cliente', 'Calle Amazonas', 'Manta', NULL, NULL, TRUE, 4, NULL),
('0506070809', 'Pedro', 'Lopez', 'pedro.lopez@example.com', '0995678901', 'Administrador', 'Calle 10 de Agosto', 'Loja', '0987654322', 'E', TRUE, 5, NULL),
('0607080910', 'Lucía', 'Ramírez', 'lucia.ramirez@example.com', '0996789012', 'Cliente', 'Calle Bolívar', 'Ambato', NULL, 'B', TRUE, 6, NULL),
('0708091011', 'Miguel', 'García', 'miguel.garcia@example.com', '0997890123', 'Conductor', 'Calle Rocafuerte', 'Santo Domingo', NULL, 'C', TRUE, 7, NULL),
('0809101112', 'Sara', 'Morales', 'sara.morales@example.com', '0998901234', 'Cliente', 'Calle Colon', 'Riobamba', '0987654323', 'D', TRUE, 8, NULL),
('0910111213', 'José', 'Vargas', 'jose.vargas@example.com', '0999012345', 'Administrador', 'Calle Espejo', 'Esmeraldas', NULL, 'E', TRUE, 9, NULL),
('1011121314', 'Elena', 'Sánchez', 'elena.sanchez@example.com', '0990123456', 'Cliente', 'Calle Loja', 'Machala', NULL, 'B', TRUE, 10, NULL);

select * from usuario;

-- Tabla: cuenta
INSERT INTO cuenta (cedula, username, contrasenia) VALUES
('1112131415', 'ltorres', 'password123'),
('1213141516', 'apacheco', 'password123'),
('1314151617', 'fcastro', 'password123'),
('0102030405', 'juanp', 'pass1234'),
('0203040506', 'mariag', 'pass2345'),
('0304050607', 'carlosr', 'pass3456'),
('0405060708', 'anam', 'pass4567'),
('0506070809', 'pedrol', 'pass5678'),
('0607080910', 'luciar', 'pass6789'),
('0708091011', 'miguelg', 'pass7890'),
('0809101112', 'saram', 'pass8901'),
('0910111213', 'josev', 'pass9012'),
('1011121314', 'elenas', 'pass0123');

-- Tabla: transporte
INSERT INTO transporte (capacidad_carga, modelo, anio_fabricacion, kilometraje, tipo_transporte, estado_transporte) VALUES
(10.5, 'Toyota Hilux', 2018, 50000, 'Pesado', 'DISPONIBLE'),
(15.0, 'Hyundai H1', 2017, 60000, 'Pesado', 'DISPONIBLE'),
(20.0, 'Nissan Frontier', 2019, 40000, 'Pesado', 'DISPONIBLE'),
(25.0, 'Chevrolet D-Max', 2020, 30000, 'Pesado', 'DISPONIBLE'),
(12.0, 'Kia K2700', 2018, 70000, 'Pesado', 'DISPONIBLE'),
(18.0, 'Mitsubishi L200', 2019, 35000, 'Pesado', 'DISPONIBLE'),
(22.5, 'Ford F-150', 2020, 45000, 'Pesado', 'DISPONIBLE'),
(16.0, 'Mazda BT-50', 2021, 20000, 'Pesado', 'DISPONIBLE'),
(19.5, 'Isuzu D-Max', 2018, 80000, 'Pesado', 'DISPONIBLE'),
(21.0, 'Toyota Tacoma', 2022, 10000, 'Pesado', 'DISPONIBLE');

select * from transporte;

-- Tabla: mantenimiento
INSERT INTO mantenimiento (fecha, descripcion, transporte_id) VALUES
('2024-01-15', 'Cambio de aceite y filtros', 1),
('2024-02-20', 'Revisión de frenos', 2),
('2024-03-10', 'Cambio de neumáticos', 3),
('2024-04-05', 'Reparación de motor', 4),
('2024-05-12', 'Cambio de luces', 5),
('2024-06-18', 'Revisión general', 6),
('2024-07-25', 'Cambio de batería', 7),
('2024-08-30', 'Revisión de suspensión', 8),
('2024-09-15', 'Revisión de transmisión', 9),
('2024-10-10', 'Alineación y balanceo', 10);

-- Tabla: ruta
INSERT INTO ruta (descripcion, listaParadas, tipo_ruta) VALUES
('Ruta Quito-Guayaquil', 'Quito-Ambato-Riobamba-Guayaquil', TRUE),
('Ruta Cuenca-Loja', 'Cuenca-Saraguro-Loja', TRUE),
('Ruta Manta-Portoviejo', 'Manta-Jipijapa-Portoviejo', TRUE),
('Ruta Quito-Ibarra', 'Quito-Cayambe-Ibarra', FALSE),
('Ruta Machala-Loja', 'Machala-Huaquillas-Loja', TRUE),
('Ruta Guayaquil-Cuenca', 'Guayaquil-Azogues-Cuenca', FALSE),
('Ruta Quito-Santo Domingo', 'Quito-Los Bancos-Santo Domingo', TRUE),
('Ruta Ambato-Baños', 'Ambato-Pelileo-Baños', FALSE),
('Ruta Esmeraldas-Atacames', 'Esmeraldas-Muisne-Atacames', FALSE),
('Ruta Riobamba-Macas', 'Riobamba-Cañar-Macas', TRUE);

-- Tabla: encomienda
INSERT INTO encomienda (id_agencia_origen, id_agencia_destino, cedula_receptor, cedula_emisor, fecha_envio, fecha_llegada, tipo_entrega, direccion_entrega, cod_postal_entrega, estado_encomienda, precio_encomienda) VALUES
(1, 2, '0203040506', '0102030405', '2024-01-01', '2024-01-03', 'Domicilio', 'Calle 1 de Mayo, Guayaquil', '090101', 'En bodega origen', 15.50),
(3, 4, '0304050607', '0405060708', '2024-02-01', '2024-02-03', 'Oficina', 'Calle Amazonas, Manta', '130802', 'En bodega origen', 20.00),
(5, 6, '0506070809', '0607080910', '2024-03-01', '2024-03-03', 'Domicilio', 'Calle Bolívar, Ambato', '180101', 'En bodega origen', 18.75),
(7, 8, '0708091011', '0809101112', '2024-04-01', '2024-04-03', 'Oficina', 'Calle Colon, Riobamba', '060150', 'En bodega origen', 25.00),
(9, 10, '0910111213', '1011121314', '2024-05-01', '2024-05-03', 'Domicilio', 'Calle Loja, Machala', '070150', 'En bodega origen', 12.50),
(2, 3, '0203040506', '0304050607', '2024-06-01', '2024-06-03', 'Oficina', 'Calle Sucre, Cuenca', '010150', 'En bodega origen', 22.00),
(4, 5, '0405060708', '0506070809', '2024-07-01', '2024-07-03', 'Domicilio', 'Calle 10 de Agosto, Loja', '110101', 'En bodega origen', 19.50),
(6, 7, '0607080910', '0708091011', '2024-08-01', '2024-08-03', 'Oficina', 'Calle Rocafuerte, Santo Domingo', '230103', 'En bodega origen', 24.25),
(8, 9, '0809101112', '0910111213', '2024-09-01', '2024-09-03', 'Domicilio', 'Calle Espejo, Esmeraldas', '080150', 'En bodega origen', 13.75),
(10, 1, '1011121314', '0102030405', '2024-10-01', '2024-10-03', 'Oficina', 'Calle Falsa 123, Quito', '170102', 'En bodega origen', 16.00);


-- Tabla: paquete
INSERT INTO paquete (descripcion, peso, volumen, isFragil, precio, id_encomienda) VALUES
('Paquete pequeño', 1.2, 0.01, FALSE, 5.00, 1),
('Caja mediana', 3.5, 0.03, TRUE, 12.00, 2),
('Sobre documentos', 0.5, 0.001, FALSE, 2.50, 3),
('Equipos electrónicos', 10.0, 0.1, TRUE, 25.00, 4),
('Ropa y textiles', 4.0, 0.04, FALSE, 8.00, 5),
('Libros y revistas', 2.0, 0.02, FALSE, 6.00, 6),
('Juguetes', 5.0, 0.05, TRUE, 10.00, 7),
('Artículos de hogar', 8.0, 0.08, TRUE, 20.00, 8),
('Material de oficina', 1.5, 0.015, FALSE, 4.00, 9),
('Herramientas', 7.0, 0.07, FALSE, 15.00, 10);

-- Tabla: factura
INSERT INTO factura (id_factura, fecha, impuestos, descuentos, total, id_encomienda, cedula_cliente, estado_factura) VALUES
('F-001', '2024-01-04', 2.50, 1.00, 17.00, 1, '0203040506', TRUE),
('F-002', '2024-02-04', 3.00, 0.50, 22.50, 2, '0304050607', TRUE),
('F-003', '2024-03-04', 2.75, 0.75, 20.00, 3, '0607080910', TRUE),
('F-004', '2024-04-04', 3.50, 0.00, 25.00, 4, '0708091011', TRUE),
('F-005', '2024-05-04', 2.25, 0.75, 14.00, 5, '1011121314', TRUE),
('F-006', '2024-06-04', 3.25, 1.25, 24.00, 6, '0203040506', TRUE),
('F-007', '2024-07-04', 3.00, 0.50, 22.00, 7, '0506070809', TRUE),
('F-008', '2024-08-04', 3.75, 1.00, 27.00, 8, '0809101112', TRUE),
('F-009', '2024-09-04', 2.50, 0.50, 15.75, 9, '0910111213', TRUE),
('F-010', '2024-10-04', 2.00, 0.00, 18.00, 10, '0102030405', TRUE);

-- Tabla: agencia_transporte
INSERT INTO agencia_transporte (id_agencia, transporte_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Tabla: almacen
INSERT INTO almacen (limite_superior_caducidad, nombre_almacen, id_agencia,numeroSecciones)
VALUES
(12, 'Almacén Principal', 1, 1),
(24, 'Almacén Secundario', 2, 1);

INSERT INTO seccion (nombre, capacidad, id_almacen)
VALUES
('Sección A', 100, 1),
('Sección B', 50, 2);

-- Tabla: ficha_encomienda
INSERT INTO ficha_encomienda (fecha_entrada, fecha_salida, estado_ficha, id_seccion, id_encomienda)
VALUES
('2024-07-20', '2024-07-21', TRUE, 1, 1),
('2024-07-21', '2024-07-22', TRUE, 2, 2);