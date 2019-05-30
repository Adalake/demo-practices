Python编码风格规范
*******************

1. 前言
==========

1.1 一般信息
-------------

这是一份基于Python PEP8的Python编码风格规范，适用于中派科技（深圳）有限责任公司上海分公司内部。此文档存在的意义是让大家写出统一风格的代码，让代码的可维护性和可读性更好。本项目采用 reStructuredText 纯文本标记语法, 并使用 Sphinx 生成 HTML、CHM、PDF等文档格式。

1.2 目录
--------------

.. code-block:: console

    └── Python编码风格规范
        ├── 1. 前言
        |    ├── 1.1 一般信息
        |    └── 1.2 目录
        ├── 2. 维护工具
        |    ├── 2.1 pylint
        |    └── 2.2 black
        ├── 3. 代码组织规格
        |    ├── 3.1 缩进
        |    ├── 3.2 函数长度                           （函数长度待定）
        |    ├── 3.3 行长度
        |    ├── 3.4 换行
        |    ├── 3.5 空行
        |    ├── 3.6 源文件编码
        |    ├── 3.7 导入
        |    ├── 3.8 dunder
        |    ├── 3.9 字符串引号
        |    ├── 3.10 空格
        |    |    ├── 3.10.1 避免使用空格的情况
        |    |    └── 3.10.2 其它建议
        |    └── 3.11 注释
        |         ├── 3.11.1 块注释
        |         ├── 3.11.2 行内注释
        |         └── 3.11.3 文档字符串
        ├── 4. 命名规则
        |    ├── 4.1 命名风格约定
        |    ├── 4.2 类名
        |    ├── 4.3 异常名
        |    ├── 4.4 全局变量名
        |    ├── 4.5 函数名
        |    ├── 4.6 函数和方法参数
        |    ├── 4.7 方法名和实例变量
        |    ├── 4.8 常量
        |    └── 4.9 包名和模块名
        ├── 5. 设计规则
        |    ├── 5.1 继承的设计
        |    ├── 5.2 公共和内部的接口
        |    ├── 5.3 编程建议
        |    ├── 5.4 功能注释
        |    └── 5.5 变量注释
        └── 6. 参考 

2. 维护工具
==============

2.1 pylint
--------------

.. tip ::
    使用pylint来规范代码风格。

编者注：运行pylint来查看代码是否有书写错误的地方，pylint提示（C）的部分与本项目不符的地方，以本项目规定的风格为准。

定义:
    Pylint是一个Python代码分析工具，它分析Python代码中的错误，查找不符合代码风格标准。可以捕获容易忽视的错误, 例如输入错误, 使用未赋值的变量等。本项目中使用的版本是pylint 1.0.0。

解释：
    * 安装：pip install pylint

    * Pylint运行结果的消息类型有如下几种：

        （C） 惯例：违反了编码风格标准

        （R） 重构：写得非常糟糕的代码

        （W） 警告：某些Python特定的问题

        （E） 错误：很可能是代码中的错误

        （F） 致命错误：阻止Pylint进一步运行的错误
示例：
    我们使用一个名为simplecaeser.py的文件为例，完整代码如下：

    .. code-block:: Python

        #!/usr/bin/env python3

        import string
        
        shift = 3
        choice = input("would you like to encode or decode?")
        word = input("Please enter text")
        letters = string.ascii_letters + string.punctuation + string.digits
        encoded = ''
        if choice == "encode":
            for letter in word:
                if letter == ' ':
                    encoded = encoded + ' '
                else:
                    x = letters.index(letter) + shift
                    encoded=encoded + letters[x]
        if choice == "decode":
            for letter in word:
                if letter == ' ':
                    encoded = encoded + ' '
                else:
                    x = letters.index(letter) - shift
                    encoded = encoded + letters[x]

        print(encoded)
    
    使用Pylint运行结果如下：

    .. code-block:: Python

        robertk01 Desktop$ pylint simplecaeser.py
        ************* Module simplecaesar
        simplecaesar.py:16:19: C0326: Exactly one space required around assignment
                    encoded=encoded + letters[x]
                        ^ (bad-whitespace)
        simplecaesar.py:1:0: C0111: Missing module docstring (missing-docstring)
        simplecaesar.py:5:0: C0103: Constant name "shift" doesn't conform to UPPER_CASE naming style (invalid-name)
        simplecaesar.py:6:0: C0103: Constant name "choice" doesn't conform to UPPER_CASE naming style (invalid-name)
        simplecaesar.py:7:0: C0103: Constant name "word" doesn't conform to UPPER_CASE naming style (invalid-name)
        simplecaesar.py:8:0: C0103: Constant name "letters" doesn't conform to UPPER_CASE naming style (invalid-name)
        simplecaesar.py:9:0: C0103: Constant name "encoded" doesn't conform to UPPER_CASE naming style (invalid-name)

        -----------------------------------
        Your code has been rated at 6.32/10
    
