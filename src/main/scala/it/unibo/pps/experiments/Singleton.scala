package it.unibo.pps.experiments

object Singleton:

  trait Counter:
    def get: Int

  private class CounterImpl extends Counter:
    private var counter = 0
    def get: Int =
      counter = counter + 1
      counter -1

  // Singleton that implements a Counter
  object SingletonCounter extends Counter:
    private var counter = 0
    override def get: Int =
      counter = counter + 1
      counter - 1

  // If we want to abandon SingletonCounter in favour of a specific class, we
  //  can simply remove it and put the following line instead, which declares SingletonCounter
  //  as an instance of the private class CounterImpl.
  //  This class works in the exact same way as the previous Singleton.
  //  This change is completely transparent to the end user, who still invokes our
  //  counter using the SingletonCounter.get syntax.

  // val SingletonCounter: Counter = new CounterImpl()

object SingletonUser extends App:
  import Singleton.*

  println(SingletonCounter.get)
  println(SingletonCounter.get)
  println(SingletonCounter.get)
