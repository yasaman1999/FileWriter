

package filewriter;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileWriter extends Thread {
    private RandomAccessFile file;
    private String data;
    private int position;

    public FileWriter(RandomAccessFile file, String data, int position) {
        this.file = file;
        this.data = data;
        this.position = position;
    }

    @Override
    public void run() {
        try {
            writeToFile(data, position);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void writeToFile(String fileData, int position) throws IOException {
        file.seek(position);
        file.write(fileData.getBytes());
    }

    public String readFromFile(int position) throws IOException {
        byte[] bytes = new byte[(int) file.length() - position];
        file.seek(position);
        file.read(bytes);

        return new String(bytes);
    }
}
