package org.example.springboottest.service;


import lombok.RequiredArgsConstructor;
import org.example.springboottest.common.constant.ResponseMessage;
import org.example.springboottest.dto.request.PostBookRequestDto;
import org.example.springboottest.dto.request.PostBookResponseDto;
import org.example.springboottest.dto.response.GetBookListResponseDto;
import org.example.springboottest.dto.response.GetBookResponseDto;
import org.example.springboottest.entity.Book;
import org.example.springboottest.entity.Category;
import org.example.springboottest.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public GetBookResponseDto<GetBookListResponseDto> createBook(PostBookRequestDto requestDto) {
        Book book = new Book(
                null, requestDto.getAuthor(), requestDto.getTitle(),
                requestDto.getCategory()
        );

        Book savedBook = bookRepository.save(book);
        return GetBookResponseDto.setSuccess(ResponseMessage.SUCCESS, convertToResponseDto(savedBook));
    }

    public List<GetBookListResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    public List<GetBookListResponseDto> getBooksByTitleContaining(String keyword) {
        List<Book> books = bookRepository.findByTitleContaining(keyword);
        return books.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    private GetBookListResponseDto convertToResponseDto(Book book) {
        return new GetBookListResponseDto(
                book.getId(), book.getAuthor(), book.getTitle()
                , book.getCategory()
        );
    }
}
