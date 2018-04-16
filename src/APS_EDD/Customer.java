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

    /**
     * @return the _number
     */
    public int getNumber() {
        return _number;
    }

    /**
     * @param _number the _number to set
     */
    public void setNumber(int _number) {
        this._number = _number;
    }

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param _name the _name to set
     */
    public void setName(String _name) {
        this._name = _name;
    }

    public Customer(int number, String name, int arrival) {
        this._number = number;
        this._name = name;
        this._arrival = arrival;
    }

    private int _number;
    private String _name;
    private int _arrival;
    private int _exit;

    public void getTimeInQueue(int x) {
        _exit = x - _arrival;
    }

    public int getIntention() {
        Random r = new Random();

        int n = r.nextInt(3);

        return n;
    }
}
