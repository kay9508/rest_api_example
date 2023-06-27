package com.sy.rest_api_example.service;

import com.sy.rest_api_example.dto.BoardDTO;
import com.sy.rest_api_example.entity.Board;
import com.sy.rest_api_example.entity.Member;
import com.sy.rest_api_example.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    public List<BoardDTO> findAll() {
        List<Board> findAll = boardRepository.findAll();
        List<BoardDTO> result = findAll.stream().map(a -> modelMapper.map(a, BoardDTO.class)).collect(Collectors.toList());
        return result;
    }

    public BoardDTO save(BoardDTO boardDTO,
                         Member member) {
        log.debug("Create Board", boardDTO);

        boardDTO.setCrePsPid(member.getId());

        Board board = modelMapper.map(boardDTO, Board.class);
        board.setMember(member);
        board.setDelAt(false);

        Board save = boardRepository.save(board);
        BoardDTO result = modelMapper.map(save, BoardDTO.class);

        return result;
    }

    public BoardDTO update(BoardDTO boardDTO,
                           Member member) {
        log.debug("Update Board", boardDTO);

        Optional<Board> load = boardRepository.findById(boardDTO.getId());
        Boolean isUpdate = false;

        if (load.isPresent()) {
            if (boardDTO.getTitle() != null) {
                load.get().setTitle(boardDTO.getTitle());
                isUpdate = true;
            }

            if (boardDTO.getContent() != null) {
                load.get().setContent(boardDTO.getContent());
                isUpdate = true;
            }

            if (isUpdate) {
                load.get().setModPsPid(member.getId());
            }
        } else {
            return null;
        }

        BoardDTO result = modelMapper.map(load.get(), BoardDTO.class);

        return result;
    }

    public BoardDTO logicalDelete(BoardDTO boardDTO,
                                                  Member member) {
        log.debug("LogicalDelete Board", boardDTO);

        Optional<Board> load = boardRepository.findById(boardDTO.getId());
        if (load.isPresent()) {
            load.get().delete();
            load.get().setModPsPid(member.getId());
        } else {
            return null;
        }

        BoardDTO result = modelMapper.map(load.get(), BoardDTO.class);

        return result;
    }
}
