import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Parser parser = new Parser();
        ArrayList<DFAWrapper> equations = parser.parse();

        for (DFAWrapper dfaWrapper : equations) {
            System.out.println(represent(dfaWrapper));
            System.out.println("---------------------------------------\n\n");
        }
    }

    private static String represent(DFAWrapper dfaWrapper) {

        String template = "DFA for recognize -> " + dfaWrapper.getName();
        ArrayList passingStates = dfaWrapper.getPassingStates();
        ArrayList failingState = dfaWrapper.getFailingStates();
        DFA dfa = dfaWrapper.getDfa();

        String subTemplate = "\n";
        for (int i = 0; i < passingStates.size(); i++) {
            subTemplate += "\nShould recognize " + passingStates.get(i) +
                    " And result is : " + dfa.canRecognize((String) passingStates.get(i));
        }

        subTemplate += "\n";

        for (int i = 0; i < failingState.size(); i++) {
            subTemplate += "\nShould not recognize " + failingState.get(i) +
                    " And result is : " + dfa.canRecognize((String) failingState.get(i));
        }
        return template+subTemplate;
    }
}
