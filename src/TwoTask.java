import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TwoTask {
    public static void main(String[] args) throws IOException {
        var writer = new FileWriter("input.txt");
        for (char c : new char[]{'a', 'b', 'c', 'd'}) writer.write(c);
        writer.close();

        var reader = new FileReader("input.txt");
        while (reader.ready()) System.out.println((char) reader.read());
    }
}
