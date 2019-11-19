package io;
//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.
import net.mindview.util.*;

public class OSExecuteDemo {
  public static void main(String[] args) {
    OSExecute.command("dir");
    OSExecute.command("no cmd");
  }
} /* Output:
}
*///:~
