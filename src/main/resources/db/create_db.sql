-- drop tables
drop table if exists movieland.movie cascade;
drop table if exists movieland.genre cascade;
drop table if exists movieland.country cascade;
drop table if exists movieland.users cascade;
drop table if exists movieland.review cascade;
drop table if exists movieland.bridge_movie_genre cascade;
drop table if exists movieland.bridge_movie_country cascade;

-- movie
create table if not exists movieland.movie
(
	id serial not null
		constraint movie_pkey
			primary key,
	name text not null,
	original_name text not null,
	issue_date date not null,
	description text not null,
	price numeric(8,2) not null,
	rating numeric(4,2) not null,
	poster_link text,
	unique (name, issue_date, poster_link)
);

alter table movieland.movie owner to ufimjmvmkfcrku;

--genre
create table if not exists movieland.genre
(
  id serial not null
    constraint genre_pkey
      primary key,
  name text not null unique
);

alter table movieland.genre owner to ufimjmvmkfcrku;

-- country
create table if not exists movieland.country
(
  id serial not null
    constraint country_pkey
      primary key,
  name text not null unique
);

alter table movieland.country owner to ufimjmvmkfcrku;

-- users
create table if not exists movieland.users
(
  id serial not null
    constraint users_pkey
      primary key,
  login text not null unique,
  salt text not null,
  password text not null,
  role text not null,
  e_mail text not null unique,
  first_name text,
  last_name text,
  register_date date not null
);

alter table movieland.users owner to ufimjmvmkfcrku;

-- review
create table if not exists movieland.review
(
  id serial not null
    constraint review_pkey
      primary key,
  movie_id integer not null,
  user_id integer not null,
  review_datetime timestamp,
  review_text text not null
);

alter table movieland.review owner to ufimjmvmkfcrku;

-- bridge_movie_genre
create table if not exists movieland.bridge_movie_genre
(
  id serial not null
    constraint bridge_movie_genre_pkey
      primary key,
  movie_id integer not null,
  genre_id integer not null,
  unique(movie_id, genre_id)
);

alter table movieland.bridge_movie_genre owner to ufimjmvmkfcrku;

-- bridge_movie_country
 create table if not exists movieland.bridge_movie_country
 (
    id serial not null
      constraint bridge_movie_country_pkey
        primary key,
  movie_id integer not null,
  country_id integer not null,
  unique(movie_id, country_id)
);

alter table movieland.bridge_movie_country owner to ufimjmvmkfcrku;
