package Controller;

import java.time.format.DateTimeParseException;

import Common.Library;
import Common.Validate;
import Model.History;
import Model.Worker;
import Model.Workers;
import View.ManageWorkerView;
import View.Menu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller extends Menu<String> {

    private Library library;
    private ManageWorkerView view;
    private Workers workers;
    private History history;
    private Validate validate;

    public Controller() {
        super(new String[]{"Add a Worker", "Increase/ decrease salary for worker",
            "Show adjusted salary worker information", "Exit"},
                "Worker manager");
        library = new Library();
        view = new ManageWorkerView();
        workers = new Workers();
        history = new History();
        validate = new Validate();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addWorker();
                break;
            case 2:
                adjustSalary();
                break;
            case 3:
                getInformationSalary();
                break;
            case 4:
                System.out.println("See you next time");
                System.exit(0);
                break;
        }
    }

    public boolean addWorker() {
        boolean status = false;
        try {
            int id = workers.size() + 1;
            String name = library.getString("Name", "No numbers allowed!");
            int age = library.getInt("Age", "NO characters allowed!");
            double salary = library.getDouble("Salary", "No characters allowed!");
            String workLocation = library.getString("WorkLocation", "No numbers allowed!");
            validate.workerValidate("Age must between 18 and 50", age, p -> p >= 18 && p <= 50);
            validate.workerValidate("Salary must > 0", salary, p -> p >= 0);
            workers.add(new Worker(id, age, salary, name, workLocation));
            status = true;
        } catch (DateTimeParseException e) {
            library.printErr("Please enter correct date and format: dd/MM/yyyy");
        } catch (Exception e) {
            library.printErr(e.getMessage());
        }
        if (status) {
            System.out.println("Success!");
        } else {
            library.printErr("Failed...");
        }
        return status;
    }

    public boolean adjustSalary() {
        boolean status = false;
        try {
            int id = library.getInt("Enter id", "Numbers only");
            Worker w = workers.search(p -> p.getId() == id).get(0);
            System.out.println(w);
            double salary = library.getDouble("Enter new salary", "Number only!");
            validate.workerValidate("Salary must > 0", salary, p -> p >= 0);
            int workStatus = 0;
            if (salary > w.getSalary()) {
                workStatus = 1;
            }
            String date;
            w.setSalary(salary);
            w.setStatus(workStatus);
            date = library.getString("Enter modify date");
            if ("".equals(date)) date = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now());
            w.setLastModifiedDate(date);
            history.addHistory(w);
            status = true;
        } catch (IndexOutOfBoundsException e) {
            library.printErr("Worker not found!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (status == false) {
            library.printErr("Failed...");
        } else {
            System.out.println("Success!");
        }
        return status;
    }

    public void getInformationSalary() {
        view.displayHistory(history);
    }

}
