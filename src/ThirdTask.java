import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;


public class ThirdTask {
    public static ArrayList<Integer> getFromPoz(String path, int poz) throws IOException {
        var raf = new RandomAccessFile(path, "r");
        var text = raf.readLine();
        raf.close();

        return new ArrayList<>(Arrays.stream(text.substring(poz).split(" ")).filter(n -> !n.equals("")).map(Integer::valueOf).toList());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFromPoz("input.txt", 5));
    }
}
