insert into users(id, join_date, name, password, ssn) values(90001, now(), 'User11', 'tesst11', '111111-1111111');
insert into users(id, join_date, name, password, ssn) values(90002, now(), 'User12', 'tesst12', '211111-1111111');
insert into users(id, join_date, name, password, ssn) values(90003, now(), 'User13', 'tesst13', '311111-1111111');

insert into post(description, user_id) values('My first post', 90001);
insert into post(description, user_id) values('My Second post', 90001);