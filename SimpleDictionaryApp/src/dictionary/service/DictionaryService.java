package dictionary.service;

import dictionary.core.DictionaryEntry;
import dictionary.storage.DictionaryStorage;
import java.io.IOException;

public class DictionaryService {
    private final DictionaryStorage storage;
    
    public DictionaryService(DictionaryStorage storage) {
        this.storage = storage;
    }
    
    public boolean addWord(DictionaryEntry entry) {
        try {
            storage.addEntry(entry.getWord(), entry.getMeaning());
            return true;
        } catch (IOException e) {
            System.err.println("Lỗi khi thêm từ: " + e.getMessage());
            return false;
        }
    }
}