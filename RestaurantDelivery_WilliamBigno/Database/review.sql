--------------------------------------------------------
--  File created - Friday-February-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REVIEW
--------------------------------------------------------

  CREATE TABLE "SYS"."REVIEW" 
   (	"USERID" NUMBER(10,0), 
	"ITEMID" NUMBER(10,0), 
	"REVIEWDETAILS" VARCHAR2(500 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYS.REVIEW
SET DEFINE OFF;
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,1,'This is yummy');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,1,'This was Great');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,2,'This was great');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,2,'So Yummy and Tasty Dog');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,3,'Love the crust');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,3,'Love the Sauce');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,1,'Great Food and Service');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,2,'Love this Place');
Insert into SYS.REVIEW (USERID,ITEMID,REVIEWDETAILS) values (2,1,'Love these Burgers');
--------------------------------------------------------
--  Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "SYS"."REVIEW" ADD PRIMARY KEY ("USERID") DISABLE;
  ALTER TABLE "SYS"."REVIEW" MODIFY ("REVIEWDETAILS" NOT NULL DISABLE);
  ALTER TABLE "SYS"."REVIEW" MODIFY ("ITEMID" NOT NULL DISABLE);
  ALTER TABLE "SYS"."REVIEW" MODIFY ("USERID" NOT NULL DISABLE);
