package by.epam.globalfoundries.util

import scala.util.Random

object BlockUtils {

  /*
  * Just sort list of blocks by timeStart field
  */
  def sortByTimeStart(listBlocks: List[Block]) :List[Block] = {
    listBlocks.sortBy(block => block.startTime)
  }

  /*
  * compute total blocking time by task
  */
  def getTotalBlockingTime(listBlocks: List[Block]) : Int = {
    val sortedListBlocks = sortByTimeStart(listBlocks)
    var totalTime = 0
    var maxEndTime = 0

    sortedListBlocks.foreach(block => {
      if (maxEndTime <= block.startTime) {
        totalTime += block.endTime - block.startTime

      } else if (maxEndTime < block.endTime) {
        totalTime +=  block.endTime - maxEndTime
      }
      if (maxEndTime < block.endTime) {
        maxEndTime = block.endTime
      }
    })

    totalTime
  }

}
