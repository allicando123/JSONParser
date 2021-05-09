import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

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
    }
}
