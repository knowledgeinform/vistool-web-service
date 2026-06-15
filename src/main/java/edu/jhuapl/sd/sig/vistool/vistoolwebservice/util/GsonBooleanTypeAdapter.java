package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import com.google.gson.*;

import java.lang.reflect.Type;

// Taken from Stack Overflow: https://stackoverflow.com/questions/27176134/gson-integer-to-boolean-for-specific-fields
// NOTE: This will be re-implemented in IST Common. This is a temporary implementation.
public class GsonBooleanTypeAdapter implements JsonDeserializer<Boolean> {
    public Boolean deserialize(JsonElement json, Type typeOfT,
                               JsonDeserializationContext context) throws JsonParseException {
        if (((JsonPrimitive) json).isBoolean()) {
            return json.getAsBoolean();
        }
        if (((JsonPrimitive) json).isString()) {
            String jsonValue = json.getAsString();
            if (jsonValue.equalsIgnoreCase("true")) {
                return true;
            } else if (jsonValue.equalsIgnoreCase("false")) {
                return false;
            } else {
                return null;
            }
        }

        int code = json.getAsInt();
        return code == 0 ? false :
                code == 1 ? true : null;
    }
}