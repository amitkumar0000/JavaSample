/*
    Make class final so that no class can inherit it .
    Make all member variable final so they can initialize only once.
    Make deep copy of all object member variable in Constructor.
    Return clone object on getter.
    Provide no setter method.
*/
public final class MyImmutable {
    private final String name;
    private final Address address;
    private final Address addresG;

    public MyImmutable(String name, String city, String district, Address address) throws CloneNotSupportedException {
        this.name = name;
        this.address = new Address(city,district);
        addresG = (Address)address.clone();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        // if address does not implements cloneable interface
        Address add = new Address(address.getCity(),address.getDistrict());
        // Address implements cloneable interface
        Address ad = null;
        try {
            ad = (Address)address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return add;
    }

    public Address getAddresG() {
        Address addressX = null;
        try {
            addressX = (Address)addresG.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return addressX;
    }
}

class Address implements Cloneable{
    private String city;
    private String district;

    public Address(String city, String district){
        this.city = city;
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address address = (Address) super.clone();
        return address;
    }
}
