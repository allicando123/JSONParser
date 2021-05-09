public class JsonNull extends JsonDataBase {

    public JsonNull() {
        this.type = DataType.Null;
        this.data = null;
    }

    public String stringify() {
        return "null";
    }
}
