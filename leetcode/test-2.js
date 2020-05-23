// 回文数
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  if (x < 0) {
    return false;
  }
  var flag = true;
  x = x.toString();
  for (let i = 0, len = x.length; i < len / 2; i++) {
    if (x[i] !== x[len - 1 - i]) {
      flag = false;
      break;
    }
  }
  return flag;
};
