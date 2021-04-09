/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressperson;

/**
 *
 * @author Lenovo
 */
public class Human extends AddressPerson{
    
    private String name;
    private String lastName;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;

    public Human(String name, String lastName, int dayBirth, int monthBirth, int yearBirth, String address) {
        this.name = name;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
        this.address = address;
    }
    
    public void findLastName(String lastName) {
        if(this.lastName.equals(lastName)){
            System.out.println("Человек найден: " + this.lastName + "" + this.name);
        }
    }
    
}
