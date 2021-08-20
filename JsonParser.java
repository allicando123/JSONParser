import java.util.ArrayList;

public class JSONParser {

    public static JSONDataBase parse(String str) {

        ParserStack<Integer> symIndexStack = new ParserStack<Integer>(); // 保存符号栈索引，用来获取符号对
        ParserStack<JSONDataBase> dataStack = new ParserStack<JSONDataBase>(); // 保存数据栈
        ParserStack<Integer> countStack = new ParserStack<Integer>(); // 占位符计数器栈
        ParserStack<JSONDataBase> tempDataStack = new ParserStack<JSONDataBase>(); // 为多个占位符存储栈弹出的数据栈

        int count = 0; // 占位符计数

        int leftSymIndex; // 左符号索引

        StringBuilder builder = new StringBuilder(str); // 使用StringBuilder提高解析速度

        boolean quotaLeft = true; // 是否为左引号，保证字符串中可以输入{} []

        for (int i = 0; i < builder.length(); i++) {
            switch (builder.charAt(i)) {
                case '{':
                case '[':

                    if (!quotaLeft)
                        continue;

                    symIndexStack.push(i); // 将左符号位置压栈

                    countStack.push(count);
                    count = 0; // 重新计数
                    break;
                case '}':

                    if (!quotaLeft)
                        continue;

                    leftSymIndex = symIndexStack.pop(); // 获取左符号索引

                    String[] keyValues = builder.substring(leftSymIndex + 1, i).split(",");

                    JSONDataBase jdb; // Json数据对象

                    JSONObject jo = new JSONObject();

                    // 将相关数量的占位符数据放入队列中
                    while (0 < count--) {
                        tempDataStack.push(dataStack.pop());
                    }

                    for (int j = 0; j < keyValues.length; j++) {
                        String[] kv = keyValues[j].split(":");
                        kv[0] = kv[0].trim();
                        kv[0] = kv[0].substring(1, kv[0].length() - 1); // 键
                        kv[1] = kv[1].trim(); // 值

                        switch (kv[1].charAt(0)) {
                            case '"': // 为字符串

                                jdb = new JSONString();
                                jdb.setValue(kv[1].substring(1, kv[1].length() - 1));
                                break;
                            case '$': // 为占位符
                                jdb = tempDataStack.pop();
                                break;
                            default: // 为数字、布尔值、空
                                if (kv[1].equals("true")) {
                                    jdb = new JSONBool();
                                    jdb.setValue(true);
                                } else if (kv[1].equals("false")) {
                                    jdb = new JSONBool();
                                    jdb.setValue(false);
                                } else if (kv[1].equals("null")) {
                                    jdb = new JSONNull();
                                } else {
                                    jdb = new JSONNumber();
                                    jdb.setValue(Double.parseDouble(kv[1]));
                                }
                                break;
                        }

                        // 存放数据
                        jo.set(kv[0], jdb);
                    }

                    dataStack.push(jo);

                    count = countStack.pop();
                    count++; // 产生了一个占位符

//                    str = str.substring(0, leftSymIndex) + "$" + str.substring(i + 1);

                    builder.delete(leftSymIndex, i + 1);
                    builder.insert(leftSymIndex, "$");
                    i = leftSymIndex;

                    break;
                case ']':

                    if (!quotaLeft)
                        continue;

                    leftSymIndex = symIndexStack.pop(); // 获取左符号索引

                    keyValues = builder.substring(leftSymIndex + 1, i).split(",");

//                    JsonDataBase jdb; // Json数据对象

                    JSONArray ja= new JSONArray();

                    // 将相关数量的占位符数据放入队列中
                    while (0 < count--) {
                        tempDataStack.push(dataStack.pop());
                    }

                    for (int j = 0; j < keyValues.length; j++) {
                        String v = keyValues[j];
                        v = v.trim();

                        switch (v.charAt(0)) {
                            case '"': // 为字符串
                                jdb = new JSONString();
                                jdb.setValue(v.substring(1, v.length() - 1));

                                break;
                            case '$': // 为占位符
                                jdb = tempDataStack.pop();
                                break;
                            default: // 为数字、布尔值、空
                                if (v.equals("true")) {
                                    jdb = new JSONBool();
                                    jdb.setValue(true);
                                } else if (v.equals("false")) {
                                    jdb = new JSONBool();
                                    jdb.setValue(false);
                                } else if (v.equals("null")) {
                                    jdb = new JSONNull();
                                } else {
                                    jdb = new JSONNumber();
                                    jdb.setValue(Double.parseDouble(v));
                                }
                                break;
                        }

                        // 存放数据
                        ja.set(jdb);
                    }

                    dataStack.push(ja);



                    count = countStack.pop();
                    count++; // 产生了一个占位符

                    builder.delete(leftSymIndex, i + 1);
                    builder.insert(leftSymIndex, "$");
                    i = leftSymIndex;

                    break;

                case '"':
                    quotaLeft = !quotaLeft;
                    break;
            }


        }

        return dataStack.pop();
    }

    public static String stringify(JSONDataBase json) {
        return json.stringify();
    }

    static class ParserStack<T> extends ArrayList<T> {
        public void push(T t) {
            add(t);
        }

        public T pop() {
            return remove(size() - 1);
        }

        public T getTop() {
            return get(size() - 1);
        }
    }
}
