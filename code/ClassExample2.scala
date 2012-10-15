/*
 * ClassExample2.scala shows mixing inheritence and traits
 * contrived, but hopefully it shows how the diffence between
 * inheritence with classes and composition using traits.
 */
package examples

// base class for a Person
case class Person( firstName: String,
		   lastName:  String,
		   age:       Int )

// a US citizen is represented in the HR by a representative
// traits can contain values and functions, unlike Java
trait USCitizen {
  private val myRep = Person( "Myke", "Representative", 45 )
  def representative = myRep
}

// trait for a senior citizen, ssOffice, a Social Security office
trait Senior {
  def ssOffice = "Unknown"
}

// derived class for a Person who is a US citizen. difference
// is that a US citizen should have a social security number
case class USPerson( override val firstName: String,
		     override val lastName:  String,
		     override val age:       Int,
		                  ssn:       String )
     extends Person( firstName, lastName, age) with USCitizen

// derived class with a Senior trait for a senior US citizen
case class USSenior( override val firstName: String,
		     override val lastName:  String,
		     override val age:       Int,
		     override val ssn:       String ) 
     extends USPerson( firstName, lastName, age, ssn )
         with Senior

// Let's make some objects!  Note use of Application for
// applications that do not need to receive arguments from the
// environment
object ClassExample2 extends Application {
  val sally = Person( "Sally", "Simon", 20 )
  val billy = USPerson( "Billy", "Redmond", 30, "123-45-6789" )
  val mark  = USSenior( "Mark", "Miraldi", 66, "789-01-2345" )
  println( sally )
  println( billy )
  println( billy representative )
  println( mark )
  println( mark representative )
  println( mark ssOffice )
}
