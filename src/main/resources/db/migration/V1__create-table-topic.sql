create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(500) not null,
    fechaCreacion date not null,
    status varchar(100) not null,
    autor bigint not null,
    curso bigint not null,

    primary key(id)
);