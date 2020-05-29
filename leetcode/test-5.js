// 二维数组中的查找

// 时间复杂度是 O(N^2)，空间复杂度是 O(1)
function Find(target, array) {
  const rowNum = array.length;
  if (!rowNum) {
    return false;
  }
  const colNum = array[0].length;
  for (let i = 0; i < rowNum; i++) {
    for (let j = 0; j < colNum; j++) {
      if (array[i][j] === target) return true;
    }
  }
  return false;
}
