//: swt/HelloSWT.java
package swt; /* Added by Eclipse.py */
// {Requires: org.eclipse.swt.widgets.Display; You must
// install the SWT library from http://www.eclipse.org }
import org.eclipse.swt.widgets.*;

/**
 * org.eclipse.swt.win32.win32.x86_64_3.103.2.v20150203-1351.jar
 *    取自eclipse/plugins目录（Version: Luna Service Release 2 (4.4.2) Build id: 20150219-0600）
 */

public class HelloSWT {
  public static void main(String [] args) {
    Display display = new Display(); //管理swt与底层操作系统之间的连接
    Shell shell = new Shell(display); //顶层主窗口
    shell.setText("Hi there, SWT!"); // Title bar
    shell.open();
    while(!shell.isDisposed())
      if(!display.readAndDispatch())
        display.sleep();
    display.dispose();
  }
} ///:~
