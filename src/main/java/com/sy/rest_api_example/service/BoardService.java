package com.sy.rest_api_example.service;

import com.sy.rest_api_example.annotation.CurrentUser;
import com.sy.rest_api_example.dto.BoardDTO;
import com.sy.rest_api_example.entity.Board;
import com.sy.rest_api_example.entity.Member;
import com.sy.rest_api_example.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    public BoardDTO save(BoardDTO boardDTO,
                         @CurrentUser Member member) {
        log.debug("Create Board", boardDTO);

        boardDTO.setCrePsPid(member.getId());

        Board board = modelMapper.map(boardDTO, Board.class);

        Board save = boardRepository.save(board);
        BoardDTO result = modelMapper.map(save, BoardDTO.class);

        return result;
    }
}
