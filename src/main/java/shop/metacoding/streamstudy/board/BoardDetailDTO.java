package shop.metacoding.streamstudy.board;

// Entity 객체 -> DTO 변환

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Entity = DTO 객체가 같을 때, 굳이 DTO를 만드는 이유
// DTO는 화면에 뿌리는 데이터로 깊은 복사를 하는 것이다. (★생성자로 넘기는 것이 깊은 복사★)
// 1. 유지보수할 때 추가 또는 제거해야하는 객체가 있을 때, Entity를 건드리지 않고 추가/제거 할 수 있다.
// 2. Entity에 없는 추가 사항을 화면에 뿌릴 수 있다.
// 3. Entity 자체에 get을 요청하는 JSON이나 RestController, MessageConverter 등으로 인해 발생하는 LazyLoading을 막을 수 있다.
// 왜냐하면 관계에 상관없이 데이터만을 DTO에 옮겨서 사용하기 때문에

@Getter
@Setter
@ToString // 객체를 sysout하면 toString이 자동 호출 됨.
public class BoardDetailDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;
    // private String warning; // author.equals("ssar") -> 블랙리스트 주의 요망

    // ★ DTO에는 @Builder를 사용하지 않는다.
    // 이렇게 하면 @Builder를 사용하지 않고, board 객체 만으로 담을 수 있다.
    public BoardDetailDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }
}
