package dictionary.ui;

import dictionary.service.DictionaryService;
import dictionary.service.LookupService;

public class DictionaryUI {
    private final MenuManager menuManager;
    
    public DictionaryUI(DictionaryService dictService, LookupService lookupService) {
        this.menuManager = new MenuManager(dictService, lookupService);
    }
    
    public void run() {
        while (true) {
            menuManager.showMainMenu();
            int choice = menuManager.getMenuChoice();
            
            switch (choice) {
                case 1:
                    menuManager.handleAddWord();
                    break;
                case 2:
                    menuManager.handleLookup();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}