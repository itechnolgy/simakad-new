create table degree (
	id integer not null,
	degree_name text,
	constraint pk_degree PRIMARY KEY(id)
);

CREATE SEQUENCE degree_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


create table period (
	academic_year text not null,
	start_date date,
	end_date date,
	constraint pk_period PRIMARY KEY(academic_year)
);


create table academic_calendar_param (
	id integer,
	param text,
	constraint pk_academic_calendar_param PRIMARY KEY(id)
);

create table academic_calendar (
	id bigint,
	period_year text,
	academic_type text,
	degree_id integer,
	start_end date,
	end_date date,
	constraint pk_academic_calendar PRIMARY KEY(id),
	constraint pk_period_year FOREIGN KEY (period_year)
	REFERENCES period(academic_year),
	constraint pk_degree_id FOREIGN KEY (degree_id)
	REFERENCES degree(id)
);

CREATE SEQUENCE academic_calendar_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 100;

CREATE TABLE staticfile_student_registration
(
  id bigint NOT NULL DEFAULT nextval('seq_staticfile_student'::regclass),
  filename text NOT NULL,
  username text NOT NULL,
  file_type text,
  creation_time timestamp without time zone DEFAULT now(),
  last_update_time timestamp without time zone DEFAULT now(),
  CONSTRAINT pk_staticfile_student PRIMARY KEY (id),
  CONSTRAINT fk_staticfile_student FOREIGN KEY (username)
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
)
WITH (
  OIDS=FALSE
);