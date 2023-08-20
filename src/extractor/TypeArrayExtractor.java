package extractor;
import static_type.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * TypeArrayExtractor Class
 * Holds Map of all possible word types found in CSV files and points them to a proper Type Enum list conversion.
 */
public class TypeArrayExtractor {

    private ArrayList<Type> types;
    private static HashMap<String,ArrayList<Type>> mapper;

    /**
     * Constructor for TypeExtractor
     * Converts all possible types words in our CSV to an arrayList of acceptable Type Enums
     */
    public TypeArrayExtractor(){
        mapper = new HashMap<>();
        mapper.put("v. t. / i.",new ArrayList<>(Arrays.asList(Type.TRANSITIVE_VERB,Type.INTRANSITIVE_VERB)));
        mapper.put("compar.",new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("b.",new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("imp. &, p. p.", new ArrayList<>(Arrays.asList(Type.IMPARFAIT,Type.PARTICLE)));
        mapper.put("strong imp.",new ArrayList<>(List.of(Type.IMPARFAIT)));
        mapper.put("prep., adv. & a.",new ArrayList<>(Arrays.asList(Type.PREPOSITION,Type.ADVERB,Type.ADJECTIVE)));
        mapper.put("v. & n.",new ArrayList<>(Arrays.asList(Type.NOUN,Type.VERB)));
        mapper.put("n. & v",new ArrayList<>(Arrays.asList(Type.NOUN,Type.VERB)));
        mapper.put("n. & v.",new ArrayList<>(Arrays.asList(Type.NOUN,Type.VERB)));
        mapper.put("n.pl.",new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p.a.",new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("a. Vigorously",new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("sing. / pl.",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("suffix.",new ArrayList<>(List.of(Type.SUFFIX)));
        mapper.put("obs. strong p. p.",new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("n. m.",new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("#",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("obj.",new ArrayList<>(List.of(Type.OBJECT)));
        mapper.put("adv. / interj.", new ArrayList<>(Arrays.asList(Type.INTERJECTION,Type.ADVERB)));
        mapper.put("adv. & conj.", new ArrayList<>(Arrays.asList(Type.CONJUNCTION,Type.ADVERB)));
        mapper.put("v. t. & v. i.",new ArrayList<>(Arrays.asList(Type.TRANSITIVE_VERB,Type.INTRANSITIVE_VERB)));
        mapper.put("v. i. & t.",new ArrayList<>(Arrays.asList(Type.TRANSITIVE_VERB,Type.INTRANSITIVE_VERB)));
        mapper.put("obs. imp.",new ArrayList<>(List.of(Type.VERB)));
        mapper.put("a. & pron.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.PRONOUN)));
        mapper.put("/", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. & vb. n", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("v. r.", new ArrayList<>(List.of(Type.VERB)));
        mapper.put("possessive pron.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("See", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. a. & vb. n.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("pref.",new ArrayList<>(List.of(Type.PREFIX)));
        mapper.put("2d person", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("adj. & conj.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.CONJUNCTION)));
        mapper.put("p. & a.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("adv. In combination or cooperation", new ArrayList<>(List.of(Type.ADVERB)));
        mapper.put("imp.& p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("Obs. imp.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("imp. & p. p. & vb. n.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE, Type.NOUN)));
        mapper.put("p. pr. &, vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("imp. & p. p. Fenced", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("p. p. &", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("adj.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("Indic. present", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("fem.",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. & a.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.ADJECTIVE)));
        mapper.put("Sing. pres. ind.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("interj.", new ArrayList<>(List.of(Type.INTERJECTION)));
        mapper.put("v. t.& i.", new ArrayList<>(Arrays.asList(Type.INTRANSITIVE_VERB, Type.TRANSITIVE_VERB)));
        mapper.put("adv., prep., & conj.", new ArrayList<>(Arrays.asList(Type.ADVERB, Type.PREPOSITION, Type.CONJUNCTION)));
        mapper.put("2d pers. sing. pres.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("p. p & a.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("e. i.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("indef. pron.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("inf", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("imp. p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("n. fem.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("v./.", new ArrayList<>(List.of(Type.VERB)));
        mapper.put("a", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("e", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("ad.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("adv., & n.", new ArrayList<>(Arrays.asList(Type.ADVERB, Type.NOUN)));
        mapper.put("a. a.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("-n/", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("n", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("ambassade.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. & vb. /", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.VERB)));
        mapper.put("n., a., & v.", new ArrayList<>(Arrays.asList(Type.NOUN,Type.ADJECTIVE,Type.VERB)));
        mapper.put("prep. & adv.", new ArrayList<>(Arrays.asList(Type.PREPOSITION,Type.ADVERB)));
        mapper.put("t",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("v. t.", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("v.", new ArrayList<>(List.of(Type.VERB)));
        mapper.put("v. t..", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("p. pr. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("A prefix.", new ArrayList<>(List.of(Type.PREFIX)));
        mapper.put("pron. / adj.", new ArrayList<>(Arrays.asList(Type.PRONOUN, Type.ADJECTIVE)));
        mapper.put("obs. imp. & p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("inerj.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("n.& v.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.VERB)));
        mapper.put("imp. & p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.PARTICLE)));
        mapper.put("n. sing & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("v.t.", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("adv. & n.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.NOUN)));
        mapper.put("p. pr. & vb n.", new ArrayList<>(Arrays.asList(Type.NOUN,Type.PARTICLE)));
        mapper.put("ae.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("superl.", new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("imp. & pp.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("n. & v. t.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.TRANSITIVE_VERB)));
        mapper.put("a. & v. t.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.TRANSITIVE_VERB)));
        mapper.put("a. & v.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.VERB)));
        mapper.put("prep., adv., conj. & n.", new ArrayList<>(Arrays.asList(Type.PREPOSITION, Type.ADJECTIVE, Type.CONJUNCTION, Type.NOUN)));
        mapper.put("a. .", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("variant", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("imperative sing.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("imp. & p. p.,", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("dat. & obj.", new ArrayList<>(List.of(Type.OBJECT)));
        mapper.put("p. pr. & vb, n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("conj. / adv.", new ArrayList<>(Arrays.asList(Type.CONJUNCTION,Type.ADVERB)));
        mapper.put("interrog. adv.", new ArrayList<>(List.of(Type.ADVERB)));
        mapper.put("interj., adv., or a.", new ArrayList<>(Arrays.asList(Type.INTERJECTION, Type.ADVERB, Type.ADJECTIVE)));
        mapper.put("interj. & n.", new ArrayList<>(Arrays.asList(Type.INTERJECTION,Type.NOUN)));
        mapper.put("n & v.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.VERB)));
        mapper.put("n. a.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("n./", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("pres. & imp.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("n..", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("pron.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("superl", new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("pres. sing.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p. pr & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("p]. pr. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("v. impers.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("imperative.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("p. pr.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("v. & a.", new ArrayList<>(Arrays.asList(Type.VERB, Type.ADJECTIVE)));
        mapper.put("p pr. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("n. pl", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p. p. & a", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("pers. pron.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("v. t. & n.", new ArrayList<>(Arrays.asList(Type.TRANSITIVE_VERB, Type.NOUN)));
        mapper.put("pres. subj.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("imp. & p. pr.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("interj. & adv.", new ArrayList<>(Arrays.asList(Type.INTERJECTION, Type.ADVERB)));
        mapper.put("a. & adv.", new ArrayList<>(Arrays.asList(Type.ADVERB, Type.ADJECTIVE)));
        mapper.put("prefix.", new ArrayList<>(List.of(Type.PREFIX)));
        mapper.put("v. i. & i.", new ArrayList<>(List.of(Type.INTRANSITIVE_VERB)));
        mapper.put("Obs", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("i.", new ArrayList<>(List.of(Type.INTRANSITIVE)));
        mapper.put("pr.p. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("infinitive.", new ArrayList<>(List.of(Type.INFINITIVE)));
        mapper.put("imp. & p. p. Adored", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.PARTICLE)));
        mapper.put("a. / n.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.NOUN)));
        mapper.put("v.i", new ArrayList<>(List.of(Type.INTRANSITIVE_VERB)));
        mapper.put("super.",new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("inf. & plural pres.", new ArrayList<>(List.of(Type.INFINITIVE)));
        mapper.put("e. t.", new ArrayList<>(List.of(Type.INTRANSITIVE)));
        mapper.put("a. f.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p. p. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("n. t.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("adv. / a.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.ADJECTIVE)));
        mapper.put("superl. -", new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("adv. & prep.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.PREPOSITION)));
        mapper.put("n .", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("v.t", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("a. & p. p.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.PARTICLE)));
        mapper.put("v. t. &", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("n. & i.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("a. Vibrating", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("a. / a. pron.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.PRONOUN)));
        mapper.put("pron. & a.",new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.PRONOUN)));
        mapper.put("v. t. / v. i.", new ArrayList<>(Arrays.asList(Type.INTRANSITIVE_VERB,Type.TRANSITIVE_VERB)));
        mapper.put("n. f.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("n.p.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("a. / pron.",new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.PRONOUN)));
        mapper.put("p. pr. &vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("3d pers. sing. pres.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("pron., a., & adv.", new ArrayList<>(Arrays.asList(Type.PRONOUN,Type.ADJECTIVE,Type.ADVERB)));
        mapper.put("v.impers.", new ArrayList<>(List.of(Type.VERB)));
        mapper.put("v. i.",new ArrayList<>(List.of(Type.INTRANSITIVE)));
        mapper.put("sing. or pl.",new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.VERB,Type.NOUN)));
        mapper.put("adv. & a.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.ADJECTIVE)));
        mapper.put("obs.", new ArrayList<>(List.of(Type.OBSOLETE)));
        mapper.put("imp. / p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.PARTICLE)));
        mapper.put("n pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("Compar. & superl. wanting, but supplied by",new ArrayList<>(List.of(Type.NONE)));
        mapper.put(", a game played with such pieces; pushpin.\"",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. & vb.", new ArrayList<>(Arrays.asList(Type.VERB,Type.PARTICLE)));
        mapper.put("sing. & pl.",new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.VERB,Type.NOUN)));
        mapper.put("mexcal.",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. & vvb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("n. & v. i.", new ArrayList<>(Arrays.asList(Type.NOUN,Type.INTRANSITIVE_VERB)));
        mapper.put("v.t & i.", new ArrayList<>(Arrays.asList(Type.INTRANSITIVE_VERB, Type.TRANSITIVE_VERB)));
        mapper.put("3d sing. pr.",new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. p. & p. a.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("a & p. p.",new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("n. sing. & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("prep., adv. & conj.", new ArrayList<>(Arrays.asList(Type.PREPOSITION,Type.ADVERB,Type.CONJUNCTION)));
        mapper.put("n. collect. & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p. pr.& vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("a & n.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.NOUN)));
        mapper.put("n. sing. & pl", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p. pr. & vb. e.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("p. p. & a.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.ADJECTIVE)));
        mapper.put("Archaic imp. & p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("imp. & p. p", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("n. / interj.",new ArrayList<>(Arrays.asList(Type.NOUN, Type.INTERJECTION)));
        mapper.put("supperl.", new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("pres. indic. sing., 1st & 3d pers.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("Compar.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("p. pr. & pr. & vb. n.",new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("imp. &. p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("ads.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("n. & adv.", new ArrayList<>(Arrays.asList(Type.NOUN,Type.ADVERB)));
        mapper.put("prep., adv., & conj.", new ArrayList<>(Arrays.asList(Type.PREPOSITION,Type.ADJECTIVE,Type.CONJUNCTION)));
        mapper.put("comp.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("pron. & conj.", new ArrayList<>(Arrays.asList(Type.PRONOUN,Type.CONJUNCTION)));
        mapper.put("p. p.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("n. pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("v. i. & n.", new ArrayList<>(Arrays.asList(Type.INTRANSITIVE_VERB, Type.NOUN)));
        mapper.put("n.sing. & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("m.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("n. / v. t. & i.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.INTRANSITIVE_VERB, Type.TRANSITIVE_VERB)));
        mapper.put("p, pr. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.NOUN)));
        mapper.put("v.i.", new ArrayList<>(List.of(Type.INTRANSITIVE)));
        mapper.put("v. t. & i.", new ArrayList<>(Arrays.asList(Type.TRANSITIVE_VERB, Type.INTRANSITIVE_VERB)));
        mapper.put("v. imperative.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("v. impersonal, pres.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("P. p. & a.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.ADJECTIVE)));
        mapper.put("a. superl.",new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("Superl.", new ArrayList<>(List.of(Type.SUPERLATIVE)));
        mapper.put("n.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("a. & a. pron.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.PRONOUN)));
        mapper.put("L. catechunenus, Gr. / instructed, from /. See", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("imp. sing.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("conj. Either", new ArrayList<>(List.of(Type.CONJUNCTION)));
        mapper.put("obs. p. p.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("n. & a.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.ADJECTIVE)));
        mapper.put("fem. a.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("vb. n.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("pron., a., conj., & adv.", new ArrayList<>(Arrays.asList(Type.PRONOUN, Type.ADJECTIVE, Type.CONJUNCTION, Type.ADVERB)));
        mapper.put("p. p., fem.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("v. i. & auxiliary.", new ArrayList<>(List.of(Type.INTRANSITIVE_VERB)));
        mapper.put("adv. or prep.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.PREPOSITION)));
        mapper.put("imp., p. p., & a.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("imp., p. p., or auxiliary", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.PARTICLE)));
        mapper.put("p. p. / a.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("syntactically sing.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("a. & n.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.NOUN)));
        mapper.put("imp. & p. pr. & vb. n.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.NOUN)));
        mapper.put("n. sing.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("def. art.", new ArrayList<>(List.of(Type.ARTICLE)));
        mapper.put("imp. &p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE, Type.PARTICLE)));
        mapper.put("an.", new ArrayList<>(List.of(Type.ARTICLE)));
        mapper.put("N.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("conj.", new ArrayList<>(List.of(Type.CONJUNCTION)));
        mapper.put("Archaic", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("v./t.", new ArrayList<>(List.of(Type.VERB)));
        mapper.put("n. i.", new ArrayList<>(List.of(Type.INTRANSITIVE)));
        mapper.put("prep. & conj.", new ArrayList<>(Arrays.asList(Type.PREPOSITION, Type.CONJUNCTION)));
        mapper.put("pron. pl.", new ArrayList<>(List.of(Type.PRONOUN)));
        mapper.put("p. a.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("pl.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE,Type.VERB,Type.NOUN)));
        mapper.put("b. t.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("imp. &. p.",new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("p. pr. vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("n., sing. & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("obs. strong imp.", new ArrayList<>(Arrays.asList(Type.OBSOLETE, Type.IMPERATIVE)));
        mapper.put("subj. 3d pers. sing.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. / vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("v. t. / auxiliary", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("a., n., & adv.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.NOUN, Type.ADVERB)));
        mapper.put("n. .", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("n. /", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("p.", new ArrayList<>(List.of(Type.PARTICLE)));
        mapper.put("p. pr. & v. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("n. masc.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("n.sing & pl.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("prep. & conj., but properly a participle", new ArrayList<>(Arrays.asList(Type.PREPOSITION,Type.CONJUNCTION)));
        mapper.put("imp. & obs. p. p.", new ArrayList<>(Arrays.asList(Type.IMPERATIVE,Type.OBSOLETE, Type.PARTICLE)));
        mapper.put("v.& n.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.VERB)));
        mapper.put("a. or pron.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.PRONOUN)));
        mapper.put("p. pr. &. vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("v. i.,", new ArrayList<>(List.of(Type.INTRANSITIVE_VERB)));
        mapper.put("p. pr. & vb. a.", new ArrayList<>(Arrays.asList(Type.PARTICLE,Type.ADJECTIVE)));
        mapper.put("n.masc.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("imp.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("participle", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("a & adv.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.ADVERB)));
        mapper.put("adv. In a vanishing manner", new ArrayList<>(List.of(Type.ADVERB)));
        mapper.put("Archaic imp.", new ArrayList<>(List.of(Type.IMPERATIVE)));
        mapper.put("n. & interj.", new ArrayList<>(Arrays.asList(Type.NOUN,Type.INTERJECTION)));
        mapper.put("p. pr. & vb/ n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("n. Chem.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("3d sing.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("object.", new ArrayList<>(List.of(Type.OBJECT)));
        mapper.put("dv.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("p. pr. a. & vb. n.", new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.ADJECTIVE, Type.NOUN)));
        mapper.put("q.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("/.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("v. t. v. t.", new ArrayList<>(List.of(Type.TRANSITIVE_VERB)));
        mapper.put("3d sing.pr.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.ADJECTIVE, Type.VERB)));
        mapper.put("v. i. / auxiliary", new ArrayList<>(List.of(Type.INTRANSITIVE_VERB)));
        mapper.put("p. pl.", new ArrayList<>(Arrays.asList(Type.NOUN, Type.ADJECTIVE, Type.VERB)));
        mapper.put("P. pr. & vb. n.",new ArrayList<>(Arrays.asList(Type.PARTICLE, Type.NOUN)));
        mapper.put("adv. / conj.", new ArrayList<>(Arrays.asList(Type.ADVERB, Type.CONJUNCTION)));
        mapper.put("a.", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("a/", new ArrayList<>(List.of(Type.ADJECTIVE)));
        mapper.put("interj., adv., & n.", new ArrayList<>(Arrays.asList(Type.INTERJECTION, Type.ADVERB,Type.NOUN)));
        mapper.put("a. / adv.", new ArrayList<>(Arrays.asList(Type.ADVERB,Type.ADJECTIVE)));
        mapper.put("Pros.", new ArrayList<>(List.of(Type.NONE)));
        mapper.put("conj. & prep.", new ArrayList<>(Arrays.asList(Type.CONJUNCTION, Type.PREPOSITION)));
        mapper.put("adv.", new ArrayList<>(List.of(Type.ADVERB)));
        mapper.put("definite article.", new ArrayList<>(List.of(Type.ARTICLE)));
        mapper.put("sing.", new ArrayList<>(List.of(Type.NOUN)));
        mapper.put("prep.", new ArrayList<>(List.of(Type.PREPOSITION)));
        mapper.put("a., adv., & n.", new ArrayList<>(Arrays.asList(Type.ADJECTIVE, Type.ADVERB, Type.NOUN)));
    }

    /**
     * Getter method
     * @return hashMap
     */
    private HashMap<String, ArrayList<Type>> getMapper() {
        return mapper;
    }

    /**
     * Getter method to for the Types of the word
     * @return ArrayList of Type Enums
     */
    public ArrayList<Type> getTypes() {
        return types;
    }

    /**
     * Changes the types of a particular word
     * @param key String of the key
     */
    public void setTypes(String key){
        this.types = mapper.get(key);
        if(types ==null){
            String[] typeStrings = key.split(",");
            types = new ArrayList<>();
            for(String ts: typeStrings){
                types.add(Type.getTypeFromString(ts));
            }
        }
    }

}
