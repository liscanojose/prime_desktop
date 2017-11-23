-- Paso 1.- Consulta Registro de usuario
-- Si la consulta no devuelve registro se procede a ejecutar el paso 2
select u.*
from usuario u
where u.correo = 'andy@prime.com'

-- Paso 2.- 
insert into persona (id,nombre,apellido,cedula,sexo,direccion,telefono,fecha_nacimiento,estatus,fecha_creacion) 
values(nextval('persona_id_seq'),'Andy','Aldana','V12345678','Masculino','Carrera 22 entre calles 12 y 13','(0416)5017020','1970-01-21 16:00:00','Activo','2017-01-21 16:00:00')

insert into usuario (id,correo,contrasenna,pregunta,respuesta,estatus,fecha_creacion)
values(nextval('usuario_id_seq'),'andy@prime.com',md5('123'),'nombre del sistema','prime','Activo','2017-01-21 16:00:00')

-- el idpersona = 1 es si es la primera vez
update usuario set idpersona = (select id from persona where cedula ='V12345678' ) where correo = 'andy@prime.com'

-- para actualizar la contrasenna
update usuario set contrasenna = md5('123') where correo = 'andy@prime.com'

-- en construccion
create or replace function 
validarAndy(correo character varying) RETURNS void AS $$
BEGIN 
	IF NOT EXISTS(select u.* from usuario u where u.correo = $1) THEN
		insert into persona (id,nombre,apellido,cedula,sexo,direccion,telefono,fecha_nacimiento,estatus,fecha_creacion)values(nextval('persona_id_seq'),'Andy','Aldana','V12345678','Masculino','Carrera 22 entre calles 12 y 13','(0416)5017020','1970-01-21 16:00:00','Activo','2017-01-21 16:00:00');

		insert into usuario (id,correo,contrasenna,pregunta,respuesta,estatus,fecha_creacion)values(nextval('usuario_id_seq'),$1,'nombre del sistema','prime','Activo','2017-01-21 16:00:00');
END;
$$ LANGUAGE plpgsql
	
select validarAndy('andy@prime.com')

