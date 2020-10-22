package com.paytm.sdechallenge

import org.scalatest.{Matchers, WordSpecLike}

class MovingAverageImplSpec extends WordSpecLike with Matchers {

  "A MovingAverageImpl" should {
    "Add elements and retrieve all of them" in {
      val movingAverageStructure = new MovingAverageImpl(5)
      movingAverageStructure.add(1)
      movingAverageStructure.add(2)
      movingAverageStructure.getAllElements should contain theSameElementsInOrderAs List(1, 2)
    }

    "Add elements till beyond window size and retrieve the window" in {
      val movingAverageStructure = new MovingAverageImpl(5)
      val numbersToAdd = List(1, 2, 3, 4, 5, 6)
      numbersToAdd foreach movingAverageStructure.add
      movingAverageStructure.getAllElements should contain theSameElementsInOrderAs List(2, 3, 4, 5, 6)
    }

    "Calculate the average of numbers added till before size is reached" in {
      val movingAverageStructure = new MovingAverageImpl(5)
      movingAverageStructure.add(1)
      movingAverageStructure.add(2)
      movingAverageStructure.getForcedMovingAverage shouldBe (3.0/2)
    }

    "Return None when less numbers are added than window" in {
      val movingAverageStructure = new MovingAverageImpl(5)
      movingAverageStructure.add(1)
      movingAverageStructure.add(2)
      movingAverageStructure.getMovingAverage shouldBe None
    }

    "Return moving average on full window" in {
      val movingAverageStructure = new MovingAverageImpl(5)
      val numbersToAdd = List(1, 2, 3, 4, 5, 6)
      numbersToAdd foreach movingAverageStructure.add
      movingAverageStructure.getMovingAverage shouldBe Some(numbersToAdd.takeRight(5).sum.toDouble / 5)
      movingAverageStructure.getForcedMovingAverage shouldBe numbersToAdd.takeRight(5).sum.toDouble / 5
    }

    "Throw error on moving average window less than 0" in {
      assertThrows[IllegalArgumentException] {
        new MovingAverageImpl(-1)
      }
    }
  }
}
