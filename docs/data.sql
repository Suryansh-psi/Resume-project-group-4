create table user(user_id int auto_increment primary key, 
username varchar(50) not null,
password varchar(50) not null,
gender enum("male", "female") not null,
dob date not null
);


insert into user(username, password, gender, dob) values("user1", "user", "male", '2008-7-04');
insert into user(username, password, gender, dob) values("user2", "user", "female", '2008-6-04');
insert into user(username, password, gender, dob) values("user3", "user", "male", '2008-5-04');
insert into user(username, password, gender, dob) values("user4", "user", "female", '2008-4-04');
insert into user(username, password, gender, dob) values("user5", "user", "male", '2008-3-04');


create table resume(
	resume_id int auto_increment primary key,
    name varchar(50) not null,
    role json not null,
    total_exp int not null,
    image varchar(200) not null,
    about_me longtext not null,
    about_me_points json,
    skills json not null,
    created_at date not null,
    update_at date,
    status varchar(50),
    reviewer varchar(50),
    user_id int,
    foreign key(user_id) references user (user_id)
);

create table workExp(
	workExp_id int auto_increment primary key,
    client_desc Longtext not null,
    country varchar(50) not null,
    role json not null,
    startDate date not null,
    endDate date not null,
    bussiness_sol longtext,
    tech_stack json not null,
    resume_id int,
    project_resp json not null,
    foreign key(resume_id) references resume (resume_id)
);