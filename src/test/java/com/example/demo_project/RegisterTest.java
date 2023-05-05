package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegisterTest {
	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterDao registerDao;

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Test
	public void registerTest() {
		Register reg = registerService.register("A01", "123456", "Josh", 18, "Tainan");
		Assert.notNull(reg, "Result is null !!");
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A01"), "Account error !");

		registerDao.delete(reg);
		Assert.isTrue(!registerDao.findById("A01").isPresent(), "reg is not null!");
		Assert.isTrue(!registerDao.existsById("A01"), "reg is not null!");
	}

	@Test
	public void activeAccountTest() {
		// register new account
		Register reg = registerService.register("A99", "123456789", "Jin", 13, "Taipei");
		Assert.isTrue(!reg.isActive(), "Account is active !");
		// active registered account
		registerService.activeAccount("A99");
		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive(), "Account is inactive !");
		registerDao.delete(newReg);
	}

	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("SA");
		roleList.add("SD");
		registerService.addRole("A02", roleList);
	}

	@Test
	public void registerControllerTest() throws Exception {
		// 如果headers要加的參數有多個，可使用此方法
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// set request body
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", "A99");
		map.put("pwd", "A123456");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Tainan");

		// map to String
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);
		// {account:"A05",pwd:"A123456",name:"David",age = 22 ,city = Taiwan};
		System.out.println(map.toString());
		// postman 格式:
		// {"account":"A05","pwd":"A123456","name":"David","age:22 ,"city":"Taiwan"};
		System.out.println(mapString);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(CONTENT_TYPE)// headers
																														// 要加的參數只有content_type時，可直接使用，不須透過headers加入
				.content(mapString));
		// get.reponse && 將response得內容轉成字串
//		MockHttpServletResponse httpResponse = result.andReturn().getResponse();
		String resString = result.andReturn().getResponse().getContentAsString();
		// 將得到的response字串轉成Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
		Object rtnmessage = resData.get("message");
		System.out.println(rtnmessage);
		Assert.isTrue(rtnmessage.equals("Successful"), "Message error!");
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_info");// 轉型
		Assert.isTrue(((String) rtnInfo.get("Account")).equals("A99"), "Account error!");
		System.out.println(rtnInfo);
		System.out.println(resData);
	}

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void addRoleListControllerTest() throws Exception {
		// set request_body
		Map<String, Object> map = new LinkedHashMap<>();
		List<String> roleList = new ArrayList<>();
		roleList.add("AAA");
//		roleList.add("BB");
		map.put("account", "A02");
		map.put("roleList", roleList);
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/addRoleList").contentType(CONTENT_TYPE)// headers
																														// 要加的參數只有content_type時，可直接使用，不須透過headers加入
				.content(mapString));

		String resString = result.andReturn().getResponse().getContentAsString();
		// 將得到的response字串轉成Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);

	}

	@Test
	public void updateRegisterInfoDaoTest() {
		int result = registerDao.updateRegisterInfo("jossss", 55, "Tainan", new Date(), "A99");
		System.out.println("===============>>>>>>" + result);
	}

	@Test
	public void doQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date);
		System.out.println(result.size());
	}

	@Test
	public void doQueryWithPageSizeTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, 2);
		System.out.println(result.size());

		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doQueryWithStartPositionTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, 2, 1);
		System.out.println(result.size());

		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doNativeQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doNativeQueryByExpiredRegTime(date, 2, 1);
		System.out.println(result.size());

		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doTest() {
		String id = "D323456789";
		String parttern = "[A-Z][1-2]\\d{8}";
		System.out.println(id.matches(parttern));
	}

	@Test
	public void doUpdateByNameTest() {
		int result = registerDao.updateAgeByName("jjj", 84);
		System.out.println(result);
	}

	@Test
	public void doUpdateByAccountTest() {
		int result = registerDao.updateAgeByAccount("A02", 84);
		System.out.println(result);
	}

	@Test
	public void doNativeUpdateByNameTest() {
		int result = registerDao.nativeUpdateAgeByName("jjj", 84);
		System.out.println(result);
	}

	@Test
	public void doNativeUpdateByAccountTest() {
		int result = registerDao.nativeUpdateAgeByAccount("A02", 84);
		System.out.println(result);
	}
	@Test
	public void doQueryRoleContains(){
		List<String> strList = Arrays.asList("DDD","BB");
		List<Register> result = registerDao.doQueryRoleContains(strList);
		for(Register item : result) {
		System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void findAll() {
		List<Register> result = registerService.findAll();
		System.out.println(result.size());
	}
}
