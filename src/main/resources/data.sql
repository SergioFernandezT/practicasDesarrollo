INSERT INTO markets(id,code,description,country,account_id)
VALUES (DEFAULT,'ROFEX','DEMO ', 'ARGENTINA',null),
       (DEFAULT,'MAE'  ,'DEMO ', 'ARGENTINA',null),
       (DEFAULT,'MAE'  ,'DEMO ', 'ARGENTINA',null),
       (DEFAULT,'ROFEX','DEMO ', 'ARGENTINA',null),
       (DEFAULT,'MAE'  ,'DEMO ', 'ARGENTINA',null);

INSERT INTO transactions(id,description,amount,operationType,account_id)
VALUES (DEFAULT,'Demo Transaction', 120000,DEFAULT,null),
       (DEFAULT,'Demo Transaction',  90000,'EXTRACCION',null);

INSERT INTO accounts(id,description,market_id,transaction_id)
VALUES (DEFAULT,'Demo ACCOUNT', NULL,NULL),
       (DEFAULT,'Demo ACCOUNT', NULL,NULL);