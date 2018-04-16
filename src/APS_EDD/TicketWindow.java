package APS_EDD;

import java.util.ArrayList;

public class TicketWindow {

    /**
     * @return the _customerServed
     */
    public int getCustomerServed() {
        return _customerServed;
    }

    public ArrayList<String> getAction() {
        return _actionList;
    }

    private ArrayList<String> _actionList = new ArrayList();
    private int _customerServed;

    public int countServedType1() {
        int count = 0;
        for (String action : _actionList) {
            if (action == "1") {
                count++;
            } else {
                count = 2;
            }
        }

        return count;
    }

    public int actionResult(int action) {
        switch (action) {
            case 0:
                _customerServed++;
                _actionList.add(Integer.toString(action));
                return 60;
            case 1:
                _customerServed++;
                _actionList.add(Integer.toString(action));
                return 90;
            case 2:
                _customerServed++;
                _actionList.add(Integer.toString(action));
                return 120;
            default:
                _actionList.add(null);
                System.out.println("Ação invalida");
                return -1;
        }
    }

}
