# 简易的JSON解析器

`Java`编写的一个简单的`Json`解析器。使用一个简单的方法设计，能够胜任大部分形式的`Json`解析工作。但是在解析时对字符串进行了大量的操作，因此在解析庞大数据时效率可能会有些许影响，解析后不受影响。

## 主要功能

1. 将`Json`字符串转化为`Json`对象。
2. 将`Json`对象转化为字符串。
3. 能够通过`Java`代码创建`Json`对象。
4. 支持字符串、数字（双精度）、布尔值、空、`Json`对象、数组数据形式。
5. 支持键和字符串中包含`[]{}"`符号。

## 项目测试

1. `javac JsonTest.java`
2. `java JsonTest`

最终会输出测试结果。

## 功能说明

```java
// 假设有Json字符串str
// 将Json字符串转化为Json数据对象
// 如果是{}对象
JsonObject json = JsonParser.parse(str);
// 如果是[]对象
JsonArray json = JsonParser.parse(str);

// 获取内容
// {} 对象
JsonDataBase name = json.get("name");
name.toString(); // 转化为字符串
// 其他基本类型有
json.get("data").toNumber();
json.get("data").toBoolean();

// 也可以转化为对象
json.get("data").toJsonNumber();
json.get("data").toJsonString();
json.get("data").toJsonObject();
json.get("data").toJsonArray();
// 也可以如下转换
(JsonObject)json.get("data");

// [] 对象
json.get(0); // 获取第一个数据

// 插入数据
// {} 对象
json.set("name", "小明");
json.set("age", 18);
JsonArray arr = new JsonArray();
json.set("成绩", arr);
// 如果需要输入空值
json.set("null", new JsonNull());

// [] 对象
json.set("Hello");
json.set("小明");
json.set(123);

// 基本类型对象有
JsonNumber num;
JsonBool bool;
JsonNull nu;
JsonString str;

// 获取对象类型
JsonDataBase.DataType type = json.getType();
// type是枚举，可以通过类型比对获取到其类型，如
type == DataType.Number;

// 将对象转化为字符串
json.stringify();
```

## 注意

由于`Json`对象采用散列表存储，因此转化为字符串后，其中顺序有可能被打乱，不过不影响正常使用。

