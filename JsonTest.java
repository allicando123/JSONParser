import java.util.Iterator;
import java.util.Map;

public class JSONTest {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.set("姓名", "小明");
        json.set("年龄", 18);
        json.set("身高", 180);

        JSONArray arr = new JSONArray();

        json.set("成绩", arr);

        JSONObject chinese = new JSONObject();
        chinese.set("分数", 120);
        chinese.set("等级", "优秀");

        JSONObject math = new JSONObject();
        math.set("分数", 150);
        math.set("等级", "卓越");

        arr.set(chinese);
        arr.set(math);

        System.out.println(json.stringify());

        chinese =  (JSONObject)arr.get(0);
        chinese.set("分数", 125);

        JSONObject english = new JSONObject();
        english.set("分数", 120);
        english.set("等级", "卓越");

        arr.insert(0, english);

        // [] 遍历
        Iterator iterator = arr.getIterator();
        while (iterator.hasNext()) {
            System.out.println(((JSONDataBase)iterator.next()).stringify());
        }

        // {} 遍历
        iterator = json.getIterator();
        while (iterator.hasNext()) {
            Map.Entry<String, JSONDataBase> entry = (Map.Entry<String, JSONDataBase>)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().stringify());
        }
    }
}
