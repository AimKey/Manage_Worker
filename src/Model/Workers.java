package Model;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Workers extends ArrayList<Worker> {

    public ArrayList<Worker> search(Predicate<Worker> p) {
        ArrayList<Worker> result = new Workers();
        for (Worker worker : this) {
            if (p.test(worker))
                result.add(worker);
        }
        return result;
    }
}
