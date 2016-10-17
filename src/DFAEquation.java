import java.util.ArrayList;
import java.util.HashMap;

public class DFAEquation {
    public String discription;
    public ArrayList<String> sigma;
    public ArrayList<String> states;
    public String initialState;
    public ArrayList<String> finalStates;
    public HashMap delta;

    public DFAEquation(String discription, ArrayList<String> sigma, ArrayList<String> states, String initialState, ArrayList<String> final_states, HashMap delta) {
        this.discription = discription;
        this.sigma = sigma;
        this.states = states;
        this.initialState = initialState;
        this.finalStates = final_states;
        this.delta = delta;
    }

    public ArrayList<String> getSigma() {
        return sigma;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public String getInitialState() {
        return initialState;
    }

    public ArrayList<String> getFinalStates() {
        return finalStates;
    }

    public HashMap getDelta() {
        return delta;
    }
}
