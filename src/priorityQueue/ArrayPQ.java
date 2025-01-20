package priorityQueue;

import java.util.ArrayList;

public class ArrayPQ {

    public static void main(String[] args) {

        UnsortedArrayPQ unsortedArrayPQ = new UnsortedArrayPQ();

        unsortedArrayPQ.insert(10);
        unsortedArrayPQ.insert(30);
        unsortedArrayPQ.insert(20);
        unsortedArrayPQ.insert(50);
        unsortedArrayPQ.insert(40);
        unsortedArrayPQ.insert(22);

        System.out.println("데이터 삽입");
        unsortedArrayPQ.printPQ();

        System.out.println("최소값 : " + unsortedArrayPQ.peekMin());

        System.out.println("최소값 삭제 : " + unsortedArrayPQ.deleteMin());
        System.out.println("삭제 후 조회");
        unsortedArrayPQ.printPQ();
    }

}

class UnsortedArrayPQ {

    // 우선순위 큐를 저장할 배열
    private ArrayList<Integer> pq;

    // 배열 초기화
    public UnsortedArrayPQ() {
        pq = new ArrayList<>();
    }

    // 삽입 연산
    public void insert(int value) {
        pq.add(value);
    }

    // 최소값 삭제 연산
    public int deleteMin() {
        if (pq.isEmpty()) { // pq가 비어있다면 예외발생
            throw new IllegalStateException("pq is empty");
        }

        int minIndex = 0; // 최소값의 인덱스 지정
        for (int i = 0; i < pq.size(); i++) { // 반복문으로 pq의 값을 비교하여 최소값 탐색
            if (pq.get(i) < pq.get(minIndex)) {
                minIndex = i;
            }
        }

        int minValue = pq.get(minIndex); // 최소값 저장
        pq.remove(minIndex); // 최소값 삭제
        return minValue; // 최소값 반환
    }

    // 최소값 조회
    public int peekMin() {
        if (pq.isEmpty()) {
            throw new IllegalStateException("pq is empty");
        }

        int minValue = pq.get(0);
        for (int i = 0; i < pq.size(); i++) {
            if (pq.get(i) < minValue) {
                minValue = pq.get(i);
            }
        }
        return minValue;
    }

    public void printPQ() {
        System.out.println(pq);
    }
}
