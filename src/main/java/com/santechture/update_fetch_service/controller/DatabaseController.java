package com.santechture.update_fetch_service.controller;

import com.santechture.update_fetch_service.core.JsonWriter;
import com.santechture.update_fetch_service.dto.DbConnection;
import com.santechture.update_fetch_service.dto.TableDTO;
import com.santechture.update_fetch_service.infrastructure.DatabaseCore;
import com.santechture.update_fetch_service.model.core.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * controller for organize the operation with database
 */
@RestController
@RequestMapping("/database")
public class DatabaseController {
    @Autowired
    private DatabaseCore databaseCore;
    private JsonWriter jsonWriter = new JsonWriter("");

    /**
     * post function for call all tables want apply on it for update
     *
     * @param dbConnection class that handle database connection details url, username, password, catalog
     * @return list of table from database that related with specific catalog
     * @throws SQLException
     */
    @PostMapping("/tables")
    public List<Table> getTables(@RequestBody DbConnection dbConnection) throws SQLException {
        return databaseCore.getDBTables(dbConnection.getUrl(), dbConnection.getUsername(), dbConnection.getPassword(), dbConnection.getCatalog());
    }

    @PostMapping("/generate_json")
    public ResponseEntity generateJson(@RequestBody List<TableDTO> tables) throws IOException {
        jsonWriter.writeToFile(tables);
        return ResponseEntity.ok("json has been generated successfully");
    }
}
