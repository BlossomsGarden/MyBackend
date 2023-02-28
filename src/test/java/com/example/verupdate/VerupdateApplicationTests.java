package com.example.verupdate;

import com.example.verupdate.Dao.UpdateInfo;
import com.example.verupdate.Dao.UpdateKindNameMap;
import com.example.verupdate.Dao.UpdateVersion;
import com.example.verupdate.Mapper.UpdateVersionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest
class VerupdateApplicationTests {
	@Autowired
    UpdateVersionMapper updateVersionMapper;
	@Test
	void TestGetVersionInfo() {
		UpdateVersion result= updateVersionMapper.queryOneVersion(1);
		System.out.println("好啊");
		System.out.println(result.launch_time);
		System.out.println(result.version_no);
		for(UpdateInfo tmp1: result.update_infos){
			System.out.println("-------------------------------");
			System.out.println(tmp1.id);
			System.out.println(tmp1.update_id);
			System.out.println(tmp1.type);
			System.out.println(tmp1.update_kind_name_id);
			System.out.println(tmp1.update_content);

			System.out.println("-------------------------------");
			System.out.println(tmp1.updateKindNameMap.id);
			System.out.println(tmp1.updateKindNameMap.type);
			System.out.println(tmp1.updateKindNameMap.kind_name);
			System.out.println(tmp1.updateKindNameMap.kind_key);
			System.out.println("-------------------------------");

			System.out.println("-------------------------------");
		}
	}

}
