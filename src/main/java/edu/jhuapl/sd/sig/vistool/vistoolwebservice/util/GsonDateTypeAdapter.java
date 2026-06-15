package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_DATE_FORMAT;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT;
import static edu.jhuapl.sd.sig.vistool.vistoolwebservice.util.VistoolUtilities.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLISECOND_DATE_FORMAT;

// Taken from Stack Overflow: https://stackoverflow.com/questions/19242940/configure-gson-to-use-several-date-formats
// NOTE: This will be re-implemented in IST Common. This is a temporary implementation.
public class GsonDateTypeAdapter implements JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        try {
            String j = json.getAsJsonPrimitive().getAsString();
            return parseDate(j);
        } catch (ParseException e) {
            throw new JsonParseException(e.getMessage(), e);
        }
    }

    private Date parseDate(String dateString) throws ParseException {
        if (dateString != null && dateString.trim().length() > 0) {
            try {
                return YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLISECOND_DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                try {
                    return YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT.parse(dateString);
                } catch (ParseException pe2) {
                    return YEAR_MONTH_DAY_DATE_FORMAT.parse(dateString);
                }
            }
        } else {
            return null;
        }
    }
}