注: lisp 文件夹下的.rkt 文件请用 Dr.Racket 打开

章节 1 运算

(/ 10 2)
"hello world"
(string-append "hello" "world")
(string-append "hello" " " "world")
(\* 10 2)
(+ 1 2)
(+ 1 2 3)
(+ 1 (+ 2 3))
(+ (string-length "hello world") 20)
(+ (string->number "12") 2)
(and #true #true)
(or #true #false)
(not #true)
(> 10 9)
(= 10 9)

BSL programmers—like the programmers for other programming languages—create libraries that others may find helpful.
We dub such libraries teachpacks because they are helpful with teaching.

One important library—the 2htdp/image library—supports operations for computing the width and height of an image.

看完上面，请总结以下类型的“加法”： number, string, image

(circle 10 "solid" "red")
(rectangle 40 10 "outline" "blue")
(overlay (circle 5 "solid" "red")
(rectangle 20 20 "solid" "blue"))
(overlay (rectangle 20 20 "solid" "blue")
(circle 5 "solid" "red"))
(place-image (circle 5 "solid" "green")
50 80
(empty-scene 100 100))

(place-image (circle 5 "solid" "green")
0 0
(empty-scene 100 100))

章节 2 Input and Output

(define (y x) (\* x x))
(y 3)

> 9

The define says “consider y a function,” which, like an expression, computes a value.
A function’s value, though, depends on the value of something called the input, which we express with (y x).
Since we don’t know what this input is, we use a name to represent the input.
Following the mathematical tradition, we use x here to stand in for the unknown input; but pretty soon, we will use all kinds of names.
Once x is replaced with a value, say 1, DrRacket can compute the result of the expressions, which is also called the output of the function.

function definition: (define (FunctionName InputName) BodyExpression)
function application: (FunctionName ArgumentExpression)

(place-image [a picture] 50 30 (empty-scene 100 60))
(place-image [a picture] 50 30 (empty-scene 100 60))

(define (picture-of-rocket height) (place-image [a picture] 50 height (empty-scene 100 60)))
(picture-of-rocket 20)
(picture-of-rocket 30)

add the 2htdp/universe library to your definitions area

how to use animate with this picture-of-rocket:

1. add the 2htdp/universe library to your definitions area.
2. click RUN and enter the following expresion: (animate picture-of-rocket), the enter Enter
3. 一个 canvas 就出现了，动画效果：rocket 图片从坐标 (50, 20) 【降落(因为 y 轴正方向向下)】 到 (50, 30)

章节 3 many ways to computer

(define (sign x)
(cond
[(> x 0) 1][(= x 0) 0]
[(< x 0) -1]))
(sign 10)
(sign 0)
(sign -7)

(define (picture-of-rocket.v2 height)
(cond
[(<= height 60)
(place-image [a picture] 50 height
(empty-scene 100 60))]
[(> height 60)
(place-image [a picture] 50 60
(empty-scene 100 60))]))
(picture-of-rocket.v2 70)

章节 4 one program, many definitions

(define (picture-of-rocket.v4 h)
(cond [(<= h (- HEIGHT (/(image-height ROCKET) 2)))
(place-image ROCKET 50 h
(empty-scene WIDTH HEIGHT))][(> h (- height (/(image-height rocket) 2))) (place-image rocket 50 (- 60 (/(image-height rocket) 2)) (empty-scene width height))]
))

though it is good to introduce all constant definitions first, followed by the definitions of functions in decreasing order of importance.

As you may recall, you can measure the height of an image with the operation image-height.

define 可定义 常数，函数。如果函数中的变量是 define 定义的，需先定义函数中的变量。

As soon as DrRacket encounters a constant definition, it determines the value of the expression and then associates the name with this value. For example,
(define HEIGHT (_ 2 CENTER))
(define CENTER 100)
causes DrRacket to complain that “CENTER is used before its definition,” when it encounters the definition for HEIGHT. In contrast,
(define CENTER 100)
(define HEIGHT (_ 2 CENTER))
works as expected.

In modern parlance, you have just experienced your first program refactoring. Every time you reorganize your program to prepare yourself for likely future change requests, you refactor your program. Put it on your resume. It sounds good, and your future employer probably enjoys reading such buzzwords, even if it doesn’t make you a good programmer. What a good programmer would never live with, however, is having a program contain the same expression three times:
(- HEIGHT (/ (image-height ROCKET) 2))

|
——》 用变量来代替一个表达式：( define ROCKET-CENTER-TO-TOP (- HEIGHT (/ (image-height ROCKET) 2)) )

---

(define (picture-of-rocket.v4 h)
(cond [(<= h (- HEIGHT (/(image-height ROCKET) 2)))
(place-image ROCKET 50 h
(empty-scene WIDTH HEIGHT))][(> h (- height (/(image-height rocket) 2))) (place-image rocket 50 (- 60 (/(image-height rocket) 2)) (empty-scene width height))]
))

---

(define WIDTH 100)
(define HEIGHT 60)
(define MTSCN (empty-scene WIDTH HEIGHT))
(define ROCKET [a picture])
(define ROCKET-CENTER-TO-TOP (- HEIGHT (/(image-height ROCKET) 2)))

(define (picture-of-rocket.v5 h)
(cond
[(<= h ROCKET-CENTER-TO-TOP)
(place-image ROCKET 50 h MTSCN)] ==> 50 是 x 轴的值
[(> h ROCKET-CENTER-TO-TOP)
(place-image ROCKET 50 ROCKET-CENTER-TO-TOP MTSCN)]))

|
——》 for future： 改变背景颜色 改变 scene 尺寸 改变降落的物体 改变降落终点的高度

章节 5 One more definition

---

; properties of the "world" and the descending rocket
(define WIDTH 100)
(define HEIGHT 60)
(define V 3)
(define X 50)

; graphical constants
(define MTSCN (empty-scene WIDTH HEIGHT))
(define ROCKET )
(define ROCKET-CENTER-TO-TOP
(- HEIGHT (/ (image-height ROCKET) 2)))

; functions
(define (picture-of-rocket.v6 t)
(cond
[(<= (distance t) ROCKET-CENTER-TO-TOP)
(place-image ROCKET X (distance t) MTSCN)][(> (distance t) rocket-center-to-top) (place-image rocket x rocket-center-to-top mtscn)]))

(define (distance t)
(\* V t))

-------- the remaining constant definitions make the function definition more readable and modifiable.

as you become a ture-blue programmer, you will find out that programs consis of many function definitions and many constant definitions.
you will see that functions refer to each other all the time. what you need to practice is to organize them so that you can read them easily.

其它

The rest of this book is all about these things; very little of the book’s content is actually about the mechanics of DrRacket, BSL, or libraries.
The book shows you how good programmers think about problems.

Good programming is far more than the mechanics of acquiring a language.
Most importantly, it is about keeping in mind that programmers create programs for other people to read them in the future.
A good program reflects the problem statements and its important concepts.

字符串的加法
(+ 1 1) == 2
(string-append "a" "b") == "ab"

(string-length "helo world") 打印：10

the arithmetic of images
An Image is a visual, rectangular piece of data, for example, a photo or a geometric figure and its frame.
images are values just like numbers and strings.

数字转化为字符串： (number->string 20) 打印："20"
计算字符串的长度： (string-length "hello") 打印 5

(define x 2)
(if (= x 0) 0 (/ 1 x)) // (define x 2)返回 0.5；(define x 0)返回 0
|\_> x = 0 吗，不等于就 1/x；如果等于 0，返回 0

The next few chapters introduce better expressions than if to express conditional computations and, most importantly, systematic ways for designing them.

2.1 functions
As far as programming is concerned, “arithmetic” is half the game; the other half is “algebra.”

(define (ff a) (\* 10 a))
(ff 3) ==> 输出 30

2.2 computing

2.3 composing functions

define one function per task.

Better yet, if you ever need to change a part of the program due to some change to the problem statement, it tends to be much easier to find the relevant parts when it is organized as a collection of small functions as opposed to a large.

Again, we state an imperative slogan:
For every constant mentioned in a problem statement, introduce one constant definition.

- 2.5 响应式编程

From a coding perspective, a program is just a bunch of function and constant definitions.

its initial state, how states are transformed, how states are rendered, and how big-bang may determine other attributes of the current state. 

DrRacket separate data processing from parsing information into data and turning data into information. 

...

- 3.4 (wish list)
  Multi-function programs come about because interactive programs automatically need functions that handle key and mouse events, functions that render the state as music, and possibly more. Even batch programs may require several different functions because they perform several separate tasks.
  we recommend keeping around a list of needed functions or a wish list. Each entry on a wish list should consist of three things: a meaningful name for the function, a signature, and a purpose statement. For the design of a batch program, put the main function on the wish list and start designing it. For the design of an interactive program, you can put the event handlers, the stop-when function, and the scene-rendering function on the list.

check-expect: 比较2个值是否相同

------------------------------------------
(define CAR [一张图片])

(define BACKGROUND
  (empty-scene 400 80))

(define Y-CAR 50)

(place-image CAR 50 Y-CAR BACKGROUND)

(define (moveCat x)
  (place-image CAR x 50 BACKGROUND))

(moveCat 50)
(moveCat 100)
(moveCat 150)
(moveCat 200)
                        
                        并不在乎输入。它只执行了一个动作
------------------------------------------

有一个主函数，main

(define (number->square s)
  (square s "solid" "red"))
(big-bang 100 [to-draw number->square])

(big-bang 200
    [to-draw number->square]
    [on-tick sub1]
    [stop-when zero?]
    [on-key reset])

----------------------------

重新渲染 Indeed, render is the only means for a big-bang expression to present data to the world.

-----------------------------

(define BACKGROUND (empty-scene 400 50))
(define DOT (circle 3 "solid" "red"))
 
(define (main y)
  (big-bang y
    [on-tick sub1]
    [stop-when zero?]
    [to-draw place-dot-at]
    [on-key stop]
   ))
 
(define (place-dot-at y)
  (place-image DOT 50 y BACKGROUND))
 
(define (stop y ke)
  0)
(place-dot-at 89)
(stop 89 "q")
(main 90)

--------------------------------

(define BACKGROUND (empty-scene 400 50))

(define (tock ws)
  (+ ws 3))
(define CAR [一张图片])
(define Y-CAR 50)
(define (render ws)
   (place-image CAR ws Y-CAR BACKGROUND))

(define (main ws)
  (big-bang ws
    [on-tick tock]
    [to-draw render]
    [on-key stop]
    [stop-when zero?]))

(define (stop ws ke)
  0)
(stop 88 "q")

(main 13 )

We end the section with an illustration of mouse event handling, which also illustrates the advantages that a separation of view and model provide.

视图和模型分离

要增加一个新功能：点击鼠标时，小车车就到点击的位置那里
|-> 修改main函数，增加鼠标事件 其它保存不变

------------------------------

(define BACKGROUND (empty-scene 400 50))
(define (tock ws)
  (+ ws 3))
(define CAR .)
(define Y-CAR 50)
(define (render ws)
   (place-image CAR ws Y-CAR BACKGROUND))

(define (main ws)
  (big-bang ws
    [on-tick tock]
    [to-draw render]
    [on-mouse hyper]
  ))

(define (hyper x-position-of-car x-mouse y-mouse me)
  (cond
    [(string=? "button-down" me) x-mouse]
    [else x-position-of-car]))

(main 13)
？？ 鼠标点击事件的x y怎么和 hyper 联系起来的 

-------------------------

第4章   （枚举 区间 项）
Then we go through three different kinds of data descriptions: enumerations, intervals, and itemizations.

==================================

(define WIDTH 300) 
(define HEIGHT 200)
(define CLOSE (/ HEIGHT 3))
(define (nxt y)
  (+ y 3))
(define MTSCN (empty-scene WIDTH HEIGHT))
(define UFO (overlay (circle 10 "solid" "green")
                     (ellipse 60 30 "solid" "purple")))
(define (render y)
  (place-image UFO 150 y MTSCN))
(define (main1 y0)
  (big-bang y0
     [on-tick nxt]
     [to-draw render]))
;以上是飞碟降落

(check-expect (render/status 10)
              (place-image (text "descending" 11 "green")
                           10 10
                           (render 10)))
(define (render/status y)
  (cond
    [(<= 0 y CLOSE)
     (place-image (text "descending" 11 "green")
                  10 10
                  (render y))]
    [(and (< CLOSE y) (<= y HEIGHT))
     (place-image (text "closing in" 11 "orange")
                  10 10
                  (render y))]
    [(> y HEIGHT)
     (place-image (text "landed" 11 "red")
                  10 10
                  (render y))]))
(define (main y1)
  (big-bang y1
    [on-tick nxt]
    [to-draw render/status]))
;以上是有纪录状态的飞碟降落

(define (render/status2 y)
  (place-image
    (cond
      [(<= 0 y CLOSE)
       (text "descending" 11 "green")]
      [(and (< CLOSE y) (<= y HEIGHT))
       (text "closing in" 11 "orange")]
      [(> y HEIGHT)
       (text "landed" 11 "red")])
    70 50
    (render y)))

(define (main2 y2)
  (big-bang y2
    [on-tick nxt]
    [to-draw render/status2]))
;以上是此时想要修改文字的位置

;调用方法： (main 2) (main1 2) (main2 2)

===================================

The design recipe for world programs demands that you translate information into data and vice versa to ensure a complete understanding of the data definition.
Do so for the LR definition, including at least HEIGHT and 0 as examples. 

4.6 数据结构的定义
What the preceding three sections have clarified is that the design of functions can—and must—exploit the organization of the data definition. Specifically, if a data definition singles out certain pieces of data or specifies ranges of data, then the creation of examples and the organization of the function reflect these cases and ranges.
组织数据定义————挑出部分数据 或 给定数据的范围

In many situations, state transition diagrams have only a finite number of states and arrows. Computer scientists call such diagrams finite state machines (FSM) 状态机

要做红绿灯需要知道啥：（时间的流逝是触发器）
Now that we know how to represent the states of our world, how to go from one to the next, and that the state changes at every tick of the clock...

----------------------------------------------------------
(define RED 0)
(define GREEN 1)
(define YELLOW 2)

(define (tl-next cs) (+ cs 1)) ;f

(define (tl-render cs) ;f
  (cond
    [(equal? cs RED) .]
    [(equal? cs GREEN) .]
    [(equal? cs YELLOW) .]))
  

(define (traffic-light-simulation initial-state) ;f
  (big-bang initial-state
    [to-draw tl-render]
    [on-tick tl-next 1]))

(define (tl-next-numeric cs)
  (modulo (+ cs 1) 3))

(define (tl-next-symbolic cs)
  (cond
    [(equal? cs RED) .]
    [(equal? cs GREEN) .]
    [(equal? cs YELLOW) .]))


(define (main initial-state)
  (big-bang initial-state
    [to-draw tl-next-symbolic]
    [on-tick tl-next-numeric 1]))

模拟交通信号灯
----------------------------------------------------------
交互： 即用 鼠标事件 键盘事件 时间流逝 表示真实世界

自动锁门。3种状态
(define LOCKED "locked")
(define CLOSED "closed")
(define OPEN "open")
(define (door-render s)
  (text s 40 "red"))

(define (door-closer state-of-door)
  (cond
    [(string=? LOCKED state-of-door) LOCKED]
    [(string=? CLOSED state-of-door) CLOSED]
    [(string=? OPEN state-of-door) CLOSED]))

(define (door-action s k)
  (cond
    [(and (string=? LOCKED s) (string=? "u" k))
     CLOSED]
    [(and (string=? CLOSED s) (string=? "l" k))
     LOCKED]
    [(and (string=? CLOSED s) (string=? " " k))
     OPEN]
    [else s]))

(define (door-simulation initial-state)
  (big-bang initial-state
    [on-tick door-closer 3]
    [on-key door-action]
    [to-draw door-render]))

(door-simulation "open")

-----------------------------------------------------------------
变量名 即 注释，如果直接在函数里写数字，比如说有2个5，就不知道这2个5是不是同一个5

在big-bang 可以组合功能，比如今天一个鼠标点击，明天一个键盘点击

坐标原点： 左上角

不能有重复的代码

* 5.3 programming with posn
(define-struct entry [name phone email])
(make-entry "Tara Harp" "666-7770" "th@smlu.edu") ;创建实例  [5.4]
(define pl (make-entry "Al Abe" "666-7771" "lee@x.me"))
(entry-phone pl) ==>输出："666-7771"


===================

结构化数据
------------------------------------------------  求笛卡尔坐标系任意点到原点的距离，由此印出结构化数据

(define (ap x y)
  (make-posn x y))
(define (distance-to-0 ap)
  (sqrt
    (+ (sqr (posn-x ap))
       (sqr (posn-y ap)))))    ； 输出方式：(distance-to-0 (make-posn 3 4))

(define (main x y)
  (sqrt
    (+ (sqr x)
       (sqr y))))              ； 输出方式：(main 3 4)

------------------------------------------------


-----------------  以下输出3个10。

(define-struct vel [deltax deltay]) ;It comes with two fields: deltax and deltay
(define-struct ball [location velocity])

(define ball1  ;
  (make-ball (make-posn 30 40) (make-vel -10 5)))

(define-struct ballf [x y deltax deltay])

(vel-deltax (ball-velocity
             (make-ball (make-posn 30 40) (make-vel -10 5))))

(vel-deltax (make-vel -10 5))

(vel-deltax (ball-velocity ball1))

-----------------

Remember that a data definition provides a way of representing information into data and interpreting that data as information. For structure types, this calls for a description of what kind of data goes into which field.

* 对角线下落运动的小球
(define MTS (empty-scene 100 100))
(define DOT (circle 3 "solid" "red"))

(define (x+ p)
  (make-posn (+ (posn-x p) 3) (+ (posn-y p) 3)))

(define (scene+dot p)
  (place-image DOT (posn-x p) (posn-y p) MTS))

(define (reset-dot p x y me)
  (cond
    [(mouse=? me "button-down") (make-posn x y)]
    [else p]))

(define (main p0)
  (big-bang p0
    [on-tick x+]
    [on-mouse reset-dot]
    [to-draw scene+dot]))

    ----------------------------------
一次输入： animation 基于时间的仿真

5.6 不知道讲啥
5.7
It is the purpose of a data definition to describe parts of this universe and to name these parts so that we can refer to them concisely. 
数据定义的目的是描述事物并命名，以便我们可以引用它

(define-struct person [name age])
(define (age? make-person)
  (person-age make-person))
(age? (make-person "xiaoming" 20))


==> 圆环面积：
(define-struct ring [outer inner])
(define (ring-of-area make-ring)
  (- (sqr (ring-outer make-ring))
           (sqr (ring-inner make-ring))))
(ring-of-area (make-ring 50 20))

例1，随高度变化的飞碟
例2，模拟交通信号灯
例3，对角线下落的小球

(define (distance-to-0 p)
  (sqrt (+ (sqr (posn-x p))
        (sqr (posn-y p)))))

(distance-to-0 (make-posn 3 4))

(define (distance x y)
  (sqrt (+ (sqr x) (sqr y))))

(distance 3 4)

(define-struct ring [r1 r2])
(define (area o)
  (- (ring-r1 o)
     (ring-r2 o)))
(area (make-ring 50 20))