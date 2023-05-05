package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Register;
@Service
@EnableScheduling
public class RegisterDaoImpl extends BaseDao {

	public List<Register> doQueryByExpiredRegTime(Date date) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R");
		sb.append(" where regTime > :expireDate");

		Map<String, Object> params = new HashMap<>();
		params.put("expireDate", date);

		return doQuery(sb.toString(), params, Register.class);
	}

	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R");
		sb.append(" where regTime > :expireDate");

		Map<String, Object> params = new HashMap<>();
		params.put("expireDate", date);

		return doQuery(sb.toString(), params, Register.class, pageSize);
	}

	public List<Register> doQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R");
		sb.append(" where regTime > :expireDate");

		Map<String, Object> params = new HashMap<>();
		params.put("expireDate", date);

		return doQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	public List<Register> doNativeQueryByExpiredRegTime(Date date, int pageSize, int startPosition) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R");
		sb.append(" where regTime > :expireDate");

		Map<String, Object> params = new HashMap<>();
		params.put("expireDate", date);

		return doQuery(sb.toString(), params, Register.class, pageSize, startPosition);
	}

	public int updateAgeByName(String name, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update Register set age = :age ");
		sb.append(" where name = :newName ");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		return doUpdate(sb.toString(), params);
	}

	public int updateAgeByAccount(String account, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update Register set age = :age ");
		sb.append(" where account = :newAccount ");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newAccount", account);
		return doUpdate(sb.toString(), params);
	}

	public int nativeUpdateAgeByName(String name, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update register set age = :age ");
		sb.append(" where name = :newName ");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newName", name);
		return doNativeUpdate(sb.toString(), params);
	}

	public int nativeUpdateAgeByAccount(String account, int newAge) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update register set age = :age ");
		sb.append(" where account = :newAccount ");
		Map<String, Object> params = new HashMap<>();
		params.put("age", newAge);
		params.put("newAccount", account);
		return doNativeUpdate(sb.toString(), params);
	}
	/**
	 * final sql : select * from register r where role like %General% or role like %SA% or role like %SD%
	 * ========================
	 * Map: 相同的key其對應的值會後蓋前
	 * params = {role0=%General%, role1=%SA%, role2=%SD%}
	 * StringBuffer sql : select * from register r where role like :role0 or role like :role1 or role like :role2
	 * 上面的 params 的 key 以及 StringBuffer sql 中的0,1,2 可以取自參數列 roleList 的 index
	 * 要判斷參數列是否為最後一個，因為會決定 StringBuffer sql 是否需要加 or
	 * @param roleList
	 * @return
	 */
	public List<Register> doQueryRoleContains(List<String> roleList) {
		Map<String, Object> params = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select * from register r where ");
		for (int i = 0; i < roleList.size(); i++) {
			String item = roleList.get(i);
			//select * from register r where role like :role0 or role like :role1 or role like :role2
			//params = {role0=%General%, role1=%SA%, role2=%SD%}
			//select * from register r where role like %General% or role like %SA% or role like %SD%
			if (i < roleList.size() - 1) {
				//select * from register r where role like General1 or role like SA
				sb.append(" role like :role" + i + " or ");
			} else {
				sb.append(" role like :role" + i);
			}
			params.put("role" + i, "%" + item + "%");
		}
		System.out.println(sb.toString());
		return doNativeQuery(sb.toString(), params, Register.class, -1, 0);
	}
	
//	@Scheduled(fixedRateString = "${heartbeat.ms}")//(設定時間)每三秒跳一次時間
//	public void schedulePrintDate() {
//		System.out.println(new Date());
//	}
	
	//cron = "秒 分 時 日 月 周 (年:可不寫)"
	@Scheduled(cron = "0 * 14-16 * * ?")//每天下午2-4點每分鐘跳一次時間
	public void schedulePrintDate1() {
		System.out.println(new Date());
	}
	
	@Scheduled(cron = "0 0 10 * * ?") //每天的上午10點跳一次時間
	public void schedulePrintDate2() {
		System.out.println(new Date());
	}
}
