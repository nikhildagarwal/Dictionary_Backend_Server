package structure;

import static_type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Custom Dictionary Data Structure
 * Contains root hashMap structure which has keys of characters and values of nodes.
 * Noes point to a list of definitions, as well as another hashMap of the same type.
 * In this way we create a tree like structure.
 */
public class Dictionary {

    private HashMap<Character, DNode> root;

    /**
     * Constructor for Dictionary Object
     */
    public Dictionary(){
        this.root = new HashMap<>();
    }

    /**
     * Add Definition to Dictionary
     * @param word String Word we want to add
     * @param definition String definition
     * @param types List of Type Enums
     * @param sentence String sentence
     */
    public boolean add(String word, String definition, ArrayList<Type> types, String sentence){
        if(word.isEmpty() || definition.isEmpty() || types == null){
            return false;
        }
        Definition def = new Definition(definition,types,sentence);
        char[] characters = word.toCharArray();
        HashMap<Character, DNode> start = root;
        DNode node = null;
        for(char c: characters){
            node = start.get(c);
            if(node == null){
                node = new DNode();
                start.put(c,node);
            }
            start = node.getNext();
        }
        if(!node.getDefinitions().contains(def)){
            node.getDefinitions().add(def);
            return true;
        }
        return false;
    }

    /**
     * Retrieve the definitions of a particular word
     * @param word String word we want to search for
     * @return List of definitions
     */
    public ArrayList<Definition> getDefinitionList(String word){
        if(word.isEmpty()){
            return null;
        }
        char[] characters = word.toCharArray();
        HashMap<Character, DNode> start = root;
        DNode node = null;
        for(char c: characters){
            node = start.get(c);
            if(node == null){
                return null;
            }
            start = node.getNext();
        }
        ArrayList<Definition> toReturn = node.getDefinitions();
        return toReturn.isEmpty() ? null : toReturn;
    }

    /**
     * Remove Definition from the dictionary
     * @param word String word we want to remove definition from
     * @param definition Definition object we want to remove from List of Definitions
     */
    public void removeDefinition(String word, Definition definition){
        if(word.isEmpty() || definition == null){
            return;
        }
        HashMap<Character, DNode> start = root;
        char[] characters = word.toCharArray();
        DNode node = null;
        for(char c: characters){
            node = start.get(c);
            if(node == null){
                return;
            }
            start = node.getNext();
        }
        node.getDefinitions().remove(definition);
    }

    /**
     * Remove Definition from the dictionary
     * @param word String word we want to remove definition from
     * @param defIndex Index of Definition Object we want to remove from Definitions List
     */
    public void removeDefinition(String word, int defIndex){
        if(word.isEmpty() || defIndex < 0){
            return;
        }
        HashMap<Character, DNode> start = root;
        char[] characters = word.toCharArray();
        DNode node = null;
        for(char c: characters){
            node = start.get(c);
            if(node == null){
                return;
            }
            start = node.getNext();
        }
        node.getDefinitions().remove(defIndex);
    }

    /**
     * Checks Dictionary Object to see if word exists in the data structure
     * @param word String word
     * @return true if word is found, false if otherwise
     */
    public boolean contains(String word){
        if(word.isEmpty()){
            return false;
        }
        HashMap<Character, DNode> start = root;
        char[] characters = word.toCharArray();
        DNode node = null;
        for(char c: characters){
            node = start.get(c);
            if(node == null){
                return false;
            }
            start = node.getNext();
        }
        return !node.getDefinitions().isEmpty();
    }

    /**
     * Override ToString method
     * @return String visualization of Dictionary Object
     */
    @Override
    public String toString(){
        return root.toString();
    }

}
