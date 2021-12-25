create sequence hibernate_sequence start 1 increment 1;

CREATE TABLE notes (
                       id uuid not null,
                       access_type varchar(255),
                       message varchar(10000),
                       name varchar(255), user_id uuid, primary key (id)
);
create table user_role (
                           user_id uuid not null,
                           roles varchar(255)
);
create table users (
                       id uuid not null,
                       active boolean not null,
                       password varchar(255),
                       username varchar(255), primary key (id)
);
alter table if exists notes
    add constraint note_user_fk
        foreign key (user_id) references users ON DELETE CASCADE;
alter table if exists user_role
    add constraint role_user_fk
        foreign key (user_id) references users ON DELETE CASCADE;