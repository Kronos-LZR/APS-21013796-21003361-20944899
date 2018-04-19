package APS_EDD;

import java.util.Random;
import DynamicQueue.Queue;
import DynamicList.List;

public class Program {

    public static void main(String[] args) {
        int timer = 0;

        // INCIANDO LISTA DE GUICHES
        List TicketList = new List();

        TicketList.add(new TicketWindow());
        TicketList.add(new TicketWindow());
        TicketList.add(new TicketWindow());

        // FILA DE CLIENTES
        Queue CustomerQueue = new Queue();
        
        // LISTA DE CLIENTES ATENDIDOS
        List CustomerLIst = new List();

        while (timer < 21600) {

            if (CheckerCustomerInQueue()) {
                CustomerQueue.enqueue(new Customer(timer));
            }

            for (int i = 0; i < TicketList.size(); i++) {
                TicketWindow tw = (TicketWindow) TicketList.getElement(i);
                if (tw.checkIfAvailable()) {
                    if(!CustomerQueue.isEmpty())
                        tw.actionResult(CustomerQueue.dequeue().getAction());
                } else {
                    tw.elapsed();
                }
            }

            timer++;

        }

        //System.out.println("Tempo de espera: " + customer.getExit() + " segundos");
        //System.out.println("Clientes Atendidos: " + ticketWindow.getCustomerServed());
        //System.out.println("Quantidade de atendimentos: " + ticketWindow.countServedType1());
    }

    private static Boolean CheckerCustomerInQueue() {

        Random r = new Random();
        int n = r.nextInt(30);

        return n == 0;
    }
}
