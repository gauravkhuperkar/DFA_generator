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

        ArrayList dfaEquationsText = (ArrayList) new JSONParser()
                .parse(jsonText.substring(1, jsonText.length() - 1)
                .replaceAll("\\\\", ""));

        for (int i = 0; i < dfaEquationsText.size(); i++) {
            HashMap<String, Object> hash = (HashMap) dfaEquationsText.get(i);
            equations.add(getDEAEquation(hash));
        }
        return equations;
    }

    private DFAEquation getDEAEquation(HashMap hash) {
        HashMap tuple = (HashMap) hash.get("tuple");
        String name = (String) hash.get("name");
        ArrayList alphabets = (ArrayList) tuple.get("alphabets");
        String startState = (String) hash.get("start-state");
        ArrayList finalStates = (ArrayList) tuple.get("final-states");
        ArrayList states = (ArrayList) tuple.get("states");
        return new DFAEquation(name, alphabets, states, startState, finalStates, parseDelta(tuple));
    }

     private HashMap<String, HashMap> parseDelta(HashMap tuple) {
         HashMap<String, HashMap> delta = (HashMap<String, HashMap>) tuple.get("delta");
         return delta;
     }
}
