// console.log('')

// -------------------- Object.assign()
//Object.assign() 方法用于将所有可枚举属性的值从一个或多个源对象分配到目标对象。它将返回目标对象。

function test1() {
  //基础操作
  let temp1 = { a: 1, b: 2 };
  let temp2 = { b: 3, d: 4 };
  let temp3 = Object.assign(temp1, temp2);
  console.log("---", temp3);
  //合并对象
  const o1 = { a: 1 };
  const o2 = { b: 2 };
  const o3 = { c: 3 };
  const obj = Object.assign(o1, o2, o3);
  console.log(obj); // { a: 1, b: 2, c: 3 }
  console.log(o1); // { a: 1, b: 2, c: 3 }, 注意目标对象自身也会改变。
  //浅拷贝 (针对深拷贝，需要使用其他办法，因为 Object.assign()拷贝的是（可枚举）属性值。)
  const obj1 = { a: 1 };
  const copy = Object.assign({}, obj1);
  console.log(copy); // { a: 1 }
}

// -------------------- Object.create()
//Object.create()方法创建一个新对象，使用现有的对象来提供新创建的对象的__proto__。

function test2_1() {
  const a = {
    nickName: "233lake",
  };
  const b = Object.create(a);
  console.log(b, b.nickName); //{} , 233lake
  //空对象
  var o;
  // 创建一个原型为null的空对象
  o = Object.create(null);
  o = {};
  // 以字面量方式创建的空对象就相当于:
  o = Object.create(Object.prototype);
}

//使用Object.create()来实现类式继承
function test2() {
  // Shape - 父类(superclass)
  function Shape() {
    this.x = 0;
    this.y = 0;
  }

  // 父类的方法
  Shape.prototype.move = function (x, y) {
    this.x += x;
    this.y += y;
    console.info("Shape moved.");
  };

  // Rectangle - 子类(subclass)
  function Rectangle() {
    Shape.call(this); // call super constructor.
  }

  // 子类续承父类
  Rectangle.prototype = Object.create(Shape.prototype);
  Rectangle.prototype.constructor = Rectangle;

  var rect = new Rectangle();

  console.log("Is rect an instance of Rectangle?", rect instanceof Rectangle); // true
  console.log("Is rect an instance of Shape?", rect instanceof Shape); // true
  rect.move(1, 1); // Outputs, 'Shape moved.'
}

// -------------------- Object.defineProperty()
// Object.defineProperty() 方法会直接在一个对象上定义一个新属性，或者修改一个对象的现有属性，并返回此对象。

function test3() {
  var o = {}; // 创建一个新对象
  // 在对象中添加一个属性与数据描述符的示例
  Object.defineProperty(o, "a", {
    value: 37,
    writable: true,
    enumerable: true,
    configurable: true,
  });
  // 对象 o 拥有了属性 a，值为 37

  // 在对象中添加一个设置了存取描述符属性的示例
  var bValue = 38;
  Object.defineProperty(o, "b", {
    // 使用了方法名称缩写
    // 下面两个缩写等价于：
    // get : function() { return bValue; },
    // set : function(newValue) { bValue = newValue; },
    get() {
      return bValue;
    },
    set(newValue) {
      bValue = newValue;
    },
    enumerable: true,
    configurable: true,
  });
  console.log(o.a, o.b);
}

function test3_1() {
  var obj = {};
  Object.defineProperties(obj, {
    property1: {
      value: true,
      writable: true,
    },
    property2: {
      value: "Hello",
      writable: false,
    },
    // etc. etc.
  });
}

// -------------------- Object.entries
// new Map() 构造函数接受一个可迭代的entries。用Object.entries方法将Object转换为Map:
function test4() {
  var obj = { foo: "bar", baz: 42 };
  var map1 = new Map(Object.entries(obj));
  console.log(map1); // Map { foo: "bar", baz: 42 }
  //Map
  //作为构造函数，Map 也可以接受一个数组作为参数。该数组的成员是一个个表示键值对的数组。
  const map = new Map([
    ["name", "张三"],
    ["title", "Author"],
  ]);
  map.size; // 2
  map.has("name"); // true
  map.get("name"); // "张三"
  map.has("title"); // true
  map.get("title"); // "Author"
}

// -------------------- Object.freeze()
// Object.isFrozen()方法判断一个对象是否被冻结。

