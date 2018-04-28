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

    for (i <- sortedListBlocks.indices) {
      if (maxEndTime <= sortedListBlocks(i).startTime) {
        totalTime += sortedListBlocks(i).endTime - sortedListBlocks(i).startTime

      } else if (maxEndTime < sortedListBlocks(i).endTime) {
        totalTime +=  sortedListBlocks(i).endTime - maxEndTime
      }
      if (maxEndTime < sortedListBlocks(i).endTime) {
        maxEndTime = sortedListBlocks(i).endTime
      }
    }

    totalTime
  }

}
