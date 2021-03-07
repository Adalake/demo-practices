//在async/await的某些时刻，你可能尝试在同步循环中调用异步函数
async function process() {
  for await (let i of [33, 44, 55, 66]) {
    console.log(i);
  }
}

this.process()