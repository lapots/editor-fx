package com.lapots.breed.editor.util;

public class StringUtils {

    public static String defaultIfBlank(String field, String defaultValue) {
        return isBlank(field) ? defaultValue : field;
    }

    // TODO: move to IntegerUtils or NumberUtils?
    public static int defaultIfBlank(String field, int defaultValue) {
        return isBlank(field) ? defaultValue : Integer.valueOf(field.split("\\.", 2)[0]);
    }

    public static boolean isBlank(String field) {
        return field == null || "".equals(field.trim());
    }
}
