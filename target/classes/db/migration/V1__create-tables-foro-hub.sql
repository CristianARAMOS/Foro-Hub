create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(500) not null,
    fecha_creacion datetime not null,
    status varchar(100) not null,
    curso bigint not null,
    usuario_id bigint not null,

    primary key(id)

);