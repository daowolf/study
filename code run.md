基本上代码块分为三种：
Static静态代码块、构造代码块、普通代码块
代码块执行顺序
静态代码块——> 构造代码块 ——> 构造函数——> 普通代码块 
继承中代码块执行顺序：
父类静态块——>子类静态块——>父类代码块——>父类构造器——>子类代码块——>子类构造器