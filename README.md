# 简易的JSON解析器

`Java`编写的一个简单的`JSON`解析器。使用一个简单的方法设计，能够胜任大部分形式的`JSON`解析工作。

## 主要功能

1. 将`JSON`字符串转化为`JSON`对象。
2. 将`JSON`对象转化为字符串。
3. 能够通过`Java`代码创建`JSON`对象。
4. 支持字符串、数字（双精度）、布尔值、空、`JSON`对象、数组数据形式。
5. 支持键和字符串中包含`[]{}"`符号。

## 项目测试

1. `javac JSONTest.java`
2. `java JSONTest`

最终会输出测试结果。

## 功能说明

```java
// 假设有JSON字符串str
// 将JSON字符串转化为JSON数据对象
// 如果是{}对象
JSONObject json = JSONParser.parse(str);
// 如果是[]对象
JSONArray json = JSONParser.parse(str);

// 获取内容
// {} 对象
JSONDataBase name = json.get("name");
name.toString(); // 转化为字符串
// 其他基本类型有
json.get("data").toNumber();
json.get("data").toBoolean();

// 也可以转化为对象
json.get("data").toJSONNumber();
json.get("data").toJSONString();
json.get("data").toJSONObject();
json.get("data").toJSONArray();
// 也可以如下转换
(JSONObject)json.get("data");

// [] 对象
json.get(0); // 获取第一个数据

// 插入数据
// {} 对象
json.set("name", "小明");
json.set("age", 18);
JSONArray arr = new JSONArray();
json.set("成绩", arr);
// 如果需要输入空值
json.set("null", new JSONNull());

// [] 对象
json.set("Hello");
json.set("小明");
json.set(123);
json.set(0, "hi"); // 修改索引为0的元素
json.insert(0, "world"); // 在索引0处插入元素
json.remove(0); // 删除索引为0的元素

// 基本类型对象有
JSONNumber num;
JSONBool bool;
JSONNull nu;
JSONString str;

// 获取对象类型
JSONDataBase.DataType type = json.getType();
// type是枚举，可以通过类型比对获取到其类型，如
type == DataType.Number;

// 获取对象中数据数量
json.size();

// 获取迭代器
json.getIterator();

// 将对象转化为字符串
json.stringify();
```

## 注意

由于`JSON`对象采用散列表存储，因此转化为字符串后，其中顺序有可能被打乱，不过不影响正常使用。

## 2021-8-20 更新

1. 将`Json`修改为`JSON`。

2. 修改了解析数据结构，提高了解析速度。

   本次测试将`JSON`字符串解析10000次和1000000次得出的结果的新旧代码对比（左新，右旧）

   1. 10000次：

      ![image-20210820163413211](README/image-20210820163413211.png)

   2. 1000000次：

      ![image-20210820163448782](README/image-20210820163448782.png)