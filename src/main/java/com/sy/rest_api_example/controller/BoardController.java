package com.sy.rest_api_example.controller;

import com.sy.rest_api_example.annotation.CurrentUser;
import com.sy.rest_api_example.dto.BoardDTO;
import com.sy.rest_api_example.entity.Member;
import com.sy.rest_api_example.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<List<BoardDTO>> getAllBoards() {
        log.debug("getAllBoards : {}");
        List<BoardDTO> result = boardService.findAll();
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/board")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO,
                                                      @CurrentUser Member member) {
        log.debug("save Board : {}", boardDTO);
        BoardDTO result = boardService.save(boardDTO, member);
        return ResponseEntity.ok().body(result);
    }

}
