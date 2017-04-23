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


    /*
    public static boolean findSolution(String problem){
	if ( problem.indexOf("internet") >-1 ||
	     problem.indexOf("frozen")>-1){
	    return true;
	}
	return false;
    }

    public static void giveSolution(String problem){
	if( problem.indexOf("internet")>-1 )
	    System.out.println("Please unplug your router's cable, wait for 10 seconds, then plug back the cable again");
	else{
	    System.out.println("Please restart your computer by press your power button and hold it until the monitor turns black");
	}
	}*/

    public static String getResponse(String statement)
    {
	String response = "";
	statement=statement.toLowerCase();
	if (statement.trim().length()==0)
	    {
		response="Say something, please.";
	    }
	else if (statement.indexOf("internet") >= 0 ||
		 statement.indexOf("wifi") >= 0 ||
		 statement.indexOf("wi-fi") >= 0)
	    {
		response = "Please unplug your router's cable, wait for 10 seconds, then plug back the cable again.";
	    }
	else if (statement.indexOf("frozen")>=0)
	    {
		response = "Try restarting your computer.";
	    }
	else
	    {
		response="We cannot help you, we will outsource the problem to China.";
	    }
	return response;
    }

    
    
    public static void main(String[] args) {

	//so there are already some people in line
	Ticket filler=new Ticket("Matteo", "I'm hungry", 0, (int)(Math.random()*4));
	_line.add(filler);
	filler=new Ticket("Yuqi", "frozen", 1, (int)(Math.random()*4));
	_line.add(filler);
	filler=new Ticket("Jeffrey", "internet", 2, (int)(Math.random()*4));
	_line.add(filler);

	int IDcounter=3;
	while (true) {
	Ticket toSolve;
	int ctr = 0;
	boolean isSolve = false;
	
	System.out.println("What is your name");
	String name=Keyboard.readString();

	int priority=-1;//=Keyboard.readInt();
	while (priority>3 || priority<0){
	    System.out.println("What is your position?");
	    System.out.println("0 for C suite");
	    System.out.println("1 for manager");
	    System.out.println("2 for worker");
	    System.out.println("3 for visitor");
	    priority=Keyboard.readInt();
	}
	
	System.out.println("What is your problem");
	String prob = Keyboard.readString();

	int ID=IDcounter;
	IDcounter+=1;

	Ticket user = new Ticket(name, prob, ID, priority);
	_line.add(user);

	String tempS = convertIntToString( user.getID() );
	System.out.println("Thank you "+name+". This is your ID: " + tempS + ", please wait for us to contact you.");

	if (!_line.isEmpty())
	    toSolve=_line.removeMin();
	else
	    continue;

	toSolve.updateSolution(getResponse(toSolve.getProb()));
	System.out.println("\nCalling ID " + convertIntToString(toSolve.getID())+ ". Hello "+toSolve.getName()+". We have attempted to handle your problem.");
	System.out.println(toSolve.getSolution()+"\n");

	}
	/*
	//user.updateProb(prob);
	isSolve = findSolution(prob);
	
	while (! isSolve && ctr < 3){
	System.out.println("Sorry we do not understand your problem, can you rephrase your problem?");
	prob = Keyboard.readString();
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

	*/
    }

}
