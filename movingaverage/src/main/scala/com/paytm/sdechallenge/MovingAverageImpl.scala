package com.paytm.sdechallenge

import scala.collection.mutable

class MovingAverageImpl(windowSize: Int) extends MovingAverage[Int, Double] {

  require(windowSize > 0)

  private val queue: mutable.Queue[Int] = mutable.Queue.empty

  private var sum: Int = 0

  override def add(elem: Int): Unit = {
    if(queue.size == windowSize) {
      sum -= queue.dequeue()
    }
    queue.enqueue(elem)
    sum += elem
  }

  override def getMovingAverage: Option[Double] = {
    if(queue.size == windowSize) {
      Some(getForcedMovingAverage)
    } else {
      None
    }
  }

  override def getForcedMovingAverage: Double = {
    if(queue.isEmpty) 0 else sum.toDouble / queue.size
  }

  override def getAllElements: List[Int] = queue.toList
}