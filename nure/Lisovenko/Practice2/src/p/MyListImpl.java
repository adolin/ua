package p;
import java.util.*;

public class MyListImpl implements MyList, ListIterable {
    Object [] arr;
    public int capacity = 10;
    int size;
    int count=0;

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }


    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    public MyListImpl() {
        arr = new Object[capacity];
    }

    private void doubleCapacity(){
        capacity*=2;
        Object [] a = new Object[capacity];
        System.arraycopy(arr,0,a,0,size);
        arr=a;
    }

    @Override
    public void add(Object e) {
        if (size==capacity-1){
            doubleCapacity();
            arr[size]=e;
            size++;
        }else {
            arr[size]=e;
            size++;
        }
    }

    @Override
    public void clear() {
        capacity=10;
        size=0;
        arr=new Object[capacity];
    }

    @Override
    public boolean remove(Object o) {
        for (int index = 0; index < size; index++)
            if (o.equals(arr[index])) {
                count++;
                int numMoved = size - index - 1;
                if (numMoved > 0)
                    System.arraycopy(arr, index+1, arr, index,
                            numMoved);
                arr[--size] = null;
                return true;
            }
        return false;
    }

    @Override
    public Object toArray() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int index = 0; index < size; index++)
            if (o.equals(arr[index])) {
                return true;
            }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i=0;i<size-1;i++){
            sb.append("[");
            sb.append(arr[i]);
            sb.append("]");
            sb.append(", ");
        }
        sb.append("[");
        sb.append(arr[size-1]);
        sb.append("]");
        sb.append("}");
        return String.valueOf(sb);
    }

    @Override
    public boolean containsAll(MyList c) {
        Object a[] = (Object[]) c.toArray();
        for (int i=0;i<a.length;i++) {
            if (!contains(a[i]))
                return false;
        }
        return true;
    }

    private class IteratorImpl implements Iterator<Object> {
        int cursor;
        int lastUse = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] arr = MyListImpl.this.arr;
            if (i >= arr.length)
                throw new ConcurrentModificationException();
            cursor = i+1;
            return arr[lastUse = i];
        }

        @Override
        public void remove() {
            if (lastUse < 0){
                throw new IllegalStateException();
            }else {
                MyListImpl.this.remove(MyListImpl.this.arr[lastUse]);
                cursor = lastUse;
                lastUse =-1;
            }
        }

    }

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        int cursor = MyListImpl.this.size();
        int lastUse = -1;
        @Override
        public boolean hasPrevious() {
            return cursor!=0;
        }

        @Override
        public Object previous() {
            int i = cursor-1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] arr = MyListImpl.this.arr;
            if (i >= arr.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return arr[lastUse = i];
        }

        @Override
        public void set(Object e) {
            if (lastUse < 0)
                throw new IllegalStateException();
            if (lastUse >= size)
                throw new IndexOutOfBoundsException();
            MyListImpl.this.arr[lastUse]=e;
        }

        @Override
        public void remove() {
            if (lastUse < 0){
                throw new IllegalStateException();
            }else {
                MyListImpl.this.remove(MyListImpl.this.arr[lastUse]);
                cursor= lastUse;
                lastUse =-1;
            }
        }
    }
}
