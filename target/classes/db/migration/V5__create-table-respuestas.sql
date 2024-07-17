create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    topico varchar(500) not null,
    fecha_creacion datetime not null,
    usuario bigint not null,

    primary key(id)

);