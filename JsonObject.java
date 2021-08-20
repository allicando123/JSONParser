import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject extends JSONDataBase {
    public JSONObject() {
        type = DataType.Object;
        data = new HashMap<String, JSONDataBase>();
    }

    public void set(String key, String value) {
        JSONDataBase json = new JSONString();
        json.setValue(value);
        ((HashMap<String, JSONDataBase>)data).put(key, json);
    }

    public void set(String key, double value) {
        JSONDataBase json = new JSONNumber();
        json.setValue(value);
        ((HashMap<String, JSONDataBase>)data).put(key, json);
    }

    public void set(String key, JSONDataBase value) {
        ((HashMap<String, JSONDataBase>)data).put(key, value);
    }

    public JSONDataBase get(String key) {
        return ((HashMap<String, JSONDataBase>)data).get(key);
    }

    public JSONDataBase remove(String key) {
        return ((HashMap<String, JSONDataBase>)data).remove(key);
    }

    public int size() {
        return ((HashMap<String, JSONDataBase>)data).size();
    }

    public Iterator<Map.Entry<String, JSONDataBase>> getIterator() {
        return ((HashMap<String, JSONDataBase>)data).entrySet().iterator();
    }

    public String stringify() {
        String s = "{";
        Iterator iterator = ((HashMap)data).entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();


            s += "\"" + entry.getKey() + "\":" + ((JSONDataBase)(entry.getValue())).stringify();

            if (iterator.hasNext())
                s += ",";
        }

        s += "}";

        return s;
    }
}
