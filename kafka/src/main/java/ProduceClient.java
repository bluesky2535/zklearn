import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ProduceClient {


    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"hadoop1:9092,hadoop2:9092,hadoop3:9092");
        //添加分区器
//        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"MyPartitioner");

        KafkaProducer producer=new KafkaProducer(properties);
        //无回调函数
        for (int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord("first","key"+i,"value+i"));
        }

        //有回调函数
        for (int i = 10; i < 20; i++) {
            producer.send(new ProducerRecord("first", "key" + i, "value+i"), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception==null){
                        System.out.println("返回的元数据信息为"+metadata.toString());
                    }
                }
            });
        }



        //同步生产
        for (int i = 0; i < 10; i++) {
            Future msg = producer.send(new ProducerRecord("first", "key" + i, "value+i"));
            msg.get();
        }
        producer.close();
        System.out.println(StringSerializer.class.getPackage());
    }


}
