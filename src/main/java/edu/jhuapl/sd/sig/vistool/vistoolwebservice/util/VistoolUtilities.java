package edu.jhuapl.sd.sig.vistool.vistoolwebservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.LineItem;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUser;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.model.vistool.VistoolUserRole;
import edu.jhuapl.sd.sig.vistool.vistoolwebservice.security.SecurityUtilities;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public final class VistoolUtilities {
    private VistoolUtilities(){}

    @Autowired
    private static ObjectMapper objectMapper = new ObjectMapper();

    public final static Gson GSON = new GsonBuilder().serializeNulls().create();

    public final static String MONTH_DAY_YEAR_FORMAT = "MM/dd/yyyy";
    public final static String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";
    public final static String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public final static String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLISECOND_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSSSSS";
    public final static SimpleDateFormat MONTH_DAY_YEAR_DATE_FORMAT = new SimpleDateFormat(MONTH_DAY_YEAR_FORMAT);
    public final static SimpleDateFormat YEAR_MONTH_DAY_DATE_FORMAT = new SimpleDateFormat(YEAR_MONTH_DAY_FORMAT);
    public final static SimpleDateFormat YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_DATE_FORMAT = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMAT);
    public final static SimpleDateFormat YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLISECOND_DATE_FORMAT = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_MILLISECOND_FORMAT);

    public static boolean isStringNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static VistoolUser getCurrentUser(SecurityUtilities securityUtilities) {
        Optional<VistoolUser> optionalVistoolUser = securityUtilities.getCurrentUser();
        if (optionalVistoolUser.isPresent()) {
            return optionalVistoolUser.get();
        }
        return null;
    }

    public static boolean currentUserIsAdmin(VistoolUser vistoolUser) {
        if (vistoolUser != null) {
            return VistoolUserRole.ADMIN.equals(vistoolUser.getVistoolUserRole());
        }
        return false;
    }

    public static boolean currentUserCanEdit(VistoolUser vistoolUser) {
        if (vistoolUser != null) {
            return VistoolUserRole.ADMIN.equals(vistoolUser.getVistoolUserRole())
                || VistoolUserRole.EDITOR.equals(vistoolUser.getVistoolUserRole());
        }
        return false;
    }

    public static LineItem cloneLineItem(LineItem lineItem) {
        return objectMapper.convertValue(lineItem, LineItem.class);
    }

    public static String nullToString(String stringData) {
        return (isStringNullOrEmpty(stringData)) ? "" : stringData;
    }
}