2.2 black
-----------

.. tip::
    使用black来格式化你的代码。

定义：
    black是一个运行在python 3.6及以上环境的Python代码格式化工具，它检测到不符合规范的代码风格直接就帮你全部格式化好，根本不需要你确定，直接替你做好决定。本项目使用的版本是black 19.3b0。
解释：
    安装：pip install black
示例：
    在使用方面black默认读取指定python文件并对其进行代码规范格式化，然后输出到原文件。
    
    .. code-block:: Python

      l = [1,    
      2,    
      3,]

    例如，我们将上面这段代码保存为test.py，然后在控制台执行 black test.py 指令，再次打开test.py，发现其中的代码变成了这个样子:
    
    .. code-block:: Python

        l = [1, 2, 3]

3. 代码组织规则
=================

3.1 缩进
----------
.. tip::
    使用4个空格缩进，禁止使用tab缩进。

当if语句的条件部分超过88个字符串时，添加括号，且需换行，遵循4个空格缩进的方法。注意超过88个字符串时，包裹着的括号的位置。

    .. code-block:: Python

        if (
            this_is_one_thing
            and this_is_one_thingthis_is_one_thingthis_is_one_thingthis_is_one_thingthis_is_one_thing
        ):
            do_something()


当括号里超过88个字符串时，需换行，同样遵循4个空格缩进的方法。

    .. code-block:: Python

        result = some_function_that_takes_arguments(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "b",
            "c",
            "d",
            "e",
            "e",
            "s",
        )

3.2 函数长度
--------------------

.. tip::
    所有函数长度最长不能超过30行。

* 当发现函数中有重复代码的时候，说明你可以将它封装成一个新的函数了。
* 每个函数按照功能命名，即每个函数的实现都应该仅包含函数名所传达的内容。

3.3 行长度
--------------------

.. tip::
    所有行限制的最大字符数为88，能放同一行的全部放同一行。

3.4 换行
------------

.. tip::
    在二元运算符之前中断。

示例：

    .. code-block:: Python

        income = (
            gross_wages
            + taxable_interest
            + (dividends - qualified_dividends)
            - ira_deduction
            - student_loan_interest
        )

3.5 空行
---------

.. tip::
    方法与方法、类与类、方法与类，这三种关系的定义之间都空两行。如果注释单独起一行，注释应与之前的类/方法定义间空两行。

3.6 源文件编码
-------------------

.. tip::
    使用ASCII标识符及英文单词。

解释：
    * 使用UTF-8编码的文件不应具有编码声明。 
    * 所有标识符、注释必须使用ASCII标识符，尽可能使用英语单词。

3.7 导入
----------

.. tip::
    仅对包和模块使用导入，每个导入应该独占一行。

* 导入格式示例：

    .. code-block:: Python

        import os
        import sys
        
        from subprocess import Popen, PIPE
    
* 导入放在文件顶部, 位于模块注释和文档字符串之后, 模块全局变量和常量之前。导入需按照从最通用到最不通用的顺序分组:
        1. 标准库导入
        2. 第三方库导入
        3. 应用程序指定导入
    
