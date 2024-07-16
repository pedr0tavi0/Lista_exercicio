package entities;

public class Employee {         //clase
    private Integer id;
    private String name;       //atributos da classe
    private Double salary;

    public Employee(){  //método construtor sem argumentos

    }

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double percentage){

        salary += salary * percentage / 100.0;
    }

    @Override
    public String toString() {
        return  id + ", " + name + ", " + String.format("%.2f",salary);
    }

}   
