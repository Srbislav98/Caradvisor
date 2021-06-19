-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user3', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Igor', 'Jovovic', 'user3@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user4', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Stefan', 'Sakic', 'user4@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user5', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Petar', 'Djurovic', 'user5@example.com', true, '2017-10-01 21:58:58.508-07');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 2);

INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('BMW 520 D xDrive','BMW','LIMUZINA',32500,2017,'DIZEL',true,180,'BELA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Mercedes Benz C 200','Mercedes','LIMUZINA',16500,2015,'DIZEL',true,136,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Kia Picanto 1.1 LX','Kia','HECBEK',2200,2006,'BENZIN',true,65,'NARANDZASTA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Dacia Duster Prestige','Dacia','DZIP',14200,2019,'DIZEL',true,114,'NARANDZASTA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Ford Kuga','Ford','DZIP',10800,2014,'DIZEL',true,140,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Peugeot 2008 GTLine','Peugeot','DZIP',28000,2020,'DIZEL',true,141,'NARANDZASTA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Ford a tipe','Ford','KABRIOLET',50000,1931,'BENZIN',false,480,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Zastava 750 fica','Zastava','LIMUZINA',1800,1980,'BENZIN',false,30,'PLAVA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Fiat Doblo','Fiat','PICKUP',9200,2015,'DIZEL',true,90,'BELA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Škoda Yeti Minivan','Škoda','MINIVAN',10400,2015,'DIZEL',true,110,'SIVA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Audi A3 Cabrio','Audi','KABRIOLET',7500,2009,'DIZEL',true,105,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Mini Cooper S','Mini','KUPE',5800,2000,'BENZIN',true,174,'PLAVA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Volkswagen Karavan Passat B5.5','Volkswagen','KARAVAN',2200,2002,'BENZIN',true,150,'CRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Opel Vectra Limuzina C','Opel','LIMUZINA',1000,2002,'BENZIN_GAS',true,147,'SREBRNA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Fiat Qubo','Fiat','MINIVAN',3500,2011,'BENZIN_METAN',true,77,'CRVENA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Porsche Taycan Turbo','Porsche','LIMUZINA',125000,2020,'ELEKTRICNI_POGON',true,680,'BELA',0);
INSERT INTO AUTOMOBIL(naziv,marka,karoserija,cena,godiste,gorivo,klima,kubikaza,boja,score) VALUES ('Honda Lifestyle Hybrid','Honda','DZIP',40700,2020,'HIBRIDNI_POGON',true,218,'CRVENA',0);

INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (100,'BMW 520 D xDrive','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto100.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (101,'Mercedes Benz C 200','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto101.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (102,'Kia Picanto 1.1 LX','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto102.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (103,'Dacia Duster Prestige','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto103.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (104,'Ford Kuga','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto104.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (105,'Peugeot 2008 GTLine','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto105.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (106,'Ford a tipe','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto106.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (107,'Zastava 750 fica','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto107.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (108,'Fiat Doblo','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto108.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (109,'Škoda Yeti Minivan','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto109.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (110,'Audi A3 Cabrio','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto110.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (111,'Mini Cooper S','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto111.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (112,'Volkswagen Karavan Passat B5.5','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto112.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (113,'Opel Vectra Limuzina C','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto113.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (114,'Fiat Qubo','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto114.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (115,'Porsche Taycan Turbo','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto115.jpg');
INSERT into FOTOGRAFIJA(id,car_naziv,lokacija_fajl)values (116,'Honda Lifestyle Hybrid','C:/Users/TehnoCentar/Desktop/Caradvisor/app/frontend/client/src/assets/img/auto116.jpg');