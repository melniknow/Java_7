import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JacksonUse {
    public static House deserializePerson(String json) throws IOException {
        return new ObjectMapper().readValue(json, House.class);
    }

    public static String serializePerson(House house) throws IOException {
        return new ObjectMapper().writeValueAsString(house);
    }

    public static void main(String[] args) throws IOException {
        var flatList = new ArrayList<Flat>();
        var personList = new ArrayList<Person>();
        personList.add(new Person("a1", "b1", "c1", new Date()));
        personList.add(new Person("a2", "b2", "c2", new Date()));

        flatList.add(new Flat(1,2.5, personList));
        var obj = new House("110", "address", new Person("a", "b", "c", new Date()), flatList);
        var json = serializePerson(obj);
        var newObj = deserializePerson(json);

        System.out.println(newObj);
    }
}
