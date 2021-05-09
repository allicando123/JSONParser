import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonObject extends JsonDataBase {
    public JsonObject() {
        type = DataType.Object;
        data = new HashMap<String, JsonDataBase>();
    }

    public void set(String key, String value) {
        JsonDataBase json = new JsonString();
        json.setValue(value);
        ((HashMap<String, JsonDataBase>)data).put(key, json);
    }

    public void set(String key, double value) {
        JsonDataBase json = new JsonNumber();
        json.setValue(value);
        ((HashMap<String, JsonDataBase>)data).put(key, json);
    }

    public void set(String key, JsonDataBase value) {
        ((HashMap<String, JsonDataBase>)data).put(key, value);
    }

    public JsonDataBase get(String key) {
        return ((HashMap<String, JsonDataBase>)data).get(key);
    }

    public String stringify() {
        String s = "{";
        Iterator iterator = ((HashMap)data).entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();


            s += "\"" + entry.getKey() + "\":" + ((JsonDataBase)(entry.getValue())).stringify();

            if (iterator.hasNext())
                s += ",";
        }

        s += "}";

        return s;
    }
}
