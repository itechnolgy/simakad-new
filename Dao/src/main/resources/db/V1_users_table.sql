drop table users;

create table users (
	username text,
	password text,
	roles text,
	user_profile_id bigint,
	constraint pk_users PRIMARY KEY (username)
);

drop table users_profile;

CREATE TABLE users_profile
(
  id bigint,
  name text,
  gender text,
  email text,
  place_birth text NOT NULL,
  date_birth timestamp without time zone NOT NULL,
  address text,
  city text,
  province text,
  identity_card_number text,
  identity_card_type text,
  phone text,
  creation_time timestamp without time zone DEFAULT now(),
  last_update_time timestamp without time zone DEFAULT now(),
  CONSTRAINT pk_users_profile PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

CREATE SEQUENCE user_id_seq
  INCREMENT 1
  MINVALUE 1000
  MAXVALUE 9223372036854775807
  START 1000
  CACHE 1000;

drop table student_registration cascade;

create table student_registration (
	id text NOT NULL DEFAULT ((('PMB-'::text || date_part('year'::text, now())) || '-'::text) || nextval('seq_student_registration'::regclass)),
	status text,
	degree_id bigint,
	constraint pk_student_registration primary key (id)
);



 