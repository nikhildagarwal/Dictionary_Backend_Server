package structure;

import java.util.ArrayList;
import java.util.HashMap;

public class DNode {

    private ArrayList<Definition> definitions;
    private HashMap<Character, DNode> next;

    public DNode(){
        this.next = new HashMap<>();
        this.definitions = new ArrayList<>();
    }

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

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    public HashMap<Character, DNode> getNext() {
        return next;
    }

    public void setDefinitions(ArrayList<Definition> definitions) {
        this.definitions = definitions;
    }

    public void setNext(HashMap<Character, DNode> next) {
        this.next = next;
    }

    @Override
    public String toString(){
        String message = "";
        message += "Definitions: " + definitions.toString() + "\n";
        message += "Next: " + next.toString() + "\n";
        return message;
    }
}
