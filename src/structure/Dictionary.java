package structure;

import static_type.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Dictionary {

    private HashMap<Character, DNode> root;
    private HashSet<String> words;

    public Dictionary(){
        this.root = new HashMap<>();
        this.words = new HashSet<>();
    }

    public void add(String word, String definition, ArrayList<Type> types, String sentence){
        if(word.isEmpty() || definition.isEmpty() || types == null){
            return;
        }
        words.add(word);
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
        node.getDefinitions().add(def);
    }

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

    public boolean contains(String word){
        return words.contains(word);
    }

    @Override
    public String toString(){
        return root.toString();
    }

}
