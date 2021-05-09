public class JsonNumber extends JsonDataBase {
    public JsonNumber() {
        type = DataType.Number;
        data = (double)0;
    }

    public String stringify() {
        return data.toString();
    }
}