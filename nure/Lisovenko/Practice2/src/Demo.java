import java.util.*;


public class Demo {


    public static void main(String[] args) {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);
        m.add(6);
        m.add(new Object());
        m.add("ghbd");
        m.add("g");
        m.add('r');
        m.add(12.434);
        m.add(434);
        m.add(45.22F);
        System.out.println(m.remove('r'));
        System.out.println(m);

        MyList m2 = new MyListImpl();
        m2.add(2);
        m2.add(1);
        m2.add(444444);
        m2.add(4);

        System.out.println(m.containsAll(m2));
        System.out.println();
        System.out.println("ФорИч");
        for (Object o : m){
            System.out.println(o);
        }

        System.out.println();
        System.out.println("Итератор");
        Iterator it = m.iterator();
        boolean flag=false;
        int y=0;
        while (it.hasNext()) {
            System.out.println(it.next());
        }


        System.out.println();
        System.out.println("Обратный порядок.");
        ListIterator l = m.listIterator();
        while (l.hasPrevious()) {
            if (y % 2 == 0) {
                flag = true;
            }
            System.out.println(l.previous());
            if (flag) {
                l.remove();
            }
            flag = false;
            y++;
        }
        ListIterator l2 = m.listIterator();
        System.out.println("После удаления");
        while (l2.hasPrevious()){
            System.out.println(l2.previous());
        }
    }
}