* 使用绝对路径导入：

    .. code-block:: Python
    
        import mypkg.sibling
        from mypkg import sibling
        from mypkg.sibling import example

* 也可用相对路径导入，特别是在处理使用绝对路径导入不必要冗长的复杂包布局时：

    .. code-block:: Python

        from . import sibling
        from .sibling import example
    
* 当从一个包含类的模块中导入类时，应该这么写：

    .. code-block:: Python
    
        from myclass import MyClass
        from foo.bar.yourclass import YourClass
    
* 如果上述的写法导致名字的冲突，那么这么写：

    .. code-block:: Python
    
        import myclass
        import foo.bar.yourclass

    然后使用“myclass.MyClass”和“foo.bar.yourclass.YourClass”。

* 如果想用*通配符，又不想引用模块中的所有变量，可以在模块中用变量__all__进行限制，限制只引用指定的变量名。如：

    .. code-block:: Python

        __all__ = ['ID_one','run']

        ID_one = 1
        name =  "This is one"
        print name

        ID_two = 2
        name =  "This is two"
        print name

        def run(somewhere):
            print name,'runs', somewhere

    这样当使用通配符导入这个包时，只会引入ID_one和run两个变量。

3.8 dunder
-------------------

.. tip::
    放在文档字符串的后面，以及除from __future__ 之外的import表达式前面。

定义：
    像 __all__, __author__, __version__这种前后被两个下划线包围的属性名和方法名，在Python中我们称之为dunder。

示例：

    .. code-block:: Python

        """This is the example module.

        This module does stuff.
        """

        from __future__ import barry_as_FLUFL

        __all__ = ["a", "b", "c"]
        __version__ = "0.1"
        __author__ = "Cardinal Biggles"

        import os
        import sys

3.9 字符串引号
-------------------

.. tip::
    在同一个文件中, 保持使用字符串引号的一致性。

当一个字符串中只有一种引号时，禁止用单引号，需用双引号。当一个字符串中包含单引号或者双引号字符的时候，使用和最外层不同的符号来避免使用反斜杠。
    
    .. code-block:: Python

        Gollum("I'm scared of lint errors.")
        Narrator('"Good!" thought a happy Python reviewer.')

为多行字符串使用三重双引号"""而不是三重单引号'''。当且仅当项目中使用单引号'来引用字符串时, 才可能会使用三重'''为非文档字符串的多行字符串来标识引用。文档字符串必须使用三重双引号"""。不过要注意, 用隐式行连接更清晰, 因为多行字符串与程序其他部分的缩进方式不一致。

    .. code-block:: Python
        
        print(
            """This is much nicer.\n"""
            """This is much nicer.\n"""
            """This is much nicer.\n"""
            """This is much nicer.\n"""
        )

        
        # 错误：
            print """This is pretty ugly.
        Don't do this.
        """

3.10 空格
-----------

3.10.1 避免使用空格的情况
^^^^^^^^^^^^^^^^^^^^^^^^^^

* 禁止紧跟在小括号，中括号或者大括号后使用空格。

    .. code-block:: Python

        # 正确: 
        spam(ham[1], {eggs: 2})

        # 错误:  
        spam( ham[ 1 ], { eggs: 2 } )

* 禁止紧贴在逗号、分号或者冒号之前使用空格。

    .. code-block:: Python

        # 正确: 
        if x == 4:
            print x, y
            x, y = y, x

        # 错误:  
        if x == 4 : 
            print x , y 
            x , y = y , x

* 然而，冒号在切片中的等号两边应该有相同数量的空格。但当一个切片参数被省略时，空格就被省略了。 

    .. code-block:: Python

        # 正确：
        ham[1:9], ham[1:9:3], ham[:9:3], ham[1::3], ham[1:9:]
        ham[lower:upper], ham[lower:upper:], ham[lower::step]
        ham[lower + offset : upper + offset]
        ham[: upper_fn(x) : step_fn(x)], ham[:: step_fn(x)]
        ham[lower + offset : upper + offset]

        # 错误：
        ham[lower + offset:upper + offset]
        ham[1: 9], ham[1 :9], ham[1:9 :3]
        ham[lower : : upper]
        ham[ : upper]

