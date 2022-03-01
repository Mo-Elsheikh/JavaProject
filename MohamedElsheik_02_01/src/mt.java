
public class mt {
	
	public int nextState(final int currentState, final String inputSymbol) {
 	   // next state is given by state table
     // get the column number for inputSymbol
     int column = -1; // initialize with -1 as invalid parameter
     // check for valid inputSymbol
     if(inputSymbol != null && inputSymbol.length() > 0) {
         for(int i=0; i<alphabet.length; i++) {
             if(alphabet[i].equals(inputSymbol)) {
                 // we found valid inputSymbol
                 // update the column number
                 column = i;
                 break;
             }
         }
     }
     // check for valid currentState
     // currentState must be in range 0(startState) to maximumPosibleState(last row in state table)
     if(currentState >= 0 && currentState < stateTransitionTable.length) {
         // if inputSymbol is valid then return nextState from table
         if(column > -1) {
             return stateTransitionTable[currentState][column];
         }
     }
     // return value of state parameter for invalid input
     return currentState;
 }

}
