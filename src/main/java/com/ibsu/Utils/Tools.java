package com.ibsu.Utils;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tools {

    private Tools() {}

    public static String getGetterName(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
    }

    public static void checkRequiredProperties(Object objectToCheck, List<String> requiredFieldList) throws Exception  {
        ArrayList errorKeywords = new ArrayList();
        Iterator it = requiredFieldList.iterator();

        while(it.hasNext()) {
            String property = (String)it.next();
            boolean isRequiredPropertyPresent = true;
            Field[] fields = objectToCheck.getClass().getDeclaredFields();
            int fieldLength = fields.length;

            for(int i = 0; i < fieldLength; ++i) {
                Field field = fields[i];
                Object value = null;

                try {
                    value = objectToCheck.getClass().getMethod(getGetterName(property), new Class[0]).invoke(objectToCheck, new Object[0]);
                } catch (Exception var12) {
                    isRequiredPropertyPresent = false;
                }

                if(value == null) {
                    isRequiredPropertyPresent = false;
                }
            }
            if(!isRequiredPropertyPresent) {
                errorKeywords.add(property + "_REQUIRED");
            }

        }

        if(errorKeywords.size() > 0) {
            throw new RuntimeException("CHECK_REQUIRED_FIELDS");
        }

    }

}
