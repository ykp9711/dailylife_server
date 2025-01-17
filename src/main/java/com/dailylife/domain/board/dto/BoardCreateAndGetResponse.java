package com.dailylife.domain.board.dto;


import com.dailylife.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "게시물 작성시 응답 객체 ")
@Builder
public class BoardCreateAndGetResponse {

    private String title;
    private String content;
    private List<String> originalFileName;
    private List<String> serverFileUrl;
    private boolean heart;
    private Long boardNum;

    public static BoardCreateAndGetResponse from(Board board , List<String> originalFileName , List<String> serverFileUrl, boolean heart) {
        return BoardCreateAndGetResponse.builder()
                .boardNum(board.getBoardNum())
                .title(board.getTitle())
                .content(board.getContent())
                .originalFileName(originalFileName)
                .serverFileUrl(serverFileUrl)
                .heart(heart).build();
    }

}
