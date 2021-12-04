package edu.example.core.objects;

import edu.example.core.stream.UserExample;

public class ObjectEquals {
    public static void main(String[] args) {

        //--------------- Difference between == and .equals() method in Java

        /*
        The main difference between the .equals() method and == operator is that one
            is a method and the other is the operator.

        We can use == operators for REFERENCE COMPARISON (address comparison) and .equals() method for CONTENT COMPARISON.
            In simple words, == checks if both objects point to the same memory location
            whereas .equals() evaluates to the comparison of values in the objects.

        If a class does not override the equals method, then by default it uses the equals (Object o) method
        of the closest parent class that has overridden this method.
         */

        UserExample userExample = new UserExample();
        UserExample userExample2 = new UserExample();
        if (userExample == userExample2){
            System.out.println("userExample == userExample2 = " + true);
        } else{
            System.out.println("userExample == userExample2 = " + false);
        }
        System.out.println("---------");

        //System.out.println("userExample == userExample2 = " + userExample == userExample2);
        // Operator '==' cannot be applied to 'java.lang.String', 'edu.example.core.stream.UserExample'

        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        String s4 = s2;
        String s5 = s3;
        String s6 = new String("hello");
        String s7 = new String("Hello");


        //both have the same addresses in the string constant pool.
        //IDEA: String values are compared using '==', not 'equals()'
        //IDEA: Replace '==' with 'equals()'

        System.out.printf("s1==s2 = %s%n", s1 == s2);  // true       // because StringPool
        System.out.printf("s1==s3 = %s%n", s1 == s3);  // false      // different object
        System.out.printf("s1==s4 = %s%n", s1 == s4);  // true       // because StringPool
        System.out.printf("s1==s5 = %s%n", s1 == s5);  // false      // different object
        System.out.printf("s1==s6 = %s%n", s1 == s6);  // false      // different object
        System.out.printf("s1==s7 = %s%n", s1 == s7);  // false      // different object
        System.out.println();

        System.out.printf("s2==s4 (where s4=s2) = %s%n", s2 == s4);  // true      // same object
        System.out.printf("s3==s5 (where s5=s3) = %s%n", s3 == s5);  // true      // same object
        System.out.println();


        System.out.println("s1.equals(s2) = " + s1.equals(s2)); //true  //IDEA: Result of 's1.equals(s2)' is always 'true'
        System.out.println("s1.equals(s3) = " + s1.equals(s3)); //true
        System.out.println("s1.equals(s4) = " + s1.equals(s4)); //true  //IDEA: Result of 's1.equals(s2)' is always 'true'
        System.out.println("s1.equals(s5) = " + s1.equals(s5)); //true
        System.out.println("s1.equals(s6) = " + s1.equals(s6)); //false // different content
        System.out.println("s1.equals(s7) = " + s1.equals(s7)); //false // different content
        System.out.println();

        System.out.println("s3.equals(s2) = " + s1.equals(s2)); //true  //IDEA: Result of 's1.equals(s2)' is always 'true'
        System.out.println("s1.equals(s3) = " + s1.equals(s3)); //true
        // the result is true because it’s only comparing the values given in s1 and s2..s5.


        //---   Equality operator(==)
        /*
        We can apply equality operators for every primitive type including boolean type.
        We can also apply equality operators for object types.
         */

        // integer-type
        System.out.println(10 == 20);

        // char-type
        System.out.println('a' == 'b');

        // char and double type
        System.out.println('a' == 97.0);

        // boolean type
        System.out.println(true == true);

        System.out.println("---------");

        /*
        If we apply == for object types then, there should be compatibility between arguments types
        (either child to parent or parent to child or same type). Otherwise, we will get compile-time error.
         */

        Thread t = new Thread();
        Object o = new Object();
        String s = new String("GEEKS");

        System.out.println(t == o);
        System.out.println(o == s);
        System.out.println("---------");

        // Operator '==' cannot be applied to 'java.lang.Thread', 'java.lang.String'
        // System.out.println(t==s);


        //---   .equals()

        /*
        In Java, string equals() method compares the two given strings based on the data/content of the string.
        If all the contents of both the strings are same then it returns true.
        If all characters are not matched then it returns false.
         */

        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = t1;

        String string1 = new String("GEEKS");
        String string2 = new String("GEEKS");

        System.out.println(t1 == t3);           //true
        System.out.println(t1 == t2);           //false
        System.out.println(string1 == string2); //false

        System.out.println(t1.equals(t2));      //false
        System.out.println(s1.equals(s2));      //true

        //--------------- String equals

        // First - by reference, then - by equals (StringLatin1 or StringUTF16) - char by char

    }
}
//--- Object equals
/*
        //'java doc'
        //### java.lang.Object @Contract(value = "null -> false", pure = true)
        //    public boolean equals(Object obj){
        //        return (this == obj);
        //    }


        Indicates whether some other object is "equal to" this one.
        The equals method implements an equivalence relation on non-null object references:
            It is reflexive:    for any non-null reference value x, x.equals(x) should return true.

            It is symmetric:    for any non-null reference values x and y, x.equals(y)
                                should return true if and only if y.equals(x) returns true.

            It is transitive:   for any non-null reference values x, y, and z,
                                if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.

            It is consistent:   for any non-null reference values x and y, multiple invocations of x.equals(y)
                                consistently return true or consistently return false,
                                provided no information used in equals comparisons on the objects is modified.

        For any non-null reference value x, x.equals(null) should return false.

        The equals method for class Object implements the most discriminating possible equivalence relation on objects;
        that is, for any non-null reference values x and y,
        this method returns true if and only if x and y refer to the same object (x == y has the value true).

        Note that it is generally necessary to override the hashCode method whenever this method is overridden,
        so as to maintain the general contract for the hashCode method, which states that equal objects must have equal hash codes.

        Params:
            obj – the reference object with which to compare.
        Returns:
            true if this object is the same as the obj argument; false otherwise.
        See Also:
            hashCode(), java.util.HashMap
 */

//--- String equals

    /*
      Compares this string to the specified object.  The result is {@code
      true} if and only if the argument is not {@code null} and is a {@code
      String} object that represents the same sequence of characters as this
      object.

      <p>For finer-grained String comparison, refer to
      {@link java.text.Collator}.

      @param  anObject
              The object to compare this {@code String} against

      @return  {@code true} if the given object represents a {@code String}
               equivalent to this string, {@code false} otherwise

      @see  #compareTo(String)
      @see  #equalsIgnoreCase(String)
     */
/*
//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//        if (anObject instanceof String) {
//            String aString = (String)anObject;
//            if (coder() == aString.coder()) {
//                return isLatin1() ? StringLatin1.equals(value, aString.value)
//                        : StringUTF16.equals(value, aString.value);
//            }
//        }
//        return false;
//    }
 */