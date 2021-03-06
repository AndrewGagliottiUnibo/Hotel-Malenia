-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Tue May 17 14:47:12 2022 
-- * LUN file: C:\Users\Dario\Desktop\Personale\Copia\Hotel-Malenia\res\tables\HotelMalenia.lun 
-- * Schema: SchemaHotel/L1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database SchemaHotel;
use SchemaHotel;


-- Tables Section
-- _____________ 

create table ABBINAMENTO (
     schedaAbbinata int not null,
     soggiornoScelto char(1) not null,
     constraint IDABBINAMENTO primary key (schedaAbbinata, soggiornoScelto));

create table ACCESSO (
     servizioScelto char(30) not null,
     numeroPrenotazione int not null,
     constraint IDACCESSO primary key (servizioScelto, numeroPrenotazione));

create table ADDETTO (
     nome char(20) not null,
     cognome char(20) not null,
     numeroTel int not null,
     dataNascita char(20) not null,
     zonaDiLavoro char(40) not null,
     ruolo char(20) not null,
     codiceFiscale char(40) not null,
     codRuolo char(1) not null,
     constraint IDADDETTO_1 unique (ruolo),
     constraint IDADDETTO_ID primary key (codRuolo),
     constraint IDADDETTO_2 unique (codiceFiscale));

create table CLIENTE (
     nome char(20) not null,
     cognome char(20) not null,
     numeroTel int not null,
     dataNascita char(20) not null,
     codiceFiscale char(40) not null,
     tipologiaSoggiorno char(1) not null,
     constraint IDCLIENTE_ID primary key (codiceFiscale));

create table CONDIZIONAMENTO (
     codSoggiorno char(1) not null,
     codListino int not null,
     codServizio char(30) not null,
     constraint IDCONDIZIONAMENTO primary key (codServizio, codSoggiorno, codListino));

create table CREAZIONE (
     codiceScheda int not null,
     codiceAddetto char(1) not null,
     constraint IDCREAZIONE primary key (codiceAddetto, codiceScheda));

create table DIRIGENTE (
     nome char(20) not null,
     cognome char(20) not null,
     numeroTel int not null,
     dataNascita char(20) not null,
     codiceFiscale char(40) not null,
     tipologiaListino int not null,
     codDirigente int not null,
     constraint IDDIRIGENTE primary key (codDirigente));

create table EFFETTUAZIONE (
     clienteServito char(40) not null,
     prestazione int not null,
     constraint IDEFFETTUAZIONE primary key (prestazione, clienteServito));

create table IDENTIFICAZIONE (
     codiceCliente char(40) not null,
     numeroScheda int not null,
     constraint IDIDENTIFICAZIONE primary key (numeroScheda, codiceCliente));

create table LISTINI (
     tipoListino int not null,
     valoreMonetario smallint not null,
     constraint IDLISTINI_ID primary key (tipoListino));

create table PRENOTAZIONE (
     tipoPrenotazione int not null,
     data char(20),
     ora char(20),
     constraint IDPRENOTAZIONE_ID primary key (tipoPrenotazione));

create table REGISTRAZIONE (
     codPrenotazione int not null,
     schedaRegistrata int not null,
     constraint IDREGISTRAZIONE primary key (codPrenotazione, schedaRegistrata));

create table SCHEDA (
     datiGestionali_DurataSoggiorno char(20) not null,
     datiGestionali_Tariffa char(20) not null,
     datiGestionali_orariCheckOut char(20) not null,
     datiGestionali_Oraricheckin char(20) not null,
     resoconto int not null,
     intolleranze char(80) not null,
     numeroCamera tinyint not null,
     codScheda int not null,
     constraint IDSCHEDA_ID primary key (codScheda));

create table SERVIZIO (
     tipoServizio char(30) not null,
     tariffa int,
     addettoAssegnato char(20) not null,
     constraint IDSERVIZIO_ID primary key (tipoServizio));

