create table member
(
 id bigint generated by default as identity,
 name varchar(255),
 pw varchar(10),
 comment varchar(255)
 primary key (id)
);
