create table master(id identity primary key ,name varchar not null , age int not null );
create table planet(id identity primary key not null  , name varchar);
create table master_planet(master_id int references master(id),planet_id int references planet(id) ON DELETE CASCADE);
