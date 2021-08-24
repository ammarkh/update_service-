package com.santechture.update_fetch_service.dto;

import com.santechture.update_fetch_service.model.core.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TableDTO {
    private String databaseName;
    private String schemaType;
    private String  tableName;
    private String auditName;
    private String colRef;
    private String tableType;
    List<Column> cols;
}
