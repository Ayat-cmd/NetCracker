/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressperson;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class MainAddressPerson {
    
    public static void main(String[] args) {
        
        String name = null;
        String lastName = null;
        int dayBirth = 0;
        int monthBirth = 0;
        int yearBirth = 0;

        System.out.println("Введите количество человек >= 4");
        
        Scanner sc = new Scanner(System.in);
        
        //Human[] h = new Human(name, lastName, dayBirth, monthBirth, yearBirth);
    }
}

abstract class Template{
    int In() {
        
        return 9;
    }
}