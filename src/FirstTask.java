import java.io.*;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        int[] arrInt = {2, 5, -1, 100, 34};
        var fs = new FileOutputStream("integers.bin");

        var ds = new DataOutputStream(fs);
        ds.writeInt(arrInt.length);

        for (int i : arrInt) ds.writeInt(i);

        fs.close();

        int[] arrInt2;

        var fs2 = new FileInputStream("integers.bin");
        var ds2 = new DataInputStream(fs2);

        var count = ds2.readInt();
        arrInt2 = new int[count];

        for (int i = 0; i < arrInt2.length; i++) arrInt2[i] = ds2.readInt();
        ds2.close();

        for (int j : arrInt2) System.out.println(j);
    }
}
