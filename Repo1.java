package com.table.Table.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.table.Table.entity.CustomerEntity;

@Repository
public interface Repo1 extends JpaRepository<CustomerEntity, Integer> {
	List<CustomerEntity>  findByName(String name);
}

