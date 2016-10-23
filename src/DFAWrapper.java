import java.util.ArrayList;

public class DFAWrapper {
    private String name;
    private DFA dfa;
    private ArrayList passingStates;
    private ArrayList failingStates;

    public DFAWrapper(String name, DFA dfa, ArrayList passingStates, ArrayList failingStates) {
        this.name = name;
        this.dfa = dfa;
        this.passingStates = passingStates;
        this.failingStates = failingStates;
    }

    public String getName() {
        return name;
    }

    public ArrayList getPassingStates() {
        return passingStates;
    }

    public ArrayList getFailingStates() {
        return failingStates;
    }

    public DFA getDfa() {
        return dfa;
    }
}
