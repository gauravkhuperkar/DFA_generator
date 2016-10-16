import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
    public ArrayList parse() throws ParseException, FileNotFoundException {
        ArrayList<DFAEquation> equations = new ArrayList<>();
        Scanner scanner = new Scanner(new File("testRunner/data.json"));
        StringBuilder jsonText = new StringBuilder();
        while(scanner.hasNextLine()) {
            jsonText.append(scanner.nextLine().toString());
        }

        ArrayList dfaEquationsText = (ArrayList) new JSONParser().parse(jsonText.substring(1, jsonText.length() - 1).replaceAll("\\\\", ""));
        for (int i = 0; i < dfaEquationsText.size(); i++) {
            HashMap<String, Object> hash = (HashMap) dfaEquationsText.get(i);
            equations.add(getDEAEquation(hash));
        }
        return equations;
    }

    private DFAEquation getDEAEquation(HashMap hash) {
        HashMap tuple = (HashMap) hash.get("tuple");
        Object alphabets = tuple.get("alphabets");
        String startState = (String) hash.get("start-state");
        Object finalStates = tuple.get("final-states");
        Object states = tuple.get("states");
        return new DFAEquation(parseSigma(alphabets), parseStates(states), startState, parseFinalStatesList(finalStates), parseDelta(tuple));
    }
     private ArrayList<String> parseSigma(Object alphabets) {
         return (ArrayList<String>) alphabets;
     }

     private ArrayList parseStates(Object states) {
         return (ArrayList) states;
     }

     private ArrayList parseFinalStatesList(Object finalStates) {
         return (ArrayList) finalStates;
     }

     private HashMap<String, HashMap<String, String>> parseDelta(HashMap tuple) {
         return new HashMap<>();
     }
}
