import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author DrinkFish
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 20);
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        System.out.println(entries);
    }
}
