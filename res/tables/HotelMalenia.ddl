-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Sat May 14 11:19:29 2022 
-- * LUN file: C:\Users\Dario\Desktop\Personale\Copia\Hotel-Malenia\res\tables\HotelMalenia.lun 
-- * Schema: SchemaHotel/SQL 
-- ********************************************* 


-- Database Section
-- ________________ 

create database SchemaHotel;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table ABBINAMENTO (
     schedaAbbinata char(1) not null,
     soggiornoScelto char(1) not null,
     constraint ID_ABBINAMENTO_ID primary key (schedaAbbinata, soggiornoScelto));

create table ACCESSO (
     servizioScelto char(1) not null,
     numeroPrenotazione char(1) not null,
     constraint ID_ACCESSO_ID primary key (servizioScelto, numeroPrenotazione));

create table ADDETTO (
     nome char(1) not null,
     cognome char(1) not null,
     numeroTel char(1) not null,
     dataNascita char(1) not null,
     zonaDiLavoro char(1) not null,
     ruolo char(1) not null,
     codiceFiscale char(1) not null,
     codRuolo char(1) not null,
     constraint SID_ADDETTO_1_ID unique (ruolo),
     constraint ID_ADDETTO_ID primary key (codRuolo),
     constraint SID_ADDETTO_ID unique (codiceFiscale));

create table CLIENTE (
     nome char(1) not null,
     cognome char(1) not null,
     numeroTel char(1) not null,
     dataNascita char(1) not null,
     codiceFiscale char(1) not null,
     tipologiaSoggiorno char(1) not null,
     constraint ID_CLIENTE_ID primary key (codiceFiscale));

create table CONDIZIONAMENTO (
     codSoggiorno char(1) not null,
     codListino char(1) not null,
     codServizio char(1) not null,
     constraint ID_CONDIZIONAMENTO_ID primary key (codServizio, codSoggiorno, codListino));

create table CREAZIONE (
     codiceScheda char(1) not null,
     codiceAddetto char(1) not null,
     constraint ID_CREAZIONE_ID primary key (codiceAddetto, codiceScheda));

create table DIRIGENTE (
     nome char(1) not null,
     cognome char(1) not null,
     numeroTel char(1) not null,
     dataNascita char(1) not null,
     codiceFiscale char(1) not null,
     tipologiaListino -- Compound attribute -- not null,
     codDirigente char(1) not null,
     constraint ID_DIRIGENTE_ID primary key (codDirigente));

create table EFFETTUAZIONE (
     clienteServito char(1) not null,
     prestazione char(1) not null,
     constraint ID_EFFETTUAZIONE_ID primary key (prestazione, clienteServito));

create table IDENTIFICAZIONE (
     codiceCliente char(1) not null,
     numeroScheda char(1) not null,
     constraint ID_IDENTIFICAZIONE_ID primary key (numeroScheda, codiceCliente));

create table LISTINI (
     tipoListino char(1) not null,
     valoreMonetario char(1) not null,
     constraint ID_LISTINI_ID primary key (tipoListino));

create table PRENOTAZIONE (
     tipoPrenotazione char(1) not null,
     data char(1),
     ora char(1),
     constraint ID_PRENOTAZIONE_ID primary key (tipoPrenotazione));

create table REGISTRAZIONE (
     codPrenotazione char(1) not null,
     schedaRegistrata char(1) not null,
     constraint ID_REGISTRAZIONE_ID primary key (codPrenotazione, schedaRegistrata));

create table SCHEDA (
     datiGestionali_DurataSoggiorno char(1) not null,
     datiGestionali_Tariffa char(1) not null,
     datiGestionali_orariCheckOut -- Compound attribute -- not null,
     datiGestionali_Oraricheck_in char(1) not null,
     resoconto -- Compound attribute -- not null,
     intolleranze char(1) not null,
     numeroCamera char(1) not null,
     codScheda char(1) not null,
     constraint ID_SCHEDA_ID primary key (codScheda));

create table SERVIZIO (
     tipoServizio char(1) not null,
     tariffa char(1),
     addettoAssegnato char(1) not null,
     constraint ID_SERVIZIO_ID primary key (tipoServizio));

create table SOGGIORNO (
     prezzo char(1) not null,
     tipologia char(1) not null,
     constraint ID_SOGGIORNO_ID primary key (tipologia));

create table VISUALIZZAZIONE (
     codSchedaVisualizzata char(1) not null,
     codAddettoAccedente char(1) not null,
     constraint ID_VISUALIZZAZIONE_ID primary key (codSchedaVisualizzata, codAddettoAccedente));


-- Constraints Section
-- ___________________ 

alter table ABBINAMENTO add constraint EQU_ABBIN_SOGGI_FK
     foreign key (soggiornoScelto)
     references SOGGIORNO;

alter table ABBINAMENTO add constraint EQU_ABBIN_SCHED
     foreign key (schedaAbbinata)
     references SCHEDA;

