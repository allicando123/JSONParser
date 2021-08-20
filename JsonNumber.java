public class JSONNumber extends JSONDataBase {
    public JSONNumber() {
        type = DataType.Number;
        data = (double)0;
    }

    public String stringify() {
        return data.toString();
    }
}