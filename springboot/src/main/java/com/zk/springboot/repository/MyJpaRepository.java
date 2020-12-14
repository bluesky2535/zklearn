package com.zk.springboot.repository;

import com.zk.springboot.pojo.JPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyJpaRepository extends JpaRepository<JPAEntity,Integer> {

}
