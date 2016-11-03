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
	constraint pk_academic_calendar PRIMARY KEY(id)
);

--

create table reg_static_file (
	id bigint not null,
	student_registration_id text,
	name text,
	type text,
	refId bigint,
	reason text,
	CONSTRAINT pk_reg_static_file PRIMARY KEY(id),
	CONSTRAINT fk_student_reg_id FOREIGN KEY (student_registration_id)
	REFERENCES student_registration(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE reg_static_file_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

create table reg_payment (
	id bigint not null,
	student_registration_id text,
	reg_static_file_id bigint,
	reason text,
	amount int,
	type text,
	status text,
	CONSTRAINT pk_reg_payment PRIMARY KEY(id),
	CONSTRAINT fk_student_reg_id FOREIGN KEY (student_registration_id)
	REFERENCES student_registration(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_static_file_id FOREIGN KEY (reg_static_file_id)
	REFERENCES reg_static_file(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE reg_payment_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


create table reg_document (
	id bigint not null,
	student_registration_id text,
	reg_static_file_id bigint,
	reason text,
	type text,
	status text,
	CONSTRAINT pk_reg_document PRIMARY KEY(id),
	CONSTRAINT fk_student_reg_id FOREIGN KEY (student_registration_id)
	REFERENCES student_registration(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_static_file_id FOREIGN KEY (reg_static_file_id)
	REFERENCES reg_static_file(id) MATCH SIMPLE
	ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE SEQUENCE reg_document_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

alter table users
  add column email text;


alter table reg_static_file
add column creation_time timestamp without time zone DEFAULT now(),
add column last_update_time timestamp without time zone DEFAULT now();

alter table reg_document
add column creation_time timestamp without time zone DEFAULT now(),
add column last_update_time timestamp without time zone DEFAULT now();

alter table reg_payment
add column creation_time timestamp without time zone DEFAULT now(),
add column last_update_time timestamp without time zone DEFAULT now();


CREATE TABLE reg_exam_schedule
(
  id bigint,
  exam_name text NOT NULL,
  exam_strata_id text NOT NULL,
  exam_date timestamp without time zone NOT NULL,
  CONSTRAINT pk_reg_exam_schedule PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);


CREATE SEQUENCE reg_exam_schedule_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 100;

create table reg_exam_result (
	student_registration_id text,
	status text,
	creation_time timestamp without time zone DEFAULT now(),
	last_update_time timestamp without time zone DEFAULT now(),
	CONSTRAINT pk_reg_exam_result PRIMARY KEY (student_registration_id)
  );
