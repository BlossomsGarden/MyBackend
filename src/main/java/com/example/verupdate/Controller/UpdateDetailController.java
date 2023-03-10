package com.example.verupdate.Controller;


import com.example.verupdate.Dao.OneVersion;
import com.example.verupdate.Dao.Response;
import com.example.verupdate.Dao.UpdateKindNameMap;
import com.example.verupdate.Dao.UpdateVersion;
import com.example.verupdate.Mapper.UpdateVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UpdateDetailController {
    @Autowired
    UpdateVersionMapper updateVersionMapper;
    @GetMapping("/updateHistory/getAll")
    public Response GetAll() {
        Response response=new Response();
        List<OneVersion> history=new ArrayList<>();
        List<UpdateVersion> Ids=updateVersionMapper.getAllVersionId();
        List<UpdateKindNameMap> updateKindNameMaps=updateVersionMapper.getAllKind();

        for(UpdateVersion i:Ids){
            UpdateVersion tmp1=updateVersionMapper.queryOneVersion(i.id);
            OneVersion tmp2=new OneVersion(tmp1);
            history.add(tmp2);
        }
        response.setHistory(history);
        response.setUpdateAndContributorName(updateKindNameMaps);
        return response;
    }
}
