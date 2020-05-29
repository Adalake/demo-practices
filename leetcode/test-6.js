// 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

/**
 * @param {number} num
 * @param {number} power
 * @return {number}
 */
var myPow = (num, power) => {
  if (power < 0) return 1 / (num * myPow(num, -(power + 1)));
  if (power === 0) return 1;
  if (power === 1) return num;
  return power % 2 === 1
    ? num * myPow(num, power - 1)
    : myPow(num * num, power / 2);
};
