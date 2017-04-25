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
	else if (statement.indexOf("blue screen") >= 0){
	    response = "https://support.microsoft.com/en-us/help/17074/windows-7-resolving-stop-blue-screen-errors, go to this website :)";
	}
	else if (statement.indexOf("virus")>=0) {
	    response = "If you downloaded malware, you should immediately shut down your computer, change all your passwords remotely, and seek more professional assistance than we can offer at this moment.";
	}
	else if (statement.indexOf("turn on")>=0 ||
		 statement.indexOf("power")>=0) {
	    response="Make sure you turned on the computer itself and not just the monitor, and make sure it is plugged in.";
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

	    Ticket user = new Ticket(name, prob, IDcounter, priority);
	    IDcounter+=1;
	    _line.add(user);

	    String tempS = convertIntToString( user.getID() );
	    System.out.println("Thank you "+name+". This is your ID: " + tempS + ", please wait for us to contact you.");
	
	    while (true) {
		System.out.println("Do you have another problem? (yes/no)");
		String ans = Keyboard.readString().toLowerCase();
		if (ans.equals("yes")) {
		    System.out.println("What is your other problem?");
		    prob = Keyboard.readString();
		    user=new Ticket(name,prob,IDcounter,priority);
		    IDcounter+=1;
		    tempS=convertIntToString(user.getID());
		    _line.add(user);
		    System.out.println("Thank you "+name+". This is your ID: " + tempS + ", please wait for us to contact you.");
		}
	    
		else if (ans.equals("no"))
		    break;
		else {
		    System.out.println("We will consider that a no");
		    break;
		}


	    }

	    if (!_line.isEmpty())
		toSolve=_line.removeMin();
	    else
		continue;

	    toSolve.updateSolution(getResponse(toSolve.getProb()));
	    System.out.println("\nCalling ID " + convertIntToString(toSolve.getID())+ ". Hello "+toSolve.getName()+". We have attempted to handle your problem.");
	    System.out.println(toSolve.getSolution()+"\n");

	}

    }

}
