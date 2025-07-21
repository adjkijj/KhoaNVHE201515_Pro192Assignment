package dictionary;

import dictionary.service.DictionaryService;
import dictionary.service.LookupService;
import dictionary.storage.DictionaryStorage;
import dictionary.ui.DictionaryUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            DictionaryStorage storage = new DictionaryStorage();
            DictionaryService dictService = new DictionaryService(storage);
            LookupService lookupService = new LookupService(storage);
            
            DictionaryUI appUI = new DictionaryUI(dictService, lookupService);
            appUI.run();
        } catch (IOException e) {
            System.err.println("Lỗi khởi tạo ứng dụng: " + e.getMessage());
        }
    }
}