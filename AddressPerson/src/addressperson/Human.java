package addressperson;

public class Human extends AddressPerson {
    
    private String name;
    private String lastName;
    private int dayBirth;
    private int monthBirth;
    private int yearBirth;

    public Human(String name, String lastName, int dayBirth, int monthBirth, int yearBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
    }
    
    public boolean findLastName(String lastName) {
        return this.lastName.equals(lastName);//true если нашли  
    }
    
    public String humanData(){
        return "Фамилия: " + this.lastName + "\nИмя: " + this.name
                + "\nДень рождения: " + this.dayBirth+"."+this.monthBirth+"."+this.yearBirth
                + "\nАдрес: улица " + getStreet() + ", дом " + getNumberHome() + ", кв " + getFlat();
    }
    
    public boolean findDayBirth(int dayBirth) {
        return this.dayBirth == dayBirth; //Если даты совпали вернуть true
    }
    
    public boolean findMonthBirth(int monthBirth) {
        return this.monthBirth == monthBirth;
    }
    
    public boolean findYearBirth(int yearBirth) {
        return this.yearBirth == yearBirth;
    }
    
    public int getYearBirth() {
        return this.yearBirth;
    }
    
    public int getDayBirth() {
        return this.dayBirth;
    }
    
    public int getMonthBirth() {
        return this.monthBirth;
    }
    
}
