package DynamicQueue;

import APS_EDD.Customer;

public class Queue implements IQueue {

    private Node _start, _end;
    private int _size;

    public Queue() {
        _start = null;
        _end = null;
        _size = 0;
    }

    public boolean isEmpty() {
        // true se a Fila está vazia
        return (_start == null);
    }

    // insere no fim da fila
    public void enqueue(Customer c) {
        Node newNode = new Node(c);

        if (_start == null) {
            _start = newNode;
            _end = _start;
        } else {
            _end.setNext(newNode);
            _end = newNode;
        }
        _size++;
    }

    public Customer dequeue() {
        // remove do inicio da fila 
        if (isEmpty()) {
            //se estiver vazia retorna -1 
            return null;
        }

        // utilizado para retornar o dado 
        Node temp = _start;

        // move o topo para o prox nó 
        _start = _start.getNext();

        if (_start == null) {
            _end = null;
        }

        _size--;

        // retorna o dado 
        return temp.getCustomer();
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("Fila vazia.");
        } else {
            Node current = _start;
            while (current != null) {
                current.displayNode();
                current = current.getNext();
            }
            System.out.println();
        }
    }
}
