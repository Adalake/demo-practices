function removeWithoutCopy(arr, item) {
  for (var i in arr) {
    while (arr[i] == item) {
      arr.splice(i, 1);
    }
  }
  return arr;
}
 