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
        
        Customer customer = new Customer(1, "Lazaro", timer);

        while (timer < 21600) {
            
            if(CheckerCustomerInQueue())
                System.out.println("T");
            else
                System.out.println("F");
            //customer.getTimeInQueue(timer);
            //timer += ticketWindow.actionResult(customer.getAction());
        }

        //System.out.println("Tempo de espera: " + customer.getExit() + " segundos");
        //System.out.println("Clientes Atendidos: " + ticketWindow.getCustomerServed());
        //System.out.println("Quantidade de atendimentos: " + ticketWindow.countServedType1());

    }
    
    private static Boolean CheckerCustomerInQueue(){
        
        Random r = new Random();
        int n = r.nextInt(30);
        
        return n == 0;
    }
}
