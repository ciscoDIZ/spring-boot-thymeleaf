drop table categoria if exists;
drop table producto if exists;
drop table puntuacion if exists;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 100 increment by 1;

create table categoria (
                           id bigint not null,
                           destacada boolean not null,
                           imagen varchar(512),
                           nombre varchar(512),
                           primary key (id)
);

create table producto (
                          id bigint not null,
                          descripcion clob,
                          descuento float not null,
                          imagen varchar(512),
                          nombre varchar(512),
                          pvp float not null,
                          categoria_id bigint,
                          primary key (id)
);

create table puntuacion (
                            id bigint not null,
                            fecha timestamp,
                            puntuacion integer not null,
                            producto_id bigint,
                            primary key (id)
);
create table usuarios (
    id_usuario bigint primary key,
    nombre varchar(100) not null,
    apellidos varchar(200) not null,
    email varchar(100) not null,
    nombre_usuario varchar(250) not null,
    passwd varchar(32) not null,
    image varchar(1000)
);

alter table producto add constraint fk_producto_categoria foreign key (categoria_id) references categoria;
alter table puntuacion add constraint fk_puntuacion_producto foreign key (producto_id) references producto;