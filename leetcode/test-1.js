var canThreePartsEqualSum = function (A) {
  let sum = A.reduce((acc, cur) => acc + cur); //sum数组之和
  let temp = 0; //temp累加
  let cnt = 0; //cnt计数
  for (let i = 0; i < A.length; i++) {
    temp += A[i];
    if (temp == sum / 3) {
      cnt++;
      if (cnt > 2) {
        return temp == sum / 3;
      }
      temp = 0;
      console.log(cnt);
    }
  }
  return (sum = !0 && cnt == 3);
};
