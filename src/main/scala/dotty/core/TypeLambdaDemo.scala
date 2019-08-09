object TypeLambdaDemoDotty extends App{
  trait Functor[F[_]]{  
    def map[A,B](a : F[A])(func : A => B) : F[B]
  }

  def functionFunctor[X] = new Functor[[A] =>> Function1[X,A]] { //Much cleaner syntax compared to Scala
    def map[A, B](a : X =>A)(func : A => B) : X => B = a andThen func
  }

  val stringToInt = (a : String) => a.toInt
  val intToDouble = (a : Int) => a.toDouble
 
  val composedFunction = functionFunctor[String].map(stringToInt)(intToDouble)

  println(composedFunction("1"))

}