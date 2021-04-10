
package addressperson;


class AddressPerson{
    
    private String street;
    private int numberHome;
    private int flat;
    
    protected void setStreet(String street) {
        this.street = street;
    }
    
    protected void setNumberHome(int numberHome) {
        this.numberHome = numberHome;
    }
    
    protected void setFlat(int flat) {
        this.flat = flat;
    }
    
    protected String getStreet() {
        return street;
    }
    
    protected int getNumberHome() {
        return numberHome;
    }
    
    protected int getFlat() {
        return flat;
    }
    
    protected boolean findStreet(String street) {
        return this.street.equals(street);//Если улица найдена true
    }
    
    protected boolean findHome(int numberHome) {
        return this.numberHome == numberHome;//Если дом совпал вернуть true
    }
    
    protected boolean findFlat(int flat) {
        return this.flat == flat;
    }
    
    public boolean findPeopleLivingSameStreet(String street) {
        return this.street.equals(street);
    }
}
