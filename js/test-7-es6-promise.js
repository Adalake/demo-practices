///每隔一秒依次执行1，2，3，4，5实现一个休眠函数
// 法1
function sleep(interval) {
  return new Promise((resolve) => {
    setTimeout(resolve, interval);
  });
}

// 用法
async function one2FiveInAsync() {
  for (let i = 1; i <= 5; i++) {
    console.log(i);
    await sleep(1000);
  }
}
function test1() {
  this.one2FiveInAsync();
}
// 法2
const arr = [1, 2, 3, 4, 5];
function test2() {
  arr.reduce(
    (p, x) =>
      p.then(
        () => new Promise((r) => setTimeout(() => r(console.log(x)), 1000))
      ),
    Promise.resolve()
  );
}


///

// test1();
this.test2()
