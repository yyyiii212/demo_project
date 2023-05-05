package com.example.demo_project;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;
import com.example.demo_project.service.ifs.OrderService;

@SpringBootTest
public class Test1 {
	@Autowired
	private OrderService orderservice;
	@Autowired
	private UsersDao usersDao;
	

	@Test
	public void contextLoads() {

		Menu beefmenu = new Menu("beef", 100);
		Menu porkmenu = new Menu("pork", 90);
		Menu chickenmenu = new Menu("chicken", 80);
		orderservice.getprice(beefmenu);
		orderservice.getprice(porkmenu);
		orderservice.getprice(chickenmenu);
		Map<Menu, Integer> menuMap = new HashMap<>();
		menuMap.put(beefmenu, 8);
		menuMap.put(porkmenu, 3);
		menuMap.put(chickenmenu, 5);
		for (Entry<Menu, Integer> item : menuMap.entrySet()) {
			Menu menu = item.getKey();
			int itemPrice = menu.getPrice();
			int num = item.getValue();
		}
		orderservice.totalprice(menuMap);
		// Map<Integer,Integer>intMap = new HashMap<>();
		// intMap.put(1, 100);
		// intMap.put(5, 90);
		// intMap.put(4, 80);
		// for(Entry<Integer, Integer> item:intMap.entrySet()) {
		// System.out.println(item.getKey()+item.getValue());
		// }
		// orderservice.getprice("beef");
		// orderservice.getprice("pork");
		// orderservice.getprice("chicken");
		// orderservice.totalprice();
		// orderservice.food();

	}

	@Test
	public void contextLoads12() {
		int[] nums = { 2, 7, 11, 15 };
		int[] num = new int[2];
		int target = 9;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[i] + nums[j] == target) {
					num[0] = nums[i];
					num[1] = nums[j];
					System.out.println(num);
				}
			}
		}
		System.out.println(1);
	}

	@Test
	public int[] contextLoads123() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 26;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			count++;
			int complement = target - nums[i];// 26-2 以此類推
			if (map.containsKey(complement)) {// 如果有找到可以計算的值就進去
				System.out.println(count);
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		return null;

		// String str = String.format("%b", x);
		// Boolean bool = Boolean.parseBoolean(str);
		// return bool;
	}

	@Test
	public void contextLoads1234() throws ParseException {

		// 日期轉換成字串(a 代表上午 or 下午)
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		System.out.println(sdff.format(new Date()));

		// 解析日期
		String datestr = "2022-11-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(datestr);
		System.out.println(newDate);
	}

	@Test
	public void contextLoads12345() {

		// 日期轉字串
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm a");
		String nowStr = now.format(format);
		System.out.println(nowStr);

		// 解析日期(LocalDate)
		String dateStr = "2022年11月25日";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		System.out.println(date);

		// 解析日期(LocalDateTime)
		String dateTimeStr = "2022年11月25日 12時30分10秒";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter1);
		System.out.println(dateTime);

		// Date 轉 LocalDate
		Date date1 = new Date();
		Instant instant = date1.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("ZoneId(指定時區): " + zoneId);
		// atZone()方法會返回從該Instant生成的ZoneDateTime
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		System.out.println("Date: " + date1);
		System.out.println("LocalDate: " + localDate);
		System.out.println("LocalDateTime: " + localDateTime);

		//
		ZoneId zoneId1 = ZoneId.systemDefault();
		LocalDate localDate1 = LocalDate.now();
		ZonedDateTime zonedDateTime = localDate1.atStartOfDay(zoneId1);
		System.out.println("ZonedDateTime: " + zonedDateTime);
	}

	@Test
	public void test12314213123() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Users u1 = new Users("AAA", encoder.encode("AA123"), "admin", true);
		Users u2 = new Users("BBB", encoder.encode("BB123"), "user", true);
		Users u3 = new Users("CCC", encoder.encode("CC123"), "user", true);
		Users u4 = new Users("DDD", encoder.encode("DD123"), "user", false);

		List<Users> usersList = Arrays.asList(u1, u2 ,u3, u4);

	}
	@Test
	public void testPositivePalindrome() {
	    int x = 121;
	    boolean result = false;
	    int temp = x;
	    int after = 0;
	    if(x<0){fail("Input should be a positive integer");}
	    while(temp != 0){
	        after = after * 10 + temp % 10;
	        temp = temp / 10;
	    }
	    if(x == after){result = true;}
	    assertTrue(result);
	}
}
