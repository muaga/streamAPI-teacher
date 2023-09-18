package shop.metacoding.streamstudy.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

// filter랑 map을 많이 쓴다 -> 이거만 그냥 써어...
public class StreamEx02Test {

    // skip() + limit() + peek()
    // paging할 수 있다.
    @Test
    public void ex05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream()
                .skip(1) // '1'을 무시하고 '2'부터 기준을 둔다.
                .peek(t -> {
                    System.out.println("peek : " + t);
                })
                .limit(2)
                .collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }

    // stream하는 과정 속에서 값이 잘 필터링이 되거나 연산작업이 진행되는 지 확인하고 싶을 때,
    // for-each는 void타입으로 return 값이 없어서 for-each 문으로 배열의 값을 확인하는 것은 힘들다.
    // peek은 stream 타입으로 return 값이 있어서, collect하기 전에 확인하고 싶을 때 사용한다.
    //

    // limit()
    @Test
    public void ex04() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().limit(2).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }

    // filter() + map()
    // filter -> 제거 / map -> 가공
    @Test
    public void ex03() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream()
                .filter(t -> t != 3) // t = 4건
                .map(t -> {
                    Integer r = t * 2;
                    return r;
                }) // t = 3건
                .collect(Collectors.toList());

        newList.stream().forEach(t -> System.out.println(t));

        // map : stream에 떠다니는 Integer인 R을 return한다.
    }

    // filter() - 3 제외
    @Test
    public void ex02() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> newList = list.stream().filter(t -> t != 3).collect(Collectors.toList());
        newList.stream().forEach(t -> System.out.println(t));
    }

    // filter() - 짝수 제외
    @Test
    public void ex01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // list.stream(); // 변수를 만들지 않고, stream에 담을 수 있다.

        // 필터링한 깊은 복사
        List<Integer> newList = list.stream().filter(t -> t % 2 != 0).collect(Collectors.toList());
        // stream(생성) -> filter(가공) -> collect(최종연산-수집)

        newList.stream().forEach(t -> System.out.println(t));

        // predicate : boolean 타입으로 true이면 물길에 놔두고, false면 물길에서 제거하자
        // boolean test(T t);

        // (t -> true) = (t -> {return true})
        // 람다식은 {}를 생략하면 -> 뒤의 값을 자동 return한다.
    }
}
