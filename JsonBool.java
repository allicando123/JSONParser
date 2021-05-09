public class JsonBool extends JsonDataBase {

    public JsonBool() {
        this.type = DataType.Bool;
        this.data = false;
    }

    public String stringify() {
        return this.data.toString();
    }
}
