package Common;

import java.util.function.Predicate;

public class Validate {

    public <T> void workerValidate(String errorMsg, T value, Predicate<T> predicate) throws Exception {
        if (!predicate.test(value))
            throw new Exception(errorMsg);
    }
}
