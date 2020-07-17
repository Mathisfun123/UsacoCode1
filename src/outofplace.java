import java.util.Arrays;
import java.util.Collections;

public class outofplace {
    public static void main(String[] args) {
        Integer [] arr = {1,3,22,34,22,3};
        Collections.max(Arrays.asList(arr));
    }
}
