package ibf2022.assessment.paf.batch3.repositories;

public class DBQueries {

    // TASK2
    public static final String SELECT_ALL_STYLES_COUNT = "SELECT styles.id AS style_id, styles.style_name AS style_name, COUNT(beers.style_id) AS beer_count FROM beers JOIN styles ON beers.style_id=styles.id GROUP BY beers.style_id ORDER BY beer_count DESC, style_name ASC;";

    // TASK3
    public static final String SELECT_STYLEID_BY_STYLENAME = "SELECT id FROM styles WHERE style_name = ?";
    public static final String SELECT_BEERS_BY_STYLENAME = "SELECT beers.id AS beer_id, beers.name AS beer_name, beers.descript AS beer_description, beers.brewery_id AS brewery_id, breweries.name AS brewery_name FROM beers JOIN breweries ON beers.brewery_id=breweries.id WHERE beers.style_id = ? ORDER BY beer_name ASC;";

    // TASK4
    public static final String SELECT_BEERS_FROM_BREWERY = """
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
            WHERE breweries.id = ? ORDER BY beer_name ASC;
                """;
}
