package com.example.dibootdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ChangeType {
    public static <T> String ObjectToJsonStr(List<T> object){
        ArrayList<String> resultData = new ArrayList<>();
        for (T t : object) {
            resultData.add(t.toString());
        }
        ObjectMapper om = new ObjectMapper();
        String beanJson = null;
        try {
            beanJson = om.writeValueAsString(resultData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return beanJson;
    }
}
