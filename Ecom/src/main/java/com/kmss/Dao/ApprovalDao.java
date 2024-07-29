package com.kmss.Dao;

import org.springframework.data.repository.CrudRepository;

import com.kmss.Entity.Approval;

public interface ApprovalDao extends CrudRepository<Approval, Integer>{
	Approval findById(int id);
}
