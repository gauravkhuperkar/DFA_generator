import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NFA {
    private ArrayList<String> sigma;
    private ArrayList<String> states;
    private String initialState;
    private States finalStates;
    private HashMap delta;

    public NFA(ArrayList<String> sigma, ArrayList<String> states, String initialState, States finalStates, HashMap delta) {
        this.sigma = sigma;
        this.states = states;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.delta = delta;
    }

    public Boolean canRecognize(String string) {
        int length = string.length();
        ArrayList<String> currentStates = new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        currentStates.add(initialState);
        HashMap iPath = (HashMap) delta.get(initialState);
        if (iPath.containsKey("#")){
            if (!currentStates.contains(iPath.get("ds#")))
                currentStates.addAll((ArrayList)iPath.get("#"));
        }

        // string length
        for (int i = 0; i < length; i++) {
            String alphabet = (string.split(""))[i];

            //number of current states
            for (int j = 0; j < currentStates.size(); j++) {
                HashMap path = (HashMap) delta.get(currentStates.get(j));

                ArrayList<String> nextStates = (ArrayList) path.get(alphabet);

                if (path.containsKey("#"))
                    result.addAll((ArrayList) path.get("#"));

                if (nextStates == null) {
                    currentStates.remove(currentStates.get(j));
                    break;
                } else {
                    result.addAll(nextStates);

                }
            }
        }

        // adding currents machines to currentStates
        for (String state : result) {
            if (!currentStates.contains(state))
                currentStates.add(state);
        }
        result.removeAll(result);
        return this.finalStates.containsAnyOf(currentStates);
    }
}
