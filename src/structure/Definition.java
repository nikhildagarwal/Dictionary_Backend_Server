package structure;

import static_type.Type;

import java.util.ArrayList;

public class Definition {

    private String definition;
    private ArrayList<Type> types;
    private String sentence;

    public Definition(String definition, ArrayList<Type> type, String sentence){
        this.definition = definition;
        this.types = type;
        this.sentence = sentence;
    }

    public String getDefinition() {
        return definition;
    }

    public String getSentence() {
        return sentence;
    }

    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

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
