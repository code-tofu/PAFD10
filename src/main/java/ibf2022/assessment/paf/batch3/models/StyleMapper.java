package ibf2022.assessment.paf.batch3.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StyleMapper implements RowMapper<Style> {

    @Override
    public Style mapRow(ResultSet styleRowset, int rowNum) throws SQLException {
        Style newStyle = new Style();
        newStyle.setStyleId(styleRowset.getInt("style_id"));
        newStyle.setName(styleRowset.getString("style_name"));
        newStyle.setBeerCount(styleRowset.getInt("beer_count"));
        return newStyle;
    }

}

/*
 * private int styleId;
 * private String name;
 * private int beerCount;
 */