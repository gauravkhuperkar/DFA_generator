import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class NFATest {
    @Test
    public void NFA_should_able_to_recognize_the_string() throws Exception {
        ArrayList<String> sigma = new ArrayList<>();
        sigma.add("a");
        sigma.add("b");
        ArrayList<String> states = new ArrayList<>();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        String initialState = "q0";
        ArrayList<String> finalStates = new ArrayList<>();
        finalStates.add("q0");
        States finalState = new States(finalStates);

        HashMap path0 = new HashMap();
        HashMap path1 = new HashMap();
        HashMap path2 = new HashMap();

        ArrayList nextStates = new ArrayList();

        nextStates.add("q1");
        path0.put("b",nextStates);

        nextStates.add("q2");
        path1.put("a",nextStates);

        nextStates.remove("q1");
        path0.put("#",nextStates);
        path1.put("b",nextStates);

        nextStates.remove("q2");
        nextStates.add("q0");
        path2.put("a",nextStates);

        HashMap delta = new HashMap();
        delta.put("q0",path0);
        delta.put("q1",path1);
        delta.put("q2",path2);

        NFA nfa = new NFA(sigma, states, initialState, finalState, delta);
        assertTrue(nfa.canRecognize("baba"));
    }
}
