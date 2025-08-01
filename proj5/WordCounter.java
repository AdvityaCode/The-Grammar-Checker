/**
 * An ADT for computing word frequencies from a text file.
 * @author: Advitya Singh and Chris Fernandez
 * @version: June 6, 2025
 */

package proj5;

public class WordCounter {

    // Only one instance variable: a BST holding WCounterInput object as data. 
    private BinarySearchTree<WCounterInput> BSTWordCounter;

    /*
     * Default constructor: creates a BST for the WordCounter.
     */
    public WordCounter(){
        BSTWordCounter = new BinarySearchTree<>();
    }
    
    /**
     * Computes frequency of each word in given file.
     * @param file path to file, such as "src/input.txt".
     */
    public void findFrequencies(String file){
        LineReader reader = new LineReader(file, " ");
        String[] words;

        while ((words = reader.getNextLine()) != null) {
            for (String rawWord : words) {
                String cleanedWord = rawWord.replaceAll("[^a-zA-Z]", "").toLowerCase();
                if (!cleanedWord.isEmpty()) {
                    insertOrIncreaseFrequencyinBSTWordCounter(cleanedWord);
                }
            }
        }
        reader.close();
    }

    /**
     * inserts a word into WordCounter or increases frequency if the word already exists
     * @param rawWord word to insert into WordCounter
     */
    private void insertOrIncreaseFrequencyinBSTWordCounter(String rawWord){
        WCounterInput currentWord = new WCounterInput(rawWord);

        if (BSTWordCounter.search(currentWord) == false){
            BSTWordCounter.insert(currentWord);
        }

        else {
            WCounterInput existing = BSTWordCounter.find(currentWord);
            existing.increaseFrequency();
        }
    }

    /**
     * returns the frequency of the given word
     * @param word string to get the frequency of
     * @return the number of times word appears in the input file
     */
    public int getFrequency(String word){
        word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        WCounterInput input = new WCounterInput(word);
        WCounterInput InputNode = BSTWordCounter.find(input);
        if (InputNode == null) return 0;
        return InputNode.getFrequency();
    }

    /**
     * returns words and their frequencies as a printable String. 
     * Each word/frequency pair should be on a separate line, and 
     * the format of each line should be <word>: <frequency>.
     * For example,
     * are: 3
     * bacon: 2
     * Words should be in alphabetical order.
     * @return string form of wordcounter
     */
    public String toString(){
        return BSTWordCounter.toString().trim();
    }
}
