package DynamicQueue;

import APS_EDD.Customer;

public interface IQueue {
    boolean isEmpty();
    void enqueue(Customer p);
    Customer dequeue();
    void display();
}
