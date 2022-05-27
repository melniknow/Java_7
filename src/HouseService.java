import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class HouseService {
    public static void serializeHouse(House house, String filename) {
        try (ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            out.writeObject(house);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static House deserializeHouse(String filename) {
        try (ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))) {
            return (House) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        var data = new ArrayList<Flat>();
        serializeHouse(new House("110", "address", new Person("a", "b", "c", new Date()), data), "house.data");
        System.out.println(deserializeHouse("house.data"));
    }
}
