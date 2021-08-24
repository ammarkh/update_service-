package com.santechture.update_fetch_service.core;

import com.santechture.update_fetch_service.dto.TableDTO;
import com.santechture.update_fetch_service.model.core.Column;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    private String filePath = "";

    public JsonWriter(String path) {
        this.filePath = path;
    }

    public void writeToFile(List<TableDTO> data) throws IOException {
        if (data.size() == 0)
            return;
        JSONArray jsonArray = new JSONArray();

        for (TableDTO currentTable : data) {
            JSONObject _json = new JSONObject();
            _json.put("databaseName", currentTable.getDatabaseName());
            _json.put("schemaType", currentTable.getSchemaType());
            _json.put("tableName", currentTable.getTableName());
            _json.put("colRef", currentTable.getColRef());
            _json.put("auditName", currentTable.getAuditName());

            JSONArray cols = new JSONArray();

            for (Column col : currentTable.getCols()) {
                JSONObject _col = new JSONObject();
                _col.put("name", col.getName());
                _col.put("type", col.getType());
                cols.add(_col);
            }
            _json.put("columns", cols); // add array of columns to table

            jsonArray.add(_json); // add object to array
        }

        write(jsonArray);

    }

    private void write(JSONArray arr) throws IOException {
        FileWriter file = new FileWriter("src/main/resources/db.json");
        file.write(arr.toJSONString());
        file.close();
    }

}
