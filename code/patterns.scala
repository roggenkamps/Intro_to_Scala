/*
 * from http://www.scala-lang.org/node/52
 */

package examples

object patterns {
  abstract class Tree
  case class Branch(left: Tree, right: Tree) extends Tree
  case class Leaf(x: Int) extends Tree

  val tree1 = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

  def sumLeaves(t: Tree): Int = t match {
    case Branch(l, r) => sumLeaves(l) + sumLeaves(r)
    case Leaf(x) => x
  }

  def toString(t: Tree): String = t match {
    case Branch(l, r) => "Branch(" + toString(l) + "," + toString(r) + ")"
    case Leaf(x)      => "Leaf(" + x + ")"
    }

  def main(args: Array[String]) {
    println("sum of leafs=" + sumLeaves(tree1))
    println("Tree: " + toString(tree1))
  }
}
