-- cqlsh < initialize.sql
-- http://cassandra.apache.org/doc/cql/CQL.html#ConsistencyLevel
-------------------------------------------------------------------------------------
-- DROP KEYSPACE DROP keyspace2; 
CREATE KEYSPACE keyspace2 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
-------------------------------------------------------------------------------------
USE keyspace2;

-- DROP TABLE bigtable;
CREATE TABLE bigtable
(
   key1 varchar,
   val1 varchar,
   val2 varchar,
   val3 varchar,
   counter int,
   PRIMARY KEY (key1)
);

DESCRIBE KEYSPACE keyspace2;
-------------------------------------------------------------------------------------
