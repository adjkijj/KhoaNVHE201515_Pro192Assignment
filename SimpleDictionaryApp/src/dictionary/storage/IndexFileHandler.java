package dictionary.storage;

import java.io.*;

public class IndexFileHandler {
    static final String INDEX_FILE = "dictionary_index.txt";
    
    public IndexFileHandler() throws IOException {
        File file = new File(INDEX_FILE);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
    
    public void addEntry(String key, long position, int length) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INDEX_FILE, true))) {
            writer.write(key + " " + position + " " + length + "\n");
        }
    }
    
    public String findEntry(String key) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INDEX_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 3);
                if (parts.length == 3 && parts[0].equalsIgnoreCase(key)) {
                    return parts[1] + " " + parts[2];
                }
            }
        }
        return null;
    }
}