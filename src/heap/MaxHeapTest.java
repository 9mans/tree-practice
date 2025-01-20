package heap;

import java.util.ArrayList;

public class MaxHeapTest {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(50);
        maxHeap.insert(30);
        maxHeap.insert(10);
        maxHeap.insert(40);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(34);

        maxHeap.printHeap();

        System.out.println("최대 값 삭제" + maxHeap.deleteMax());
        maxHeap.printHeap();
    }
}

class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        int parent = (current - 1) / 2;

        while (current > 0 && heap.get(current) > heap.get(parent)) {
            swap(current, parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    // 최대 값을 삭제하는 메서드
    public int deleteMax() {
        if (heap.isEmpty()) { // 힙이 비어있는 경우 예외를 발생시킴
            throw new IllegalStateException("heap is empty");
        }

        int max = heap.get(0); // 힙의 최대값(루트 노드)을 추출한다
        heap.set(0, heap.get(heap.size() - 1)); // 배열의 마지막 노드를 루트 위치로 이동
        heap.remove(heap.size() - 1); // 마지막 노드를 제거하여 배열 크기를 줄인다


        // 하향 조정 과정
        int current = 0; // 현재 루트 위치에서 시작한다
        while (true) {
            int left = 2 * current + 1; // 왼쪽 자식 노드의 인덱스
            int right = 2 * current + 2; // 오른쪽 자식 노드의 인덱스
            int largest = current; // 현재 노드를 가장 큰 값으로 초기화한다

            // 왼쪽 자식이 존재하고, 현재 노드보다 값이 크면 largest를 왼쪽으로 업데이트
            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            // 오른쪽 자식이 존재하고 largest보다 값이 크면 오른쪽으로 업데이트
            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            // 현재 노드가 가장 크다면 루프를 종료한다
            if (largest == current) {
                break;
            }

            swap(current, largest); // 현재 노드와 가장 큰 값을 가진 자식 노드 교환
            current = largest; // 자식을 새로운 현재 노드로 설정
        }

        return max;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }
}

