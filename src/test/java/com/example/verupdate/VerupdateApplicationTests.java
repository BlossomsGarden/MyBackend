package com.example.verupdate;

import com.example.verupdate.Dao.UpdateInfo;
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
		UpdateVersion result= updateVersionMapper.getVersionInfo(1);
		System.out.println("好啊");
		System.out.println(result.id);
		System.out.println(result.launch_time);
		System.out.println(result.version_no);
		System.out.println(result.update_infos);
	}

}
