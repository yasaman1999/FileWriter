package filewriter;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class TestFileWriter {
    private static final String FILE_PATH = "G.txt";

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");

        ArrayList<FileWriter> threads = new ArrayList<>();
        FileWriter t1 = new FileWriter(file, "HELLO", 0);
        FileWriter t2 = new FileWriter(file, "student", 8);

        t1.start();
        threads.add(t1);
        t2.start();
        threads.add(t2);
        for (FileWriter t : threads) {
            try {
                t.join();
                System.out.println(t.readFromFile(0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        file.close();
    }
}
