drop trigger TIB_ERREUR_CAISSE
/

drop trigger TIB_MOTIF_REGULARISATION
/

alter table AGENT
   drop constraint FK_AGENT_DEPENDRE_AGENCE
/

alter table AGENT
   drop constraint FK_AGENT_ETRE_TYPE_AGE
/

alter table ERREURS_CAISSES_REGUL
   drop constraint FK_ERREURS__AVOIR_TYPE_REG
/

alter table ERREURS_CAISSES_REGUL
   drop constraint FK_ERREURS__AVOIR3_MOTIF_RE
/

alter table ERREURS_CAISSES_REGUL
   drop constraint FK_ERREURS__CORRESPON_ERREUR_C
/

alter table ERREURS_CAISSES_REGUL
   drop constraint FK_ERREURS__SAISIR_AGENT
/

alter table ERREUR_CAISSE
   drop constraint FK_ERREUR_C_AVOIR2_TYPE_ERR
/

alter table ERREUR_CAISSE
   drop constraint FK_ERREUR_C_COMMETRE_AGENT
/

alter table ERREUR_CAISSE
   drop constraint FK_ERREUR_C_ETRE_VICT_AGENCE
/

alter table ERREUR_CAISSE
   drop constraint FK_ERREUR_C_RELATION__STATUS_R
/

drop table AGENCE cascade constraints
/

drop index ETRE_FK
/

drop table AGENT cascade constraints
/

drop index SAISIR_FK
/

drop index AVOIR_FK
/

drop index CORRESPONDRE_FK
/

drop table ERREURS_CAISSES_REGUL cascade constraints
/

drop index AVOIR2_FK
/

drop index RELATION_5_FK
/

drop index ETRE_VICTIME_FK
/

drop index COMMETRE_FK
/

drop table ERREUR_CAISSE cascade constraints
/

drop table MOTIF_REGULARISATION cascade constraints
/

drop table STATUS_REGULARISATION cascade constraints
/

drop table TYPE_AGENT cascade constraints
/

drop table TYPE_ERREUR cascade constraints
/

drop table TYPE_REGULARISATION cascade constraints
/

drop sequence AUTO_INCREMENTATION
/

create sequence AUTO_INCREMENTATION
increment by 1
start with 0
 minvalue 0
/

/*==============================================================*/
/* Table : AGENCE                                               */
/*==============================================================*/
create table AGENCE 
(
   CODE_AGENCE          VARCHAR2(32)         not null
      constraint CKC_CODE_AGENCE_AGENCE check (CODE_AGENCE = upper(CODE_AGENCE)),
   NOM_AGENCE           VARCHAR2(256)        not null
      constraint CKC_NOM_AGENCE_AGENCE check (NOM_AGENCE = upper(NOM_AGENCE)),
   constraint PK_AGENCE primary key (CODE_AGENCE)
)
/

/*==============================================================*/
/* Table : AGENT                                                */
/*==============================================================*/
create table AGENT 
(
   CODE_AGENT           VARCHAR2(32)         not null
      constraint CKC_CODE_AGENT_AGENT check (CODE_AGENT = upper(CODE_AGENT)),
   CODE_AGENCE          VARCHAR(32),
   CODE_TYPE_AGENT      INTEGER              not null
      constraint CKC_CODE_TYPE_AGENT_AGENT check (CODE_TYPE_AGENT in (0,1,2)),
   MAIL                 VARCHAR2(320)       
      constraint CKC_MAIL_AGENT check (MAIL is null or (MAIL = lower(MAIL))),
   MOT_DE_PASSE         VARCHAR2(32),
   NOM                  VARCHAR2(32)        
      constraint CKC_NOM_AGENT check (NOM is null or (NOM = upper(NOM))),
   PRENOM               VARCHAR2(32)        
      constraint CKC_PRENOM_AGENT check (PRENOM is null or (PRENOM = upper(PRENOM))),
   constraint PK_AGENT primary key (CODE_AGENT)
)
/

/*==============================================================*/
/* Index : ETRE_FK                                              */
/*==============================================================*/
create index ETRE_FK on AGENT (
   CODE_TYPE_AGENT ASC
)
/

/*==============================================================*/
/* Table : ERREURS_CAISSES_REGUL                                */
/*==============================================================*/
create table ERREURS_CAISSES_REGUL 
(
   DTIME_REGULARISATION DATE                 not null,
   CODE_AGENT           VARCHAR2(32)         not null
      constraint CKC_CODE_AGENT_ERREURS_ check (CODE_AGENT = upper(CODE_AGENT)),
   CODE_MOTIF_REGULARISATION INTEGER              not null
      constraint CKC_CODE_MOTIF_REGULA_ERREURS_ check (CODE_MOTIF_REGULARISATION in (0,1,2,3,4,5,6,7)),
   ERREUR_CAISSE_ID     INTEGER              not null,
   CODE_TYPE_REGULARISATION INTEGER              not null
      constraint CKC_CODE_TYPE_REGULAR_ERREURS_ check (CODE_TYPE_REGULARISATION in (0,1)),
   MONTANT_REGULARISATION NUMBER(19,2)         not null,
   constraint PK_ERREURS_CAISSES_REGUL primary key (DTIME_REGULARISATION)
)
/

