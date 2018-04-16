package APS_EDD;

public class Program {

    public static void main(String[] args) {
        int timer = 21000;
        TicketWindow ticketWindow = new TicketWindow();
        Customer customer = new Customer(1, "Lazaro", timer);

        while (timer < 21600) {

            customer.getTimeInQueue(timer);

            timer += ticketWindow.actionResult(customer.getIntention());
        }

        System.out.println("Tempo de espera: " + customer.getExit() + " segundos");
        System.out.println("Clientes Atendidos: " + ticketWindow.getCustomerServed());
        System.out.println("Quantidade de atendimentos: " + ticketWindow.countServedType1());

    }
}
