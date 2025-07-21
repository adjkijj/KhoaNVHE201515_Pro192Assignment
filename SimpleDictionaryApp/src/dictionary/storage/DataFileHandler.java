package dictionary.storage;

import java.io.*;

public class DataFileHandler {
    private static final String DATA_FILE = "dictionary_data.txt";
    private long dataPointer = 0;
    
    public DataFileHandler() throws IOException {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            file.createNewFile();
        }
        dataPointer = file.length();
    }
    
    public long writeData(String data) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(DATA_FILE, "rw")) {
            file.seek(dataPointer);
            byte[] bytes = data.getBytes("UTF-8");
            file.write(bytes);
            long currentPos = dataPointer;
            dataPointer += bytes.length;
            return currentPos;
        }
    }
    
    public String readData(long position, int length) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(DATA_FILE, "r")) {
            file.seek(position);
            byte[] bytes = new byte[length];
            file.readFully(bytes);
            return new String(bytes, "UTF-8");
        }
    }
}