package com.santechture.update_fetch_service.infrastructure;

import com.santechture.update_fetch_service.model.core.Table;
import com.sun.istack.Nullable;

import java.sql.SQLException;
import java.util.List;


public interface DatabaseCore {

    List<Table> getDBTables(String url, String userName, String password, @Nullable String catalog) throws SQLException;

}
