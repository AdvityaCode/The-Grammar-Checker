/**
 * Comparable data entry for a BST Node. 
 * WordCounter inserts objects of type WCounterInput into BST.
 * @author: Advitya Singh
 * @version: June 6, 2025
 */

package proj5;

public class WCounterInput implements Comparable<WCounterInput> {

    // two instance variables, the word itslef and the wordFrequency is the number of times it occurs
    private String wordItself;
    private int wordFrequency;

    /**
     * Constructor: constructs a word with 1 frequency. 
     * @param word
     */
    public WCounterInput(String word){
        wordItself = word;
        wordFrequency = 1;
    }

    /**
     * increases frequency by 1. 
     */
    public void increaseFrequency(){
        wordFrequency++;
    }

    /**
     * returns the word itself
     * @return the String of the word
     */
    public String getWord(){
        return wordItself;
    }

    /**
     * returns the number of times the word occurs
     * @return the int frequency instance variable
     */
    public int getFrequency(){
        return wordFrequency;
    }

    /**
     * compareTo for a WCounterInput object. 
     * Uses the simple word compare to that compares alphabetically.
     */
    @Override
    public int compareTo(WCounterInput other) {
        return this.wordItself.compareTo(other.getWord());
    }

    /**
     * toString for a WCounterInput object.
     * For example: hello: 2
     */
    public String toString() {
        return getWord() + ": " + getFrequency();
    }

}
