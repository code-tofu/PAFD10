package ibf2022.assessment.paf.batch3.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BeerMapper implements RowMapper<Beer> {

    @Override
    public Beer mapRow(ResultSet beerRowSet, int rowNum) throws SQLException {
        Beer newBeer = new Beer();
        newBeer.setBeerId(beerRowSet.getInt("beer_id"));
        newBeer.setBeerName(beerRowSet.getString("beer_name"));
        newBeer.setBeerDescription(beerRowSet.getString("beer_description"));
        newBeer.setBreweryId(beerRowSet.getInt("brewery_id"));
        newBeer.setBreweryName(beerRowSet.getString("brewery_name"));
        return newBeer;
    }

}

// private int beerId;
// private String beerName;
// private String beerDescription;
// private int breweryId;
// private String breweryName;
// SELECT beers.id AS beer_id, beers.name AS beer_name, beers.descript AS
// beer_description, beers.brewery_id AS brewery_id, breweries.name AS
// brewery_name FROM beers JOIN breweries ON beers.brewery_id=breweries.id WHERE
// beers.style_id = 31 ORDER BY beer_name limit 5 ;