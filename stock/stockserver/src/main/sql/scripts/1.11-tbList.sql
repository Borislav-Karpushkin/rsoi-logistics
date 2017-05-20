DROP TABLE IF EXISTS TBLIST;
DROP TABLE IF EXISTS TBLIST_ELM;
CREATE TABLE TBLIST
(
	list_id       SERIAL            NOT NULL,
	title         VARCHAR(100)      NOT NULL,
	description   VARCHAR(1000),
	reference_id  VARCHAR(100)      NOT NULL
)
;


CREATE TABLE TBLIST_ELM
(
	elm_id        SERIAL            NOT NULL,
	title         VARCHAR(200)      NOT NULL,
	short_name    VARCHAR(200),
	reference_id  VARCHAR(100)      NOT NULL,
	state         SMALLINT,
	position      INTEGER,
	depth         SMALLINT,
	description   VARCHAR(200),
	list_id       INTEGER           NOT NULL,
	parent_id     INTEGER
)
;

ALTER TABLE TBLIST ADD CONSTRAINT PK_List
	PRIMARY KEY (list_id)
;

ALTER TABLE TBLIST_ELM ADD CONSTRAINT PK_TBList_Elm
	PRIMARY KEY (elm_id)
;


ALTER TABLE TBLIST
	ADD CONSTRAINT UQ_TBList_reference_id UNIQUE (reference_id)
;

ALTER TABLE TBLIST_ELM
	ADD CONSTRAINT UQ_TBList_Elm_reference_id UNIQUE (list_id, reference_id)
;


ALTER TABLE TBLIST_ELM ADD CONSTRAINT FK_TBList_Elm_TBList_Elm
	FOREIGN KEY (parent_id) REFERENCES TBLIST_ELM (elm_id)
;
