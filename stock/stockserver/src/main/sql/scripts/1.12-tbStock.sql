CREATE TABLE stocks (
  stock_id            SERIAL                  PRIMARY KEY,
  full_name           character varying(100)  UNIQUE,
  short_name          character varying(100)  ,
  address             character varying(100)  NOT NULL,
  category_id         INTEGER                 REFERENCES tblist_elm(elm_id),
  organization_name   character varying(100)
);