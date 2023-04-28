-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files


--  show databases;


-- CREATE DATABASE brewery;
-- OR: to follow railway naming convention:
CREATE DATABASE railway;
SHOW databases;
use railway;

source C:/Users/ftc_b/GIT/PAFD10/database/beers.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/breweries.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/categories.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/geocodes.sql;
source C:/Users/ftc_b/GIT/PAFD10/database/styles.sql;

