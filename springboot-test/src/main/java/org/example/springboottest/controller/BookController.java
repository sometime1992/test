package org.example.springboottest.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.common.constant.ApiMappingPattern;
import org.example.springboottest.dto.request.PostBookRequestDto;
import org.example.springboottest.dto.request.PostBookResponseDto;
import org.example.springboottest.dto.response.GetBookListResponseDto;
import org.example.springboottest.dto.response.GetBookResponseDto;
import org.example.springboottest.entity.Category;
import org.example.springboottest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.BOOK)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 생성자 주입 - RequiredArgsConstructor로 대체
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    // 책 생성
    @PostMapping
    public ResponseEntity<GetBookResponseDto<GetBookListResponseDto>> createBook(@RequestBody PostBookRequestDto requestDto) {
        GetBookResponseDto<GetBookListResponseDto> result = bookService.createBook(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 전체 책 조회
    @GetMapping
    public ResponseEntity<List<GetBookListResponseDto>> getAllBooks() {
        List<GetBookListResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 제목에 특정 단어가 포함된 책 조회
    @GetMapping("/search/title")
    public ResponseEntity<List<GetBookListResponseDto>> getBooksByTitleContaining(
            @RequestParam String keyword
    ) {
        List<GetBookListResponseDto> books = bookService.getBooksByTitleContaining(keyword);
        return ResponseEntity.ok(books);
    }

}
