-- ------------------------------------------------------------------------------------------------- --
-- DROP KEYSPACE DROP keyspace2; 
-- CREATE KEYSPACE test WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
-- ------------------------------------------------------------------------------------------------- --
-- USE test;

DROP TABLE test.movie;
CREATE TABLE test.movie 
(
    title text, 
    year  int, 
    description text, 
    rating text,
    PRIMARY KEY (title)
);

DESCRIBE KEYSPACE test;
-- ------------------------------------------------------------------------------------------------- --
