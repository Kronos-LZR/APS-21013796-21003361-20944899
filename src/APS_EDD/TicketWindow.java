package APS_EDD;

public class TicketWindow {

    // PROPRIEDADES
    private int _customerServed;
    private int _available;
    
    private int _cashOut = 0;
    private int _deposit = 0;
    private int _payment = 0;    
    
    //GETTERS
    public int getCustomerServed() {
        return _customerServed;
    }
    
    public int getCashOut() {
        return _cashOut;
    }

    public int getDeposit() {
        return _deposit;
    }

    public int getPayment() {
        return _payment;
    }

    // METODOS
    public void elapsed() {
        this._available--;
    }

    public Boolean checkIfAvailable() {
        if (this._available == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int actionResult(int action) {
        switch (action) {
            case 0:
                _customerServed++;
                _available = 60;
                _cashOut++;
                return 60;
            case 1:
                _customerServed++;
                _available = 90;
                _deposit++;
                return 90;
            case 2:
                _customerServed++;
                _available = 120;
                _payment++;
                return 120;
            default:
                System.out.println("Ação invalida");
                return -1;
        }
    }

}
