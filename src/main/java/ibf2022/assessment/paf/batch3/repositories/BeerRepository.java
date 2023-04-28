package ibf2022.assessment.paf.batch3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.assessment.paf.batch3.models.Beer;
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
        System.out.println(styleList.size());
        return styleList;
    }

    // DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
    public List<Beer> getBreweriesByBeer(/* You can add any number parameters here */) {
        // TODO: Task 3

        return null;
    }

    // DO NOT CHANGE THE METHOD'S NAME OR THE RETURN TYPE OF THIS METHOD
    public Optional<Brewery> getBeersFromBrewery(/* You can add any number of parameters here */) {
        // TODO: Task 4

        return Optional.empty();
    }
}
