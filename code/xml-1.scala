case class Person( firstName: String,
		   lastName:  String,
		   age:       Int )

val sallyX = 
<Person>
<FName>Sally</FName>
<LName>Simon</LName>
<Age>20</Age>
</Person>

def XMLtoPerson( node: scala.xml.Node ) : Person =
   Person((node \ "FName").text,
	  (node \\ "LName").text,
	  (node \ "Age").text.toInt)

def personToXML(fname: String,
               lname: String,
	       age:   Int ) =
<Person>
<FName>{fname}</FName>
<LName>{lname}</LName>
<Age>{age}</Age>
</Person>

val sally = XMLtoPerson( sallyX )

val sallyX1 = personToXML( sally.firstName, sally.lastName, sally.age )
