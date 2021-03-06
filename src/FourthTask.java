import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FourthTask {
    public static List<Path> getFilesFromDirWithType(String type, String path) throws IOException {
        return Files.walk(Paths.get(path), 1)
                .filter(n -> Files.isRegularFile(n) && n.toFile().getName().endsWith("." + type))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFilesFromDirWithType("txt", "/home/sergey"));
    }
}
