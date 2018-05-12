package am.ak.example

class A(n: Int) {
  var value = n
}

class B(n: Int) {
  var value = new A(n)
}

object Test {
  def main(args: Array[String]) {
    var x = new B(5)
    x = new B(6) // Doesn't work, because I can't replace the object created on the line above with this new one.
    x.value = new A(6) // Doesn't work, because I can't replace the object assigned to B.value for a new one.
    x.value.value = 6 // Works, because A.value can receive a new object.
  }
}