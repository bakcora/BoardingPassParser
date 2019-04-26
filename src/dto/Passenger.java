
package dto;

import java.io.Serializable;

/**
 *
 * @author uakgul
 * 
 */
public class Passenger implements Serializable{
    
    public String name;
    
    public String surname;
    
    public String pnrNo;
    
    public String iataCode;
    
    public String flightNo;
    
    public String flightDate;
    
    public String flightFr;
    
    public String flightTo;
    
    public String seatNo;
    
    public String compartment;

    public Passenger() {
    }

    /**
     * 
     * @param name
     * @param surname
     * @param pnrNo
     * @param flightDate
     * @param iataCode
     * @param flightNo
     * @param flightFr
     * @param flightTo
     * @param seatNo
     * @param compartment 
     */
    public Passenger(String name, String surname, String pnrNo, String flightDate, String iataCode, String flightNo, String flightFr, String flightTo, String seatNo, String compartment) {
        this.name = name;
        this.surname = surname;
        this.pnrNo = pnrNo;
        this.flightDate = flightDate;
        this.iataCode = iataCode;
        this.flightNo = flightNo;
        this.flightFr = flightFr;
        this.flightTo = flightTo;
        this.seatNo = seatNo;
        this.compartment = compartment;
    }
    
    
    
    @Override
    public String toString() {
        
        return  " \nPassenger{\n" + 
                ",name=" + name  + "\n" +
                ",surname=" + surname  + "\n" +
                ",pnrNo=" + pnrNo  + "\n" +
                ",flightDate=" + flightDate  + "\n" +
                ",iataCode=" + iataCode  + "\n" +
                ",flightNo=" + flightNo  + "\n" +
                ",flightFr=" + flightFr  + "\n" +
                ",flightTo=" + flightTo  + "\n" +
                ",flightDate=" + flightDate  + "\n" +
                ",seatNo=" + seatNo  + "\n" +
                ",compartment=" + compartment  + "\n" +
                '}' +
                " \n.................................\n";
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightFr() {
        return flightFr;
    }

    public void setFlightFr(String flightFr) {
        this.flightFr = flightFr;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getCompartment() {
        return compartment;
    }

    public void setCompartment(String compartment) {
        this.compartment = compartment;
    }
     
    
    
}
