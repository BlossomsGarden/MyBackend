package com.example.verupdate.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//定义了一个结构体
public class UpdateInfo {
    public Integer id;
    public Integer update_id;
    public Character type;
    public Integer update_kind_name_id;
    public String update_content;
    public UpdateKindNameMap updateKindNameMap;
}

