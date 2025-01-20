package priorityQueue;

import java.util.ArrayList;

public class SortArrayPQ {
    public static void main(String[] args) {
        SortedArrayPQ sortedArrayPQ = new SortedArrayPQ();

        sortedArrayPQ.insert(10);
        sortedArrayPQ.insert(30);
        sortedArrayPQ.insert(20);
        sortedArrayPQ.insert(50);
        sortedArrayPQ.insert(60);
        sortedArrayPQ.insert(5);

        sortedArrayPQ.printPQ();

        System.out.println("최소 값 : " + sortedArrayPQ.peekMin());

        System.out.println("삭제 : " + sortedArrayPQ.deleteMin());

        System.out.println("삭제 후");
        sortedArrayPQ.printPQ();
    }
}

class SortedArrayPQ {
    private ArrayList<Integer> pq;

    public SortedArrayPQ() {
        pq = new ArrayList<>();
    }

    // 삽입 연산에서 정렬 후 값 삽입
    public void insert(int value) {
        int i = 0;

        // 정렬된 위치 찾기
        // pq의 사이즈를 넘지 않을때까지 인덱스 i의 값과 value값을 비교하는 루프
        while (i < pq.size() && pq.get(i) < value) {
            i++;
        }

        pq.add(i, value);
    }

    public int deleteMin() {
        if (pq.isEmpty()) {
            throw new IllegalStateException("pq is empty");
        }

        return pq.remove(0);
    }

    public int peekMin() {
        if (pq.isEmpty()) {
            throw new IllegalStateException("pq is empty");
        }

        return pq.get(0);
    }

    public void printPQ() {
        System.out.println(pq);
    }
}