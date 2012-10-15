


case class WeirdInt( i: Int ) {

  def ?+ (j: WeirdInt) = WeirdInt( i + j.i )

  def ?- (j: WeirdInt) = WeirdInt( i - j.i )

  def ?* (j: WeirdInt) = WeirdInt( i * j.i )

  def ?/ (j: WeirdInt) = WeirdInt( i / j.i )

  def toInt = i
}