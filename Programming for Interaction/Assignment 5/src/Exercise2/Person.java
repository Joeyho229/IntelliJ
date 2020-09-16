package Exercise2;

public class Person {
    protected String name;
    protected String address;

    Person(String name, String address){
        this.address = address;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "Person{" + "name='" + name + '\'' + ", address='" + address + '\'' + '}';
    }
}
