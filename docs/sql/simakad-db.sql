-- create database
-- create database simakad;

-- master table identity_card
create sequence seq_identity_card
	start 1001
	increment 1;

create table if not exists identity_card (
	identity_id integer not null default (nextval('seq_identity_card')),
	identity_type text not null,
	creation_time timestamp with time zone default (now()),
	last_update_time timestamp with time zone default (now()),
	constraint pk_identity_card primary key (identity_id)
);
	
insert into identity_card values (DEFAULT, 'KTP');
insert into identity_card values (DEFAULT, 'SIM');
insert into identity_card values (DEFAULT, 'KITAS');
insert into identity_card values (DEFAULT, 'Passport');
insert into identity_card values (DEFAULT, 'Lain-lain');

-- table student registration
create sequence seq_student_registration
 start 1000001
 increment 1;

create table if not exists student_registration (
	id bigint default (nextval('seq_student_registration')),
	student_name text,
	gender text,
	address text,
	city text,
	province text,
	identity_card_number text,
	identity_card_type text,
	creation_time timestamp with time zone default (now()),
	last_update_time timestamp with time zone default (now()),
	constraint pk_student_registration primary key (id) 
);

insert into student_registration values (DEFAULT, 'test','m','jkt','bsd','banten','123','ktp');
insert into student_registration values (DEFAULT, 'test','m','jkt','bsd','banten','123','ktp');

-- table student eligible
create sequence seq_student_eligible
start 1000001
increment 1;

create table if not exists student (
	id bigint default (nextval('seq_student_eligible')),
	registration_id bigint not null,
	student_name text,
	gender text,
	address text, 
	city text,
	province text,
	active boolean,
	creation_time timestamp with time zone default(now()),
	last_update_time timestamp with time zone default(now()),
	constraint pk_student primary key (id),
	constraint fk_student_registration foreign key (registration_id) references student_registration (id) on delete cascade
);

-- table lecture
create sequence seq_lecture
start 1000001
increment 1;

create table if not exists lecture (
	id bigint default(nextval('seq_lecture')),
	lecture_name text,
	gender text,
	address text,
	city text,
	province text,
	active boolean,
	creation_time timestamp with time zone default(now()),
	last_update_time timestamp with time zone default(now()),
	constraint pk_lecture primary key (id)
);

-- table study program
create sequence seq_study_program
start 101
increment 1;

create table if not exists study_program (
	id bigint default(nextval('seq_study_program')),
	program_name text not null,
	description text,
	constraint pk_study_program primary key(id)
);

insert into study_program values (DEFAULT,'Strata 1 (S1)','');
insert into study_program values (DEFAULT,'Strata 2 (S2)','');
insert into study_program values (DEFAULT,'Strata 3 (S3)','');


-- table course
create table if not exists course (
	course_id text not null,
	study_program_id bigint not null,
	course_name text not null,
	course_description text,
	constraint pk_course primary key (course_id),
	constraint fk_course foreign key (study_program_id) references study_program(id) on delete cascade
);
