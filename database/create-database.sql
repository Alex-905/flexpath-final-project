create database if not exists flexpath_final;
use flexpath_final;

drop table if exists users, roles, resorts, trip_lists, trip_list_resorts;

create table users (
    username varchar(255) primary key,
    password varchar(255)
);

create table roles (
    username varchar(255) not null,
    role varchar(250) not null,
    primary key (username, role),
    foreign key (username) references users(username) on delete cascade
);

create table resorts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username varchar(255),
    location varchar(255),
    base INT,
    vert_drop INT,
    avg_snow INT,
    diff_level varchar(50),
    resort_name varchar(255),
    description varchar(500),
    is_pub boolean,
    foreign key (username) references users(username) on delete cascade 
);

create table trip_lists(
    id INT AUTO_INCREMENT PRIMARY KEY,
    trip_list varchar(255),
    description varchar(500),
    is_pub boolean,
    username varchar(255),
    foreign key (username) references users(username) on delete cascade
);

create table trip_list_resorts (
    trip_list_id INT,
    resort_id INT,
    primary key (trip_list_id, resort_id),
    foreign key (trip_list_id) references trip_lists(id) on delete cascade,
    foreign key (resort_id) references resorts(id) on delete cascade 
);

insert into users (username, password) values ('admin', '$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq');
insert into roles (username, role) values ('admin', 'ADMIN');

insert into users (username, password) values ('user', '$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq');
insert into roles (username, role) values ('user', 'USER');
