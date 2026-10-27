import java.util.ArrayList;

class maxHeap {
    ArrayList<Integer> heap;

    public maxHeap() {
        heap = new ArrayList<>();
    }

    public void push(int x) {
        heap.add(x);

        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) >= heap.get(i)) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, temp);

            i = parent;
        }
    }

    public void pop() {
        if (heap.isEmpty()) {
            return;
        }

        int last = heap.remove(heap.size() - 1);

        if (heap.isEmpty()) {
            return;
        }

        heap.set(0, last);

        int i = 0;
        int n = heap.size();

        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < n && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == i) {
                break;
            }

            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);

            i = largest;
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            return -1;
        }

        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }
}

