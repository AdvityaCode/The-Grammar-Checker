/**
 * One possible Comparable data entry for a BST Node. 
 * Thesaurus inserts objects of type EntryForThesaurus into BST.
 * @author: Advitya Singh
 * @version: June 6, 2025
 */

package proj5;

public class EntryForThesaurus implements Comparable<EntryForThesaurus> {
    
    // two instance variables: word itself and and array of its synonyms
    private String word;
    private String[] synonyms;

    /**
     * Non-default constructor. Constructs a EntryForThesaurus object from given word and synonym list.
     * @param word the word itself
     * @param synonymArray its synonyms
     */
    public EntryForThesaurus(String word, String[] synonymArray) {
        this.word = word;
        synonyms = synonymArray;
    }

    /**
     * Default constructor. Constructs a EntryForThesaurus object from given word 
     * and initializes array to an empty array.
     * @param word
     */
    public EntryForThesaurus(String word) {
        this.word = word;
        synonyms = new String[0];
    }

    /**
     * getter for word
     * @return word itself
     */
    public String getWord() {
        return this.word;
    }

    /**
     * getter for the synonym array
     * @return the synonym array
     */
    public String[] getSynonyms() {
        return this.synonyms;
    }

    /**
     * Adds synonyms if the word already exists in the array
     * @param toAdd the array of words to add
     */
    public void addSynonyms(String[] toAdd){
        int uniqueCount = 0;
        for (String newWord : toAdd) {
            boolean isDuplicate = false;
            for (String existing : synonyms) {
                if (existing.equals(newWord)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }

        // Create a new array with the correct new size
        String[] combined = new String[synonyms.length + uniqueCount];
        int index = 0;

        // Copy over existing synonyms
        for (String s : synonyms) {
            combined[index++] = s;
        }

        // Add new unique ones
        for (String newWord : toAdd) {
            boolean isDuplicate = false;
            for (String existing : synonyms) {
                if (existing.equals(newWord)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                combined[index++] = newWord;
            }
        }

        // Update the field
        synonyms = combined;
    }

    /**
     * compareTo method that compares two EntryForThesaurus object.
     */
    @Override
    public int compareTo(EntryForThesaurus other) {
        return this.word.compareToIgnoreCase(other.word);
    }

    /**
     * toString public method for an EntryForThesaurus object.
     * For example: really - {syn1, syn2,..., synn}
     */
    @Override
    public String toString() {
        return word.toLowerCase() + " - " + synonymsToString();
    }

    /**
     * helper method for EntryForThesaurus toString() method. 
     * @return a string of synonyms like {syn1, syn2,..., syn3}
     */
    private String synonymsToString(){
        if (synonyms.length == 0) return "{}";

        String result = "{"; 
        for (int i = 0; i < synonyms.length; i++) {
            result += synonyms[i];
            if (i < synonyms.length - 1) result += ", ";
        }
        result += "}";
        return result;
    }
}
