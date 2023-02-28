package com.example.verupdate.Service;

import com.example.verupdate.Dao.UpdateInfo;
import com.example.verupdate.Dao.UpdateVersion;
import com.example.verupdate.Mapper.UpdateVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateVersionImpl implements UpdateVersionI {
    @Autowired
    UpdateVersionMapper updateVersionMapper;
    @Override
    public UpdateVersion getVersionInfo(Integer id){
        UpdateVersion result= updateVersionMapper.getVersionInfo(id);
        return result;
    }
}