/*==============================================================*/
/* Index : CORRESPONDRE_FK                                      */
/*==============================================================*/
create index CORRESPONDRE_FK on ERREURS_CAISSES_REGUL (
   ERREUR_CAISSE_ID ASC
)
/

/*==============================================================*/
/* Index : AVOIR_FK                                             */
/*==============================================================*/
create index AVOIR_FK on ERREURS_CAISSES_REGUL (
   CODE_TYPE_REGULARISATION ASC
)
/

/*==============================================================*/
/* Index : SAISIR_FK                                            */
/*==============================================================*/
create index SAISIR_FK on ERREURS_CAISSES_REGUL (
   CODE_AGENT ASC
)
/

/*==============================================================*/
/* Table : ERREUR_CAISSE                                        */
/*==============================================================*/
create table ERREUR_CAISSE 
(
   ERREUR_CAISSE_ID     INTEGER              not null,
   CODE_AGENT           VARCHAR2(32)         not null
      constraint CKC_CODE_AGENT_ERREUR_C check (CODE_AGENT = upper(CODE_AGENT)),
   CODE_TYPE_ERREUR     CHAR(1)              not null
      constraint CKC_CODE_TYPE_ERREUR_ERREUR_C check (CODE_TYPE_ERREUR in ('E','D') and CODE_TYPE_ERREUR = upper(CODE_TYPE_ERREUR)),
   CODE_AGENCE          VARCHAR2(32)         not null
      constraint CKC_CODE_AGENCE_ERREUR_C check (CODE_AGENCE = upper(CODE_AGENCE)),
   CODE_STATUT_REGULARISATION INTEGER              not null
      constraint CKC_CODE_STATUT_REGUL_ERREUR_C check (CODE_STATUT_REGULARISATION in (0,1,2)),
   DATE_VACATION        DATE                 not null,
   MONTANT              NUMBER(19,2)         not null,
   constraint PK_ERREUR_CAISSE primary key (ERREUR_CAISSE_ID)
)
/

/*==============================================================*/
/* Index : COMMETRE_FK                                          */
/*==============================================================*/
create index COMMETRE_FK on ERREUR_CAISSE (
   CODE_AGENT ASC
)
/

/*==============================================================*/
/* Index : ETRE_VICTIME_FK                                      */
/*==============================================================*/
create index ETRE_VICTIME_FK on ERREUR_CAISSE (
   CODE_AGENCE ASC
)
/

/*==============================================================*/
/* Index : RELATION_5_FK                                        */
/*==============================================================*/
create index RELATION_5_FK on ERREUR_CAISSE (
   CODE_STATUT_REGULARISATION ASC
)
/

/*==============================================================*/
/* Index : AVOIR2_FK                                            */
/*==============================================================*/
create index AVOIR2_FK on ERREUR_CAISSE (
   CODE_TYPE_ERREUR ASC
)
/

/*==============================================================*/
/* Table : MOTIF_REGULARISATION                                 */
/*==============================================================*/
create table MOTIF_REGULARISATION 
(
   CODE_MOTIF_REGULARISATION INTEGER              not null
      constraint CKC_CODE_MOTIF_REGULA_MOTIF_RE check (CODE_MOTIF_REGULARISATION >= 0),
   DESCRIPTION_MOTIF_REGUL VARCHAR2(1024)       not null
      constraint CKC_DESCRIPTION_MOTIF_MOTIF_RE check (DESCRIPTION_MOTIF_REGUL = upper(DESCRIPTION_MOTIF_REGUL)),
   constraint PK_MOTIF_REGULARISATION primary key (CODE_MOTIF_REGULARISATION)
)
/

/*==============================================================*/
/* Table : STATUS_REGULARISATION                                */
/*==============================================================*/
create table STATUS_REGULARISATION 
(
   CODE_STATUT_REGULARISATION INTEGER              not null
      constraint CKC_CODE_STATUT_REGUL_STATUS_R check (CODE_STATUT_REGULARISATION in (0,1,2)),
   NOM_STATUS_REGULARISATION VARCHAR2(256)        not null
      constraint CKC_NOM_STATUS_REGULA_STATUS_R check (NOM_STATUS_REGULARISATION = upper(NOM_STATUS_REGULARISATION)),
   constraint PK_STATUS_REGULARISATION primary key (CODE_STATUT_REGULARISATION)
)
/

