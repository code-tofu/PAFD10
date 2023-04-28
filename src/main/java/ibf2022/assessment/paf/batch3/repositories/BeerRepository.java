package ibf2022.assessment.paf.batch3.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
import ibf2022.assessment.paf.batch3.models.BeerMapper;
import ibf2022.assessment.paf.batch3.models.Brewery;
import ibf2022.assessment.paf.batch3.models.Style;
import ibf2022.assessment.paf.batch3.models.StyleMapper;

import static ibf2022.assessment.paf.batch3.repositories.DBQueries.*;

@Repository
public class BeerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // Task 2: DO NOT CHANGE THE SIGNATURE OF THIS METHOD
    public List<Style> getStyles() {
        List<Style> styleList = jdbcTemplate.query(SELECT_ALL_STYLES_COUNT, new StyleMapper());
        // System.out.println(styleList.size());
        return styleList;
    }

    // Task 3: DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
    public List<Beer> getBreweriesByBeer(int styleID) {
        // int styleID = getStyleIDbyStyleName(styleName);
        List<Beer> beerList = jdbcTemplate.query(SELECT_BEERS_BY_STYLENAME, new BeerMapper(), styleID);
        // System.out.println(beerList.size());
        return beerList;
    }

    // Task 4: DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
    public Optional<Brewery> getBeersFromBrewery(int breweryID) {
        /*
         * Although memory inefficient (sql rowset contains repeated fields per type of
         * beer), instruction is to use SINGLE SQL query, hence implementation as below
         */
        Brewery brewery = new Brewery();
        List<Beer> beerList = new LinkedList<>();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SELECT_BEERS_FROM_BREWERY, breweryID);
        if (rs.next()) {
            brewery.setAddress1(rs.getString("address1"));
            brewery.setAddress2(rs.getString("address2"));
            brewery.setBreweryId(breweryID);
            brewery.setCity(rs.getString("city"));
            brewery.setDescription(rs.getString("brewery_description"));
            brewery.setName(rs.getString("brewery_name"));
            brewery.setPhone(rs.getString("phone"));
            brewery.setWebsite(rs.getString("website"));

            Beer newBeer = new Beer();
            newBeer.setBeerId(rs.getInt("beer_id"));
            newBeer.setBeerName(rs.getString("beer_name"));
            newBeer.setBeerDescription(rs.getString("beer_description"));
            beerList.add(newBeer);
            // beer.breweryId and beer.breweryName fields not filled to save memory
        } else {
            return Optional.empty();
        }
        while (rs.next()) {
            Beer newBeer = new Beer();
            newBeer.setBeerId(rs.getInt("beer_id"));
            newBeer.setBeerName(rs.getString("beer_name"));
            newBeer.setBeerDescription(rs.getString("beer_description"));
            beerList.add(newBeer);
        }
        brewery.setBeers(beerList);
        // System.out.println(beerList.size());
        return Optional.of(brewery);

    }

    // TASK 3: DEPRECATED
    // public int getStyleIDbyStyleName(String styleName) {
    // try {
    // int styleID = jdbcTemplate.queryForObject(SELECT_STYLEID_BY_STYLENAME,
    // Integer.class, styleName);
    // System.out.println(styleName + "-id:" + styleID);
    // return styleID;
    // } catch (EmptyResultDataAccessException NotFoundErr) {
    // return -1;
    // }
    // }
}
