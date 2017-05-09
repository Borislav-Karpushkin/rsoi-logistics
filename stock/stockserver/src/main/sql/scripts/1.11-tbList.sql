CREATE TABLE tblist (
    list_id             SERIAL                      PRIMARY KEY,
    reference_id        character varying(50)       UNIQUE NOT NULL,
    title               character varying(100)      NOT NULL,
    description         character varying(100)      NOT NULL
);

CREATE TABLE tblist_elm (
    elm_id              SERIAL                      PRIMARY KEY,
    list_id             INTEGER                     REFERENCES tblist(list_id),
    reference_id        character varying(50)       UNIQUE NOT NULL,
    title               character varying(100)      NOT NULL,
    description         character varying(100)      NOT NULL
);