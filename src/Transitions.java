import java.util.HashMap;

public class Transitions {
    private String transitions;

    public Transitions(String transitions) {
        this.transitions = transitions;
    }

    public HashMap getTransition() {
        String[] transition = transitions.split("\n");
        HashMap delta = new HashMap();

        for (int i = 0; i < transition.length; i++) {
            String[] split = transition[i].split(",");
            String currentState = split[0];
            String alphabet = split[1];
            String nextState = split[2];
            HashMap path = new HashMap();
            if (delta.containsKey(currentState)) {
                path = (HashMap) delta.get(currentState);
            }
            path.put(alphabet, nextState);
            delta.put(currentState, path);
        }
        return delta;
    }
}
