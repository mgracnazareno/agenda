-- drop database mysqlproject;
-- create database mysqlproject;
use mysqlproject;

INSERT into USER VALUES(1, 0, 'Mary@Test.com', 'Brown ','test123', 'user-admin.png','Mary', 'brownmar');
INSERT into USER VALUES(2, 1, 'Medhi@Test.com', 'Zaloul ','medhi123', 'icons8-user-64.png','medhi', 'medhiz');
INSERT into USER VALUES(3, 1, 'maryam@Test.com', 'hanifeh ','maryam123', 'user-entrepreneur.png','maryam', 'maryamH');

INSERT into Role VALUES(1,'Peut tout faire','Admin');
INSERT into Role VALUES(2,'Gère les profil, les evenements, amis, partager et signaler des abus dutilisateurs','User');
INSERT into Role VALUE(3,'Gère les entreprises, les evenements','Manager');

INSERT INTO USER_ROLE VALUES(1, 1);
INSERT INTO USER_ROLE VALUES(2,2);
INSERT INTO USER_ROLE VALUE(3,3);