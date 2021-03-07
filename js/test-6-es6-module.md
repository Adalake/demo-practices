关于模块化
// 模块还能继承引用

# a.js : 

export default function() {
    console.log(‘我是默认export’)
}

const a = {
	x:1,
	y:2
}

function b() {
 	console.log(‘我是函数b’)
}

export {a, b}

—

# b.js:

import * as anyName from ‘./a.js’

import {a,b} from ‘./a.js’

import defaultMoudle from ‘./a.js’

es6 模块
# export 关键字
export命令除了输出变量，还可以输出函数或类（class）。

// 写法一
export var m = 1;

// 写法二
var m = 1;
export {m};

// 正确
export function f() {};

// 正确
function f() {}
export {f};

# import 命令
使用export命令定义了模块的对外接口以后，其他 JS 文件就可以通过import命令加载这个模块。


---
路由 打包配置：https://www.jianshu.com/p/b08908e6a0cf
当访问为空白页，这也是引用资源路径问题。