CREATE TABLE product (
  product_id          SERIAL          PRIMARY KEY,
  product_code        VARCHAR(16)     UNIQUE,
  category_id         INTEGER         REFERENCES tblist_elm(elm_id),
  product_name        VARCHAR(100)    NOT NULL,
  producer_id         INTEGER         REFERENCES producers(producer_id),
  producer_price      REAL            DEFAULT 0 CHECK (producer_price >= 0)
);

CREATE TABLE stock_product (
  id                  SERIAL          PRIMARY KEY,
  product_id          INTEGER         REFERENCES product(product_id),
  stock_id            INTEGER         REFERENCES stocks(stock_id),
  number_available    INTEGER         DEFAULT 0,
  price               REAL            CHECK (price >= 0)
);