alter table ACCESSO add constraint EQU_ACCES_PRENO_FK
     foreign key (numeroPrenotazione)
     references PRENOTAZIONE;

alter table ACCESSO add constraint EQU_ACCES_SERVI
     foreign key (servizioScelto)
     references SERVIZIO;

alter table ADDETTO add constraint ID_ADDETTO_CHK
     check(exists(select * from CREAZIONE
                  where CREAZIONE.codiceAddetto = codRuolo)); 

alter table ADDETTO add constraint ID_ADDETTO_CHK
     check(exists(select * from VISUALIZZAZIONE
                  where VISUALIZZAZIONE.codAddettoAccedente = codRuolo)); 

alter table ADDETTO add constraint ID_ADDETTO_CHK
     check(exists(select * from SERVIZIO
                  where SERVIZIO.addettoAssegnato = codRuolo)); 

alter table CLIENTE add constraint ID_CLIENTE_CHK
     check(exists(select * from EFFETTUAZIONE
                  where EFFETTUAZIONE.clienteServito = codiceFiscale)); 

alter table CLIENTE add constraint ID_CLIENTE_CHK
     check(exists(select * from IDENTIFICAZIONE
                  where IDENTIFICAZIONE.codiceCliente = codiceFiscale)); 

alter table CLIENTE add constraint EQU_CLIEN_SOGGI_FK
     foreign key (tipologiaSoggiorno)
     references SOGGIORNO;

alter table CONDIZIONAMENTO add constraint EQU_CONDI_SERVI
     foreign key (codServizio)
     references SERVIZIO;

alter table CONDIZIONAMENTO add constraint EQU_CONDI_LISTI_FK
     foreign key (codListino)
     references LISTINI;

alter table CONDIZIONAMENTO add constraint EQU_CONDI_SOGGI_FK
     foreign key (codSoggiorno)
     references SOGGIORNO;

alter table CREAZIONE add constraint EQU_CREAZ_ADDET
     foreign key (codiceAddetto)
     references ADDETTO;

alter table CREAZIONE add constraint EQU_CREAZ_SCHED_FK
     foreign key (codiceScheda)
     references SCHEDA;

alter table DIRIGENTE add constraint EQU_DIRIG_LISTI_FK
     foreign key (tipologiaListino -- Compound attribute --)
     references LISTINI;

alter table EFFETTUAZIONE add constraint REF_EFFET_PRENO
     foreign key (prestazione)
     references PRENOTAZIONE;

alter table EFFETTUAZIONE add constraint EQU_EFFET_CLIEN_FK
     foreign key (clienteServito)
     references CLIENTE;

alter table IDENTIFICAZIONE add constraint EQU_IDENT_SCHED
     foreign key (numeroScheda)
     references SCHEDA;

alter table IDENTIFICAZIONE add constraint EQU_IDENT_CLIEN_FK
     foreign key (codiceCliente)
     references CLIENTE;

alter table LISTINI add constraint ID_LISTINI_CHK
     check(exists(select * from CONDIZIONAMENTO
                  where CONDIZIONAMENTO.codListino = tipoListino)); 

alter table LISTINI add constraint ID_LISTINI_CHK
     check(exists(select * from DIRIGENTE
                  where DIRIGENTE.tipologiaListino = tipoListino)); 

alter table PRENOTAZIONE add constraint ID_PRENOTAZIONE_CHK
     check(exists(select * from REGISTRAZIONE
                  where REGISTRAZIONE.codPrenotazione = tipoPrenotazione)); 

alter table PRENOTAZIONE add constraint ID_PRENOTAZIONE_CHK
     check(exists(select * from ACCESSO
                  where ACCESSO.numeroPrenotazione = tipoPrenotazione)); 

alter table REGISTRAZIONE add constraint EQU_REGIS_SCHED_FK
     foreign key (schedaRegistrata)
     references SCHEDA;

alter table REGISTRAZIONE add constraint EQU_REGIS_PRENO
     foreign key (codPrenotazione)
     references PRENOTAZIONE;

alter table SCHEDA add constraint ID_SCHEDA_CHK
     check(exists(select * from VISUALIZZAZIONE
                  where VISUALIZZAZIONE.codSchedaVisualizzata = codScheda)); 

alter table SCHEDA add constraint ID_SCHEDA_CHK
     check(exists(select * from REGISTRAZIONE
                  where REGISTRAZIONE.schedaRegistrata = codScheda)); 

alter table SCHEDA add constraint ID_SCHEDA_CHK
     check(exists(select * from IDENTIFICAZIONE
                  where IDENTIFICAZIONE.numeroScheda = codScheda)); 

alter table SCHEDA add constraint ID_SCHEDA_CHK
     check(exists(select * from ABBINAMENTO
                  where ABBINAMENTO.schedaAbbinata = codScheda)); 

