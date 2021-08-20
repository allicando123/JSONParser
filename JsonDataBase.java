public abstract class JSONDataBase {
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

    public JSONDataBase()
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

    public JSONNumber toJsonNumber() {
        return (JSONNumber)this;
    }

    public JSONString toJsonString() {
        return (JSONString)this;
    }

    public JSONObject toJsonObject() {
        return (JSONObject)this;
    }

    public JSONArray toJsonArray() {
        return (JSONArray)this;
    }

    public boolean isNull() {
        return data == null;
    }

    public DataType getType() {
        return type;
    }

    public abstract String stringify();
}