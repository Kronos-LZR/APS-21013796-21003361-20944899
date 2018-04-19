package APS_EDD;

public class TicketWindow {

    private int _customerServed;
    private int _available;

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

    public int countServedType1() {
        int count = 0;

        return count;
    }

    public int actionResult(int action) {
        switch (action) {
            case 0:
                _customerServed++;
                _available = 60;
                return 60;
            case 1:
                _customerServed++;
                _available = 90;
                return 90;
            case 2:
                _customerServed++;
                _available = 120;
                return 120;
            default:
                System.out.println("Ação invalida");
                return -1;
        }
    }

}
