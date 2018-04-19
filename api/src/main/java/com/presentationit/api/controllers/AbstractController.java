package com.presentationit.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.presentationit.api.dto.AbstractDto;
import com.presentationit.api.model.AbstractEntity;

public abstract class AbstractController<T extends AbstractEntity, R extends AbstractDto> {

	@Autowired
	protected DozerBeanMapper mapper;
	protected Class<T> entityClass;
	protected Class<R> dtoClass;

	public AbstractController(Class<T> entityClass, Class<R> dtoClass) {
		this.entityClass = entityClass;
		this.dtoClass = dtoClass;
	}
	
	/**
	 * 
	 * @param iterable
	 * @return
	 */
	protected List<R> map(Iterable<T> iterable) {
		List<R> result = new ArrayList<>();
		for (T value : iterable) {
			result.add(map(value));
		}
		return result;
	}

	/**
	 * 
	 * @param bean
	 * @return
	 */
	protected R map(T bean) {
		return mapper.map(bean, dtoClass);
	}
	
	protected T map(R bean) {
		return mapper.map(bean, entityClass);
	}
}
