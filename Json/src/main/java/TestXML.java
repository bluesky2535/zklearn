import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class TestXML {

    public static void main(String[] args) throws JsonProcessingException {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("足球");
        objects.add("乒乓球");
        objects.add("篮球");
        LocalDate date = LocalDate.now();

        //将对象转为JSON
        Person p = new Person("张三", 1, objects, date);
        XmlMapper mapper = new XmlMapper();
        //注册时间处理模块
        mapper.registerModule(new JavaTimeModule()).
                registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module());
        mapper.findAndRegisterModules();
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String text = mapper.writeValueAsString(p);
        System.out.println(text);

        Person p2 = mapper.readValue(text, Person.class);
        System.out.println(p2);

    }

}
