package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {

    public static final String SELECT_ALL_STYLES_COUNT = "SELECT styles.id AS style_id, styles.style_name AS style_name, COUNT(beers.style_id) AS beer_count FROM beers JOIN styles ON beers.style_id=styles.id GROUP BY beers.style_id ORDER BY beer_count DESC, style_name ASC;";

}
