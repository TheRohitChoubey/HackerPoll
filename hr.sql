create table hacker(personid number(10) Primary key,username varchar(250),email varchar(250),password varchar(50),location varchar(200),
contest varchar(20),datastructure varchar(2),python varchar(2),cpp varchar(2),
java varchar(2), algorithms varchar(2), votes int);

create table savedip(ipid number(10) Primary key,ip varchar(250));

select * from hacker;
select * from savedip;