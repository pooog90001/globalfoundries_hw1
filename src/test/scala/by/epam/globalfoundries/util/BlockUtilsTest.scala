package by.epam.globalfoundries.util

import org.scalatest.FunSuite

class BlockUtilsTest extends FunSuite {

  test("should compute sorted list and return total 23") {
    var list = List[Block](
      Block(0, 3),
      Block(2, 7),
      Block(9, 14),
      Block(11, 25),
      Block(13, 18),
      Block(17, 21)
    )

    val expectedTotalBlockingTime = 23
    val  actualTotalBlockingTime = BlockUtils.getTotalBlockingTime(list)

    assert(actualTotalBlockingTime  === expectedTotalBlockingTime)
  }

  test("should compute unsorted list and return total 19") {
    var list = List[Block](
      Block(11, 25),
      Block(0, 3),
      Block(13, 18),
      Block(9, 14),
      Block(17, 21)
    )

    val expectedTotalBlockingTime = 19
    val  actualTotalBlockingTime = BlockUtils.getTotalBlockingTime(list)

    assert(actualTotalBlockingTime  === expectedTotalBlockingTime)
  }

  test("should compute unsorted list and return total 3") {
    var list = List[Block](
      Block(0, 2),
      Block(0, 3),
      Block(0, 2),
      Block(0, 1)
    )

    val expectedTotalBlockingTime = 3
    val  actualTotalBlockingTime = BlockUtils.getTotalBlockingTime(list)

    assert(actualTotalBlockingTime  === expectedTotalBlockingTime)
  }

  test("should compute empty list and return total 0") {
    var list = List[Block]()

    val expectedTotalBlockingTime = 0
    val  actualTotalBlockingTime = BlockUtils.getTotalBlockingTime(list)

    assert(actualTotalBlockingTime  === expectedTotalBlockingTime)
  }

  test("should compute unsorted list and return total 30") {
    var list = List[Block](
      Block(10, 25),
      Block(0, 5),
      Block(30, 40)
    )

    val expectedTotalBlockingTime = 30
    val  actualTotalBlockingTime = BlockUtils.getTotalBlockingTime(list)

    assert(actualTotalBlockingTime  === expectedTotalBlockingTime)
  }

}
