import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class JacksonUse {
    public House deserializePerson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = (ObjectNode) mapper.readTree(json);

        String houseNumber = root.path("houseNumber").asText();
        String address = root.path("address").asText();


        return new House(houseNumber, address, null, null);
    }

    public static String serializePerson(House house) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNodeFactory nodeFactory = mapper.getNodeFactory();
        ObjectNode root = nodeFactory.objectNode();

        root.put("houseNumber", house.getHouseNumber());
        root.put("address", house.getAddress());


        Writer writer = new StringWriter();
        mapper.writeValue(writer, root);

        return writer.toString();
    }

    public static void main(String[] args) throws IOException {
        var data = new ArrayList<Flat>();
        System.out.println(serializePerson(new House("110", "address", new Person("a", "b", "c"), data)));
    }
}
