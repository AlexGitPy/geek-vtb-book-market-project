create table authors (id bigserial primary key, name varchar(255));
insert into authors (name)
values
('Kurt Vonnegut'),
('Dostoevsky'),
('Daniel Defoe');

create table books (id bigserial primary key, title varchar(255), price int, author_id bigint references authors (id));
insert into books (title, price, author_id)
values
('Slaughterhouse-Five', 200, 1),
('Crime and Punishment', 250, 2),
('Robinson Crusoe', 300, 3);