import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("足球");
        objects.add("乒乓球");
        objects.add("篮球");
        LocalDate date = LocalDate.now();
        //注册时间处理模块
        mapper.registerModule(new JavaTimeModule()).
                registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module());
        mapper.findAndRegisterModules();
        //将对象转为JSON
        Person p = new Person("张三", 1, objects, date);
        //可以写注解的根节点
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String s = mapper.writeValueAsString(p);
        System.out.println(s);
        //将JSON转为对象
//        Person person = mapper.readValue(s, Person.class);
//        System.out.println(person);
        //将JSON转为树
        JsonNode jsonNode = mapper.readTree(s);
        Iterator<String> stringIterator = jsonNode.fieldNames();
        while (stringIterator.hasNext()) {
            String next = stringIterator.next();
            System.out.println(next);
        }
        JsonNode path = jsonNode.findPath("FriendDetail");
        JsonNode value = jsonNode.findValue("FriendDetail");
        System.out.println(path);
        System.out.println(value);

        //查找子字符串
        JsonNode name = path.findPath("name");
        System.out.println(name.toString());


        //遍历数组形式的json字符串
        String arrayJson = "[{\"number\":64,\"result\":\"SUCCESS\"},{\"number\":65,\"result\":\"FAILURE\"},{\"number\":66,\"result\":\"ABORTED\"},{\"number\":67,\"result\":\"SUCCESS\"}]";
        JsonNode jsonNode1 = mapper.readTree(arrayJson);
        for (JsonNode node : jsonNode1) {
            System.out.println(node.toString());
        }
        System.out.println(jsonNode1);


    }

}
