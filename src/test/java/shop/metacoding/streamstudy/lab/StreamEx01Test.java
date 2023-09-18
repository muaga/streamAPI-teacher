package shop.metacoding.streamstudy.lab;

import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

// 람다식은 2개 이상의 매개변수를 쓰지 않을 때는 {}를 생략할 수 있다.

// stream = 물길에 있는 상태
// stream은 DTO에서 화면에 뿌릴 때 사용하기 아주 좋다
public class StreamEx01Test {

    // bubble 정렬 -> 오름차순 정렬
    // for문을 돌면서 1번 돌 때, 배열의 앞/뒤의 값을 비교해서 큰 값을 맨 뒤로 보낸다.
    // 그래서 1번씩 돌 때마다 제일 큰 값이 맨 뒤로 착착 쌓인다.
    @Test
    public void ex05() {
        int[] a = { 1, 5, 8, 7, 3, 6, 4, 10, 11, 9 };
        int b;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {

            }
        }
    }

    // stream을 사용하지 않고 중복값 제거한 상태로 깊은 복사 하기
    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> newList = new ArrayList<>();

        // contains를 써서 앞에 newList에 같은 값이 없으면 add하기
        for (Integer i : list) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }
        System.out.println("list : " + list);
        System.out.println("newList : " + newList);

        // newList에 옮긴 다음 newList에서 동일한 값 제거하기
        for (Integer t : list) {
            newList.add(t);
        }

        for (int i = 0; i < newList.size(); i++) {
            for (int j = i + 1; j < newList.size(); j++) {
                if (newList.get(i) == newList.get(j)) {
                    newList.remove(j);
                }
            }
        }
        System.out.println("list : " + list);
        System.out.println("newList : " + newList);
    }

    // 얕은 복사, 깊은 복사
    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        // 얉은 복사 = 주소만 복사(새로운 데이터 생성 X, 같은 데이터의 주소를 가지고 있음)
        lowList = list;

        // 깊은 복사 = 값을 복사(새로운 데이터 생성 O, 다른 주소와 같은 데이터를 가지고 있음)
        for (Integer i : list) {
            highList.add(i);
        }

    }

    // distinct()
    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);

        Stream<Integer> stream = list.stream();
        stream.distinct().forEach(t -> {
            System.out.println("중복 제거된 배열 : " + t);
        });
    }

    // list -> stream 생성
    // Stream<Integer> stream = list.stream();
    @Test
    public void ex01() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(4);
        list.add(2);
        list.add(3);
        list.add(1);

        // list를 stream으로 생성
        Stream<Integer> stream = list.stream();

        // for문처럼 순회
        // = 람다식 O
        // add된 순서대로 들어온다.
        stream.forEach(t -> {
            // stream.forEach((t, d) -> {}); -> 매개변수가 2개일 때
            System.out.println(t);
        });
        // = 람다식 X
        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t);
            }
        });

        // consumer : stream을 소비
        // <> : 소비할 type
        // void accept(T t) = (t(매개변수) -> {}): 타입을 알 수 없음

    }
}
