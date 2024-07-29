package com.kmss.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.kmss.Entity.Products;
@Component
public interface ProductDao extends CrudRepository<Products, Integer>{
	Products findById(int id);
}
