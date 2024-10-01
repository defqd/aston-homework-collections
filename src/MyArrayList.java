import java.util.Collection;

public class MyArrayList <T extends Comparable<T>>{
    private int size;
    private Object[] values;

    public MyArrayList() {
        size = 0;
        values = new Object[size];
    }

    public T get(int index) {
        checkedIndex(index);
        return (T) values[index];
    }

    public boolean add(T value) {
        values = grow(size + 1);

        values[size++] = value;

        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        values = grow(collection.size() + size);

        for (T value : collection) {
            values[size++] = value;
        }

        return true;
    }

    public T remove(int index) {
        checkedIndex(index);

        T oldValue = (T) values[index];

        var temp = new Object[size - 1];

        for (int i = 0, k = 0; i < size; i++) {
            if (i == index) {
                continue;
            }

            temp[k++] = values[i];
        }

        values = temp;
        --size;

        return oldValue;
    }

    private Object[] grow(int minCapacity) {
        var temp = new Object[minCapacity];
        System.arraycopy(values, 0, temp, 0, values.length);

        return temp;
    }

    private void checkedIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public int size() {
        return this.size;
    }

    public void display() {
        for (var value : values) {
            System.out.println(value);
        }
    }

    public void sort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((T) values[j]).compareTo((T) values[j + 1]) > 0) {
                    T temp = (T) values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}