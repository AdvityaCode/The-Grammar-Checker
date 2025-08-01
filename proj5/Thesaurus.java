/**
 * Data structure that holds words and their associated synonyms. You can look up a word and retrieve a synonym for it.
 * @author: Advitya Singh and Chris Fernandez
 * @version: June 6, 2025
 */

package proj5;
import java.util.Random;

public class Thesaurus<E> {

    // Only one instance variable: a BST holding EntryForThesaurus object as data. 
    private BinarySearchTree<EntryForThesaurus> BSTThesaurus;
    
    /**
     * Default constructor. Creates an empty thesaurus.
     */
    public Thesaurus(){
        BSTThesaurus = new BinarySearchTree<>();
    }

    /**
     * Builds a thesaurus from a text file.
     * Each line of the text file is a comma-separated list of synonymous words. The first word 
     * in each line should be the thesaurus entry. The remaining words 
     * on that line are the list of synonyms for the entry.
     * 
     * @param file path to comma-delimited text file
     */
    public Thesaurus(String file){
        BSTThesaurus = new BinarySearchTree<>();

        LineReader reader = new LineReader(file, ",");
        String[] eachLine;

        while ((eachLine = reader.getNextLine()) != null) {
            if (eachLine.length > 1) {
                String firstWord = eachLine[0].toLowerCase();
                String[] synonymList = new String[eachLine.length - 1];
                for (int i = 1; i < eachLine.length; i++) {
                    synonymList[i - 1] = eachLine[i];
                }
                insert(firstWord, synonymList);
            }

            else if (eachLine.length == 1){
                String firstWord = eachLine[0].toLowerCase();
                String[] synonymList = {};
                insert(firstWord, synonymList);
            }
        }
        reader.close();
    }

    /**
     * removes entry (and its associated synonym list) from this thesaurus.
     * If entry does not exist, do nothing.
     * 
     * @param entry word to remove
     */
    public void delete(String entry){
        EntryForThesaurus entryToDelete = new EntryForThesaurus(entry);
        BSTThesaurus.delete(entryToDelete);
    }

    /**
     * Gets a random synonym for the given keyword.
     * If keyword does not exist, return the empty string.
     * 
     * @param keyword word to find a synonym for
     * @return a random synonym from the synonym list of that word, 
     * or empty string if keyword doesn't exist.
     */
    public String getSynonymFor(String keyword){
        EntryForThesaurus ThesaurusInput = new EntryForThesaurus(keyword);
        if (BSTThesaurus.search(ThesaurusInput) == false){
            return "";
        }

        else {
            Random rand = new Random();
            String[] synonymList = BSTThesaurus.find(ThesaurusInput).getSynonyms();
            if (synonymList.length == 0) {
                return "";
            }
            int randomIndex = rand.nextInt(synonymList.length);
            return synonymList[randomIndex];
        }
    }

    /**
     * inserts entry and synonyms into thesaurus.
     * If entry does not exist, it creates one. If it does exist, it adds the given 
     * synonyms to the entry's synonym list.
     * 
     * @param entry keyword to be added
     * @param syns array of synonyms for keyword entry
     */
    public void insert(String entry, String[] syns){
        EntryForThesaurus temp = new EntryForThesaurus(entry.toLowerCase());

        if (BSTThesaurus.search(temp)){
            BSTThesaurus.find(temp).addSynonyms(syns);
        }

        else {
            BSTThesaurus.insert(new EntryForThesaurus(entry, syns));
        }
    }
    
    /**
     * return this thesaurus as a printable string. Each keyword 
     * and synonym list should be on its own line. The format of 
     * each line is: <keyword> - {<syn1>, <syn2>, ..., <synN>}
     * For example, happy - {glad, content, joyful}
     * jump - {leap, bound}
     * The thesaurus keywords will be in alphabetical order. 
     * The order of the synonym list words is arbitrary.
     * 
     * @return String representation
     */
    public String toString() {
        return BSTThesaurus.toString();
    }
}
