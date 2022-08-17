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
     codFiscale varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico numeric(20),
     codRuolo varchar(30) not null,
     constraint IDADDETTO_ID primary key (codRuolo));

create table CLIENTE (
     codFiscale varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico numeric(20),
     constraint IDCLIENTE_ID primary key (codFiscale));

create table DIRIGENTE (
     codDirigente varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico numeric(20),
     tipoServizioCoordinato varchar(30) not null,
     stagioneServizioCoordinato varchar(10) not null,
     annoServizioCoordinato numeric(4) not null,
     tipologiaSoggiornoCondizionato varchar(30) not null,
     meseSoggiornoCondizionato varchar(15) not null,
     annoSoggiornoCondizionato numeric(4) not null,
     constraint IDDIRIGENTE primary key (codDirigente));

create table EROGAZIONE (
     tipoServizioErogato varchar(30) not null,
     stagioneServizioErogato varchar(10) not null,
     annoServizioErogato numeric(4) not null,
     ruoloAddettoErogante varchar(30) not null,
     constraint IDEROGAZIONE primary key (tipoServizioErogato, stagioneServizioErogato, annoServizioErogato, ruoloAddettoErogante));

create table PRENOTAZIONE (
     tipoPrenotazione varchar(30) not null,
     giorno varchar(10),
     ora numeric(2),
     dataInizioSoggiornoRegistrato date not null,
     codFiscaleClienteRegistrato varchar(16) not null,
     tipoServizioUsufruito varchar(30) not null,
     stagioneServizioUsufruito varchar(15) not null,
     annoServizioUsufruito numeric(4) not null,
     codReceptionistOperante varchar(16) not null,
     constraint IDPRENOTAZIONE unique (tipoPrenotazione, giorno, ora, dataInizioSoggiornoRegistrato, codFiscaleClienteRegistrato));

create table RECEPTIONIST (
     codReceptionist varchar(16) not null,
     nome varchar(30) not null,
     cognome varchar(30) not null,
     dataNascita date not null,
     numeroTelefonico numeric(20),
     constraint IDRECEPTIONIST_ID primary key (codReceptionist));

create table SERVIZIO (
     tipoServizio varchar(30) not null,
     stagione varchar(15) not null,
     anno numeric(4) not null,
     tariffa numeric(10),
     constraint IDSERVIZIO_ID primary key (tipoServizio, stagione, anno));

create table SOGGIORNO (
     codFiscaleCliente varchar(16) not null,
     dataInizio date not null,
     durataSoggiorno date not null,
     soggiornante tinyint not null,
     offertaScelta varchar(20) not null,
     codScheda numeric(10) not null,
     numeroCamera numeric(5) not null,
     resoconto numeric(10),
     tipologiaSoggiornoScelto varchar(30) not null,
     meseSoggiornoScelto varchar(15) not null,
     annoSoggiornoScelto numeric(4) not null,
     codReceptionistInserente varchar(16) not null,
     constraint IDSOGGIORNO primary key (dataInizio, codFiscaleCliente));

create table TIPOLOGIASOGGIORNO (
     tipologia varchar(30) not null,
     mese varchar(15) not null,
     anno numeric(4) not null,
     prezzo numeric(10) not null,
     constraint IDTIPOLOGIASOGGIORNO primary key (tipologia, mese, anno));


-- Constraints Section
-- ___________________ 

-- Not implemented
-- alter table ADDETTO add constraint IDADDETTO_CHK
--     check(exists(select * from EROGAZIONE
--                  where EROGAZIONE.ruoloAddettoErogante = codRuolo)); 

-- Not implemented
-- alter table CLIENTE add constraint IDCLIENTE_CHK
--     check(exists(select * from SOGGIORNO
--                  where SOGGIORNO.codFiscaleCliente = codFiscale)); 

alter table DIRIGENTE add constraint FKCOORDINAZIONE
     foreign key (tipoServizioCoordinato, stagioneServizioCoordinato, annoServizioCoordinato)
     references SERVIZIO(tipoServizio, stagione, anno);

alter table DIRIGENTE add constraint FKCONDIZIONAMENTO
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

-- Not implemented
-- alter table RECEPTIONIST add constraint IDRECEPTIONIST_CHK
--    check(exists(select * from SOGGIORNO
--                where SOGGIORNO.codReceptionistInserente = codReceptionist)); 

-- Not implemented
-- alter table SERVIZIO add constraint IDSERVIZIO_CHK
--    check(exists(select * from EROGAZIONE
--                  where EROGAZIONE.tipoServizioErogato = tipoServizio and EROGAZIONE.stagioneServizioErogato = stagione and EROGAZIONE.annoServizioErogato = anno)); 

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

