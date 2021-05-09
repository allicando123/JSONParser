import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonArray extends JsonDataBase {
    public JsonArray() {
        type = DataType.Array;
        data = new ArrayList<JsonDataBase>();
    }

    public void set(double value) {
        JsonDataBase json = new JsonNumber();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).add(json);
    }

    public void set(String value) {
        JsonDataBase json = new JsonString();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).add(json);
    }

    public void set(JsonDataBase value) {
        ((ArrayList<JsonDataBase>)data).add(value);
    }

    public JsonDataBase get(int index) {
        return ((ArrayList<JsonDataBase>)data).get(index);
    }

    public String stringify() {
        String s = "[";
        Iterator iterator = ((ArrayList)data).iterator();

        while (iterator.hasNext()) {
            JsonDataBase entry = (JsonDataBase)iterator.next();


            s += entry.stringify();

            if (iterator.hasNext())
                s += ",";
        }

        s += "]";

        return s;
    }
}
