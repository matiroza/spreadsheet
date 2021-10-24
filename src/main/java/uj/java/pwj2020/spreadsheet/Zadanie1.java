package uj.java.pwj2020.spreadsheet;

import java.sql.SQLOutput;

public class Zadanie1 {
    public static void main(String[] args){
        int     [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][] //100
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][] //200
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][][][][][][]
                [][][][][][][][][][][][][][][] X;        //255
        // maksymalny wymiar tablicy w Javie to 255, powyżej rozmiaru 255 wyrzucany jest bład "array type has too many dimensiosns"

        //Zadanie 2
        Diamond diamond = new Diamond();
        diamond.x();

        //Zadanie 3
        Foo foo = new Foo();
        Foo.Boo boo = new Foo.Boo(); //static class
//        Foo.Doo doo = new Foo.Doo();

    }


}


//Zadanie 2
interface A {
    default void x() {
        System.out.println("AAA");
    }
}

interface B extends A {
    default void x() {
        System.out.println("BBB");
    }
}

interface C extends A {
    default void x() {
        System.out.println("CCC");
    }
}

class Diamond implements B, C {
    @Override
    public void x() {
        B.super.x();
    }
}

//Zadanie 3

class Foo{
    public static class Boo{
        static void b(){
            System.out.println("static");
        }
    }
    public class Doo{
        void d(){
            System.out.println("nostatic");
        }
    }

}
