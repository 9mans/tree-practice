package heap;

import java.util.ArrayList;

public class MinHeapTest {
    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);

        minHeap.printHeap();
    }
}

class MinHeap {

    // 완전 이진 트리의 속성을 만족하기 위해 배열 형태로 관리되는 힙을 생성한다
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value); // 값을 배열의 끝에 추가한다
        int current = heap.size() -1; // 현재 노드의 인덱스를 저장한다 새로 추가된 값의 위치는 배열의 마지막 0부터 시작하기 때문에 -1
        int parent = (current -1) / 2; // 부모 노드의 인덱스를 계산한다 완전 이진 트리에서 부모와 자식의 관계는 다음과 같다(공식이다)

        // 마지막 자리에 값을 추가했기 때문에 상향 조정을 해야한다 상향 조정을 구현한 코드다
        // 부모노드가 없거나 힙 속성을 만족하면 종료한다
        while (current > 0 && heap.get(current) < heap.get(parent)) { // 현재 노드가 루트 노드가 아니거나, 부모 노드의 값보다 작을때까지 반복한다

            swap(current, parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    private void swap(int i, int j) { // 배열 내 두 노드의 위치를 바꾸는 역할을 한다
        // i인덱스와 j인덱스의 값을 서로 교환한다
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap);
    }

}
