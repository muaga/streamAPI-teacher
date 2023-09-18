package shop.metacoding.streamstudy.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import shop.metacoding.streamstudy.board.Board;
import shop.metacoding.streamstudy.board.BoardDetailDTO;
import shop.metacoding.streamstudy.board.BoardListDTO;

public class StreamEx03Test {

    // Entity List -> DTO 변환
    @Test
    public void ex02() {
        Board b1 = Board.builder()
                .id(1)
                .title("제목 1")
                .content("내용 1")
                .author("ssar")
                .build();

        Board b2 = Board.builder()
                .id(2)
                .title("제목 2")
                .content("내용 2")
                .author("ssar")
                .build();

        Board b3 = Board.builder()
                .id(3)
                .title("제목 3")
                .content("내용 3")
                .author("cos")
                .build();

        List<Board> boardList = Arrays.asList(b1, b2, b3); // 자동 add
        List<BoardListDTO> responseDTOList = boardList.stream()
                .filter(board -> !board.getAuthor().equals("cos")) // author가 cos인 데이터는 제거
                .filter(board -> !board.getContent().contains("1")) // content에 "1"을 포함한 데이터는 제거
                .map(board -> new BoardListDTO(board)) // DTO를 new 해서 생성 -> board => boardListDTO 가공
                .collect(Collectors.toList());
        System.out.println(responseDTOList);
    }

    // Entity -> DTO 변환
    @Test
    public void ex01() {
        Board board = Board.builder()
                .id(1)
                .title("제목 1")
                .content("내용")
                .author("ssar")
                .build();

        BoardDetailDTO responseDTO = new BoardDetailDTO(board);
        System.out.println("reponseDTO : " + responseDTO);
    }
}
