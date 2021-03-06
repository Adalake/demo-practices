//去重
var arr = [1, 2, 3, 3, 2, 1];

function test1() {
  //法1
  let a1 = Array.from(new Set(arr));
  //法2 indexOf() 和 push()
  let temp1 = [];
  for (let i = 0; i < arr.length; i++) {
    if (temp1.indexOf(arr[i]) == -1) {
      temp1.push(arr[i]);
    }
  }
  //法3 排序后相邻去除法 sort()
  let temp2 = arr.sort();
  let temp3 = [];
  for (let i = 0; i < temp2.length; i++) {
    if (temp2[i] !== temp2[i + 1]) {
      temp3.push(temp2[i]);
    }
  }
  console.log(a1, temp1, temp3);
}

//求和
var arr2 = [1, 2, 3, 4];

function test2() {
  //法1 reduce
  let temp1 = arr2.reduce((pre, cur) => {
    return pre + cur;
  }, 0);
  //法2 「for循环」「for in」「forEach」「for of」 此处我只写了这其中的一种
  let sum = 0;
  for (let i in arr2) {
    sum += arr2[i];
  }
  //法3 map
  let sum2 = 0;
  arr2.map((x) => {
    return (sum2 += x);
  });
  console.log(temp1, sum, sum2);
}

//扁平
var arr3 = [
  1,
  2,
  3,
  4,
  [1, 2, 3, [1, 2, 3, [1, 2, 3]]],
  5,
  "string",
  { name: "lake" },
];
// 如果原数组有空位，Array.prototype.flat() 会跳过空位。

function test3() {
  var a = [1, 2, 3, [1, 2, 3, [1, 2, 3]]];
  console.log(a.flat()); //基本操作
  //使用 Infinity，可展开任意深度的嵌套数组
  var arr4 = [1, 2, [3, 4, [5, 6, [7, 8, [9, 10]]]]];
  arr4.flat(Infinity);
  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}
//手写实现扁平 法1递归 法2reduce 法3es6扩展运算符
function test3_1() {
  function test3_2(arr) {
    let arrResult = [];
    arr.forEach((item) => {
      if (Array.isArray(item)) {
        arrResult = arrResult.concat(test3_2(item));
      } else {
        arrResult.push(item);
      }
    });
    console.log(arrResult);
    return arrResult;
  }
  test3_2(arr3);
}

function test4(arr) {
  while (arr.some((item) => Array.isArray(item))) {
    arr = [].concat(...arr);
  }
  return arr;
}

//判断数组是数组 || 数据类型
function test5() {
  const arr = [1, 2];
  let a = typeof arr;
  let a1 = arr instanceof Array;
  let a2 = arr.constructor === Array;
  let a3 = Object.prototype.toString.call(arr) === "[object Array]";
  let a4 = Array.isArray(arr);
  console.log(a, a1, a2, a3, a4); //object true true true true
  let d1 = arr instanceof Object;
  let d2 = arr.constructor === Object;
  console.log(d1, d2); //true false
}
//基本操作

//高阶函数  map/reduce /filter
//reduce实现扁平
function test7() {
  const arr = [
    1,
    2,
    3,
    4,
    [1, 2, 3, [1, 2, 3, [1, 2, 3]]],
    5,
    "string",
    { name: "lake" },
  ];
  // 首先使用 reduce 展开一层
  arr.reduce((pre, cur) => pre.concat(cur), []);
  // 用 reduce 展开一层 + 递归
  const flat = (arr) => {
    return arr.reduce((pre, cur) => {
      return pre.concat(Array.isArray(cur) ? flat(cur) : cur);
    }, []);
  };
  // [1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 1, 2, 3, 5, "string", { name: "lake" }];
}

//求和
// 略...

// this.test1();
// this.test2();
this.test3_1(); //手写扁平
// this.test5()
// 遍历数组并取得数组元素的方法非常之多，包括且不限于下面几种：

// for 循环
// for...of
// for...in
// forEach()
// entries()
// keys()
// values()
// reduce()
// map()
