--------------------------------------------------------
--  File created - Friday-February-02-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ITEMS
--------------------------------------------------------

  CREATE TABLE "SYS"."ITEMS" 
   (	"ID" NUMBER(10,0), 
	"ITEMNAME" VARCHAR2(20 BYTE), 
	"DESCRIPTION" VARCHAR2(500 BYTE), 
	"PRICE" NUMBER(20,2), 
	"ACTIVE" NUMBER(*,0), 
	"CATEGORY" VARCHAR2(20 BYTE), 
	"IMAGE" VARCHAR2(200 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYS.ITEMS
SET DEFINE OFF;
Insert into SYS.ITEMS (ID,ITEMNAME,DESCRIPTION,PRICE,ACTIVE,CATEGORY,IMAGE) values (1,'Burger','Hot Hot',16,1,'Hot','" "');
Insert into SYS.ITEMS (ID,ITEMNAME,DESCRIPTION,PRICE,ACTIVE,CATEGORY,IMAGE) values (2,'Hot Dog','Hot and Amazing',10,1,'Hot','" "');
Insert into SYS.ITEMS (ID,ITEMNAME,DESCRIPTION,PRICE,ACTIVE,CATEGORY,IMAGE) values (3,'Cheese Pizza','Hot and Crispy',13.5,1,'Hot','" "');
--------------------------------------------------------
--  Constraints for Table ITEMS
--------------------------------------------------------

  ALTER TABLE "SYS"."ITEMS" ADD PRIMARY KEY ("ID") DISABLE;
  ALTER TABLE "SYS"."ITEMS" ADD CHECK (active in (0,1)) DISABLE;
  ALTER TABLE "SYS"."ITEMS" MODIFY ("CATEGORY" NOT NULL DISABLE);
  ALTER TABLE "SYS"."ITEMS" MODIFY ("PRICE" NOT NULL DISABLE);
  ALTER TABLE "SYS"."ITEMS" MODIFY ("DESCRIPTION" NOT NULL DISABLE);
  ALTER TABLE "SYS"."ITEMS" MODIFY ("ITEMNAME" NOT NULL DISABLE);
  ALTER TABLE "SYS"."ITEMS" MODIFY ("ID" NOT NULL DISABLE);
