package com.bluesky.config;

public class Flyway {


    public static void main(String[] args) {
//        String url = "jdbc:mysql://127.0.0.1:3306/hello?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=false&serverTimezone=GMT%2B8";
//        String user = "root";
//        String password = "123456";


        String url = "jdbc:postgresql://127.0.0.1:5432/flyway";
        String user = "postgres";
        String password = "postgres";
        org.flywaydb.core.Flyway flyway = org.flywaydb.core.Flyway.configure().dataSource(url, user, password).load();
//        // 创建 flyway_schema_history 表,如果之前没有用flyway进行管理，可以先执行该步骤，生成flyway_schema_history表
//		flyway.baseline();
//
//        // 删除 flyway_schema_history 表中失败的记录
//		flyway.repair();
//
//        // 检查 sql 文件
//		flyway.validate();

        // 执行数据迁移
        flyway.migrate();

        // 删除当前 schema 下所有表
//        flyway.clean();

    }

    public void hah(){
        System.out.println("哈哈和");
    }
}