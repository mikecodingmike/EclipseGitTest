CREATE OR REPLACE PROCEDURE PRC_CREATE_BANKACCOUNT IS
    V_COUNT     NUMBER;
BEGIN
    SELECT COUNT(*) INTO V_COUNT
    FROM ALL_TABLES
    WHERE   OWNER = 'DEMO' AND
            TABLE_NAME = 'BANKACCOUNT';
    IF V_COUNT = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE BANKACCOUNT(
                                ACCOUNTNUMBER   INTEGER          NOT NULL    PRIMARY KEY,
                                FIRSTNAME       VARCHAR(20)      NOT NULL,
                                OPENINGDATE     DATE             NOT NULL,
                                AMOUNT          DECIMAL(10,2)    NOT NULL,
                                CREDITLIMIT     DECIMAL(10,2)    NOT NULL
                            )';
    END IF;
    SELECT COUNT(*) INTO V_COUNT
    FROM ALL_SEQUENCES
    WHERE   SEQUENCE_OWNER = 'DEMO' AND
            SEQUENCE_NAME = 'SEQ_ACCOUNTNUMBER';
    IF V_COUNT = 0 THEN
        EXECUTE IMMEDIATE 'CREATE SEQUENCE SEQ_ACCOUNTNUMBER
                            START WITH 1000
                            INCREMENT BY 1
                            CACHE 20';
        COMMIT;
    END IF;
END PRC_CREATE_BANKACCOUNT;