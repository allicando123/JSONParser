public class JSONString extends JSONDataBase {
    public JSONString() {
        type = DataType.String;
        data = "";
    }

    public String stringify() {
        return "\"" + data.toString() + "\"";
    }
}