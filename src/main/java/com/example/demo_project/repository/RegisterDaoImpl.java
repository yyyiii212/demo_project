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
	 * Map: �ۦP��key��������ȷ|��\�e
	 * params = {role0=%General%, role1=%SA%, role2=%SD%}
	 * StringBuffer sql : select * from register r where role like :role0 or role like :role1 or role like :role2
	 * �W���� params �� key �H�� StringBuffer sql ����0,1,2 �i�H���۰ѼƦC roleList �� index
	 * �n�P�_�ѼƦC�O�_���̫�@�ӡA�]���|�M�w StringBuffer sql �O�_�ݭn�[ or
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
	
//	@Scheduled(fixedRateString = "${heartbeat.ms}")//(�]�w�ɶ�)�C�T����@���ɶ�
//	public void schedulePrintDate() {
//		System.out.println(new Date());
//	}
	
	//cron = "�� �� �� �� �� �P (�~:�i���g)"
	@Scheduled(cron = "0 * 14-16 * * ?")//�C�ѤU��2-4�I�C�������@���ɶ�
	public void schedulePrintDate1() {
		System.out.println(new Date());
	}
	
	@Scheduled(cron = "0 0 10 * * ?") //�C�Ѫ��W��10�I���@���ɶ�
	public void schedulePrintDate2() {
		System.out.println(new Date());
	}
}
