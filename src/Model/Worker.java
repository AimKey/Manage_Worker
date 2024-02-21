package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Worker {
    private int id, age;
    private double salary;
    private String name, workLocaiton;
    private LocalDate lastModifiedDate;
    private int status = -1;

    public Worker(int id, int age, double salary, String name, String workLocaiton) {
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.workLocaiton = workLocaiton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkLocaiton() {
        return workLocaiton;
    }

    public void setWorkLocaiton(String workLocaiton) {
        this.workLocaiton = workLocaiton;
    }

    public String getLastModifiedDate() {
        if (lastModifiedDate == null)
            return "NOT YET";
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(lastModifiedDate);
    }

    public void setLastModifiedDate(String LastModifiedDate) {
        this.lastModifiedDate = LocalDate.parse(LastModifiedDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return "Worker [id=" + id + ", age= " + age + ", salary= " + salary + ", name= " + name + ", workLocaiton= "
                + workLocaiton + ", Last Modified Date = " + getLastModifiedDate() + ", status= " + getStatus() + "]";
    }

    public String getStatus() {
        String s = "";
        switch (this.status) {
            case -1:
                s = "UNCHANGED";
                break;
            case 1:
                s = "UP";
                break;
            case 0:
                s = "DOWN";
                break;
            default:
                s = "Invalid value";
                break;
        }
        return s;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
