# The Grammar Checker
A software for an **automated grammar** checker that checks for overused words in a text file. It replaces these overused words with synonyms from a provided thesaurus. The algorithm additionaly maintains punctuation and sentence case.

## 🚀 Accomplished via this Project
- An algorithm that creates a thesaurus data structure from a text file where the first word in a line is they keyword and all the following words are synonyms.
- A word counter data structure that determines the frequency of each word in an input file.
- Created the above two data structures using a binary search tree data structure.
- Gained expertise with Java generics and interfaces. 
- Contended with good design principles like modularity, reusibility, understandibity, coherency, efficiency, and robustness.

## 📂 How the algorithm works summarized (use JavaDocs to understand each embedded data structure and its purpose)
1. Input: GrammarChecker creates a Thesaurus and executes the algorithm to improve grammar.  
2. The algorithm identifies overused words in the text using the WordCounter data structure. 
3. Overused words are replaced with synonyms from the thesaurus data structure while preserving sentence case and punctuation.  
4. Output: A cleaned-up version of the original text.

## 🔮 Future Improvements
- **Integration with Public Thesaurus APIs**: Extend functionality by connecting to publicly available thesaurus datasets or APIs, enabling broader synonym suggestions.  
- **User-Facing Application**: Transform the project into a standalone application (desktop or web-based) with an intuitive interface, allowing non-technical users to easily check and improve their writing.  
- **Enhanced Synonym Selection**: Implement context-aware algorithms to choose the most appropriate synonym, improving readability and preserving intended meaning.  

