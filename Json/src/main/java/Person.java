import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("FriendDetail")
@JsonIgnoreProperties({"list"})
public class Person {
    private  String name;
    private int age;
    private List<String> list;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate localDate;

    public Person(String name, int age, ArrayList<String> objects, LocalDate date) {
        this.name=name;
        this.age=age;
        this.list=objects;
        this.localDate=date;
    }
}
