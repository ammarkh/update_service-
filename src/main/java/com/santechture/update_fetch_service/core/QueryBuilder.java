package com.santechture.update_fetch_service.core;

import java.util.*;

/**
 * class QueryBuilder that responsible on build the query for sql file.
 * contains insert for insert query
 * update for update query
 * delete for delete query
 */

public class QueryBuilder {

    private String queryStatement = "";

    public String insert(String table, String[] _cols, String[] _val) {
        queryStatement = "Insert into " + table + " (";
        // cols = Arrays.asList(_cols.clone());
        Arrays.asList(_cols.clone()).stream().forEach((key) -> queryStatement += key + ", ");
        queryStatement = queryStatement.substring(0, queryStatement.length() - 2) + ") values (";

        Arrays.asList(_val.clone()).stream().forEach((val) -> queryStatement += val + ", ");

        return queryStatement.substring(0, queryStatement.length() - 2) + ");";
    }

    public String update(String table, Map<String, String> data, String colRef, String colVal) {
        queryStatement = "Update " + table + " Set ";

        Set set = data.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            queryStatement += entry.getKey() + "=" + entry.getValue() + ", ";
        }
        queryStatement = queryStatement.substring(0, queryStatement.length() - 2);
        queryStatement += " Where " + colRef + " = " + colVal + ";";
        return queryStatement;
    }

    public String delete(String table, String colRef, String colVal) {
        return "Delete From " + table + " Where " + colRef + " = " + colVal + ";";
    }

    public String select(String table, String[] _cols, String[] _val, String colRef, String colVal) {
        queryStatement = "Select (";
        Arrays.asList(_cols.clone()).stream().forEach((key) -> queryStatement += key + ", ");
        queryStatement = queryStatement.substring(0, queryStatement.length() - 2) + ") From " + table;

        queryStatement = (colRef != "") ? queryStatement += " where " + colRef + " = " + colVal : "";
        return queryStatement;
    }
}
