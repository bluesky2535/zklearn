import com.google.common.util.concurrent.ThreadFactoryBuilder;
import javafx.scene.control.Cell;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class MyHbaseTest2 {


/*hbase:
  config:
    hbase.zookeeper.quorum: node1.server.com,node2.server.com,node3.server.com
    #node1.tct.com,node.tct.com,node3.tct.com,node4.tct.com,node5.tct.com,node6.tct.com
    hbase.zookeeper.property.clientPort: 2181
    zookeeper.znode.parent: /hbase-unsecure
    hbase.client.keyvalue.maxsize: 1048576
    hbase.rootdir: /apps/hbase/data

    */

    public org.apache.hadoop.conf.Configuration configuration() throws Exception {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
  /*      Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/config.properties"));
        properties.load(bufferedReader);*/
        // 获取key对应的value值
        configuration.set("hbase.zookeeper.quorum","172.51.216.121,172.51.216.122,172.51.216.123");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
//        configuration.set("zookeeper.znode.parent","/hbase-unsecure");
        configuration.set("hbase.client.keyvalue.maxsize","10");
        configuration.set("hbase.rootdir","/hbase");

        return configuration;
    }

    public Connection myHbaseConnection() throws URISyntaxException {
        try {
            org.apache.hadoop.conf.Configuration conf = configuration();
            Connection connection = ConnectionFactory.createConnection(conf);
            boolean closed = connection.isClosed();
            System.out.println("zookeeper是否关闭"+closed);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private String getMapKey(Map<String,String> map,String value){
        StringBuffer key = new StringBuffer("");
        if (map.containsValue(value) || StringUtils.isEmpty(value)){
            map.entrySet().stream().filter(entry -> entry.getValue().equals(value)).findFirst().ifPresent(entry -> key.append(entry.getKey()));
        }

        return key.toString();
    }



    public List getTopicDate( Connection connection,String tableName,String startRowKey) throws Exception {
        TableName tablename = TableName.valueOf(tableName);
        List<Object> dataList = new LinkedList<>();
        HTable table = (HTable) connection.getTable(tablename);
        ResultScanner resultScanner = null;


        //新建一个查询对象作为查询条件
        Get get = new Get(startRowKey.getBytes());

        //按行查询数据
        Result result = table.get(get);

        byte[] row = result.getRow();
        System.out.println("row key is:" +new String(row));

        List<Cell> listCells = result.listCells();
        for (Cell cell : listCells) {
            byte[] familyArray = cell.getFamilyArray();
            byte[] qualifierArray = cell.getQualifierArray();
            byte[] valueArray = cell.getValueArray();

            System.out.println("row value is:"+ new String(familyArray) +
                    new String(qualifierArray) + new String(valueArray));
        }
        System.out.println("---------------查行键数据结束----------");



        return dataList;
    }
    /**
     * 查询表中的数据
     */
    public static void queryTable(Connection connection,String tableNameString) throws IOException {
        System.out.println("--------------------查询整表的数据--------");

        //获取数据表对象
        Table table = connection.getTable(TableName.valueOf(tableNameString));
        Scan scan = new Scan();
        scan.setStartRow(Bytes.toBytes("998f70063974b3b4853be8e2ccc68791b77"));
        scan.setStopRow(Bytes.toBytes("998f70063974b3b4853be8e2ccc68791b77"));
        //获取表中的数据
        ResultScanner scanner = table.getScanner(scan);

        //循环输出表中的数据
        for (Result result : scanner) {

            byte[] row = result.getRow();
            System.out.println("row key is:"+new String(row));

            List<Cell> listCells = result.listCells();
            for (Cell cell : listCells) {

                byte[] familyArray = cell.getFamilyArray();
                byte[] qualifierArray = cell.getQualifierArray();
                byte[] valueArray = cell.getValueArray();

                System.out.println("row value is:"+ new String(familyArray) +
                        new String(qualifierArray) + new String(valueArray));
            }
        }
        System.out.println("---------------查询整表数据结束----------");
    }

    public static void main(String[] args) throws Exception {
        MyHbaseTest2 test2=new MyHbaseTest2();
        Connection connection = test2.myHbaseConnection();

        Map<String,String> keyType=new HashMap<String,String>();
        keyType.put("operatorNumber","int");
        keyType.put("ticketType","int");
        keyType.put("stationNumber","int");
        keyType.put("allocateTime","string");
        keyType.put("allocateNumber","int");
        Map<String,String> keyMapping=new HashMap<String,String>();

//        List topicDate = test2.getTopicDate(connection, "datatransfer.TicketAllocate",  "9996596d4cd7fad4ad7aa81cf458f1db7");


        test2.queryTable(connection,"datatransfer.TicketAllocate");


    }


}
