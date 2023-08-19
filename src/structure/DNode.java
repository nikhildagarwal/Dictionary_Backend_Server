package structure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Node object for HashMap Values
 * Contains pointer to List of definitions, and pointer to the next HashMap in the "tree"
 */
public class DNode {

    private ArrayList<Definition> definitions;
    private HashMap<Character, DNode> next;

    /**
     * Constructor for null DNode
     */
    public DNode(){
        this.next = new HashMap<>();
        this.definitions = new ArrayList<>();
    }

    /**
     * Constructor for DNode with Preset values
     * @param definitions List of Definition Objects
     * @param next HashMap contains next set of keys and values
     */
    public DNode(ArrayList<Definition> definitions, HashMap<Character, DNode> next){
        this.next = next;
        this.definitions = definitions;
        if(this.next == null){
            this.next = new HashMap<>();
        }
        if(this.definitions == null){
            this.definitions = new ArrayList<>();
        }
    }

    /**
     * Getter method for list of definitions
     * @return List of Definition Objects
     */
    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    /**
     * Getter method for getting the next hashMap in chain
     * @return HashMap of next character and DNode pairs
     */
    public HashMap<Character, DNode> getNext() {
        return next;
    }

    /**
     * Override and set definitions of Dnode to given List
     * @param definitions List of Definitions
     */
    public void setDefinitions(ArrayList<Definition> definitions) {
        this.definitions = definitions;
    }

    /**
     * Override and set next HashMap to given Map
     * @param next HashMap of Character, DNode pairs
     */
    public void setNext(HashMap<Character, DNode> next) {
        this.next = next;
    }

    /**
     * Override of toString method
     * @return String representation of DNode object
     */
    @Override
    public String toString(){
        String message = "";
        message += "Definitions: " + definitions.toString() + "\n";
        message += "Next: " + next.toString() + "\n";
        return message;
    }
}