* 禁止紧贴在函数参数，索引或者切片的左括号之前使用空格。

    .. code-block:: Python

        # 正确: 
        spam(1)
        dct["key"] = lst[index]

        # 错误:  
        spam (1)
        dct ["key"] = lst [index]

* 为了和另一个赋值语句对齐，在赋值运算符附件加多个空格。 

    .. code-block:: Python

        # 正确：
        x = 1
        y = 2
        long_variable = 3

        # 错误：
        x             = 1
        y             = 2
        long_variable = 3

3.10.2 其它建议
^^^^^^^^^^^^^^^^

* 不要依赖单词尾部的空格。
* 需在二元运算符两边加一个空格：赋值（=），增量赋值（+=, -=），比较（==, <, >, !=, <>, <=, >=, in, not, in, is, is not），布尔（and, or, not）。
* 如果使用具有不同优先级的运算符，请考虑在具有最低优先级的运算符周围添加空格。但是，两侧空格务必要保持一致。 

    .. code-block:: Python

        i = i + 1
        submitted += 1
        x = x * 2 - 1
        hypot2 = x * x + y * y
        c = (a + b) * (a - b)

* 在制定关键字参数或者默认参数值的时候，不要在=附近加上空格。多个参数中间有逗号的话，逗号后要空一格。 

    .. code-block:: Python

        # 正确：
        def complex(real, imag=0.0):
            return magic(r=real, i=imag)

        # 错误：
        def complex(real, imag = 0.0):
            return magic(r = real, i = imag)

* 功能型注释应该使用冒号的一般性规则，并且在使用->的时候要在两边加空格。

    .. code-block:: Python

        # 正确：
        def munge(input: AnyStr):
            ...


        def munge() -> AnyStr:
            ...


        # 错误：
        def munge(input:AnyStr): 
            ...


        def munge()->PosInt: 
            ...

* 当给有类型备注的参数赋值的时候，在=两边添加空格（仅针对那种有类型备注和默认值的参数）。

    .. code-block:: Python

        # 正确：
        def munge(sep: AnyStr = None):
            ...


        def munge(input: AnyStr, sep: AnyStr = None, limit=1000):
            ...

        # 错误：
        def munge(input: AnyStr=None): 
            ...


        def munge(input: AnyStr, limit = 1000): 
            ...

3.11 注释
-----------

.. tip::
    注释应该离开代码2个空格，使用英文书写注释。

* 当代码更改时，记得更新对应的注释。
* 注释应该是完整的句子。如果一个注释是一个短语或句子，它的第一个单词应该大写，除非它是以小写字母开头的标识符。
* 如果注释很短，结尾的句号可以省略。而块注释一般由完整句子的一个或多个段落组成，并且每句话结束有个句号。 

3.11.1 块注释
^^^^^^^^^^^^^^^

块注释缩进到与代码相同的级别，每一行开头使用一个#和一个空格（除非块注释内部缩进文本）。块注释内部的段落通过只有一个#的空行分隔。

3.11.2 行内注释
^^^^^^^^^^^^^^^^^^

行内注释是与代码语句同行的注释，行内注释注释由#和一个空格开始，和代码有两个空格分隔。

如果状态明显的话，行内注释是不必要的，反而会分散注意力。比如说下面这样就不需要：

    .. code-block:: Python

        x = x + 1  # Increment x

但有时，这样做很有用：

    .. code-block:: Python

        x = x + 1  # Compensate for border

3.11.3 文档字符串
^^^^^^^^^^^^^^^^^^

* 公共模块，函数，类以及方法需要编写文档字符串，而非公共的方法没有必要，但是应该有一个描述方法具体作用的注释，这个注释应该在def那一行之后。
* 多行文档说明使用的结尾三引号应该自成一行，例如：

    .. code-block:: Python

        """Return a foobang

        Optional plotz says to frobnicate the bizbaz first.
        """

* 对于单行的文档说明，尾部的三引号需和文档在同一行。

4. 命名规则
================

