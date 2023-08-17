package CreateMyList;
public class MyList<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public MyList() {
        this.capacity = 10;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T element) {
        if (size == capacity) {
            expandArray();
        }
        data[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (T) data[index];
    }

    private void expandArray() {
        int newCapacity = capacity * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        MyList<Integer> integerList = new MyList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        System.out.println("Size: " + integerList.size());
        System.out.println("Capacity: " + integerList.getCapacity());
        System.out.println("Element at index 1: " + integerList.get(1));
    }
}
