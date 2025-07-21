package dictionary.ui;

import dictionary.service.DictionaryService;
import dictionary.service.LookupService;

public class MenuManager {
    private final DictionaryService dictService;
    private final LookupService lookupService;
    private final UserInputHandler inputHandler;
    
    public MenuManager(DictionaryService dictService, LookupService lookupService) {
        this.dictService = dictService;
        this.lookupService = lookupService;
        this.inputHandler = new UserInputHandler();
    }
    
    public void showMainMenu() {
        System.out.println("\n==== DICTIONARY APP ====");
        System.out.println("1. Thêm từ mới");
        System.out.println("2. Tra từ");
        System.out.println("3. Thoát");
    }
    
    public void handleAddWord() {
        if (dictService.addWord(inputHandler.getNewWordInput())) {
            System.out.println("Đã thêm từ thành công!");
        } else {
            System.out.println("Thêm từ thất bại!");
        }
    }
    
    public void handleLookup() {
        System.out.println("Kết quả: " + lookupService.lookup(inputHandler.getLookupWord()));
    }
    
    public int getMenuChoice() {
        return inputHandler.getMenuChoice();
    }
}