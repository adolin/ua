package test;

/**
* Created by mAdRid on 09.06.2016.
*/

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import p.MyList;
import p.MyListImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MyListImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: iterator()
     *
     */
    @Test
    public void testIterator() throws Exception {
        Iterator a = new MyListImpl().iterator();
        assert(a instanceof Iterator);
    }

    /**
     *
     * Method: listIterator()
     *
     */
    @Test
    public void testListIterator() throws Exception {
        p.ListIterator a = new MyListImpl().listIterator();
        assert(a instanceof Iterator);
    }

    /**
     *
     * Method: add(Object e)
     *
     */
    @Test
    public void testAdd() throws Exception {
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
        m.add(null);
        assertTrue(m.size()==13);
    }

    /**
     *
     * Method: clear()
     *
     */
    @Test
    public void testClear() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.clear();
        assertTrue (m.size()==0);
    }

    /**
     *
     * Method: remove(Object o)
     *
     */
    @Test
    public void testRemoveO() throws Exception {
        MyList m = new MyListImpl();
        assertFalse(m.remove(new Object()));
        m.add(22);
        assertTrue(m.size()==1);
        assertTrue(m.remove(22));
        assertTrue(m.size()==0);
    }

    /**
     *
     * Method: toArray()
     *
     */
    @Test
    public void testToArray() throws Exception {
        MyList m = new MyListImpl();
        Object[] arr = (Object[]) m.toArray();
        assertTrue(m.size()==0);
        assertTrue(m.size()==arr.length);
        m.add(2);
        m.add("ggd");
        arr = (Object[]) m.toArray();
        assertTrue(m.size()==2);
        assertTrue(m.size()==arr.length);
    }

    /**
     *
     * Method: size()
     *
     */
    @Test
    public void testSize() throws Exception {
        MyList m = new MyListImpl();
        assertTrue(m.size()==0);
        m.add(1);
        assertTrue(m.size()==1);
        m.remove(1);
        assertTrue(m.size()==0);
    }

    /**
     *
     * Method: contains(Object o)
     *
     */
    @Test
    public void testContains() throws Exception {
        MyList m = new MyListImpl();
        m.add("gf");
        assertTrue(m.contains("gf"));
        assertFalse(m.contains("f"));
    }

    /**
     *
     * Method: toString()
     *
     */
    @Test
    public void testToString() throws Exception {
        MyList m = new MyListImpl();
        m.add(2);
        m.add(null);
        m.add("f");
        String act = "{[2], [null], [f]}";
        assertEquals(m.toString(),act);
    }

    /**
     *
     * Method: containsAll(MyList c)
     *
     */
    @Test
    public void testContainsAll() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(6);
        m.add(new Object());
        m.add("ghbd");
        m.add("g");
        m.add('r');
        m.add(12.434);
        m.add(434);
        m.add(45.22F);
        MyList m2 = new MyListImpl();
        m2.add(1);
        m2.add(434);
        m2.add(6);
        assertTrue(m.containsAll(m2));
        m2.add(44444);
        assertFalse(m.containsAll(m2));
    }

    /**
     *
     * Method: hasNext()
     *
     */
    @Test
    public void testHasNext() throws Exception {
        MyList m = new MyListImpl();
        assertFalse(m.iterator().hasNext());
        Iterator it = m.iterator();
        m.add(1);
        m.add(2);
        m.add(6);
        for (int i=0;i<m.size();i++){
            assertTrue(it.hasNext());
            it.next();
        }
    }

    /**
     *
     * Method: next()
     *
     */
    @Test (expected = NoSuchElementException.class)
    public void testNext() throws Exception {
        MyList m = new MyListImpl();
        Iterator it = m.iterator();
        it.next();
    }
    @Test
    public void testNext1() throws Exception {
        MyList m = new MyListImpl();
        Iterator it = m.iterator();
        m.add(1);
        m.add(2);
        m.add(6);
        Object [] o = (Object[]) m.toArray();
        for (int i=0;i<m.size();i++){
            assertTrue(it.hasNext());
            assertEquals(it.next(),o[i]);
        }
    }
    /**
     *
     * Method: remove()
     *
     */
    @Test (expected = IllegalStateException.class)
    public void testRemove() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        Iterator it = m.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            it.remove();
        }
    }

    @Test (expected = IllegalStateException.class)
    public void testRemove2() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        Iterator it = m.iterator();
        it.remove();
    }

    @Test
    public void testRemove3() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        Iterator it = m.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        assertTrue(m.size()==0);
    }
    /**
     *
     * Method: hasPrevious()
     *
     */
    @Test
    public void testHasPrevious() throws Exception {
        MyList m = new MyListImpl();
        p.ListIterator it = m.listIterator();
        assertFalse(it.hasPrevious());
        m.add(1);
        m.add(2);
        m.add(6);
        it = m.listIterator();
        while (it.hasPrevious()){
            assertTrue(it.hasPrevious());
            it.previous();
        }
    }

    /**
     *
     * Method: previous()
     *
     */
    @Test (expected = NoSuchElementException.class)
    public void testPrevious() throws Exception {
        MyList m = new MyListImpl();
        p.ListIterator it = m.listIterator();
        it.previous();
    }

    @Test
    public void testPrevious2() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(6);
        p.ListIterator it = m.listIterator();
        Object o[] = (Object[]) m.toArray();
        int i = o.length-1;
        while (it.hasPrevious()) {
            assertEquals(it.previous(), o[i]);
            i--;
        }
    }
    /**
     *
     * Method: set(Object e)
     *
     */
    @Test (expected = IllegalStateException.class)
    public void testSet() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(6);
        p.ListIterator it = m.listIterator();
        it.set(4);
    }

    @Test
    public void testSet2() throws Exception {
        MyList m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(6);
        p.ListIterator l2 = m.listIterator();

        while (l2.hasPrevious()){
            l2.previous();
            l2.set("rr");
        }
        Object [] o = (Object[]) m.toArray();

        for (int i=m.size()-1;i>=0;i--){
            assertEquals(o[i],"rr");
        }
    }

    /**
     *
     * Method: doubleCapacity()
     *
     */
    @Test
    public void testDoubleCapacity() throws Exception {
        MyListImpl m = new MyListImpl();
        m.add(1);
        m.add(2);
        m.add(6);
        assertTrue(m.capacity ==10);
        m.add(1);
        m.add(2);
        m.add(6);m.add(1);
        m.add(2);
        m.add(6);m.add(1);
        m.add(2);
        m.add(6);m.add(1);
        m.add(2);
        m.add(6);
        assertTrue(m.capacity == 20);
    }

}


