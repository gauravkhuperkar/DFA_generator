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

        result.add(initialState);

        HashMap nextPath = (HashMap) delta.get(initialState);

        if (nextPath.containsKey("#"))
            result.addAll((ArrayList)nextPath.get("#"));

        currentStates.addAll(result);
        result.removeAll(result);

        // loop string length
        for (int i = 0; i < length; i++) {
            String alphabet = (string.split(""))[i];

            //loop for number of current states
            for (int j = 0; j < currentStates.size(); j++) {
                HashMap path = (HashMap) delta.get(currentStates.get(j));

                if (path.containsKey("#"))
                    result.addAll((ArrayList) path.get("#"));

                if (path.get(alphabet) != null) {
                    result.addAll((ArrayList) path.get(alphabet));
                }
            }
            currentStates.removeAll(currentStates);
            currentStates.addAll(result);
            result.removeAll(result);
        }
        return this.finalStates.containsAnyOf(currentStates);
    }
}
