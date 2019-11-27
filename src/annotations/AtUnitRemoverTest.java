//: annotations/AtUnitExample5.java
package annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCleanup;
import net.mindview.atunit.TestObjectCreate;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

import java.io.IOException;
import java.io.PrintWriter;

public class AtUnitRemoverTest {

  public static void main(String[] args) throws Exception {
    OSExecute.command(
      "java -cp out/production/Thinking-in-Java;lib/javassist-3.21.0-GA.jar net.mindview.atunit.AtUnitRemover out/production/Thinking-in-Java/annotations/AtUnitExample5");
  }
} /* Output:
annotations.AtUnitExample5
  . test1
Running cleanup
  . test2
Running cleanup
  . test3
Running cleanup
OK (3 tests)
*///:~
