package DynamicQueue;

import APS_EDD.Customer;

public class Node{

    public Customer getCustomer() {
        return _customer;
    }

    public Node getNext() {
        return _next;
    }
    
    public void setNext(Node next) {
        this._next = next;
    }
    
        private Customer _customer;             
        private Node _next;              
        
        public Node(Customer p) { 
            this._customer = p;
            _next = null;
        }
        
        public void displayNode() { 
            System.out.println(getCustomer().toString()); 
        }
}
