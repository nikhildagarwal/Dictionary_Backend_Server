import static_type.Type;
import structure.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args){
        Dictionary dict = new Dictionary();
        dict.add("nikhil","Creator of this Book",new ArrayList<>(Arrays.asList(Type.NOUN,Type.PROPER_NOUN)),"Hi my name is Nikhil");
        dict.add("a","Singular",new ArrayList<>(List.of(Type.NOUN)),"I would like a bagel");
        dict.add("astra","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("assist","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("alaby","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("alabi","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("nikher","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("lullaby","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("lullaci","valorant agent from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("lullaci","valorant agent from ghana playing",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("astra","valorant agent ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");
        dict.add("astra","valorant from ghana playing smokes",new ArrayList<>(List.of(Type.PROPER_NOUN)),"I main astra on haven");

        ArrayList<String> hi = dict.getList("a");
        System.out.println(hi);
    }
}
