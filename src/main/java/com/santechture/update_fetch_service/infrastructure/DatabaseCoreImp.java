package com.santechture.update_fetch_service.infrastructure;

import com.santechture.update_fetch_service.model.core.Column;
import com.santechture.update_fetch_service.model.core.Table;
import com.sun.istack.Nullable;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service("DatabaseCore")
public class DatabaseCoreImp implements DatabaseCore {

    private Connection jdbcConnection;//= DriverManager.getConnection("", "", "");


    @Override
    public List<Table> getDBTables(String url, String userName, String password, @Nullable String catalog) throws SQLException {
        jdbcConnection = DriverManager.getConnection(url, userName, password);
        DatabaseMetaData md = jdbcConnection.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(catalog, "dbo", "%", types);
        ResultSet colRs = md.getColumns(catalog, "dbo", "%", null);
        List<Table> tables = new ArrayList<>();
        String currentTableName = "";
        List<Column> cols = new ArrayList<>();
        String databaseName = "";
        String schemaType = "";
        String tableType = "";
        while (colRs.next()) {
            if (currentTableName == "") {
                currentTableName = colRs.getString(3);
                databaseName = colRs.getString(1);
                schemaType = colRs.getString(2);
            }
            if (!currentTableName.equals(colRs.getString(3))) {
                tables.add(new Table(databaseName, schemaType, currentTableName, tableType, cols));
                currentTableName = colRs.getString(3);
                databaseName = colRs.getString(1);
                schemaType = colRs.getString(2);

                cols = new ArrayList<>();
            }

            cols.add(new Column(colRs.getString(4), colRs.getString(6), colRs.getString(7)));


            // tables.add(new Table(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return tables;
    }
}
