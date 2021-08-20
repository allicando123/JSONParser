public class JSONBool extends JSONDataBase {

    public JSONBool() {
        this.type = DataType.Bool;
        this.data = false;
    }

    public String stringify() {
        return this.data.toString();
    }
}
