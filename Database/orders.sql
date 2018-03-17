--------------------------------------------------------
--  File created - Friday-February-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "SYS"."ORDERS" 
   (	"ID" NUMBER(10,0), 
	"ITEMID" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYS.ORDERS
SET DEFINE OFF;
Insert into SYS.ORDERS (ID,ITEMID) values (2,2);
Insert into SYS.ORDERS (ID,ITEMID) values (3,1);
Insert into SYS.ORDERS (ID,ITEMID) values (4,3);
Insert into SYS.ORDERS (ID,ITEMID) values (4,2);
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "SYS"."ORDERS" ADD PRIMARY KEY ("ID") DISABLE;
  ALTER TABLE "SYS"."ORDERS" MODIFY ("ITEMID" NOT NULL DISABLE);
  ALTER TABLE "SYS"."ORDERS" MODIFY ("ID" NOT NULL DISABLE);
