create database DBKNK;
use DBKNK;


drop database DBKNK;


create table Studenti (
Stud_ID varchar(20),
Emri varchar(50) not null,
Mbiemri varchar(50) not null,
Fakulteti varchar(100) not null,
Departamenti varchar(100) not null,
VitiLindjes varchar(50) not null,
VendiLindjes varchar(50) not null,
MbaroiStudimet varchar(50),
VitiRegjistrimit varchar(50) not null,
Titulli varchar(70) not null default 'Student',
primary key (Stud_ID));


create table Lendet (
Lenda varchar(50) not null,
ECTS int not null,
Profesori varchar(50) not null,
primary key(Lenda));

create table Profesori (
Profesori varchar(50),
Prof_Password varchar(50) not null,
primary key (Profesori));


create table Login (
Stud_ID varchar(50),
Stud_Password varchar(50) not null,
foreign key (Stud_ID) references Studenti(Stud_ID),
primary key(Stud_ID));


create table Notat (
Stud_ID varchar(50) not null,
Lenda varchar(50) not null,
ECTS int not null,
Profesori varchar(50) not null,
Nota int not null,
foreign key (Stud_ID) references Studenti(Stud_ID),
foreign key (Profesori) references Profesori(Profesori));


insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Arkitektura e Kompjutereve', '6', 'Valon Raca');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Algoritmet dhe Struktura e Te Dhenave', '5', 'Kadri Sylejmani');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Baza e te dhenave', '7', 'Lule Ahmedi');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Gjuhe Programuese', '5', 'Avni Rexhepi');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Interneti', '7', 'Lule Ahmedi');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Komunikimi Njeri Kompjuter', '7', 'Isak Shabani');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Programimi i orientuar ne objekte', '7', 'Isak Shabani');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Qarqe Digjitale', '5', 'Artan Mazrekaj');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Siguria e te dhenave', '6', 'Blerim Rexha');
insert into `dbknk`.`Lendet` (`Lenda`, `ECTS`, `Profesori`) values
('Shkathtesi komunikuese', '5', 'Blerim Rexha');


insert into `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) values
('Isak Shabani', 'root');
insert into `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) values
('Artan Mazrekaj', 'root');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES
('Avni Rexhepi', 'root');
insert into `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) values
('Blerim Rexha', 'root');
INSERT INTO `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) VALUES
('Kadri Sylejmani', 'root');
insert into `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) values
('Lule Ahmedi', 'root');
insert into `dbknk`.`Profesori` (`Profesori`, `Prof_Password`) values
('Valon Raca', 'root');


insert into `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) values
('190714100043', 'Erona', 'Muja', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '16-03-2001', 'Drenas', '2020', '01-10-2017', 'Bachelor i Inxhinierise Kompjuterike');
insert into `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) values
('190714100082', 'Njomza', 'Ismaili', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '16-04-2001', 'Kamenice', '2020', '01-10-2017', 'Bachelor i Inxhinierise Kompjuterike');
insert into `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) values
('190714100080', 'Nazife', 'Beqiri', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '28-09-2001', 'Skenderaj', '2020', '01-10-2017', 'Bachelor i Inxhinierise Kompjuterike');
insert into `dbknk`.`Studenti` (`Stud_ID`, `Emri`, `Mbiemri`, `Fakulteti`, `Departamenti`, `VitiLindjes`, `VendiLindjes`, `MbaroiStudimet`, `VitiRegjistrimit`, `Titulli`) values
('190714100109', 'Valdete', 'Salihi', 'Fakulteti i Inxhinierise Elektrike Dhe Kompjuterike', 'Inxhinieri Kompjuterike', '24-02-2001', 'Gjilan', '', '01-10-2018', 'Student');


insert into `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) values
('190714100043', 'root');
insert into `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) values
('190714100082', 'root');
insert into `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) values
('190714100080', 'root');
insert into `dbknk`.`Login` (`Stud_ID`, `Stud_Password`) values
('190714100109', 'root');


insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Arkitektura e Kompjutereve', '6', 'Valon Raca', '6');
insert into `dbknk`.`Notat`(`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Algoritmet dhe Struktura e Te Dhenave', '5', 'Kadri Sylejmani', '9');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Baza e te dhenave', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Interneti', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '7');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Programimi i orientuar ne objekte', '7', 'Isak Shabani', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Qarqe Digjitale', '5', 'Artan Mazrekaj', '10');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Siguria e te dhenave', '6', 'Blerim Rexha', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100043', 'Shkathtesi komunikuese', '5', 'Blerim Rexha', '10');


insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Arkitektura e Kompjutereve', '6', 'Valon Raca', '6');
insert into `dbknk`.`Notat`(`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Algoritmet dhe Struktura e Te Dhenave', '5', 'Kadri Sylejmani', '9');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Baza e te dhenave', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Interneti', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '7');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Programimi i orientuar ne objekte', '7', 'Isak Shabani', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Qarqe Digjitale', '5', 'Artan Mazrekaj', '10');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Siguria e te dhenave', '6', 'Blerim Rexha', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100082', 'Shkathtesi komunikuese', '5', 'Blerim Rexha', '10');


insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Arkitektura e Kompjutereve', '6', 'Valon Raca', '6');
insert into `dbknk`.`Notat`(`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Algoritmet dhe Struktura e Te Dhenave', '5', 'Kadri Sylejmani', '9');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Baza e te dhenave', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Interneti', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '7');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Programimi i orientuar ne objekte', '7', 'Isak Shabani', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Qarqe Digjitale', '5', 'Artan Mazrekaj', '10');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Siguria e te dhenave', '6', 'Blerim Rexha', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100080', 'Shkathtesi komunikuese', '5', 'Blerim Rexha', '10');


insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Arkitektura e Kompjutereve', '6', 'Valon Raca', '6');
insert into `dbknk`.`Notat`(`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Algoritmet dhe Struktura e Te Dhenave', '5', 'Kadri Sylejmani', '9');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Baza e te dhenave', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Gjuhe Programuese', '5', 'Avni Rexhepi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Interneti', '7', 'Lule Ahmedi', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Komunikimi Njeri Kompjuter', '7', 'Isak Shabani', '7');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Programimi i orientuar ne objekte', '7', 'Isak Shabani', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Qarqe Digjitale', '5', 'Artan Mazrekaj', '10');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Siguria e te dhenave', '6', 'Blerim Rexha', '8');
insert into `dbknk`.`Notat` (`Stud_ID`, `Lenda`, `ECTS`, `Profesori`, `Nota`) values
('190714100109', 'Shkathtesi komunikuese', '5', 'Blerim Rexha', '10');



Select * from Notat;

Select * from Studenti where Stud_ID = "190714100109";

Select * from Notat where Lenda = "Komunikimi Njeri Kompjuter";
