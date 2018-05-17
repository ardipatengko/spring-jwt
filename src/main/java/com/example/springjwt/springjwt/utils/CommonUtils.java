package com.example.springjwt.springjwt.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class CommonUtils {

    CommonUtils(){

    }

    public static <T> CommonResponse<T> generateCommonResponse(T t){
        CommonResponse<T> commonResponse = new CommonResponse<>();
        commonResponse.setData(t);
        CommonStatus commonStatus = new CommonStatus();
        commonStatus.setResponseCode("200");
        commonStatus.setResponseDesc("SUCCESS");
        commonResponse.setCommonStatus(commonStatus);
        return commonResponse;
    }

    public static String generateJson(Object object) throws JsonProcessingException {
        ObjectWriter writer = generateDefaultJsonWriter();
        return writer.writeValueAsString(object);
    }

    public static ObjectWriter generateDefaultJsonWriter() {
        return generateDefaultJsonMapper().writer();
    }

    public static ObjectMapper generateDefaultJsonMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        SimpleFilterProvider simpleFilter = new SimpleFilterProvider();
        simpleFilter.setFailOnUnknownId(false);
        om.setFilterProvider(simpleFilter);
        return om;
    }
}
