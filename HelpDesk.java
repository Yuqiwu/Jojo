import cs1.Keyboard;

public class HelpDesk
{

    private static ArrayPriorityQueue<Ticket> _line = new ArrayPriorityQueue<Ticket>();

    public static String convertIntToString(int newID){
	String ret = "";
	if (newID > 9)
	    ret = "0" + newID;
	else
	    ret = "00" + newID;
	return ret;
    }

    public static boolean findSolution(String problem){
	if ( problem.equals("internet") ||
	     problem.equals("frozen")){
	    return true;
	}
	return false;
    }

    public static void giveSolution(String problem){
	if( problem.equals("internet") )
	    System.out.println("Please unplug your router's cable, wait for 10 seconds, then plug back the cable again");
	else{
	    System.out.println("Please restart your computer by press your power button and hold it until the monitor turns black");
	}
    }

    public static void main(String[] args) {

	int ctr = 0;
	boolean isSolve = false;
	
	System.out.println("What is your name");
	String name = Keyboard.readWord();

	System.out.println("What is your position?");
	System.out.println("0 for C suite");
	System.out.println("1 for manager");
	System.out.println("2 for worker");
	System.out.println("3 for visitor");
	int priority=Keyboard.readInt();
	
	System.out.println("What is your problem");
	String prob = Keyboard.readWord();

	int ID=(int)(Math.random()*1000);

	Ticket user = new Ticket(name, prob, ID, priority);
	_line.add(user);
	//user.updateProb(prob);
	isSolve = findSolution(prob);
	
	while (! isSolve && ctr < 3){
	    System.out.println("Sorry we do not understand your problem, can you rephrase your problem?");
	    prob = Keyboard.readWord();
	    user.updateProb(prob);
	    isSolve = findSolution(prob);
	    ctr++;
	}
	
	if (isSolve){
	    giveSolution(prob);
	}
	
	else{
	    user.assignID( (int)(Math.random() * 100) );
	    String tempS = convertIntToString( user.getID() );
	    System.out.println("Sorry we still cannot understand your problem, we will assign you a real person to help you.\nThis is your ID " + tempS + ", please wait for us to contact you.");
	}
    }

}
