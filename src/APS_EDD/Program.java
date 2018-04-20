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
        List CustomerList = new List();

        // Hora Extra
        int workOvertime;

        // Tempo medio de espera
        int tme = 0;

        // CONTADORES DE AÇÔES
        int tCashOut = 0, tDeposit = 0, tPayment = 0, tCustomers = 0;

        while (true) {

            if (timer < 21600) {
                if (CheckerCustomerInQueue()) {
                    CustomerQueue.enqueue(new Customer(timer));
                }
            }

            for (int i = 0; i < TicketList.size(); i++) {
                TicketWindow tw = (TicketWindow) TicketList.getElement(i);
                if (tw.checkIfAvailable()) {
                    if (!CustomerQueue.isEmpty()) {
                        Customer c = CustomerQueue.dequeue();
                        tw.actionResult(c.getAction());
                        c.getTimeInQueue(timer);
                        CustomerList.add(c);
                    }
                } else {
                    tw.elapsed();
                }
            }

            if (CustomerQueue.isEmpty() && timer > 21600) {
                int count = 0;

                for (int i = 0; i < TicketList.size(); i++) {
                    TicketWindow tw = (TicketWindow) TicketList.getElement(i);
                    if (tw.checkIfAvailable()) {
                        count++;
                    }
                }

                if (count == 3) {
                    break;
                }
            }

            timer++;
        }

        // CALCULA SERVIÇOS
        for (int i = 0; i < TicketList.size(); i++) {
            TicketWindow tw = (TicketWindow) TicketList.getElement(i);
            tCashOut += tw.getCashOut();
            tDeposit += tw.getDeposit();
            tPayment += tw.getPayment();
            tCustomers += tw.getCustomerServed();
        }

        // CALCULANDO HORA-EXTRA
        workOvertime = timer - 21600;

        // PEGANDO TEMPO DE ESPERA DE CADA CLIENTE
        for (int i = 0; i < CustomerList.size(); i++) {
            Customer c = (Customer) CustomerList.getElement(i);
            tme += c.getExit();
        }

        // CALCULANDO TEMPO MEDIO DE ESPERA
        tme = tme / CustomerList.size();

        System.out.println("Tempo medio de espera é de: " + tme + " segundos");
        System.out.println("Tempo extra é de: " + workOvertime + " segundos");
        System.out.println("Clientes atendidos: " + tCustomers);
        System.out.println("Saques realizados: " + tCashOut);
        System.out.println("Depositos realizados: " + tDeposit);
        System.out.println("Pagamentos realizados: " + tPayment);

    }

    private static Boolean CheckerCustomerInQueue() {

        Random r = new Random();
        int n = r.nextInt(30);

        return n == 0;
    }
}