4.1 命名风格约定
-----------------

* 以下列出推荐的命名标准，应该按照这些标准编写新的模块和包(包括第三方框架)，但如果现有库具有不同的风格，则首选内部一致性。

    * 命名变量名、函数名时，使用下划线分隔的小写字母命名。如：lower_case_with_underscores。
    * 命名类名时，使用CamelCase驼峰命名法命名。如：CapitalizedWords。
    * 命名常量时，使用大写字母，可通过下划线分割。如：MAX_OVERFLOW。
    * 当遇到常用缩写时，所有缩写的字母用大写，因此，HTTPServerError比HttpServerError好。
    * 其它情况，使用单个小写字符，或者全小写。如：b 和 lowercase。

* 不要使用字母‘O’（大写的O），或者‘I’（大写的I）作为单字符变量名。在有些字体里，这些字符无法和数字0和1区分。谨慎使用小写字母"l"（小写的L）作为单字符变量名。

* 暴露给用户的API接口的命名，应该遵循反映使用场景而不是实现的原则。

4.2 类名
-----------------

.. tip::
    类名一般使用驼峰命名法。

在接口被文档化并且主要被用于调用的情况下，可以使用函数的命名风格代替。 

注意，对于内置的变量命名有一个单独的约定：大部分内置变量是单个单词（或者两个单词连接在一起），首字母大写的命名法只用于异常名或者内部的常量。

4.3 异常名
-----------------

.. tip::
    在异常名后面加上“Error”后缀。


4.4 全局变量名
-----------------

这一类变量只在模块内部使用，约定和函数命名规则一样。 

通过 from M import * 导入的模块应该使用all机制去防止内部的接口对外暴露，或者使用在全局变量前加下划线的方式（表明这些全局变量是模块内非公有）。

4.5 函数名
-----------------

.. tip::
    函数名应该小写，如果想提高可读性可以用下划线分隔。

大小写混合仅在为了兼容原来主要以大小写混合风格的情况下使用（比如 threading.py），保持向后兼容性。

4.6 函数和方法参数
---------------------

.. tip::
    将self作为实例方法的的第一个参数，将cls作为类静态方法的第一个参数。

如果函数的参数名和已有的关键词冲突，用同义词来避免这种冲突，也可以在最后加单一下划线，最好不要用缩写或随意拼写。如 \class_ 比 \clss 更好。

4.7 方法名和实例变量
----------------------

.. tip::
    使用下划线分隔小写单词以提高可读性，在非共有方法和实例变量前使用单下划线。

通过双下划线前缀触发Python的命名转换规则来避免和子类的命名冲突。 

Python通过类名对这些命名进行转换：如果类 Foo 有一个叫 __a 的成员变量，它无法通过 Foo.__a 访问，但可以通过 Foo._Foo__a 访问。用前缀双下划线来避免类中的属性命名与子类冲突的情况。 

4.8 常量
-----------------

.. tip::
    常量通常定义在模块级，通过下划线分隔的全大写字母命名。

例如：MAX_OVERFLOW 和 TOTAL。

4.9 包名和模块名
------------------------

.. tip::
    模块应该用简短全小写的名字，如果为了提升可读性，下划线也是可以用的。Python包名也应该使用简短全小写的名字，但不使用下划线。

当使用C或者C++编写了一个依赖于提供高级（更面向对象）接口的Python模块的扩展模块，这个C/C++模块需要一个下划线前缀（例如：_socket）。

5. 设计规则
=============

5.1 继承的设计
---------------------

判断一个类的方法和实例变量（统称：属性）是共有还是非共有。如果不确定，那就选非共有；因为将一个非共有变量转为共有比反过来更容易。 

以下是一些让代码Pythonic的准则：

* 公共属性不应该有前缀下划线。

* 如果公共属性名和关键字冲突，在属性名之后增加一个下划线。但是在作为参数或者变量时，‘cls’是表示‘类’最好的选择，特别是作为类方法的第一个参数。

* 对于单一的共有属性数据，直接对外暴露它的变量名。

