# Jojo
Matteo Wong, Jeffrey Weng, Yuqi Wu

##Design

###Description
CLI-based helpdesk program.<br>
*Procedure*
1. Ask Question 
2. Get sorted into a priority queue
3. Questions will be answered based on your priority level
4. Wait.


####HelpDesk
The help desk will ask preliminary questions such as name, your question, your role in the establishment, etc. Then it will put you into a priority queue where you have to wait until all the higher prioriy customers have gone.(You'll also be given an ID based on your position in line)

The help desk also gives you a response based off of keywords in your question. For example, if your question has the word "internet" in it, it'll generate answers according to that.

While doing all that, the helpdesk will update the customer's ticket with the new solution, and also recommend an alternative to get your question answered.


####Ticket

The Ticket will just be a container that'll hold all the information generated from Helpdesk, and given to the customer and then sorted into a queue.

We used the compareTo method from the interface Comparable to compare ticket priority values. Dequeing from the queue will always be at the same spot, while the enqueue will be done based off of the priority.

Therefore, dequeue will be O(1), and enqueue will be O(n).
