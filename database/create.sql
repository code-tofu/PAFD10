-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files


--  show databases;


-- create database brewery;
-- OR: to follow railway naming convention:
CREATE DATABASE railway;
SHOW databases;
use railway;

source C:/Users/ftc_b/GIT/PAFD10/database/beers.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/breweries.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/categories.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/geocodes.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/styles.sql;

-- to view that tables have been imported
SHOW tables;

-- to inspect tables;
desc beers;
desc breweries;
desc categories;
desc breweries_geocode;
desc styles;

-- to view table data;
SELECT * FROM beers LIMIT 5;
SELECT * FROM breweries LIMIT 5;
SELECT * FROM categories LIMIT 5;
SELECT * FROM breweries_geocode LIMIT 5;
SELECT * FROM styles LIMIT 5;

/*
mysql> show tables;
+-------------------+
| Tables_in_railway |
+-------------------+
| beers             |
| breweries         |
| breweries_geocode |
| categories        |
| styles            |
+-------------------+
5 rows in set (0.00 sec)

mysql> desc beers;
+------------+--------------+------+-----+---------------------+----------------+
| Field      | Type         | Null | Key | Default             | Extra          |
+------------+--------------+------+-----+---------------------+----------------+
| id         | int          | NO   | PRI | NULL                | auto_increment |
| brewery_id | int          | NO   | MUL | 0                   |                |
| name       | varchar(255) | NO   |     |                     |                |
| cat_id     | int          | NO   | MUL | 0                   |                |
| style_id   | int          | NO   | MUL | 0                   |                |
| abv        | float        | NO   |     | 0                   |                |
| ibu        | float        | NO   |     | 0                   |                |
| srm        | float        | NO   |     | 0                   |                |
| upc        | int          | NO   |     | 0                   |                |
| filepath   | varchar(255) | NO   |     |                     |                |
| descript   | text         | NO   |     | NULL                |                |
| add_user   | int          | NO   |     | 0                   |                |
| last_mod   | datetime     | NO   |     | 0000-00-00 00:00:00 |                |
+------------+--------------+------+-----+---------------------+----------------+
13 rows in set (0.00 sec)

mysql> desc breweries;
+----------+--------------+------+-----+---------------------+----------------+
| Field    | Type         | Null | Key | Default             | Extra          |
+----------+--------------+------+-----+---------------------+----------------+
| id       | int          | NO   | PRI | NULL                | auto_increment |
| name     | varchar(255) | NO   |     |                     |                |
| address1 | varchar(255) | NO   |     |                     |                |
| address2 | varchar(255) | NO   |     |                     |                |
| city     | varchar(255) | NO   |     |                     |                |
| state    | varchar(255) | NO   |     |                     |                |
| code     | varchar(25)  | NO   |     |                     |                |
| country  | varchar(255) | NO   |     |                     |                |
| phone    | varchar(50)  | NO   |     |                     |                |
| website  | varchar(255) | NO   |     |                     |                |
| filepath | varchar(255) | NO   |     |                     |                |
| descript | text         | NO   |     | NULL                |                |
| add_user | int          | NO   |     | 0                   |                |
| last_mod | datetime     | NO   |     | 0000-00-00 00:00:00 |                |
+----------+--------------+------+-----+---------------------+----------------+
14 rows in set (0.00 sec)

mysql> desc categories;
+----------+--------------+------+-----+---------------------+----------------+
| Field    | Type         | Null | Key | Default             | Extra          |
+----------+--------------+------+-----+---------------------+----------------+
| id       | int          | NO   | PRI | NULL                | auto_increment |
| cat_name | varchar(255) | NO   |     |                     |                |
| last_mod | datetime     | NO   |     | 0000-00-00 00:00:00 |                |
+----------+--------------+------+-----+---------------------+----------------+
3 rows in set (0.00 sec)

mysql> desc geocodes;
ERROR 1146 (42S02): Table 'railway.geocodes' doesn't exist
mysql> desc styles;
+------------+--------------+------+-----+---------------------+----------------+
| Field      | Type         | Null | Key | Default             | Extra          |
+------------+--------------+------+-----+---------------------+----------------+
| id         | int          | NO   | PRI | NULL                | auto_increment |
| cat_id     | int          | NO   | MUL | 0                   |                |
| style_name | varchar(255) | NO   |     |                     |                |
| last_mod   | datetime     | NO   |     | 0000-00-00 00:00:00 |                |
+------------+--------------+------+-----+---------------------+----------------+
4 rows in set (0.00 sec)
*/