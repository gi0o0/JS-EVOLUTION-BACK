package com.jarzsoft.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICRUD<T> {

	T create(T t);

	T update(T t);

	ResponseEntity<Object> delete(int id);

	T listById(int id);

	List<T> listAll();
}
