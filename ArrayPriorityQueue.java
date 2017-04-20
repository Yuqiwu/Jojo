//RLM -- Matteo Wong, Ricky Chen, Lisa Eng
//APCS2 pd3
//HW32 -- Getting Past the Velvet Rope
//2017-04-19

import java.util.ArrayList;

public class ArrayPriorityQueue<T> implements PriorityQueue<T>{

    ArrayList<T> _data;

    //constructor
    public ArrayPriorityQueue() {
	_data=new ArrayList<T>();
    }

    public void add(T x) {
	//this is just addLinear, loop through and when you reach something less than you add 
	for (int i=0;i<_data.size();i++) {
	    //smallest number highest priority
	    if (((Comparable)_data.get(i)).compareTo((Comparable)x)<0) {//if the next number is smaller add there
		_data.add(i, x);
		return;
	    }

	}
	_data.add(x);
    }

    public boolean isEmpty() {
	return _data.size()==0;
    }

    //removes from end
    public T peekMin() {
	return _data.get(_data.size()-1);
    }

    //removes from end
    public T removeMin() {
	return _data.remove(_data.size()-1);
    }


    public static void main(String[] args){

	ArrayPriorityQueue<Integer> test = new ArrayPriorityQueue<Integer>();
	System.out.println(test.isEmpty());
	for (int i=0;i<100;i++) {
	    test.add((int)(Math.random()*100));
	}
	test.add(0);
	System.out.println(test.isEmpty());
	
	while (!test.isEmpty()){
	    System.out.println(test.removeMin());
	}
    }
}
