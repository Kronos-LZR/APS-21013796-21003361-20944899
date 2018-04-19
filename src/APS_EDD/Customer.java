package APS_EDD;

import java.util.Random;

public class Customer {

    /**
     * @return the _exit
     */
    public int getExit() {
        return _exit;
    }

    /**
     * @param _exit the _exit to set
     */
    public void setExit(int _exit) {
        this._exit = _exit;
    }

    /**
     * @return the _arrival
     */
    public int getArrival() {
        return _arrival;
    }

    /**
     * @param _arrival the _arrival to set
     */
    public void setArrival(int _arrival) {
        this._arrival = _arrival;
    }

    public Customer(int arrival) {
        this._arrival = arrival;
    }

    private int _arrival;
    private int _exit;

    public void getTimeInQueue(int x) {
        _exit = x - _arrival;
    }

    public int getAction() {
        Random r = new Random();

        int n = r.nextInt(3);

        return n;
    }
}
