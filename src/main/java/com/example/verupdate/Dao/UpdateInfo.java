package com.example.verupdate.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//定义了一个结构体
public class UpdateInfo {
    private Integer id;
    private Integer update_id;
    private Character type;
    private Integer update_kind_name_id;
    private String update_content;
}

