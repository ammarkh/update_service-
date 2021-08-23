package com.santechture.update_fetch_service.core;


import com.santechture.update_fetch_service.model.JsonTableObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {

    private static String jsonPath = "";
    private static List<JsonTableObject> tables = new ArrayList<>();

    public JSONReader() {
    }

    public JSONReader(String path) {
        jsonPath = path;
    }


    public List<JsonTableObject> getJson() throws IOException, ParseException {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        FileReader reader = new FileReader("C:/Users/akhalifa/Desktop/dataConf.json", StandardCharsets.UTF_8);
        Object obj = jsonParser.parse(reader);

        JSONArray confList = (JSONArray) obj;
        //Iterate over Database array
        confList.forEach(db -> parseConfObject((JSONObject) db));

        return tables;
    }

    private static void parseConfObject(JSONObject _confObject) {
        JSONArray tableList = (JSONArray) _confObject.get("tables");
        tableList.forEach(tb -> parseTableObject((JSONObject) tb));
    }

    private static void parseTableObject(JSONObject table) {
        JSONObject _table = (JSONObject) table.get("table");

        JsonTableObject tableObject = new JsonTableObject();


        tableObject.setAuditName((String) _table.get("audit"));
        tableObject.setTableName((String) _table.get("name"));
        tableObject.setColRef((String) _table.get("colRef"));
        tableObject.setColValue((String) _table.get("colVal"));

        tables.add(tableObject);
    }


}
