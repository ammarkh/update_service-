package com.santechture.update_fetch_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DbConnection {
    private String url;
    private String username;
    private String password;
    private String catalog;
}
