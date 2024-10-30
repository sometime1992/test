package org.example.springboottest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springboottest.entity.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBookListResponseDto {
    private Long id;
    private String author;
    private String title;
    private Category category;
}
