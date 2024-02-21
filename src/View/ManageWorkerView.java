package View;

import java.util.Collections;

import Model.History;

public class ManageWorkerView {
    public void displayHistory(History history) {
        System.out.println("--------------------Display Information Salary-----------------------");
        System.out.printf("%-8s %-10s %-10s %-10s %-8s %-10s\n", "ID", "Name", "Age", "Salary", "Status", "Date");
        Collections.sort(history);
        for (String worker : history) {
            System.out.println(worker);
        }
    }
}
