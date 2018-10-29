/* make class final so that no class can inherit it */
public final class MyImmutable {
    private final String name;
    private final Address address;

    public MyImmutable(String name, String city, String district){
        this.name = name;
        address = new Address(city,district);
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
