// 二维数组中的查找

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
