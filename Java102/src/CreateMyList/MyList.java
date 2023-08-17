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
            return null;
        }
        return (T) data[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedElement = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size - 1] = null;
        size--;
        return removedElement;
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            return null;
        }
        T oldElement = get(index);
        data[index] = element;
        return oldElement;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    private void expandArray() {
        int newCapacity = capacity * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        System.out.println("Original List: " + myList);
        myList.remove(1);
        System.out.println("List After Removing Banana: " + myList);

        myList.set(0, "Orange");
        System.out.println("List After Setting Orange: " + myList);
    }
}

