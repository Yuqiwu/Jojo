/*
  Team: Jojo
  Team Member: Yu Qi Wu, Matteo Wong, Jeffrey Weng
  Lab#03
  2017-04-20
 */

import cs1.Keyboard;

public class Ticket implements Comparable{

    private String _name;
    private String _problem;
    private int _id;
    private int _priority;
    private String _solutionDescription;

    public Ticket(String newName, String _newProblem, int _newId, int _newPriority){
	_name = newName;
	_problem = _newProblem;
	_id = _newId;
	_priority = _newPriority;
    }

    public void updateProb(String newProb){
	_problem = newProb;
    }

    public void assignID(int newID){
	_id = newID;
    }

    public int getID(){
	return _id;
    }
    
    //returns 1 if Ticket calling compareTo has higher priority
    //0 if same priority
    //-1 if lower priority
    public int compareTo(Object o) {
	if (this._priority> ((Ticket) o)._priority)
	    return 1;
	else if (this._priority> ((Ticket)o)._priority)
	    return 0;
	else
	    return -1;
    }

    public String toString() {
	return "Name: "+_name+"\nID: "+_id+"\nProblem: "+_problem+"\nSolution: "+_solutionDescription;
    }


} 