* 如果你的类打算用来继承的话，并且这个类里有不希望子类使用的属性，就要考虑使用双下划线前缀并且没有后缀下划线的命名方式。这会调用Python的命名转换算法，将类的名字加入到属性名里。这样做可以帮助避免在子类中不小心包含了相同的属性名而产生的冲突。 

    注意1： 只有类名才会整合进属性名，如果子类的属性名和类名和父类都相同，那么还是会存在命名冲突的问题。 

    注意2： 命名转换会在某些场景使用起来不太方便，例如调试和__getattr__()。

5.2 公共和内部的接口
-------------------------

.. tip::
    公共接口需保证向后兼容。

文档化的接口被认为是公开的，除非文档明确声明它们是临时或内部接口，不受向后兼容性保证。所有未记录的接口都应该是内部的。 

为了更好地支持内省（introspection），模块应该使用__all__属性显式地在它们的公共API中声明名称。将__all__设置为空列表表示模块没有公共API。 

即使通过__all__设置过，内部接口（包，模块，类，方法，属性或其他名字）依然需要单个下划线前缀。 

如果一个命名空间（包，模块，类）被认为是内部的，那么包含它的接口也应该被认为是内部的。 

其他模块必须不能间接访问导入的名称，除非它是包含它的模块中有明确的文档说明的API，例如 os.path 或者是一个包里从子模块公开函数接口的 __init__ 模块。

5.3 编程建议
---------------

* 和像None这样的单例对象进行比较的时候应该始终用 is 或者 is not，永远不要用等号运算符。 

* 使用 is not 运算符，而不是 not … is 。另外，当你写 if x 时，请明确你想表达的确实是： if x is not None。
    .. code-block:: Python

        # 正确：
        if foo is not None:

        # 禁止：
        if not foo is None:

* 不要用 == 去和True或者False比较：

    .. code-block:: Python

        # 正确: 
        if greeting:

        # 错误: 
        if greeting == True:

* 当使用富比较（rich comparisons，一种复杂的对象间比较的新机制，允许返回值不为-1,0,1）实现排序操作的时候，最好实现全部的六个操作符（__eq__, __ne__, __lt__, __gt__, __ge__）而不是依靠其他的代码去实现特定的比较。 

* 使用def表达式，而不是通过赋值语句将lambda表达式绑定到一个变量上。 

    .. code-block:: Python

        # 正确：
        def f(x): return 2*x

        # 禁止：
        f = lambda x: 2*x

* 适当地使用异常链接，可以显式指定“raise X from Y”。

* 当捕获到异常时，尽量写上具体的异常名，而不是只用一个except: 块。比如说：

    .. code-block:: Python

        try:
            import platform_specific_module
        except ImportError:
            platform_specific_module = None

  两种不应该只使用"excpet"块的情况：

     1. 如果异常处理的代码会打印或者记录log

     2. 如果代码需要做清理工作，使用 raise..try…finally

*  当给捕捉的异常绑定一个名字时，使用显式命名绑定语法：

    .. code-block:: Python

        try:
            process_data()
        except Exception as exc:
            raise DataProcessingFailedError(str(exc))

* 当捕捉操作系统的错误时，使用Python 3.3中errno内定数值指定的异常等级。

* 另外，对于所有的 try/except 语句块，在try语句中只填充必要的代码，这样能避免掩盖掉bug。 

    .. code-block:: Python

        # 正确：
        try:
            value = collection[key]
        except KeyError:
            return key_not_found(key)
        else:
            return handle_value(value)

        # 错误：
        try:
            # Too broad!
            return handle_value(collection[key])
        except KeyError:
            # Will also catch KeyError raised by handle_value()
            return key_not_found(key)

* 当代码片段局部使用了某个资源的时候，使用with表达式来确保这个资源使用完后被清理干净。用try/finally也可以。

* 无论何时获取和释放资源，都应该通过单独的函数或方法调用上下文管理器。举个例子： 

    .. code-block:: Python

        # 正确：
        with conn.begin_transaction():
            do_stuff_in_transaction(conn)

        # 错误：
        with conn:
            do_stuff_in_transaction(conn)

 第二个例子没有提供任何信息去指明__enter__和__exit__方法在事务之后做出了关闭连接之外的其他事情。这种情况下，明确指明非常重要。

