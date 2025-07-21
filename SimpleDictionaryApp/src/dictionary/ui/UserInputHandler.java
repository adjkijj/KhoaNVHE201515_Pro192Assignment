package dictionary.ui;

import dictionary.core.DictionaryEntry;
import java.util.Scanner;

public class UserInputHandler {
    private final Scanner scanner;
    
    public UserInputHandler() {
        this.scanner = new Scanner(System.in, "UTF-8");
    }
    
    public DictionaryEntry getNewWordInput() {
        System.out.print("Nhập từ: ");
        String word = scanner.nextLine().trim();
        System.out.print("Nhập nghĩa: ");
        String meaning = scanner.nextLine().trim();
        return new DictionaryEntry(word, meaning);
    }
    
    public String getLookupWord() {
        System.out.print("Nhập từ cần tra: ");
        return scanner.nextLine().trim();
    }
    
    public int getMenuChoice() {
        System.out.print("Nhập lựa chọn: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}