注: lisp文件夹下的.rkt文件请用Dr.Racket打开

章节1 运算

(/ 10 2)
"hello world"
(string-append "hello" "world")
(string-append "hello" " " "world")
(* 10 2)
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

章节2 Input and Output

(define (y x) (* x x))
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
3. 一个canvas就出现了，动画效果：rocket图片从坐标 (50, 20) 【降落(因为y轴正方向向下)】 到 (50, 30)


章节3 many ways to computer

(define (sign x)
  (cond
    [(> x 0) 1]
    [(= x 0) 0]
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

章节4 one program, many definitions

(define (picture-of-rocket.v4 h)
  (cond [(<= h (- HEIGHT (/(image-height ROCKET) 2)))
         (place-image ROCKET 50 h
                      (empty-scene WIDTH HEIGHT))]
        [(> h (- HEIGHT (/(image-height ROCKET) 2)))
         (place-image ROCKET 50 (- 60 (/(image-height ROCKET) 2))
                      (empty-scene WIDTH HEIGHT))]
        ))

though it is good to introduce all constant definitions first, followed by the definitions of functions in decreasing order of importance. 

define 可定义 常数，函数。如果函数中的变量是 define定义的，需先定义函数中的变量。

As soon as DrRacket encounters a constant definition, it determines the value of the expression and then associates the name with this value. For example,
  (define HEIGHT (* 2 CENTER))
  (define CENTER 100)
causes DrRacket to complain that “CENTER is used before its definition,” when it encounters the definition for HEIGHT. In contrast,
  (define CENTER 100)
  (define HEIGHT (* 2 CENTER))
works as expected.

------------------------------------

 (define (picture-of-rocket.v4 h)
  (cond [(<= h (- HEIGHT (/(image-height ROCKET) 2)))
         (place-image ROCKET 50 h
                      (empty-scene WIDTH HEIGHT))]
        [(> h (- HEIGHT (/(image-height ROCKET) 2)))
         (place-image ROCKET 50 (- 60 (/(image-height ROCKET) 2))
                      (empty-scene WIDTH HEIGHT))]
        ))

------------------------------------

(define WIDTH 100)
(define HEIGHT 60)
(define MTSCN (empty-scene WIDTH HEIGHT))
(define ROCKET [a picture])
(define ROCKET-CENTER-TO-TOP (- HEIGHT (/(image-height ROCKET) 2)))

(define (picture-of-rocket.v5 h)
  (cond
    [(<= h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 h MTSCN)]
    [(> h ROCKET-CENTER-TO-TOP)
     (place-image ROCKET 50 ROCKET-CENTER-TO-TOP MTSCN)]))
