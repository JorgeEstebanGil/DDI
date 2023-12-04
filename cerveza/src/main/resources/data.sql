
-- BEGIN: Insert into BREWERY_NEW
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva1');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva2');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva3');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva4');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva5');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva6');
-- END: Insert into BREWERY_NEW

-- BEGIN: Insert into BREWERY_OLD
INSERT INTO BREWERY_OLD (nombre) VALUES ('old1');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old2');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old3');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old4');
-- END: Insert into BREWERY_OLD

-- BEGIN: Insert into BEER
INSERT INTO BEER (nombre, anoLanzamiento, brewery_new, brewery_old) VALUES ('cerveza1', 2001, 1, null);
INSERT INTO BEER (nombre, anoLanzamiento, brewery_new, brewery_old) VALUES ('cerveza2', 2023, 2, null);
INSERT INTO BEER (nombre, anoLanzamiento, brewery_new, brewery_old) VALUES ('cerveza3', 1999, null, 1);
INSERT INTO BEER (nombre, anoLanzamiento, brewery_new, brewery_old) VALUES ('cerveza4', 1898, null, 3);
INSERT INTO BEER (nombre, anoLanzamiento, brewery_new, brewery_old) VALUES ('cerveza5', 2006, 1, null);
-- END: Insert into BEER
