/**
 * Testing file for WordCounter Object.
 * @author: Advitya Singh
 * @version: June 6, 2025
 */
package proj5;

import org.junit.*;

import static org.junit.Assert.*;
import org.junit.rules.Timeout;


public class WordCounterTester {

    private WordCounter wordCounter;

    @Rule
	public Timeout timeout = Timeout.millis(100); 

    @Before
    public void setUp() {
        wordCounter = new WordCounter();
    }


    // Constructing a wordCounter testing using toString
    @Test
    public void testConstructor(){
        assertEquals(wordCounter.toString(), "");
    }

    // from this point, all testing for wordCounter is done using the apartment text provided.

    // testing findFrequency and getFrequency: word occuring once
    @Test
    public void findingFrequencyForWordOccuringOnce(){
        wordCounter.findFrequencies("proj5/apartment.txt");
        assertEquals(wordCounter.getFrequency("when"), 1);
    }

    // testing findFrequency and getFrequency: word occuring five times
    @Test
    public void getFrequencyForWordOccuringMultiple(){
        wordCounter.findFrequencies("proj5/apartment.txt");
        assertEquals(wordCounter.getFrequency("grungy"), 5);
    }

    // testing findFrequency and getFrequency: lastWord
    @Test
    public void getFrequencyForLastWord(){
        wordCounter.findFrequencies("proj5/apartment.txt");
        assertEquals(wordCounter.getFrequency("insane"), 3);
    }

    // testing getFrequency for non-existing word
    @Test
    public void getFrequencyNonexistingWord(){
        wordCounter.findFrequencies("proj5/apartment.txt");
        assertEquals(wordCounter.getFrequency("yes"), 0);
    }

    // toString for entire wordCounter was done in main method by printing. 
}
