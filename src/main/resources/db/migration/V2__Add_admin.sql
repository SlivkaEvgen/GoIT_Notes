-- default name = admin;
-- default password = super_secret_password
insert into users (id, username, password, active)
values ('a81bc81b-dead-4e5d-abff-90865d1e13b1', 'admin',
        '$2a$10$TOPFQd/3BbFmhGr6Q1j/Suz5ViNOrQB3L3vjBY9cGfErYRuDWUN9m', true);

insert into user_role (user_id, roles)
values ('a81bc81b-dead-4e5d-abff-90865d1e13b1', 'USER'),
       ('a81bc81b-dead-4e5d-abff-90865d1e13b1', 'ADMIN');