// 用在vue中data参数中，避免过多的数据绑定
function test5() {
  const obj = {
    prop: 42,
  };
  Object.freeze(obj);
  obj.prop = 33; //抛出异常
  //冻结数组
  let a = [0];
  Object.freeze(a); // 现在数组不能被修改了.
  console.log(obj); //42
}

//要使对象不可变，需要递归冻结每个类型为对象的属性（深冻结）。
function test6() {
  // 深冻结函数.
  function deepFreeze(obj) {
    // 取回定义在obj上的属性名
    var propNames = Object.getOwnPropertyNames(obj);
    // 在冻结自身之前冻结属性
    propNames.forEach(function (name) {
      var prop = obj[name];
      // 如果prop是个对象，冻结它
      if (typeof prop == "object" && prop !== null) {
        deepFreeze(prop);
      }
    });
    // 冻结自身(no-op if already frozen)
    return Object.freeze(obj);
  }
  obj2 = {
    internal: {},
  };
  deepFreeze(obj2);
  obj2.internal.a = "anotherValue";
  obj2.internal.a; // undefined
  console.log(obj2.internal.a);
}

// Object.getOwnPropertyNames()
// 返回一个由指定对象的所有自身属性的属性名（包括不可枚举属性但不包括Symbol值作为名称的属性）组成的数组。
// 如果你只要获取到可枚举属性，查看Object.keys或用for...in循环（还会获取到原型链上的可枚举属性，不过可以使用hasOwnProperty()方法过滤掉）。

// 使用了 Array.prototype.filter() 方法，从所有的属性名数组（使用Object.getOwnPropertyNames()方法获得）中去除可枚举的属性（使用Object.keys()方法获得），剩余的属性便是不可枚举的属性了
function test7() {
  var arr = ["a", "b", "c"];
  console.log(Object.getOwnPropertyNames(arr).sort()); // ["0", "1", "2", "length"]
}

//Object.getPrototypeOf()
//返回指定对象的原型。 如果没有继承属性，则返回 null 。

function test8() {
  const prototype1 = {};
  const object1 = Object.create(prototype1);
  console.log(
    Object.getPrototypeOf(object1) === prototype1,
    Object.getPrototypeOf(prototype1) === Object.prototype //不是null哦
  ); //true，true
}

// Object.hasOwnProperty
// 所有继承了 Object 的对象都会继承到 hasOwnProperty 方法。这个方法可以用来检测一个对象是否含有特定的自身属性；
// 和 in 运算符不同，该方法会忽略掉那些从原型链上继承到的属性。

function test9() {
  const object1 = {};
  object1.property1 = 42;

  console.log(object1.hasOwnProperty("property1"));
  // expected output: true

  console.log(object1.hasOwnProperty("toString"));
  // expected output: false
}

//Object.is()
// Object.is() 方法判断两个值是否为同一个值。如果满足以下条件则两个值相等:
function test9() {
  Object.is("foo", "foo"); // true
  Object.is(window, window); // true

  Object.is("foo", "bar"); // false
  Object.is([], []); // false

  var foo = { a: 1 };
  var bar = { a: 1 };
  Object.is(foo, foo); // true
  Object.is(foo, bar); // false

  Object.is(undefined, undefined); // true
  Object.is(null, null); // true

  // 特例
  Object.is(0, -0); // false
  Object.is(0, +0); // true
  Object.is(-0, -0); // true
  Object.is(NaN, 0 / 0); // true
}

// 与== 运算不同。  == 运算符在判断相等前对两边的变量(如果它们不是同一类型) 进行强制转换 (这种行为的结果会将 "" == false 判断为 true), 而 Object.is不会强制转换两边的值。

//Object.keys()

function test9() {
  var obj = { 0: "a", 1: "b", 2: "c" };
  console.log(Object.keys(obj)); // console: ['0', '1', '2']
  var obj = { 0: "a", 1: "b", 2: "c" };
  console.log(Object.values(obj)); // ['a', 'b', 'c']
}

// 判断对象是否有某属性in，判断对象是否有自己的某属性hasOwnPorperty
function test10() {
  var a = { name: "lake" };
  console.log("name" in a,'toString' in a); //true true
  console.log(a.hasOwnProperty('name'),a.hasOwnProperty('toString')) //true false
}

//执行区
// this.test1();
// this.test2();
// this.test2_1();
// this.test3();
// this.test4();
// this.test5();
// this.test6(); //深冻结
// this.test8();
this.test10()