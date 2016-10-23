import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void DFA_should_able_to_recognize_the_string() throws Exception {
        ArrayList<String> sigma = new ArrayList<>();
        sigma.add("0");
        sigma.add("1");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        String initial_state = "q0";
        ArrayList<String> final_states = new ArrayList<>();
        final_states.add("q2");
        Transitions transitions = new Transitions("q0,0,q0\nq0,1,q1\nq1,0,q1\nq1,1,q2\nq2,0,q2\nq2,1,q2");
        HashMap delta = transitions.getTransition();
        DFA dfa = new DFA(sigma, states, initial_state, final_states, delta);

        assertTrue(dfa.canRecognize("010101"));
    }
}
