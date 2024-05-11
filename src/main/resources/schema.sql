DROP TABLE IF EXISTS markets;

CREATE TABLE markets
(
    id INTEGER PRIMARY KEY auto_increment,
    code VARCHAR(255),
    description VARCHAR(255),
    country VARCHAR(255)
);

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
    id INTEGER PRIMARY KEY auto_increment,
    description VARCHAR(255),
    market_id INTEGER,
    FOREIGN KEY (market_id) REFERENCES markets(id)
);

DROP TABLE IF EXISTS transactions;

CREATE TABLE transactions
(
    id INTEGER PRIMARY KEY auto_increment,
    description VARCHAR(255),
    amount INTEGER,
    operationType VARCHAR(255),
    account_id INTEGER,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

ALTER TABLE markets ADD COLUMN account_id INTEGER;
ALTER TABLE markets ADD CONSTRAINT market_account FOREIGN KEY (account_id) REFERENCES accounts(id);

ALTER TABLE accounts ADD COLUMN (transaction_id INTEGER);
ALTER TABLE accounts ADD CONSTRAINT transaction_account FOREIGN KEY (transaction_id) REFERENCES transactions(id);


