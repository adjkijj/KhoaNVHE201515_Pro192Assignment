package dictionary.service;

import dictionary.storage.DictionaryStorage;
import java.io.IOException;

public class LookupService {
    private final DictionaryStorage storage;
    
    public LookupService(DictionaryStorage storage) {
        this.storage = storage;
    }
    
    public String lookup(String word) {
        try {
            String result = storage.lookup(word);
            return result != null ? result : "Không tìm thấy từ trong từ điển";
        } catch (IOException e) {
            System.err.println("Lỗi khi tra từ: " + e.getMessage());
            return "Lỗi khi tra từ";
        }
    }
}