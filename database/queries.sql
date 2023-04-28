-- QUERIES PERFORMED FOR CHECKS/QUERIES TO TEST JDBCTEMPLATE

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

mysql> desc breweries_geocode;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int          | NO   | PRI | NULL    | auto_increment |
| brewery_id | int          | NO   | MUL | 0       |                |
| latitude   | float        | NO   |     | 0       |                |
| longitude  | float        | NO   |     | 0       |                |
| accuracy   | varchar(255) | NO   |     |         |                |
+------------+--------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

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


--TASK 2
SELECT styles.id AS style_id, styles.style_name AS style_name, COUNT(beers.style_id) AS beer_count FROM beers JOIN styles ON beers.style_id=styles.id GROUP BY beers.style_id ORDER BY beer_count DESC, style_name ASC;

--TASK 3
SELECT id FROM styles WHERE style_name = 'American-Style Pale Ale'; --26

SELECT id FROM styles WHERE style_name = 'Belgian-Style Quadrupel'; --62

SELECT id FROM styles WHERE style_name = 'American-Style India Pale Ale'; --31

SELECT beers.id AS beer_id, beers.name AS beer_name, beers.descript AS beer_description, beers.brewery_id AS brewery_id, breweries.name AS brewery_name FROM beers JOIN breweries ON beers.brewery_id=breweries.id WHERE beers.style_id = 31 ORDER BY beer_name limit 5 ;

-- TASK 4

SELECT
    breweries.name AS brewery_name,
    breweries.descript AS brewery_description,
    breweries.address1,
    breweries.address2, 
    breweries.city,
    breweries.phone,
    breweries.website,
    beers.id AS beer_id,
    beers.name AS beer_name,
    beers.descript AS beer_description
from breweries JOIN beers on breweries.id=beers.brewery_id
WHERE breweries.id = 2 ORDER BY beer_name ASC LIMIT 1;


SELECT name, descript FROM beers AS description WHERE brewery_id = 2 ORDER BY name;
SELECT COUNT(name) FROM beers WHERE brewery_id = 2;
SELECT name FROM breweries WHERE id = 2;
SELECT name FROM beers where id = 3985;