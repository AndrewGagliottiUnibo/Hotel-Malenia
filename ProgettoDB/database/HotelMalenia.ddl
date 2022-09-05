-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Tue Aug 16 16:14:38 2022 
-- ********************************************* 


-- Database Section
-- ________________ 

create database schemahotel;
use schemahotel;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table ADDETTO (
     codRuolo tinyint unsigned not null,
     codFiscale varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico varchar(20),
     constraint IDADDETTO_ID primary key (codRuolo));

create table CLIENTE (
     codFiscale varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico varchar(20),
     constraint IDCLIENTE_ID primary key (codFiscale));

create table DIRIGENZA (
     firmaOperazione tinyint unsigned not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico varchar(20),
     tipoServizioCoordinato varchar(30) not null,
     stagioneServizioCoordinato varchar(15) not null,
     annoServizioCoordinato year not null,
     tipologiaSoggiornoCondizionato varchar(30) not null,
     meseSoggiornoCondizionato varchar(15) not null,
     annoSoggiornoCondizionato year not null,
     constraint IDDIRIGENZA primary key (firmaOperazione));

create table EROGAZIONE (
     tipoServizioErogato varchar(30) not null,
     stagioneServizioErogato varchar(15) not null,
     annoServizioErogato year not null,
     ruoloAddettoErogante tinyint unsigned not null,
     constraint IDEROGAZIONE primary key (tipoServizioErogato, stagioneServizioErogato, annoServizioErogato, ruoloAddettoErogante));

create table PRENOTAZIONE (
     tipoPrenotazione varchar(30) not null,
     giorno varchar(10),
     ora time,
     dataInizioSoggiornoRegistrato date not null,
     codFiscaleClienteRegistrato varchar(16) not null,
     tipoServizioUsufruito varchar(30) not null,
     stagioneServizioUsufruito varchar(15) not null,
     annoServizioUsufruito year not null,
     codReceptionistOperante tinyint unsigned not null,
     constraint IDPRENOTAZIONE unique (tipoPrenotazione, giorno, ora, dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato));

create table RECEPTIONIST (
     codReceptionist tinyint unsigned not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico varchar(20),
     constraint IDRECEPTIONIST_ID primary key (codReceptionist));

create table SERVIZIO (
     tipoServizio varchar(30) not null,
     stagione varchar(15) not null,
     anno year not null,
     tariffa numeric(10,2),
     constraint IDSERVIZIO_ID primary key (tipoServizio, stagione, anno));

create table SOGGIORNO (
     codFiscaleCliente varchar(16) not null,
     dataInizio date not null,
     durataSoggiorno date not null,
     soggiornante boolean not null,
     offertaScelta varchar(20) not null,
     codScheda numeric(10) not null,
     numeroCamera numeric(5) not null,
     resoconto numeric(10, 2),
     tipologiaSoggiornoScelto varchar(30) not null,
     meseSoggiornoScelto varchar(15) not null,
     annoSoggiornoScelto year not null,
     codReceptionistInserente tinyint unsigned not null,
     constraint IDSOGGIORNO primary key (dataInizio, codFiscaleCliente));

create table TIPOLOGIASOGGIORNO (
     tipologia varchar(30) not null,
     mese varchar(15) not null,
     anno year not null,
     prezzo numeric(10, 2) not null,
     constraint IDTIPOLOGIASOGGIORNO primary key (tipologia, mese, anno));




alter table DIRIGENZA add constraint FKCOORDINAZIONE
     foreign key (tipoServizioCoordinato, stagioneServizioCoordinato, annoServizioCoordinato)
     references SERVIZIO(tipoServizio, stagione, anno);

alter table DIRIGENZA add constraint FKCONDIZIONAMENTO
     foreign key (tipologiaSoggiornoCondizionato, meseSoggiornoCondizionato, annoSoggiornoCondizionato)
     references TIPOLOGIASOGGIORNO(tipologia, mese, anno);

alter table EROGAZIONE add constraint FKEROG_ADD
     foreign key (ruoloAddettoErogante)
     references ADDETTO(codRuolo);

alter table EROGAZIONE add constraint FKEROG_SER
     foreign key (tipoServizioErogato, stagioneServizioErogato, annoServizioErogato)
     references SERVIZIO(tipoServizio, stagione, anno);

alter table PRENOTAZIONE add constraint FKACCESSO
     foreign key (tipoServizioUsufruito, stagioneServizioUsufruito, annoServizioUsufruito)
     references SERVIZIO(tipoServizio, stagione, anno);

alter table PRENOTAZIONE add constraint FKREGISTRAZIONE
     foreign key (dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato)
     references SOGGIORNO(dataInizio, codFiscaleCliente);

alter table PRENOTAZIONE add constraint FKEFFETTUAZIONE
     foreign key (codReceptionistOperante)
     references RECEPTIONIST(codReceptionist);

alter table SOGGIORNO add constraint FKABBINAMENTO
     foreign key (tipologiaSoggiornoScelto, meseSoggiornoScelto, annoSoggiornoScelto)
     references TIPOLOGIASOGGIORNO(tipologia, mese, anno);

alter table SOGGIORNO add constraint FKIDENTIFICAZIONE
     foreign key (codFiscaleCliente)
     references CLIENTE(codFiscale);

alter table SOGGIORNO add constraint FKCREAZIONE
     foreign key (codReceptionistInserente)
     references RECEPTIONIST(codReceptionist);


-- Index Section
-- _____________ 