/*==============================================================*/
/* Table : TYPE_AGENT                                           */
/*==============================================================*/
create table TYPE_AGENT 
(
   CODE_TYPE_AGENT      INTEGER              not null
      constraint CKC_CODE_TYPE_AGENT_TYPE_AGE check (CODE_TYPE_AGENT in (0,1,2)),
   NOM_TYPE_AGENT       VARCHAR2(256)        not null
      constraint CKC_NOM_TYPE_AGENT_TYPE_AGE check (NOM_TYPE_AGENT = upper(NOM_TYPE_AGENT)),
   constraint PK_TYPE_AGENT primary key (CODE_TYPE_AGENT)
)
/

/*==============================================================*/
/* Table : TYPE_ERREUR                                          */
/*==============================================================*/
create table TYPE_ERREUR 
(
   CODE_TYPE_ERREUR     CHAR(1)              not null
      constraint CKC_CODE_TYPE_ERREUR_TYPE_ERR check (CODE_TYPE_ERREUR in ('E','D') and CODE_TYPE_ERREUR = upper(CODE_TYPE_ERREUR)),
   NOM_TYPE_ERREUR      VARCHAR2(256)        not null
      constraint CKC_NOM_TYPE_ERREUR_TYPE_ERR check (NOM_TYPE_ERREUR = upper(NOM_TYPE_ERREUR)),
   constraint PK_TYPE_ERREUR primary key (CODE_TYPE_ERREUR)
)
/

/*==============================================================*/
/* Table : TYPE_REGULARISATION                                  */
/*==============================================================*/
create table TYPE_REGULARISATION 
(
   CODE_TYPE_REGULARISATION INTEGER              not null
      constraint CKC_CODE_TYPE_REGULAR_TYPE_REG check (CODE_TYPE_REGULARISATION in (0,1)),
   NOM_TYPE_REGULARISATION VARCHAR2(256)        not null
      constraint CKC_NOM_TYPE_REGULARI_TYPE_REG check (NOM_TYPE_REGULARISATION = upper(NOM_TYPE_REGULARISATION)),
   constraint PK_TYPE_REGULARISATION primary key (CODE_TYPE_REGULARISATION)
)
/

alter table AGENT
   add constraint FK_AGENT_DEPENDRE_AGENCE foreign key (CODE_AGENCE)
      references AGENCE (CODE_AGENCE)
/

alter table AGENT
   add constraint FK_AGENT_ETRE_TYPE_AGE foreign key (CODE_TYPE_AGENT)
      references TYPE_AGENT (CODE_TYPE_AGENT)
/

alter table ERREURS_CAISSES_REGUL
   add constraint FK_ERREURS__AVOIR_TYPE_REG foreign key (CODE_TYPE_REGULARISATION)
      references TYPE_REGULARISATION (CODE_TYPE_REGULARISATION)
/

alter table ERREURS_CAISSES_REGUL
   add constraint FK_ERREURS__AVOIR3_MOTIF_RE foreign key (CODE_MOTIF_REGULARISATION)
      references MOTIF_REGULARISATION (CODE_MOTIF_REGULARISATION)
/

alter table ERREURS_CAISSES_REGUL
   add constraint FK_ERREURS__CORRESPON_ERREUR_C foreign key (ERREUR_CAISSE_ID)
      references ERREUR_CAISSE (ERREUR_CAISSE_ID)
/

alter table ERREURS_CAISSES_REGUL
   add constraint FK_ERREURS__SAISIR_AGENT foreign key (CODE_AGENT)
      references AGENT (CODE_AGENT)
/

alter table ERREUR_CAISSE
   add constraint FK_ERREUR_C_AVOIR2_TYPE_ERR foreign key (CODE_TYPE_ERREUR)
      references TYPE_ERREUR (CODE_TYPE_ERREUR)
/

alter table ERREUR_CAISSE
   add constraint FK_ERREUR_C_COMMETRE_AGENT foreign key (CODE_AGENT)
      references AGENT (CODE_AGENT)
/

alter table ERREUR_CAISSE
   add constraint FK_ERREUR_C_ETRE_VICT_AGENCE foreign key (CODE_AGENCE)
      references AGENCE (CODE_AGENCE)
/

alter table ERREUR_CAISSE
   add constraint FK_ERREUR_C_RELATION__STATUS_R foreign key (CODE_STATUT_REGULARISATION)
      references STATUS_REGULARISATION (CODE_STATUT_REGULARISATION)
/


create trigger TIB_ERREUR_CAISSE before insert
on ERREUR_CAISSE for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  La colonne "ERREUR_CAISSE_ID" utilise la sequence AUTO_INCREMENTATION
    select AUTO_INCREMENTATION.NEXTVAL INTO :new.ERREUR_CAISSE_ID from dual;

--  Traitement d'erreurs
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger TIB_MOTIF_REGULARISATION before insert
on MOTIF_REGULARISATION for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  La colonne "CODE_MOTIF_REGULARISATION" utilise la sequence AUTO_INCREMENTATION
    select AUTO_INCREMENTATION.NEXTVAL INTO :new.CODE_MOTIF_REGULARISATION from dual;

--  Traitement d'erreurs
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/

