public class JSONNull extends JSONDataBase {

    public JSONNull() {
        this.type = DataType.Null;
        this.data = null;
    }

    public String stringify() {
        return "null";
    }
}
