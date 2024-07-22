package com.table.Table.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.table.Table.entity.FormEntity;

@Repository
public interface Repo2 extends JpaRepository<FormEntity, Integer> {
}
