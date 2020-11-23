package com.zklearn;


@ZkTable("tb_student")
public class Student {
    @ZkField(columnName = "id",type = "varchar",length = 50)
    private String id;
    @ZkField(columnName = "name",type = "varchar",length = 50)
    private String name;
    @ZkField(columnName = "age",type = "int",length = 50)
    private String age;

}
