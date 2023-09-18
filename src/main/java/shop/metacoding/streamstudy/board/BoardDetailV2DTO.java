package shop.metacoding.streamstudy.board;

// Entity + Entity 객체 -> DTO in DTO

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shop.metacoding.streamstudy.user.User;

// board(id, title, content), user(id, username), isOwner
@Getter
@Setter
@ToString
public class BoardDetailV2DTO {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private UserDTO user;
    // User도 DTO를 만드는 이유 : DTO 속에 Entity를 사용하면, Entity의 모든 것이 노출된다.
    private boolean isOwner;

    public BoardDetailV2DTO(Board board, Integer sessionId) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();

        this.user = new UserDTO(board.getUser());

        // 게시물의 주인과 로그인한 유저가 일치한 지의 true/false
        this.isOwner = board.getUser().getId() == sessionId;
    }

    // 내부 DTO
    // DTO 속 DTO는 static을 사용할 필요가 없다. BoardDetailV2DTO에만 사용할 DTO이기 때문에,
    // 즉 내부 DTO라서
    @Getter
    @Setter
    public class UserDTO {
        private Integer id;
        private String username;

        public UserDTO(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }
}
