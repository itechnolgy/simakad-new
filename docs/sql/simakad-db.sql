-- create database
-- create database simakad;
-- master table identity_card

create sequence seq_identity_card
start 100
increment 1;

create table if not exists identity_card (
	identity_id text not null default 'ID-'||(nextval('seq_identity_card')),
	identity_type text not null,
	creation_time timestamp with time zone default (now()),
	last_update_time timestamp with time zone default (now()),
	constraint pk_identity_card primary key (identity_id)
);
alter table identity_card owner to sttj;

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
	id text default 'PMB-'||date_part('year', now())||'-'||(nextval('seq_student_registration')),
	student_name text,
	gender text,
	place_birth text not null,
	date_birth timestamp without time zone not null,
	address text,
	city text,
	province text,
	identity_card_number text,
	identity_card_type text,
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_student_registration primary key (id)
);
alter table student_registration owner to sttj;

insert into student_registration values (DEFAULT,  'vikraa', 'm', 'jakarta', now(), 'jkt', 'bsd', 'banten', '123', 'ktp');
insert into student_registration values (DEFAULT, 'test','m','jakarta',now(),'jkt','bsd','banten','123','ktp');

-- table student eligible
create sequence seq_student_eligible
start 100000001
increment 1;


create table if not exists student (
	id text default 'M'||(nextval('seq_student_eligible')),
	registration_id text not null,
	student_name text,
	gender text,
	address text,
	city text,
	province text,
	active boolean,
	creation_time timestamp without time zone default(now()),
	last_update_time timestamp without time zone default(now()),
	constraint pk_student primary key (id),
	constraint fk_student_registration foreign key (registration_id) references student_registration (id) on delete cascade
);
alter table student owner to sttj;

-- table lecture
create sequence seq_lecture
start 2000001
increment 1;

create table if not exists lecture (
	id bigint default(nextval('seq_lecture')),
	lecture_name text,
	gender text,
	address text,
	city text,
	province text,
	active boolean,
	creation_time timestamp without time zone default(now()),
	last_update_time timestamp without time zone default(now()),
	constraint pk_lecture primary key (id)
);
alter table lecture owner to sttj;

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
alter table study_program owner to sttj;

insert into study_program values (DEFAULT,'Strata 1 (S1)','');
insert into study_program values (DEFAULT,'Strata 2 (S2)','');
insert into study_program values (DEFAULT,'Strata 3 (S3)','');


-- table course
create table if not exists course (
	course_id text not null,
	study_program_id bigint not null,
	course_name text not null,
	course_description text,
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_course primary key (course_id),
	constraint fk_course foreign key (study_program_id) references study_program(id) on delete cascade
);
alter table course owner to sttj;

-- table roles
create sequence seq_roles
start 201
increment 1;

create table if not exists roles (
	id bigint not null default nextval('seq_roles'),
	roles_name text,
	roles_description text,
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_roles primary key (id)
);
alter table roles owner to sttj;


-- table login
create table if not exists login (
	id TEXT NOT NULL,
	role_id bigint,
	username TEXT NOT NULL,
	password VARCHAR(20),
	category TEXT NOT NULL,
	year_date TEXT DEFAULT date_part('year', now()),
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_login primary key (id),
	constraint fk_login foreign key (role_id) references roles(id) on delete cascade
);
alter table login owner to sttj;

-- table staticfile student
create sequence seq_staticfile_student
start 10001
increment 1;

create table if not exists staticfile_student (
	id bigint not null default nextval('seq_staticfile_student'),
	path text not null,
	user_id text not null,
	file_type text,
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_staticfile_student primary key (id),
	constraint fk_staticfile_student foreign key (user_id) references login(id) on delete cascade
);
alter table staticfile_student owner to sttj;

-- table staticfile admin

create sequence seq_staticfile_admin
start 20001
increment 1;

create table if not exists staticfile_admin (
	id bigint not null default nextval('seq_staticfile_admin'),
	path text not null,
	user_id text not null,
	file_type text,
	creation_time timestamp without time zone default (now()),
	last_update_time timestamp without time zone default (now()),
	constraint pk_staticfile_admin primary key (id),
	constraint fk_staticfile_admin foreign key (user_id) references login(id) on delete cascade
);
alter table staticfile_admin owner to sttj;

-- table payment
create sequence seq_payment
start 10001
increment 1;

create table if not exists payment_registration (
	id bigint not null default nextval('seq_payment'),
	user_id text not null,
	year_date text default date_part('year', now()),
	payment_status integer default 0
);
alter table payment_registration owner to sttj;

/* payment status
0 = default 
1 = accepted
2 = rejected
*/

-- table exam
create table if not exists exam_registration_result (
	registration_id text not null,
	year_date text default date_part('year', now()),
	exam_status integer,
	constraint pk_exam_registration_result primary key (registration_id),
	constraint fk_exam_registration_result foreign key (registration_id) references student_registration(id) on delete cascade
);
alter table exam_registration_result owner to sttj;


-- table payment registration list
create table if not exists payment_registration_list (
	id integer not null,
	payment_name text not null,
	payment_year text,
	study_program_id bigint not null,
	amount numeric not null default 0,
	active_status boolean default false,
	creation_time timestamp without time zone default now(),
	last_update_time timestamp without time zone default now(),
	constraint pk_payment_registration_list primary key (id),
	constraint fk_payment_registration_list foreign key (study_program_id) references study_program(id)
);