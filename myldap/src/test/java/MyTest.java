import org.junit.Before;
import org.junit.Test;

import javax.naming.ldap.LdapContext;

public class MyTest {
    String url = "ldap://192.168.137.101:389/";
    String basedn = "dc=ts,dc=com";  // basedn
    String root = "cn=admin,dc=ts,dc=com";  // 用户
    String pwd ="123456";  // pwd
    LdapContext ctx=null;//cdh ldap认证

    @Before
    public void myBefore(){
        ctx=LdapUtil.ldapConnect(url,root,pwd);//cdh ldap认证
    }


    @Test
    public void addUser(){

        LdapUser ldapUser = new LdapUser();
        ldapUser.setCn("zheng wu");
        ldapUser.setSn("wu");
        ldapUser.setUid("1002");
        ldapUser.setUserPassword("123456");
        ldapUser.setDisplayName("zhengwudispaly");
        ldapUser.setMail("zhengwu@qq.com");
        ldapUser.setDescription("测试用户");
        ldapUser.setUidNumber("1002");
        ldapUser.setGidNumber("500");
        LdapUtil.addUser(ldapUser,ctx);
    }

    @Test
    public void addGroup(){
        LdapUser ldapUser = new LdapUser();
        ldapUser.setCn("newgroup");
        ldapUser.setSn("newgroup");
        ldapUser.setGidNumber("501");
        LdapUtil.addGoups(ldapUser,ctx);
    }


    @Test
    public void renZheng(){

    }


}
