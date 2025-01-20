package priorityQueue;

import java.util.ArrayList;

public class HeapPQ {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(30);
        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(80);
        minHeap.insert(320);

        minHeap.printHeap();

        System.out.println("최소값 : " + minHeap.peekMin());

        System.out.println("최소값 삭제 : " + minHeap.deleteMin());
        System.out.println("삭제 후");
        minHeap.printHeap();
    }
}

class MinHeap {
    private ArrayList<Integer> heap; // 힙을 저장할 ArrayList

    public MinHeap() {
        heap = new ArrayList<>(); // ArrayList 초기화
    }

    // 요소 삽입
    public void insert(int value) {
        heap.add(value); // 배열의 끝에 요소 추가
        int current = heap.size() - 1; // 새로 추가된 요소의 인덱스
        int parent = (current - 1) / 2; // 부모 노드의 인덱스 계산

        // 상향 조정으로 힙 속성을 복구
        while (current > 0 && heap.get(current) < heap.get(parent)) {
            swap(current, parent); // 현재 노드와 부모 노드 위치 교환
            current = parent; // 부모 노드를 새로운 현재 노드로 설정
            parent = (current - 1) / 2; // 새로운 부모 노드의 인덱스
        }
    }

    // 최소값 삭제
    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("pq is empty");
        }

        int min = heap.get(0); // 최소값은 루트노드
        heap.set(0, heap.get(heap.size() - 1)); // 마지막 노드를 루트로 이동
        heap.remove(heap.size() - 1); // 마지막 노드 제거

        int current = 0; // 루트에서 시작
        while (true) {
            int left = 2 * current + 1; // 왼쪽 자식 노드 인덱스
            int right = 2 * current + 2; // 오른쪽 자식 노드 인덱스
            int smallest = current; // 현재 노드가 가장 작은 값으로 초기화

            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left; // 왼쪽 자식이 더 작으면 왼쪽 값으로 갱신
            }

            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right; // 오른쪽 값이 더 작으면 오른쪽 값으로 갱신
            }

            if (smallest == current) {
                break; // 힙 속성을 만족하면 탈출
            }

            swap(current, smallest); // 현재 노드와 가장 작은 노드를 교환
            current = smallest; // 교환된 노드를 새로운 현재 노드로 설정
        }

        return min;
    }

    public int peekMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("pq is empty");
        }
        return heap.get(0);
    }

    private void swap(int i, int j) {
        int tmep = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmep);
    }

    public void printHeap() {
        System.out.println(heap);
    }
}
