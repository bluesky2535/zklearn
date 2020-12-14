package com.zk.springboot.pojo;


import javax.persistence.*;

@Entity
@Table(name = "jpa_entity")
public class JPAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "jname")
    private String name;



    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
