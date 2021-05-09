import java.util.ArrayList;
import java.util.HashMap;

public abstract class JsonDataBase {
    public enum DataType {
        None,
        String,
        Number,
        Object,
        Array,
        Bool,
        Null
    };

    protected DataType type;

    protected Object data;

    public JsonDataBase()
    {
        type = DataType.None;
    }

    public void setValue(Object value) {
        data = value;
    }

    public String toString() {
        return data.toString();
    }

    public double toNumber() {
        return (double)data;
    }

    public boolean toBoolean() {
        return (boolean)data;
    }

    public JsonNumber toJsonNumber() {
        return (JsonNumber)this;
    }

    public JsonString toJsonString() {
        return (JsonString)this;
    }

    public JsonObject toJsonObject() {
        return (JsonObject)this;
    }

    public JsonArray toJsonArray() {
        return (JsonArray)this;
    }

    public boolean isNull() {
        return data == null;
    }

    public DataType getType() {
        return type;
    }

    public abstract String stringify();
}