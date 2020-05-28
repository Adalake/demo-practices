// function truncate(arr) {
//   let temp = [];
//   for (let i in arr) {
//     temp.push(arr[i]);
//   }
//   temp.pop();
//   return temp;
// }
function truncate(arr) {
  let temp = arr.slice();
  temp.pop();
  return temp;
}
