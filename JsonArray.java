import java.util.ArrayList;
import java.util.Iterator;

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

    public void set(int index, double value) {
        JsonDataBase json = new JsonNumber();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).set(index, json);
    }

    public void set(int index, String value) {
        JsonDataBase json = new JsonString();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).set(index, json);
    }

    public void set(int index, JsonDataBase value) {
        ((ArrayList<JsonDataBase>)data).set(index, value);
    }

    public JsonDataBase remove(int index) {
        return ((ArrayList<JsonDataBase>)data).remove(index);
    }

    public void insert(int index, double value) {
        JsonDataBase json = new JsonNumber();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).add(index, json);
    }

    public void insert(int index, String value) {
        JsonDataBase json = new JsonString();
        json.setValue(value);
        ((ArrayList<JsonDataBase>)data).add(index, json);
    }

    public void insert(int index, JsonDataBase value) {
        ((ArrayList<JsonDataBase>)data).add(index, value);
    }

    public JsonDataBase get(int index) {
        return ((ArrayList<JsonDataBase>)data).get(index);
    }

    public int size() {
        return ((ArrayList<JsonDataBase>)data).size();
    }

    public int indexOf(Object o) {
        return ((ArrayList<JsonDataBase>)data).indexOf(o);
    }

    public Iterator<JsonDataBase> getIterator() {
        return ((ArrayList<JsonDataBase>)data).iterator();
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
