import com.zk.spring.*;
import com.zk.spring.config.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class Test1 {

    /**
     * 控制反转:将控制权交给用户，比如说访问不同类型的数据库，之前是通过硬编码，这样很不友好，扩展性差，通过set方法进行设置，控制权从业务层交给用户
     * 依赖注入：
     * 依赖：bean创建对象依赖于容器
     * 注入：bean需要的属性由容器set注入
     */


    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
/*        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        User user3 = (User) context.getBean("useralias");
        System.out.println(user.getName());
        System.out.println(user==user2);
        System.out.println(user3==user2);*/


        /*Student{
         name='wangwu',
         address=Address{aname='北京市'},
         hobby=[just some string,
         MyDataSource{driverClassName='com.mysql.jdbc.Driver', url='jdbc:mysql://localhost:3306/mydb', username='root', password='misterkaoli'}],
         course={an entry=just some string, a ref=MyDataSource{driverClassName='com.mysql.jdbc.Driver', url='jdbc:mysql://localhost:3306/mydb', username='root', password='misterkaoli'}},
         toys=[a list element followed by a reference, MyDataSource{driverClassName='com.mysql.jdbc.Driver', url='jdbc:mysql://localhost:3306/mydb', username='root', password='misterkaoli'}],
         wife='',
         properties={support=support@example.org, administrator=administrator@example.org, development=development@example.org},
         books=[机器学习, Java核心思想, kafka]}
         */
        Student student = (Student) context.getBean("student");
        System.out.println(student);



        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user.getName());
        System.out.println(user==user2);


        /*测试自动装配*/
        People people = (People) context.getBean("people",People.class);
        people.getCat().shout();
        people.getCat2().shout();
        Dog dog = people.getDog();

        /*测试扫描包*/
        Company company = (Company) context.getBean("company",Company.class);
        System.out.println(company.getName());


    }


    /**
     * 通过配置类进行扫描
     */
    @org.junit.Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = context.getBean("getUser", User.class);
        User user2 = context.getBean("getUser", User.class);
        System.out.println(user.getName());
        System.out.println(user==user2);

    }
}