* 返回的语句保持一致。函数中的返回语句都应该返回一个表达式，或者都不返回。如果一个返回语句需要返回一个表达式，那么在没有值可以返回的情况下，需要用 return None 显式指明，并且在函数的最后显式指定一条返回语句。 

    .. code-block:: Python

        # 正确：
        def foo(x):
            if x >= 0:
                return math.sqrt(x)
            else:
                return None

        def bar(x):
            if x < 0:
                return None
            return math.sqrt(x)

        # 错误：
        def foo(x):
            if x >= 0:
                return math.sqrt(x)

        def bar(x):
            if x < 0:
                return
            return math.sqrt(x)

* 使用字符串方法代替字符串模块。 

* 使用''.startswith()和''.endswith() 代替通过字符串切割的方法去检查前缀和后缀。 

    .. code-block:: Python

        # 正确: 
        if foo.startswith('bar'):

        # 错误: 
        if foo[:3] == 'bar':

* 对象类型的比较应该用isinstance()而不是直接比较type。

    .. code-block:: Python

        # 正确: 
        if isinstance(obj, int):

        # 错误: 
        if type(obj) is type(1):

* 对于序列来说（strings，lists，tuples），可以使用空序列为false的情况。
    
    .. code-block:: Python

        # 正确: 
        if not seq:
            if seq:

        # 错误: 
        if len(seq):
            if not len(seq):

* 当有Python内置函数的时候使用内置函数，而不是自己写。

    比如，当想在列表末尾添加新的对象，应该使用Python内置函数append()。这样不仅可以简化代码还能直接更改对象。

    .. code-block:: Python

        >>> pre=[1,2,3]
        >>> def add_item(xs,x):
        ...     return xs + [x]
        ...
        >>> def add_item2(xs,x):
        ...     xs.append(x)
        ...
        >>> add_item(pre,4)
        [1, 2, 3, 4]
        >>> pre
        [1, 2, 3]
        >>> add_item2(pre,5)
        >>> pre
        [1, 2, 3, 5]
        >>>

* 使用装饰器装饰类、函数去避免写重复代码。抽离出一些雷同的代码组件多个特定功能的装饰器。这样我们可以针对不同的需求使用特定的装饰器，这时因为源码去除了大量泛化的内容而使得源码具有更加清晰的逻辑。

    .. code-block:: Python

        class Decorator(object):
            def __init__(self, f):
                self.f = f
            def __call__(self):
                print("decorator start")
                self.f()
                print("decorator end")

        @Decorator
        def func():
            print("func")

        func()

    这个例子在控制台打印如下：

    .. code-block:: Python

        decorator start
        func
        decorator end

5.4 功能注释
--------------

* 如果代码对功能注释有不同的用途，在文件的顶部增加一个这种形式的注释：
      
    .. code-block:: Python

        # type: ignore

 这会告诉检查器忽略所有的注释。

* 不想使用类型检测的用户可以忽略他们，然而第三方库的用户可能希望在这些库上运行类型检测。因此建议使用存根文件类型：.pyi文件，这种文件类型会被类型检测器读取。

* 对于需要向后兼容的代码，可以以注释的形式添加功能型注释。

5.5 变量注释
-----------------

* 模块级变量、类和实例变量以及局部变量的注释应该在冒号后面有一个空格。

* 冒号前没有空格。

* 如果一个赋值等号右侧存在值，那么等号两边应该正好有一个空格。

* 变量注释语法是所有Python版本中存根文件的首选语法。

示例：

    .. code-block:: Python

        code: int

        class Point:
            coords: Tuple[int, int]
            label: str = '<unknown>'

6. 参考
==========

1. Python PEP 8： https://www.python.org/dev/peps/pep-0008/

2. 谷歌Python风格指南： https://github.com/google/styleguide/blob/gh-pages/pyguide.md

