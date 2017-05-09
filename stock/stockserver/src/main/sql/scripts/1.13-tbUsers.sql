CREATE TABLE employee (
    employee_id     SERIAL                  PRIMARY KEY,
    first_name      character varying(50)   NOT NULL,
    last_name       character varying(50)   NOT NULL,
    middle_name     character varying(50)   NOT NULL,
    position_id     INTEGER                 REFERENCES tblist_elm(elm_id)
    work_id         INTEGER                 REFERENCES stocks(stock_id)
);

CREATE TABLE users (
    user_id     SERIAL                  PRIMARY KEY,
    login       character varying(50)   UNIQUE NOT NULL,
    password    character varying(50)   NOT NULL,
    employee_id INTEGER                 REFERENCES employee(employee_id)
);