import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatesTest {
    @Test
    public void contains_should_recognize_if_state_is_present_in_list() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");

        States states = new States(statesList);
        assertTrue(states.contains("q0"));
    }

    @Test
    public void contains_should_not_recognize_if_state_is_not_present_in_list() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");

        States states = new States(statesList);
        assertFalse(states.contains("q2"));
    }

    @Test
    public void containsAnyOf_should_recognize_if_given_list_of_states_are_present_in_collection() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");
        statesList.add("q2");

        States states = new States(statesList);
        ArrayList<String> finalStates = new ArrayList();
        finalStates.add("q1");

        assertTrue(states.containsAnyOf(finalStates));

        finalStates.add("q4");
        assertTrue(states.containsAnyOf(finalStates));
    }

    @Test
    public void containsAnyOf_should_not_recognize_if_not_a_single_state_from_given_list_are_not_present_in_collection() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");
        statesList.add("q2");

        States states = new States(statesList);
        ArrayList<String> finalStates = new ArrayList();
        finalStates.add("q5");

        assertFalse(states.containsAnyOf(finalStates));

        finalStates.add("q4");
        assertFalse(states.containsAnyOf(finalStates));
    }

    @Test
    public void containsAllOf_should_recognize_all_given_states_if_they_present_in_collection() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");
        statesList.add("q2");

        States states = new States(statesList);
        ArrayList<String> finalStates = new ArrayList();
        finalStates.add("q1");

        assertTrue(states.containsAllOf(finalStates));

        finalStates.add("q0");
        finalStates.add("q2");
        assertTrue(states.containsAllOf(finalStates));
    }

    @Test
    public void containsAllOf_should_not_recognize_all_given_states_even_if_not_a_single_state_from_given_list_are_not_present_in_collection() throws Exception {
        ArrayList<String> statesList = new ArrayList<>();
        statesList.add("q0");
        statesList.add("q1");
        statesList.add("q2");

        States states = new States(statesList);
        ArrayList<String> finalStates = new ArrayList();
        finalStates.add("q1");
        finalStates.add("q0");
        finalStates.add("q2");
        finalStates.add("q4");

        assertFalse(states.containsAllOf(finalStates));
    }
}