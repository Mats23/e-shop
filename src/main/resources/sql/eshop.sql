

CREATE SEQUENCE category_id_seq;
CREATE SEQUENCE establishment_id_seq;
CREATE SEQUENCE establishment_type_id_seq;
CREATE SEQUENCE client_establishment_id_seq;
CREATE SEQUENCE image_id_seq;
CREATE SEQUENCE product_id_seq;
CREATE SEQUENCE client_id_seq;
CREATE SEQUENCE neighborhood_id_seq;




CREATE TABLE "NEIGHBORHOOD" (
	"ID_NEIGHBORHOOD" integer NOT NULL UNIQUE DEFAULT nextval('neighborhood_id_seq'),
	"NAME" varchar(255) NOT NULL,
	"CREATED_AT" TIMESTAMP(0) NOT NULL,
	"UPDATE_AT" TIMESTAMP(0) NOT NULL,
	CONSTRAINT "NEIGHBORHOOD_pk" PRIMARY KEY ("ID_NEIGHBORHOOD")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "CLIENT" (
	"ID_CLIENT" integer NOT NULL UNIQUE DEFAULT nextval('client_establishment_id_seq'),
	"NAME" varchar(255),
	"EMAIL" varchar(100) NOT NULL,
	"PASSWORD" varchar(100),
	"CREATED_AT" TIMESTAMP(0) NOT NULL,
	"UPDATE_AT" TIMESTAMP(0) NOT NULL,
	CONSTRAINT "CLIENT_pk" PRIMARY KEY ("ID_CLIENT")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ESTABLISHMENT_TYPE" (
	"ID_TYPE" integer NOT NULL UNIQUE DEFAULT nextval('establishment_type_id_seq'),
	"NAME" varchar(100),
	"CREATED_AT" TIMESTAMP(0) NOT NULL,
	"UPDATE_AT" TIMESTAMP(0) NOT NULL,
	CONSTRAINT "ESTABLISHMENT_TYPE_pk" PRIMARY KEY ("ID_TYPE")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "ESTABLISHMENT" (
	"ID_ESTABLISHMENT" integer NOT NULL UNIQUE DEFAULT nextval('establishment_id_seq'),
	"NAME" varchar(255),
	"ID_ESTABLISHMENT_TYPE" int NOT NULL UNIQUE,
	"CONTACT" varchar(45),
	"ADRESS" varchar(150),
	"CREATED_AT" TIMESTAMP(0) NOT NULL,
	"UPDATE_AT" TIMESTAMP(0) NOT NULL,
	"ID_CATEGORY" int NOT NULL UNIQUE,
	"ID_NEIGHBORHOOD" int NOT NULL UNIQUE,
	CONSTRAINT "ESTABLISHMENT_pk" PRIMARY KEY ("ID_ESTABLISHMENT")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "CATEGORY" (
	"ID_CATEGORY" integer NOT NULL UNIQUE DEFAULT nextval('category_id_seq'),
	"NAME" varchar(255),
	"CREATED_AT" TIMESTAMP(0) NOT NULL,
	"UPDATE_AT" TIMESTAMP(0) NOT NULL,
	CONSTRAINT "CATEGORY_pk" PRIMARY KEY ("ID_CATEGORY")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "CLIENT_ESTABLISHMENT" (
	"ID_CLIENT_ESTABLISHMENT" integer NOT NULL UNIQUE DEFAULT nextval('client_establishment_id_seq'),
	"ID_CLIENT" int NOT NULL UNIQUE,
	"ID_ESTABLISHMENT" int NOT NULL UNIQUE,
	"CREATED_AT" TIMESTAMP NOT NULL,
	"UPDATE_AT" TIMESTAMP NOT NULL,
	CONSTRAINT "CLIENT_ESTABLISHMENT_pk" PRIMARY KEY ("ID_CLIENT_ESTABLISHMENT")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "IMAGE" (
	"ID_IMAGE" integer NOT NULL UNIQUE DEFAULT nextval('image_id_seq'),
	"NAME" varchar(500) NOT NULL,
	"TYPE" varchar(50) NOT NULL,
	"ID_ESTABLISHMENT" int NOT NULL UNIQUE,
	"CREATED_AT" TIMESTAMP NOT NULL,
	"UPDATE_AT" TIMESTAMP NOT NULL,
	CONSTRAINT "IMAGE_pk" PRIMARY KEY ("ID_IMAGE")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "PRODUCT" (
	"ID_PRODUCT" integer NOT NULL UNIQUE DEFAULT nextval('product_id_seq'),
	"NAME" varchar(400) NOT NULL,
	"PRICE" DECIMAL NOT NULL,
	"AMOUNT" bigint NOT NULL,
	"DESCRIPTION" varchar(500) NOT NULL,
	"CREATED_AT" TIMESTAMP NOT NULL,
	"UPDATE_AT" TIMESTAMP NOT NULL,
	"ID_ESTABLISHMENT" bigint NOT NULL UNIQUE,
	CONSTRAINT "PRODUCT_pk" PRIMARY KEY ("ID_PRODUCT")
) WITH (
  OIDS=FALSE
);






ALTER TABLE "ESTABLISHMENT" ADD CONSTRAINT "ESTABLISHMENT_fk0" FOREIGN KEY ("ID_ESTABLISHMENT_TYPE") REFERENCES "ESTABLISHMENT_TYPE"("ID_TYPE");
ALTER TABLE "ESTABLISHMENT" ADD CONSTRAINT "ESTABLISHMENT_fk1" FOREIGN KEY ("ID_CATEGORY") REFERENCES "CATEGORY"("ID_CATEGORY");
ALTER TABLE "ESTABLISHMENT" ADD CONSTRAINT "ESTABLISHMENT_fk2" FOREIGN KEY ("ID_NEIGHBORHOOD") REFERENCES "NEIGHBORHOOD"("ID_NEIGHBORHOOD");


ALTER TABLE "CLIENT_ESTABLISHMENT" ADD CONSTRAINT "CLIENT_ESTABLISHMENT_fk0" FOREIGN KEY ("ID_CLIENT") REFERENCES "CLIENT"("ID_CLIENT");
ALTER TABLE "CLIENT_ESTABLISHMENT" ADD CONSTRAINT "CLIENT_ESTABLISHMENT_fk1" FOREIGN KEY ("ID_ESTABLISHMENT") REFERENCES "ESTABLISHMENT"("ID_ESTABLISHMENT");

ALTER TABLE "IMAGE" ADD CONSTRAINT "IMAGE_fk0"  FOREIGN KEY ("ID_ESTABLISHMENT") REFERENCES "ESTABLISHMENT"("ID_ESTABLISHMENT_TYPE");

ALTER TABLE "PRODUCT" ADD CONSTRAINT "PRODUCT_fk0"  FOREIGN KEY ("ID_ESTABLISHMENT") REFERENCES "ESTABLISHMENT"("ID_ESTABLISHMENT");

