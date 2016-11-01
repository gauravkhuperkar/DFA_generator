import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<String> currentStates = new ArrayList();
        currentStates.add(initialState);

        for (int i = 0; i < length; i++) {
            String alphabet = (string.split(""))[i];
            for (int j = 0; j < currentStates.size(); j++) {
                HashMap path = (HashMap) delta.get(currentStates.get(j));
                ArrayList<String> nextStates = (ArrayList) path.get(alphabet);

                if(nextStates == null ) {
                    currentStates.remove(currentStates.get(j));
                } else {
                    for (int k = 0; k < nextStates.size(); k++) {
                        if (!currentStates.contains(nextStates.get(k))) {
                            currentStates.add(nextStates.get(k));
                            if (path.containsKey("#")) currentStates.addAll((ArrayList) path.get("#"));
                        }
                    }
                }
            }

        }
        return this.finalStates.containsAnyOf(currentStates);
    }
}
