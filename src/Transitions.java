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
            String current_state = split[0];
            String alphabet = split[1];
            String next_state = split[2];
            HashMap path = new HashMap();
            if (delta.containsKey(current_state)) {
                path = (HashMap) delta.get(current_state);
            }
            path.put(alphabet, next_state);
            delta.put(current_state, path);
        }
        return delta;
    }
}
