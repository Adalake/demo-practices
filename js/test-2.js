// 闭包
// 当我们需要在模块中定义一些变量，并希望这些变量一直保存在内存中但又不会 “污染” 全局的变量时，就可以用闭包来定义这个模块
function test1() {
  function counterCreator() {
    var index = 1;
    function counter() {
      console.log(index);
      return index++;
    }
    return counter;
  }

  var counterA = counterCreator();
  var counterB = counterCreator();
  counterA(); // 1
  counterA(); // 2
  counterB(); // 1
  counterB(); // 2
}

//防抖
function debounceClick() {
  this.betterFn();
}
function debounce1(wait = 50) {
  let timer = null; // 通过闭包缓存一个定时器 id
  return function () {
    if (timer) {
      clearTimeout(timer);
    }
    timer = setTimeout(() => console.log("fn 防抖执行了"), wait);
  };
}
betterFn = this.debounce1(1000);

//节流
function throttleClick() {
  this.betterFn2();
}
function throttle1(delay = 1000) {
  var lastTime = 0;
  return function () {
    var nowTime = Date.now();
    if (nowTime - lastTime > delay) {
      console.log("scroll事件被触发了" + Date.now());
      lastTime = nowTime;
    }
  };
}
betterFn2 = this.throttle1(1000);

this.test1();
