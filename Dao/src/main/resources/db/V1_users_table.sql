create table users (
	username text,
	password text,
	roles text,
	user_profile_id bigint
);
-- password : samsung123
insert into users values('kovan','$2a$10$rBAHxDp0/W6nAB5rNwN1SuA9fXLEd8ZqKaTCXUaf/LWIDxiQihn3a','ROLE_ADMIN');


CREATE TABLE users_profile
(
  id text NOT NULL DEFAULT ((('PMB-'::text || date_part('year'::text, now())) || '-'::text) || nextval('seq_student_registration'::regclass)),
  student_name text,
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
  CONSTRAINT pk_student_registration PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);