import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.LogManager;

/**
 * @author zk
 */

@Data
@Slf4j(topic = "TestReentrantReadWriteLock")
public class TestReentrantReadWriteLock {


    private String name="sss";
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public TestReentrantReadWriteLock() {

    }

    public static void main(String[] args) throws InterruptedException {

        log.info("hhaha");
        System.out.println(new TestReentrantReadWriteLock().getName());
        DataSource dataSource = new DataSource();
        new Thread(() -> {
            dataSource.read();


        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println("hah");
            dataSource.write();

        }).start();
//        writeLock.unlock();


    }
}


@Slf4j(topic = "DataSource")
class DataSource {
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    public void read() {
        readLock.lock();
        try {
            log.info("读锁加入");
        } finally {
            log.debug("读锁解除");
            readLock.unlock();
        }
    }

    public void write() {
        writeLock.lock();
        try {
            log.info("写入");
        } finally {
            writeLock.unlock();
        }
    }
}