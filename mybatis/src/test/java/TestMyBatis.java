
import com.zk.mybatis.dao.StudentMapper;
import com.zk.mybatis.dao.TeacherMapper;
import com.zk.mybatis.dao.UserMapper;
import com.zk.mybatis.pojo.Student;
import com.zk.mybatis.pojo.Teacher;
import com.zk.mybatis.pojo.User;
import com.zk.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {


    /**
     * 查询全部
     *
     */
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        sqlSession.close();
    }

    /**
     * 删除
     */
    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count = mapper.deleteById(2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(count);
    }

    /**
     * 增加
     */
    @Test
    public void test3(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u=new User();
        u.setAge(10);
        u.setId(3);
        u.setName("赵六");
        int i = mapper.addUser(u);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
    }

    /**
     * 更新
     */
    @Test
    public void test4(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u=new User();
        u.setAge(10);
        u.setId(3);
        u.setName("赵四");
        int i = mapper.updateUser(u);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
    }

    /**
     * 根据单个ID查询
     */
    @Test
    public void test5(){

        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User u1 = mapper.queryById(1);
        User u2 = mapper.queryById(1);
        System.out.println(u1.toString());
        System.out.println(u1==u2);
    }

    /**
     * 测试分页插件
     */
    @Test
    public void test6(){

        SqlSession sqlSession= MybatisUtils.getSqlSession();
        List<User> list = sqlSession.selectList("com.zk.mybatis.dao.UserMapper.getUserByRowBounds", null, new RowBounds(0, 1));
        for (User user : list) {
            System.out.println(user.toString());
        }

    }

    /**
     * 测试注解sql查询
     */
    @Test
    public void test7(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        User byAnnotation = mapper.getByAnnotation(1);
        System.out.println(byAnnotation.toString());
    }


    /**
     * 测试关联查询，学生对老师的对象映射
     */
    @Test
    public void test8(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper=sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.queryById(1);
        System.out.println(student);
    }

    /**
     * 测试老师对应学生的list集合
     */
    @Test
    public void test9(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.queryById(1);
        System.out.println(teacher);
    }

}
