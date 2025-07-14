import java.io.*;

public class FileReadEfficiency {

    public static void readWithFileReader(String path) throws IOException {
        FileReader fr = new FileReader(path);
        int c;
        while ((c = fr.read()) != -1) {
            
        }
        fr.close();
    }

    public static void readWithInputStreamReader(String path) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
        int c;
        while ((c = isr.read()) != -1) {
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "largefile.txt"; 

        long startFR = System.nanoTime();
        readWithFileReader(filePath);
        long endFR = System.nanoTime();
        System.out.println("FileReader Time: " + (endFR - startFR) / 1_000_000.0 + " ms");

        // InputStreamReader
        long startISR = System.nanoTime();
        readWithInputStreamReader(filePath);
        long endISR = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endISR - startISR) / 1_000_000.0 + " ms");
    }
}