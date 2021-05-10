import java.util.Iterator;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        JsonObject json = new JsonObject();
        json.set("姓名", "小明");
        json.set("年龄", 18);
        json.set("身高", 180);

        JsonArray arr = new JsonArray();

        json.set("成绩", arr);

        JsonObject chinese = new JsonObject();
        chinese.set("分数", 120);
        chinese.set("等级", "优秀");

        JsonObject math = new JsonObject();
        math.set("分数", 150);
        math.set("等级", "卓越");

        arr.set(chinese);
        arr.set(math);

        System.out.println(json.stringify());

        chinese =  (JsonObject)arr.get(0);
        chinese.set("分数", 125);

        JsonObject english = new JsonObject();
        english.set("分数", 120);
        english.set("等级", "卓越");

        arr.insert(0, english);

        // [] 遍历
        Iterator iterator = arr.getIterator();
        while (iterator.hasNext()) {
            System.out.println(((JsonDataBase)iterator.next()).stringify());
        }

        // {} 遍历
        iterator = json.getIterator();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonDataBase> entry = (Map.Entry<String, JsonDataBase>)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().stringify());
        }
    }
}
