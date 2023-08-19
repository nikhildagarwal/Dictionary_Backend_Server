package structure;

import static_type.Type;

import java.util.ArrayList;

/**
 * Definition Object for a specific word
 * Contains the actual definition of a word, the type of word it is, and an example sentence for the word
 * Used to store Definition of word in the specific node of that word in our dictionary data structure
 */
public class Definition {

    private String definition;
    private ArrayList<Type> types;
    private String sentence;

    /**
     * Constructor for definition Object
     * @param definition String definition of word
     * @param type List of Types Enums
     * @param sentence Example sentence
     */
    public Definition(String definition, ArrayList<Type> type, String sentence){
        this.definition = definition;
        this.types = type;
        this.sentence = sentence;
    }

    /**
     * Getter method for definition
     * @return String definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Getter method for sentence
     * @return String sentence
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Getter method for List of Type Enums
     * @return ArrayList of types
     */
    public ArrayList<Type> getTypes() {
        return types;
    }

    /**
     * Set definition
     * @param definition String defintion
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * Set Sentence
     * @param sentence String sentence
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Override toString method
     * @return String representation of definition
     */
    @Override
    public String toString(){
        String message = "[";
        message += "Definition: " + definition+", ";
        String sub = "|";
        for(Type t: types){
            sub += t.getString()+"|";
        }
        message += "Type: " + sub + ", ";
        message += "Sentence: " + sentence ;
        return message + "]";
    }

    /**
     * Override Equals method
     * @param obj Definition Object to compare to
     * @return true if the same, false if otherwise
     */
    @Override
    public boolean equals(Object obj){
        try{
            Definition def = (Definition) obj;
            return def.sentence.equals(sentence) && def.types.equals(types) && def.definition.equals(definition);
        }catch (Exception e){
            return false;
        }
    }
}
