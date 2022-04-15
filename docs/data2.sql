create table user(user_id int auto_increment primary key, 
username varchar(50),
password varchar(50),
gender varchar(10),
dob date
);


create table resume(
	resume_id int auto_increment primary key,
    name varchar(50),
    role json,
    total_exp int,
    image blob,
    about_me longtext,
    about_me_points json,
    skills json,
    created_at date,
    update_at date,
    status varchar(50),
    reviewer varchar(50),
    user_id int,
    foreign key(user_id) references user (user_id)
);

create table workExp(
	workExp_id int auto_increment primary key,
    client_desc Longtext,
    country varchar(50),
    projectName varchar(200),
    role json,
    startDate date,
    endDate date,
    bussiness_sol longtext,
    tech_stack json,
    resume_id int,
    project_resp json,
    foreign key(resume_id) references resume (resume_id)
);

create table roleMaster(
                           role_id int auto_increment primary key,
						   role_name varchar(50),
                           role_desc varchar(150),
                           isVisible boolean
                           );
                           
                           
create table techStack(
	techStackId int auto_increment primary key,
    techStackName varchar(30),
    techStackDesc varchar(150),
    isVisible boolean
);   


create table projectMaster(
           project_id int auto_increment primary key,
           project_name varchar(50),
           project_desc varchar(200),
           isVisible boolean
           );                        
          