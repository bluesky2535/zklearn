import com.zk.designmodel.yilaidaozhi.Driver;
import com.zk.designmodel.yilaidaozhi.ICar;
import com.zk.designmodel.yilaidaozhi.IDriver;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

public class TestDesign extends TestCase {

    Mockery context=new JUnit4Mockery();

    @Test
    public void test1(){
        //根据接口虚拟一个对象
        final ICar car=context.mock(ICar.class);
        IDriver driver=new Driver();
        //内部类
        context.checking(new Expectations(){{
            oneOf(car).run();
        }});
        driver.drive(car);
    }
}
