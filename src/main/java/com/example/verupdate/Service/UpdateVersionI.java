package com.example.verupdate.Service;

import com.example.verupdate.Dao.OneVersion;
import com.example.verupdate.Dao.UpdateInfo;
import com.example.verupdate.Dao.UpdateVersion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UpdateVersionI {
    public UpdateVersion queryOneVersion(Integer id);

    public List<UpdateVersion> getAllVersionId();
}
