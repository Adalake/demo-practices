//在async/await的某些时刻，你可能尝试在同步循环中调用异步函数
async function process() {
  for await (let i of [33, 44, 55, 66]) {
    console.log(i);
  }
}

//箭头函数的this指向问题
var name = "windowsName";
var a = {
  name: "lake",
  func1: function () {
    console.log(this.name);
  },
  func2: function () {
    console.log(this); // 对象a
    this.func1(); //'lake'
    setTimeout(function () {
      //  this.func1()  //报错this.func1 is not a function   //因为是匿名函数 this指向window 【这里不是异步的问题】
      console.log(this); //window
    }, 100);
    setTimeout(() => {
      this.func1(); //'lake
    }, 0);
  },
};
function test1() {
  a.func2();
}
// 在不使用箭头函数的情况下，是会报错的，因为最后调用 setTimeout 的对象是 window，但是在 window 中并没有 func1 函数。

//bind函数
function test() {
  var a = {
    name: "Cherry",
    fn: function (a, b) {
      console.log(a + b);
    },
    // 也可写为：
    fn1(a, b) {
      console.log(a + b);
    },
  };
  var b = a.fn;
  b.bind(a, 1, 2)(); // 3
  var b1 = a.fn1;
  b1.bind(a, 1, 2)(); // 3
}

// 扩展运算符
function test2() {
  this.testlog([1, 2]);
  this.log(1); //1
  this.log(1, 2); //1
  this.applog(1); //(app) 1
  this.applog(1, 2); //(app) 1 2
}
//代理console方法
// 法1
function testlog(x) {
  console.log.call(console, ...x);
}

// 法2
function log() {
  console.log.apply(console, arguments);
}

// 给每个log 添加app前缀
function applog() {
  var args = Array.prototype.slice.call(arguments);
  args.unshift("(app)");
  console.log.apply(console, args);
}

//setTimeout 和普通函数 || 箭头函数
var id = "Global";
function fun1() {
  // setTimeout中使用普通函数
  setTimeout(function () {
    console.log(this.id);
  }, 2000);
}
function fun2() {
  // setTimeout中使用箭头函数
  setTimeout(() => {
    console.log(this.id);
  }, 2000);
}
fun1(); // 'Global'
fun1.call({
  id: "Obj",
}); // 'Global'
fun2.call({
  id: "Obj",
}); // 'Obj'

// 上面这个例子，函数fun1中的setTimeout中使用普通函数，2秒后函数执行时，这时函数其实是在全局作用域执行的，所以this指向Window对象，this.id就指向全局变量id，所以输出'Global'。
// 但是函数fun2中的setTimeout中使用的是箭头函数，这个箭头函数的this在定义时就确定了，它继承了它外层fun2的执行环境中的this，而fun2调用时this被call方法改变到了对象{id: 'Obj'}中，所以输出'Obj'。


// this.process();
// this.test();
// this.test1();
// this.test2();

