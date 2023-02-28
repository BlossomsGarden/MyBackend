package com.example.verupdate.Mapper;

import com.example.verupdate.Dao.UpdateVersion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UpdateVersionMapper {
    public UpdateVersion queryOneVersion(Integer id);
    public List<UpdateVersion> getAllVersionId();
}