create table SOGGIORNO (
     prezzo int not null,
     tipologia char(1) not null,
     constraint IDSOGGIORNO_ID primary key (tipologia));

create table VISUALIZZAZIONE (
     codSchedaVisualizzata int not null,
     codAddettoAccedente char(20) not null,
     constraint IDVISUALIZZAZIONE primary key (codSchedaVisualizzata, codAddettoAccedente));

-- Constraints Section
-- ___________________ 

alter table ABBINAMENTO add constraint FKABB_SOG
     foreign key (soggiornoScelto)
     references SOGGIORNO (tipologia);

alter table ABBINAMENTO add constraint FKABB_SCH
     foreign key (schedaAbbinata)
     references SCHEDA (codScheda);

alter table ACCESSO add constraint FKACC_PRE
     foreign key (numeroPrenotazione)
     references PRENOTAZIONE (tipoPrenotazione);

alter table ACCESSO add constraint FKACC_SER
     foreign key (servizioScelto)
     references SERVIZIO (tipoServizio);

-- Not implemented
-- alter table ADDETTO add constraint IDADDETTO_CHK
--     check(exists(select * from CREAZIONE
--                  where CREAZIONE.codiceAddetto = codRuolo)); 

-- Not implemented
-- alter table ADDETTO add constraint IDADDETTO_CHK
--     check(exists(select * from VISUALIZZAZIONE
--                  where VISUALIZZAZIONE.codAddettoAccedente = codRuolo)); 

-- Not implemented
-- alter table ADDETTO add constraint IDADDETTO_CHK
--     check(exists(select * from SERVIZIO
--                  where SERVIZIO.addettoAssegnato = codRuolo)); 

-- Not implemented
-- alter table CLIENTE add constraint IDCLIENTE_CHK
--     check(exists(select * from EFFETTUAZIONE
--                  where EFFETTUAZIONE.clienteServito = codiceFiscale)); 

-- Not implemented
-- alter table CLIENTE add constraint IDCLIENTE_CHK
--     check(exists(select * from IDENTIFICAZIONE
--                  where IDENTIFICAZIONE.codiceCliente = codiceFiscale)); 

alter table CLIENTE add constraint FKSELEZIONE
     foreign key (tipologiaSoggiorno)
     references SOGGIORNO (tipologia);

alter table CONDIZIONAMENTO add constraint FKCON_SER
     foreign key (codServizio)
     references SERVIZIO (tipoServizio);

alter table CONDIZIONAMENTO add constraint FKCON_LIS
     foreign key (codListino)
     references LISTINI (tipoListino);

alter table CONDIZIONAMENTO add constraint FKCON_SOG
     foreign key (codSoggiorno)
     references SOGGIORNO (tipologia);

alter table CREAZIONE add constraint FKCRE_ADD
     foreign key (codiceAddetto)
     references ADDETTO (codRuolo);

alter table CREAZIONE add constraint FKCRE_SCH
     foreign key (codiceScheda)
     references SCHEDA (codScheda);

alter table DIRIGENTE add constraint FKGESTIONE
     foreign key (tipologiaListino)
     references LISTINI (tipoListino);

alter table EFFETTUAZIONE add constraint FKEFF_PRE
     foreign key (prestazione)
     references PRENOTAZIONE (tipoPrenotazione);

alter table EFFETTUAZIONE add constraint FKEFF_CLI
     foreign key (clienteServito)
     references CLIENTE (codiceFiscale);

alter table IDENTIFICAZIONE add constraint FKIDE_SCH
     foreign key (numeroScheda)
     references SCHEDA (codScheda);

alter table IDENTIFICAZIONE add constraint FKIDE_CLI
     foreign key (codiceCliente)
     references CLIENTE (codiceFiscale);

