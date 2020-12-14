package com.zk.springboot.controller;

import com.zk.springboot.pojo.JPAEntity;
import com.zk.springboot.repository.MyJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("/jpaentity")
public class JpaController {
    @Autowired
    MyJpaRepository myJpaRepository;


    @GetMapping("/get/{id}")
    public JPAEntity getEntity(@PathVariable("id") Integer id){
        Optional<JPAEntity> one = myJpaRepository.findById(id);
        return one.get();
    }
    @GetMapping("/save")
    public JPAEntity saveEntity(JPAEntity jpaEntity){
        String name = jpaEntity.getName();

        JPAEntity entity = myJpaRepository.save(jpaEntity);
        return entity;
    }


}
