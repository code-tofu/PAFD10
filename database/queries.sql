-- QUERIES PERFORMED FOR CHECKS:

--TASK 2
SELECT styles.id AS style_id, styles.style_name AS style_name, COUNT(beers.style_id) AS beer_count FROM beers JOIN styles ON beers.style_id=styles.id GROUP BY beers.style_id ORDER BY beer_count DESC, style_name ASC;


