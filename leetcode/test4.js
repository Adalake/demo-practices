// 递归
function factorial(n) {
  if (n === 1) {
    return n;
  } else {
    return n * factorial(n - 1);
  }
}
// 测试用例：factorial(5) 即 5*4*3*2*1

