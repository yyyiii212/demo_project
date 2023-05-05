package com.example.demo_project.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.CollectionUtils;

public class BaseDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz) { // �L��������
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// �쥻�ϥ� entryset �M������
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
//			for(Entry<String, Object> item : params.entrySet()) {
//				query.setParameter(item.getKey(), item.getValue());
//			}
		}
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int pageSize) { // �L��������
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// �쥻�ϥ� entryset �M������
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doQuery(String sql, Map<String, Object> params, Class<EntityType> clazz,
			int pageSize, int startPosition) { // �L��������
		Query query = entityManager.createQuery(sql, clazz);
		if (!CollectionUtils.isEmpty(params)) {
			// �쥻�ϥ� entryset �M������
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if (startPosition > 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <EntityType> List<EntityType> doNativeQuery(String nativeSql, Map<String, Object> params, Class<EntityType> clazz,
			int pageSize, int startPosition) { // �L��������
		Query query = null;
		if(clazz == null) {
			query = entityManager.createNativeQuery(nativeSql);
		}else {
			query = entityManager.createNativeQuery(nativeSql, clazz);
		}
		
		if (!CollectionUtils.isEmpty(params)) {
			// �쥻�ϥ� entryset �M������
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		if (pageSize > 0) {
			query.setMaxResults(pageSize);
		}
		if (startPosition > 0) {
			query.setFirstResult(startPosition);
		}
		return query.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doUpdate(String sql, Map<String, Object> params){
		Query query = entityManager.createQuery(sql);
		if(!CollectionUtils.isEmpty(params)) {
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.executeUpdate();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doUpdateByAccount(String sql, Map<String, Object> params){
		Query query = entityManager.createQuery(sql);
		if(!CollectionUtils.isEmpty(params)) {
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.executeUpdate();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int doNativeUpdate(String sql, Map<String, Object> params){
		Query query = entityManager.createNativeQuery(sql);
		if(!CollectionUtils.isEmpty(params)) {
			for (Parameter p : query.getParameters()) {
				query.setParameter(p, params.get(p.getName()));
			}
		}
		return query.executeUpdate();
	}
}
