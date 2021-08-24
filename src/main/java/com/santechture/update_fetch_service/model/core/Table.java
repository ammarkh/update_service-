package com.santechture.update_fetch_service.model.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private String databaseName;
    private String schemaType;
    private String tableName;
    private String tableType;
    List<Column> cols;
}
