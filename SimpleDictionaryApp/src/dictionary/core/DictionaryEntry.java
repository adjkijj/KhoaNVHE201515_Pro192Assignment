package dictionary.core;

public class DictionaryEntry {
    private final String word;
    private final String meaning;
    
    public DictionaryEntry(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
    
    public String getWord() { return word; }
    public String getMeaning() { return meaning; }
    
    @Override
    public String toString() {
        return word + " - " + meaning;
    }
}