import java.util.ArrayList;
import java.util.HashMap;

public class DFA_eqution {
    public String[] sigma;
    public String[] states;
    public String initial_state;
    public ArrayList<String> final_states;
    public HashMap delta;

    public DFA_eqution(String[] sigma, String[] states, String initial_state, ArrayList<String> final_states, HashMap delta) {
        this.sigma = sigma;
        this.states = states;
        this.initial_state = initial_state;
        this.final_states = final_states;
        this.delta = delta;
    }
}
