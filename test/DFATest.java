import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class DFATest {
    @Test
    public void DFA_should_able_to_recognize_the_string() throws Exception {
        String [] sigma = new String[]{"0","1"};
        String [] states = new String[]{"q0","q1"};
        String initial_state = "q0";
        ArrayList<String> final_states = new ArrayList<String>();
        final_states.add("q2");
        Transitions transitions = new Transitions("q0,0,q0\nq0,1,q1\nq1,0,q1\nq1,1,q2\nq2,0,q2\nq2,1,q2");
        HashMap delta = transitions.getTransition();
        DFA_eqution equation = new DFA_eqution(sigma, states, initial_state, final_states, delta);
        DFA dfa = new DFA(equation);
        System.out.println(dfa.canRecognize("010101"));
        assertTrue(true);
    }
}
