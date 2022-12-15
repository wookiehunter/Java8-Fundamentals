package java8.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Zip {
    public static void main(String[] args) {
        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        try (FileSystem fsZip = openZip(Paths.get("myData.zip"))) {
            copyToZip(fsZip);
            writeToFileInZip1(fsZip,data);
            writeToFileInZip2(fsZip,data);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create","true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFS = FileSystems.newFileSystem(zipUri, providerProps);

        return zipFS;
    }

    private static void copyToZip(FileSystem zipFs) throws IOException {
        Path srcFile = Paths.get("file1.txt");
        Path destFile = zipFs.getPath("/file1Copied.txt");

        Files.copy(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);
    }

    private static void writeToFileInZip1(FileSystem zipFS,  String[] data) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(zipFS.getPath("/newFile1.txt"))) {
            for(String d:data) {
                writer.write(d);
                writer.newLine();
            }
        }
    }

    private static void writeToFileInZip2(FileSystem zipFS,  String[] data) throws IOException {
        Files.write(zipFS.getPath("/newFile2.txt"), Arrays.asList(data), Charset.defaultCharset(), StandardOpenOption.CREATE);
    }
}
