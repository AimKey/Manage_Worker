package Model;

import java.util.ArrayList;

public class History extends ArrayList<String> {

    public void addHistory(Worker worker) {
        String s = String.format("%-8s %-10s %-10d %-10.1f %-8s %-10s", worker.getId(), worker.getName(),
                worker.getAge(), worker.getSalary(), worker.getStatus(), worker.getLastModifiedDate());
        this.add(s);
    }
}
