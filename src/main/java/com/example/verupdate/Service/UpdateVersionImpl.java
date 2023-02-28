package com.example.verupdate.Service;

import com.example.verupdate.Dao.OneVersion;
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
    public UpdateVersion queryOneVersion(Integer id){
        UpdateVersion result= updateVersionMapper.queryOneVersion(id);
        return result;
    }
    @Override
    public List<UpdateVersion> getAllVersionId(){
        return updateVersionMapper.getAllVersionId();
    }
}
