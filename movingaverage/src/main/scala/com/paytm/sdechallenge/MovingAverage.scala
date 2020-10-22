package com.paytm.sdechallenge

trait MovingAverage[E, A] {

  /**
   * Adds an element to the moving average Data Structure
   * @param elem The element to add to the moving average structure
   */
  def add(elem: E): Unit

  /**
   *
   * @return Returns an Optional of the Moving Average of the elements added
   *         - None if the number of elements added is less than window size
   *         - Some(average) if the window size is reached
   *
   */
  def getMovingAverage: Option[A]

  /**
   *
   * @return Returns the Moving average of upto the last window size elements added
   *         If the window size is 5 but only 3 elements have been added, the average of the 3 numbers is returned.
   *         If the windows size is 5 and >=5 elements have been added, the average of the last 5 numbers is returned.
   *
   */
  def getForcedMovingAverage: A

  /**
   *
   * @return Gets upto the last @windowSize elements added to the structure
   */
  def getAllElements: List[E]

}
