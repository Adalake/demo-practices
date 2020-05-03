相同的表达式不要重复出现多次 --figure 7

The rest of this chapter introduces four forms of atomic data of BSL: numbers, strings, images, and Boolean values.The next volume, How to Design Components, will explain how to design atomic data.

figure-8(version 5) 达成: 小火箭从顶部降落，通过 cond 判断小火箭的高度，使得小火箭的底部停在画板的底部。

"The second edition shows how these ideas apply also to writing interactive programs, through the medium of small games.
Even the biggest games have an underlying rich data model and transformations over them, and separate from this the “graphical” parts.
So once a problem is decomposed into these parts, the same ideas can apply to the model. Thus the model-view separation arises in a way that is natural, lightweight, and immediately useful."

--------------presentation of HTDP

1. Why does HtDP use Racket/Scheme rather than say, Python?

   - try to teach the concepts, and it's amazing how complex things can be made from it. (可删)

   - All mainstream, general purpose languages are too complex for beginners. 它是 Teaching Language，它的内置方法都很有语义化，比如 Alex 的 fetchDataFromDB()。还有API的使用方法。以及某个变量它所有的地方

   - Appropriate error messages, that students know how to make progress by reading (and not deciphering) the error messages.

2. Why should I read

   - ref: https://www.quora.com/Why-should-I-read-the-book-How-to-Design-Programs-What-does-it-offer-to-a-programmer-with-experience-I-have-been-programming-for-5-years-now-I-have-experience-in-C++-Java-and-Python (大型游戏：丰富的数据模型和基于此的转换，和与之分离的图形化部分)

   -

- 1.4 the arithmeic of image：马里奥 数字可以表示图像 =》 数字可以描述真实世界

- 为什么我要使用响应式编程(RP)？
  响应式编程提高了代码的抽象层级，所以你可以只关注定义了业务逻辑的那些相互依赖的事件，而非纠缠于大量的实现细节。RP 的代码往往会更加简明。

  特别是在开发现在这些有着大量与数据事件相关的 UI events 的高互动性 Webapps、手机 apps 的时候，RP 的优势就更加明显。10 年前，网页的交互就只是提交一个很长的表单到后端，而在前端只产生简单的渲染。Apps 就表现得更加的实时了：修改一个表单域就能自动地把修改后的值保存到后端，为一些内容"点赞"时，会实时的反应到其它在线用户那里等等。

  现在的 Apps 有着大量各种各样的实时 Events，以给用户提供一个交互性较高的体验。我们需要工具去应对这个变化，而响应式编程就是一个答案。

- 面向对象编程
    So I would argue that if you really want to get to the heart of OOP — before you’ve been corrupted by non-OO languages like Java — HtDP is a good way to go.

* 你不知道你将在哪个领域工作，也不知道将使用何种语言

- 3.6 desigining world programs (马里奥) --IMPORTANT

    data that represents the state of the world 
    计数器 真实时间 键盘事件 鼠标点击 事件结束后基数...

    小车车移动：Sample Problem Design a program that moves a car from left to right on the world canvas, three pixels per clock tick.

* 定义一个关于小车车移动的函数，变量有小车车，画布，移动距离。这样我们就不用管是什么在移动，移动了多长距离，在什么范围内移动。这个函数只执行了这个动作，不在乎输入。

* 为什么新增一个函数如此简单 （3.6 增加小车车鼠标点击的功能）
You may wonder why this program modification is so straightforward. There are really two reasons. First, this book and its software strictly separate the data that a program tracks—the model—and the image that it shows—the view. In particular, functions that deal with events have nothing to do with how the state is rendered. If we wish to modify how a state is rendered, we can focus on the function specified in a to-draw clause. Second, the design recipes for programs and functions organize programs in the right way. If anything changes in a problem statement, following the design recipe a second time naturally points out where the original problem solution has to change. While this may look obvious for the simple kind of problems we are dealing with now, it is critical for the kind of problems that programmers encounter in the real world.

* 组织数据定义

* 4.7 finite  state worlds 
    状态切换图： Such a diagram consists of states and arrows that connect these states

    Each state depicts a traffic light in one particular configuration: red, yellow, or green. Each arrow shows how the world can change, from which state it can transition to another state. Our sample diagram contains three arrows, because there are three possible ways in which the traffic light can change. Labels on the arrows indicate the reason for changes; a traffic light transitions from one state to another as time passes.

* 设计模式的主要目标是让程序更易于扩展，“对修改封闭，对扩展开放”。也就是说理想情况下，任何新需求都能通过添加新模块解决，而不用修改老的代码。（虽然现实上有种种困难，但是这种做法在某些大型软件系统中也发挥了相当作用。）但是要知道，越是接近现在，各种不同的设计思想越是百花齐放，各种思路也是平起平坐的关系。更多编程思想比如：数据驱动编程（Data Driven Programming）。将程序架构的复杂度转移为结构化的数据表示，实现极其灵活的设计。组件式编程。Unity采用了这种方式设计且获得了很大成功。组件式尽量用类的组合代替类的继承，但是依然保留了一些多态的特性。Actor模型。与传统面向对象有良好兼容性，充分利用多核性能，在需要高性能并发的场合大放异彩。函数式编程。比较古老的理念也焕发了新生。当然，这些思想与面向对象并非对立，而是互为补充。

* big-bang 可以表示现实世界，其中只有 to-draw 是渲染，其它是一个一个函数
