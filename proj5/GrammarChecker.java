/**
 * Uses a thesaurus and word frequencies to replace overused words in a text document with random synonyms.
 * @author: Advitya Singh and Chris Fernandez
 * @version: June 6, 2025
 */
package proj5;

public class GrammarChecker {

    int threshold;
    Thesaurus<EntryForThesaurus> thesaurus;

    /**
     * Non-default constructor. Builds a thesaurus out of the
     * given comma-separated file and sets the threshold for overused words. 
     * 
     * @param thesaurusFile path to comma-separated file used to build a thesaurus
     * @param threshold a word is considered "overused" if it appears more than 
     * (but not equal to) this many times in a text document
     */
    public GrammarChecker(String thesaurusFile, int threshold){
        thesaurus = new Thesaurus<>(thesaurusFile);
        this.threshold = threshold;
    }
    
    /**
     * Given a text file, replaces overused words with synonyms.
     * Finished text is printed to the console.
     * 
     * @param textfile file with original text
     */
    public void improveGrammar(String textfile) {
        WordCounter wordCounter = new WordCounter();
        wordCounter.findFrequencies(textfile);

        LineReader reader = new LineReader(textfile, " ");

        String[] line;
        while ((line = reader.getNextLine()) != null) {

            for (int i = 0; i < line.length; i++) {
                String word = line[i];

                String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                String punctuation = word.replaceAll("[a-zA-Z]", "");
                int frequency = wordCounter.getFrequency(cleanWord);

                if (frequency > threshold) {
                    String synonym = thesaurus.getSynonymFor(cleanWord);
                    if (!synonym.equals("")) {
                        String replaced = matchCapitalization(word.replaceAll("[^a-zA-Z]", ""), synonym);
                        System.out.print(replaced + punctuation + " ");
                    } else {
                        System.out.print(word + " ");
                    }
                } else {
                    System.out.print(word + " ");
                }
            }
        }
        }

    /**
     * Helper method for improveGrammar. Helps make sure two words of different capitalization count as the same word.
     * @param original original string encountered in text. 
     * @param replacement what to replace the non-word charachters like punctuation with. Usually an empty string. 
     * @return lowercase of the original word without punctuation. 
     */
    private String matchCapitalization(String original, String replacement) {
        if (original.toUpperCase().equals(original)) {
            return replacement.toUpperCase();
        } else if (Character.isUpperCase(original.charAt(0))) {
            return Character.toUpperCase(replacement.charAt(0)) + replacement.substring(1);
        } else {
            return replacement.toLowerCase();
        }
    }

}
