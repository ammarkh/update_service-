package com.santechture.update_fetch_service;


import com.santechture.update_fetch_service.core.JSONReader;
import com.santechture.update_fetch_service.core.QueryBuilder;
import com.santechture.update_fetch_service.model.JsonTableObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

@SpringBootApplication
public class UpdateFetchServiceApplication {
    private static QueryBuilder queryBuilder = new QueryBuilder();

    public static void main(String[] args) {
        SpringApplication.run(UpdateFetchServiceApplication.class, args);

        JSONReader jsonReader = new JSONReader();
        try {
            for (JsonTableObject jsonTableObject : jsonReader.getJson()) {
                System.out.println(jsonTableObject.getTableName());
                System.out.println(jsonTableObject.getAuditName());
                System.out.println(jsonTableObject.getColRef());
                System.out.println(jsonTableObject.getColValue());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//        Map<String, String> dictionary = new Hashtable<>();
//        dictionary.put("col1", "1");
//        dictionary.put("col2", "name1");
//        dictionary.put("col3", "age1");
//
//        System.out.println(queryBuilder.update("tab", dictionary, "ce1", "21"));
        //System.out.println(queryBuilder.delete("table1", "col1", "colv1"));
        //System.out.println(queryBuilder.update("table1", dictionary, "id", "3"));
        // System.out.println(queryBuilder.insert("table1",new String[]{"col1", "col2"}, new String[]{"val1", "val2"}));
        //System.out.println(queryBuilder.select("table1",new String[]{"col1", "col2"}, new String[]{"val1", "val2"}, "id", "1"));
    }

}
