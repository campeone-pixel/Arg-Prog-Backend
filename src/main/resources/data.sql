
-- Inserción de datos en la tabla Persona
INSERT INTO Persona (nombres, apellido, nacionalidad_es, nacionalidad_en, email, sobre_mi_es, sobre_mi_en, ocupacion_es, ocupacion_en, image_background_header, image_perfil, image_sobre_mi)
VALUES
    ('Juan', 'Perez', 'Español', 'English', 'juan@example.com', 'Sobre mí en español', 'About me in English', 'Programador', 'Developer', 'https://imgur.com/6ArQhzs', 'https://photos.app.goo.gl/4jGbLtp3rbs2dJ9Y7', 'https://imgur.com/BtkuREn');

INSERT INTO Persona (nombres, apellido, nacionalidad_es, nacionalidad_en, email, sobre_mi_es, sobre_mi_en, ocupacion_es, ocupacion_en, image_background_header, image_perfil, image_sobre_mi)
VALUES
    ('Maria', 'Lopez', 'Español', 'English', 'maria@example.com', 'Sobre mí en español', 'About me in English', 'Diseñador', 'Designer', 'https://imgur.com/6ArQhzs', 'https://imgur.com/AxCTNg1', 'https://imgur.com/BtkuREn');

-- Inserción de datos en la tabla Educación
INSERT INTO Educacion (escuela, titulo_es, titulo_en, imagen, carrera_es, carrera_en, inicio, fin)
VALUES
    ('Escuela 1', 'Título 1', 'Title 1', 'https://imgur.com/posxPHb', 'Carrera 1', 'Career 1', '2020-01-01', '2022-12-31');

INSERT INTO Educacion (escuela, titulo_es, titulo_en, imagen, carrera_es, carrera_en, inicio, fin)
VALUES
    ('Escuela 2', 'Título 2', 'Title 2', 'https://imgur.com/a/lYs7LZe', 'Carrera 2', 'Career 2', '2019-01-01', '2021-12-31');

-- Inserción de datos en la tabla Experiencia
INSERT INTO Experiencia (puesto_es, puesto_en, lugar, desde, hasta, empresa, descripcion_es, descripcion_en)
VALUES
    ('Puesto 1', 'Position 1', 'Lugar 1', '2020-01-01', '2022-12-31', 'Empresa 1', 'Descripción 1 en español', 'Description 1 in English');

INSERT INTO Experiencia (puesto_es, puesto_en, lugar, desde, hasta, empresa, descripcion_es, descripcion_en)
VALUES
    ('Puesto 2', 'Position 2', 'Lugar 2', '2019-01-01', '2021-12-31', 'Empresa 2', 'Descripción 2 en español', 'Description 2 in English');

-- Inserción de datos en la tabla Proyecto
INSERT INTO Proyecto (nombre_es, nombre_en, descripcion_es, descripcion_en, link, link_foto)
VALUES
    ('Proyecto 1', 'Project 1', 'Descripción del Proyecto 1 en español', 'Project 1 Description in English', 'enlace1.com', '//imgur.com/a/RaFD11N');

INSERT INTO Proyecto (nombre_es, nombre_en, descripcion_es, descripcion_en, link, link_foto)
VALUES
    ('Proyecto 2', 'Project 2', 'Descripción del Proyecto 2 en español', 'Project 2 Description in English', 'enlace2.com', '//imgur.com/a/RaFD11N');

-- Inserción de datos en la tabla Skill
INSERT INTO Skill (nombre, porcentaje)
VALUES
    ('Habilidad 1', '80');

INSERT INTO Skill (nombre, porcentaje)
VALUES
    ('Habilidad 2', '90');


