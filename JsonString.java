public class JsonString extends JsonDataBase {
    public JsonString() {
        type = DataType.String;
        data = "";
    }

    public String stringify() {
        return "\"" + data.toString() + "\"";
    }
}