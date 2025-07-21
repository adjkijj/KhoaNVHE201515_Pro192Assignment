package dictionary.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryStorage {
    private final IndexFileHandler indexHandler;
    private final DataFileHandler dataHandler;
    private final Map<String, String> cache;
    
    public DictionaryStorage() throws IOException {
        this.indexHandler = new IndexFileHandler();
        this.dataHandler = new DataFileHandler();
        this.cache = new HashMap<>();
        loadCache();
    }
    
    private void loadCache() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(IndexFileHandler.INDEX_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 3);
                if (parts.length == 3) {
                    cache.put(parts[0], parts[1] + "|" + parts[2]);
                }
            }
        }
    }
    
    public void addEntry(String key, String value) throws IOException {
        // Ghi value vào data file
        long valuePos = dataHandler.writeData(value);
        int valueLen = value.length();
        
        // Ghi key vào data file
        long keyPos = dataHandler.writeData(key);
        int keyLen = key.length();
        
        // Thêm vào index file
        indexHandler.addEntry(key, valuePos, valueLen);
        indexHandler.addEntry(value, keyPos, keyLen);
        
        // Cập nhật cache
        cache.put(key, valuePos + "|" + valueLen);
        cache.put(value, keyPos + "|" + keyLen);
    }
    
    public String lookup(String key) throws IOException {
        String entry = cache.get(key);
        if (entry != null) {
            String[] parts = entry.split("\\|");
            long position = Long.parseLong(parts[0]);
            int length = Integer.parseInt(parts[1]);
            return dataHandler.readData(position, length);
        }
        return null;
    }
}