alter table SCHEDA add constraint ID_SCHEDA_CHK
     check(exists(select * from CREAZIONE
                  where CREAZIONE.codiceScheda = codScheda)); 

alter table SERVIZIO add constraint ID_SERVIZIO_CHK
     check(exists(select * from ACCESSO
                  where ACCESSO.servizioScelto = tipoServizio)); 

alter table SERVIZIO add constraint ID_SERVIZIO_CHK
     check(exists(select * from CONDIZIONAMENTO
                  where CONDIZIONAMENTO.codServizio = tipoServizio)); 

alter table SERVIZIO add constraint EQU_SERVI_ADDET_FK
     foreign key (addettoAssegnato)
     references ADDETTO;

alter table SOGGIORNO add constraint ID_SOGGIORNO_CHK
     check(exists(select * from ABBINAMENTO
                  where ABBINAMENTO.soggiornoScelto = tipologia)); 

alter table SOGGIORNO add constraint ID_SOGGIORNO_CHK
     check(exists(select * from CONDIZIONAMENTO
                  where CONDIZIONAMENTO.codSoggiorno = tipologia)); 

alter table SOGGIORNO add constraint ID_SOGGIORNO_CHK
     check(exists(select * from CLIENTE
                  where CLIENTE.tipologiaSoggiorno = tipologia)); 

alter table VISUALIZZAZIONE add constraint EQU_VISUA_ADDET_FK
     foreign key (codAddettoAccedente)
     references ADDETTO;

alter table VISUALIZZAZIONE add constraint EQU_VISUA_SCHED
     foreign key (codSchedaVisualizzata)
     references SCHEDA;


-- Index Section
-- _____________ 

create unique index ID_ABBINAMENTO_IND
     on ABBINAMENTO (schedaAbbinata, soggiornoScelto);

create index EQU_ABBIN_SOGGI_IND
     on ABBINAMENTO (soggiornoScelto);

create unique index ID_ACCESSO_IND
     on ACCESSO (servizioScelto, numeroPrenotazione);

create index EQU_ACCES_PRENO_IND
     on ACCESSO (numeroPrenotazione);

create unique index SID_ADDETTO_1_IND
     on ADDETTO (ruolo);

create unique index ID_ADDETTO_IND
     on ADDETTO (codRuolo);

create unique index SID_ADDETTO_IND
     on ADDETTO (codiceFiscale);

create unique index ID_CLIENTE_IND
     on CLIENTE (codiceFiscale);

create index EQU_CLIEN_SOGGI_IND
     on CLIENTE (tipologiaSoggiorno);

create unique index ID_CONDIZIONAMENTO_IND
     on CONDIZIONAMENTO (codServizio, codSoggiorno, codListino);

create index EQU_CONDI_LISTI_IND
     on CONDIZIONAMENTO (codListino);

create index EQU_CONDI_SOGGI_IND
     on CONDIZIONAMENTO (codSoggiorno);

create unique index ID_CREAZIONE_IND
     on CREAZIONE (codiceAddetto, codiceScheda);

create index EQU_CREAZ_SCHED_IND
     on CREAZIONE (codiceScheda);

create index EQU_DIRIG_LISTI_IND
     on DIRIGENTE (tipologiaListino -- Compound attribute --);

create unique index ID_DIRIGENTE_IND
     on DIRIGENTE (codDirigente);

create unique index ID_EFFETTUAZIONE_IND
     on EFFETTUAZIONE (prestazione, clienteServito);

create index EQU_EFFET_CLIEN_IND
     on EFFETTUAZIONE (clienteServito);

create unique index ID_IDENTIFICAZIONE_IND
     on IDENTIFICAZIONE (numeroScheda, codiceCliente);

create index EQU_IDENT_CLIEN_IND
     on IDENTIFICAZIONE (codiceCliente);

create unique index ID_LISTINI_IND
     on LISTINI (tipoListino);

create unique index ID_PRENOTAZIONE_IND
     on PRENOTAZIONE (tipoPrenotazione);

create unique index ID_REGISTRAZIONE_IND
     on REGISTRAZIONE (codPrenotazione, schedaRegistrata);

create index EQU_REGIS_SCHED_IND
     on REGISTRAZIONE (schedaRegistrata);

create unique index ID_SCHEDA_IND
     on SCHEDA (codScheda);

create unique index ID_SERVIZIO_IND
     on SERVIZIO (tipoServizio);

create index EQU_SERVI_ADDET_IND
     on SERVIZIO (addettoAssegnato);

create unique index ID_SOGGIORNO_IND
     on SOGGIORNO (tipologia);

create unique index ID_VISUALIZZAZIONE_IND
     on VISUALIZZAZIONE (codSchedaVisualizzata, codAddettoAccedente);

create index EQU_VISUA_ADDET_IND
     on VISUALIZZAZIONE (codAddettoAccedente);