-- Not implemented
-- alter table LISTINI add constraint IDLISTINI_CHK
--     check(exists(select * from CONDIZIONAMENTO
--                  where CONDIZIONAMENTO.codListino = tipoListino)); 

-- Not implemented
-- alter table LISTINI add constraint IDLISTINI_CHK
--     check(exists(select * from DIRIGENTE
--                  where DIRIGENTE.tipologiaListino = tipoListino)); 

-- Not implemented
-- alter table PRENOTAZIONE add constraint IDPRENOTAZIONE_CHK
--     check(exists(select * from REGISTRAZIONE
--                  where REGISTRAZIONE.codPrenotazione = tipoPrenotazione)); 

-- Not implemented
-- alter table PRENOTAZIONE add constraint IDPRENOTAZIONE_CHK
--     check(exists(select * from ACCESSO
--                  where ACCESSO.numeroPrenotazione = tipoPrenotazione)); 

alter table REGISTRAZIONE add constraint FKREG_SCH
     foreign key (schedaRegistrata)
     references SCHEDA (codScheda);

alter table REGISTRAZIONE add constraint FKREG_PRE
     foreign key (codPrenotazione)
     references PRENOTAZIONE (tipoPrenotazione);

-- Not implemented
-- alter table SCHEDA add constraint IDSCHEDA_CHK
--     check(exists(select * from VISUALIZZAZIONE
--                  where VISUALIZZAZIONE.codSchedaVisualizzata = codScheda)); 

-- Not implemented
-- alter table SCHEDA add constraint IDSCHEDA_CHK
--     check(exists(select * from REGISTRAZIONE
--                  where REGISTRAZIONE.schedaRegistrata = codScheda)); 

-- Not implemented
-- alter table SCHEDA add constraint IDSCHEDA_CHK
--     check(exists(select * from IDENTIFICAZIONE
--                  where IDENTIFICAZIONE.numeroScheda = codScheda)); 

-- Not implemented
-- alter table SCHEDA add constraint IDSCHEDA_CHK
--     check(exists(select * from ABBINAMENTO
--                  where ABBINAMENTO.schedaAbbinata = codScheda)); 

-- Not implemented
-- alter table SCHEDA add constraint IDSCHEDA_CHK
--     check(exists(select * from CREAZIONE
--                  where CREAZIONE.codiceScheda = codScheda)); 

-- Not implemented
-- alter table SERVIZIO add constraint IDSERVIZIO_CHK
--     check(exists(select * from ACCESSO
--                  where ACCESSO.servizioScelto = tipoServizio)); 

-- Not implemented
-- alter table SERVIZIO add constraint IDSERVIZIO_CHK
--     check(exists(select * from CONDIZIONAMENTO
--                  where CONDIZIONAMENTO.codServizio = tipoServizio)); 

alter table SERVIZIO add constraint FKEROGAZIONE
     foreign key (addettoAssegnato)
     references ADDETTO (codRuolo);

-- Not implemented
-- alter table SOGGIORNO add constraint IDSOGGIORNO_CHK
--     check(exists(select * from ABBINAMENTO
--                  where ABBINAMENTO.soggiornoScelto = tipologia)); 

-- Not implemented
-- alter table SOGGIORNO add constraint IDSOGGIORNO_CHK
--     check(exists(select * from CONDIZIONAMENTO
--                  where CONDIZIONAMENTO.codSoggiorno = tipologia)); 

-- Not implemented
-- alter table SOGGIORNO add constraint IDSOGGIORNO_CHK
--     check(exists(select * from CLIENTE
--                  where CLIENTE.tipologiaSoggiorno = tipologia)); 

alter table VISUALIZZAZIONE add constraint FKVIS_ADD
     foreign key (codAddettoAccedente)
     references ADDETTO (codRuolo);

alter table VISUALIZZAZIONE add constraint FKVIS_SCH
     foreign key (codSchedaVisualizzata)
     references SCHEDA (codScheda);


-- Index Section
-- _____________ 

