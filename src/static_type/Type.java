package static_type;

public enum Type {

    NOUN("noun"),
    VERB("verb"),
    ADJECTIVE("adjective"),
    ADVERB("adverb"),
    PRONOUN("pronoun"),
    PREPOSITION("preposition"),
    CONJUNCTION("conjunction"),
    INTERJECTION("interjection"),
    TRANSITIVE_VERB("transitive verb"),
    INTRANSITIVE_VERB("intransitive verb"),
    IMPERATIVE("imperative"),
    IMPARFAIT("imparfait"),
    PARTICLE("particle"),
    ARTICLE("article"),
    SUFFIX("suffix"),
    SUPERLATIVE("superlative"),
    INTRANSITIVE("intransitive"),
    OBSOLETE("obsolete"),
    INFINITIVE("infinitive"),
    PREFIX("prefix"),
    OBJECT("object"),
    NONE("n/a");

    private final String string;

    Type(String string){
        this.string = string;
    }

    public String getString(){
        return string;
    }
}
