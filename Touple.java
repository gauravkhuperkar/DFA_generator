class Tuple  {
    Array<String> sigma;
    Array<State> states;
	State initial_state;
	Array<State> final_states;

	Tuple(tuple) {
		sigma = tuple.sigma;
		states = tuple.states;
	}
}