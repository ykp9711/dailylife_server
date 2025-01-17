package com.dailylife.domain.reply.controller;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.dto.BoardUpdateRequest;
import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.board.service.BoardService;
import com.dailylife.domain.reply.dto.ReplyDeleteRequest;
import com.dailylife.domain.reply.dto.ReplyGetRequest;
import com.dailylife.domain.reply.dto.ReplyGetResponse;
import com.dailylife.domain.reply.dto.ReplyInsertRequest;
import com.dailylife.domain.reply.entity.Reply;
import com.dailylife.domain.reply.service.ReplyService;
import com.dailylife.domain.user.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reply")
@RequiredArgsConstructor
@Api(tags = "Reply API")
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation(value = "댓글 작성", notes = "댓글 작성")
    @PostMapping("/insert")
    public ResponseEntity<Reply> createBoard(@Valid @RequestBody ReplyInsertRequest replyInsertRequest){
        return ResponseEntity.ok(replyService.insert(replyInsertRequest));
    }

    @ApiOperation(value = "댓글 삭제", notes = "작성한 댓글을 삭제하기 위해서 댓글 PK (replyNum)넘겨 주시면 됩니다.")
    @DeleteMapping("/delete/{replyNum}")
    public ResponseEntity<Boolean> deleteReply(@PathVariable("replyNum")Long replyNum, ReplyDeleteRequest replyDeleteRequest){
        return ResponseEntity.ok(replyService.delete(replyNum));
    }

    @ApiOperation(value = "댓글 확인", notes = "게시물 댓글 확인을 위해서 게시물번호 PK (boardNum)넘겨 주시면 됩니다.")
    @GetMapping("/getReply/{boardNum}")
    public ResponseEntity<List<ReplyGetResponse>> getReply(@PathVariable("boardNum")Long boardNum){
        return ResponseEntity.ok(replyService.getReplyList(boardNum));
    }

}
