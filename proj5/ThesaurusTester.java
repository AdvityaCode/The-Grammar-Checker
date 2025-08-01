/**
 * /**
 * Testing file for Thesaurus Object.
 * @author: Advitya Singh
 * @version: June 6, 2025
 */
package proj5;
import org.junit.*;

import static org.junit.Assert.*;
import org.junit.rules.Timeout;

public class ThesaurusTester {

    @Rule
	public Timeout timeout = Timeout.millis(100); 

    // testing default constructor using toString. should be empty string
    @Test
    public void testConstructor() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();

        assertEquals(thesaurus.toString(), "");
    }

    // Inserting one word and synonyms into Thesaurus
    @Test
    public void testInsertAndToStringSingle() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        thesaurus.insert("happy", new String[]{"joyful", "cheerful"});

        String output = thesaurus.toString();
        assertTrue(output.contains("happy - {joyful, cheerful}"));
    }

    // testing inserting into thesaurus more than once
    @Test
    public void testAddSynonymsToExistingWord() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        thesaurus.insert("smart", new String[]{"intelligent"});
        thesaurus.insert("smart", new String[]{"clever", "intelligent"}); // "intelligent" duplicate

        String output = thesaurus.toString();
        assertTrue(output.contains("smart - {intelligent, clever}") ||
                   output.contains("smart - {clever, intelligent}"));
    }

    // inserting and deleting from thesaurus
    @Test
    public void testDeleteRemovesWord() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        thesaurus.insert("cold", new String[]{"chilly", "freezing"});
        thesaurus.delete("cold");

        String output = thesaurus.toString();
        assertFalse(output.contains("cold"));
    }

    // trying to delete a non-existing word. 
    @Test
    public void testDeleteNonExisting() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        thesaurus.delete("cold");

        String output = thesaurus.toString();
        assertFalse(output.contains("cold"));
    }


    // testing getSynonym for a word with two synonyms
    @Test
    public void testGetSynonymForExistingWord() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        thesaurus.insert("bright", new String[]{"shiny", "luminous"});
        String synonym = thesaurus.getSynonymFor("bright");

        assertTrue(synonym.equals("shiny") || synonym.equals("luminous"));
    }

    // getting synonyms for a non-existing word should be am empty string. 
    @Test
    public void testGetSynonymForNonexistentWord() {
        Thesaurus<EntryForThesaurus> thesaurus = new Thesaurus<>();
        String synonym = thesaurus.getSynonymFor("nonexistent");

        assertEquals("", synonym);
    }

    // further testing for the thesaurus was done by printing to the console using smallThesaurus.txt. 

}
