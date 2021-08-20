import java.util.ArrayList;
import java.util.Iterator;

public class JSONArray extends JSONDataBase {
    public JSONArray() {
        type = DataType.Array;
        data = new ArrayList<JSONDataBase>();
    }

    public void set(double value) {
        JSONDataBase json = new JSONNumber();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).add(json);
    }

    public void set(String value) {
        JSONDataBase json = new JSONString();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).add(json);
    }

    public void set(JSONDataBase value) {
        ((ArrayList<JSONDataBase>)data).add(value);
    }

    public void set(int index, double value) {
        JSONDataBase json = new JSONNumber();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).set(index, json);
    }

    public void set(int index, String value) {
        JSONDataBase json = new JSONString();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).set(index, json);
    }

    public void set(int index, JSONDataBase value) {
        ((ArrayList<JSONDataBase>)data).set(index, value);
    }

    public JSONDataBase remove(int index) {
        return ((ArrayList<JSONDataBase>)data).remove(index);
    }

    public void insert(int index, double value) {
        JSONDataBase json = new JSONNumber();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).add(index, json);
    }

    public void insert(int index, String value) {
        JSONDataBase json = new JSONString();
        json.setValue(value);
        ((ArrayList<JSONDataBase>)data).add(index, json);
    }

    public void insert(int index, JSONDataBase value) {
        ((ArrayList<JSONDataBase>)data).add(index, value);
    }

    public JSONDataBase get(int index) {
        return ((ArrayList<JSONDataBase>)data).get(index);
    }

    public int size() {
        return ((ArrayList<JSONDataBase>)data).size();
    }

    public int indexOf(Object o) {
        return ((ArrayList<JSONDataBase>)data).indexOf(o);
    }

    public Iterator<JSONDataBase> getIterator() {
        return ((ArrayList<JSONDataBase>)data).iterator();
    }

    public String stringify() {
        String s = "[";
        Iterator iterator = ((ArrayList)data).iterator();

        while (iterator.hasNext()) {
            JSONDataBase entry = (JSONDataBase)iterator.next();


            s += entry.stringify();

            if (iterator.hasNext())
                s += ",";
        }

        s += "]";

        return s;
    }
}
