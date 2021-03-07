// jsonp底层方法
function jsonp(url, callback) {
  var oscript = document.createElement("script");
  if (oscript.readyState) {
    // ie8及以下版本
    oscript.onreadystatechange = function () {
      if (
        oscript.readyState === "complete" ||
        oscript.readyState === "loaded"
      ) {
        callback();
      }
    };
  } else {
    oscript.onload = function () {
      callback();
    };
  }
  oscript.src = url;
  document.body.appendChild(oscript);
}

// call & apply
Function.prototype.myCall = function () {
  // myApply 通用
  if (typeof this !== "function") throw "caller must be a function";
  let self = arguments[0] || window;
  self._fn = this;
  let args = [...arguments].flat().slice(1); // 展开后取参数列表
  let res = self._fn(...args); // 谁调用函数，函数的 this 就指向谁
  Reflect.deleteProperty(self, "_fn"); // 删除 _fn 属性
  return res;
};

//深拷贝
function deepClone(target) {
  if (typeof target !== "object") {
    return target;
  }
  var result;
  if (Object.prototype.toString.call(target) == "[object Array]") {
    // 数组
    result = [];
  } else {
    // 对象
    result = {};
  }
  for (var prop in target) {
    if (target.hasOwnProperty(prop)) {
      result[prop] = deepClone(target[prop]);
    }
  }
  return result;
}

//异步顺序输出0~4
function test0() {
  //输出5个5
  for (var i = 0; i < 5; i++) {
    setTimeout(() => {
      console.log(i);
    }, 0);
  }
}
function test1() {
  for (let i = 0; i < 5; i++) {
    setTimeout(() => {
      console.log(i);
    }, 0);
  }
}
function test2() {
  for (var i = 0; i < 5; i++) {
    (function (j) {
      setTimeout(() => {
        console.log(j);
      }, 0);
    })(i);
  }
}

function test3() {
  return new Promise((res) => setTimeout(res, 0));
}
async function test3_1() {
  for (let i = 0; i < 5; i++) {
    await test3();
    console.log(i);
  }
}

// this.test0();
// this.test1();
// this.test2();
this.test3_1();
