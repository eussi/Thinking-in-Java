package containers;
//: containers/SortedSetDemo.java
// What you can do with a TreeSet.

import java.util.*;

import static net.mindview.util.Print.*;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet,
                "one two three four five six seven eight"
                        .split(" "));
        print(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        print(low);
        print(high);
        Iterator<String> it = sortedSet.iterator();
        System.out.println("---");
        for (int i = 0; i <= 7; i++) {
            if (i == 3)
                low = it.next();
            else if (i == 6)
                high = it.next();
            else {
                System.out.println(it.next());
            }

        }
        System.out.println("---");
        print(low);
        print(high);
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
        print(sortedSet.tailSet(low));
    }
} /* Output:
[eight, five, four, one, seven, six, three, two]
eight
two
one
three
[one, seven, six]
[eight, five, four, one, seven, six]
[one, seven, six, three, two]
*///:~
