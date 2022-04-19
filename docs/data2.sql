create table user(
	user_id int auto_increment primary key, 
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


create table skillMaster(
              skillId int auto_increment primary key,
              skill varchar(30),
              category varchar(50),
              isVisible boolean
              );   
              
              
              
create table membership(
               membershipId int auto_increment primary key,
               membership_no int,
               membership_type varchar(20),
               membership_since Date,
               expiry_date Date,
               resume_id int,
               foreign key(resume_id) references resume (resume_id)
               );
                     
                     
create table achievement(
              achievementId int auto_increment primary key,
              achievement_name varchar(50),
              achievement_desc varchar(150),
              resume_id int,
              foreign key(resume_id) references resume (resume_id)
              );
                                      
create table education (
	educationId int auto_increment primary key,
    educationName varchar(50),
    educationType varchar(50),
    educationLocation varchar(150),
    startDate date,
    endDate date,
    percentage int,
    resume_id int,
    foreign key(resume_id) references resume (resume_id)
);