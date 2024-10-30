package org.example.springboottest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName="set")
public class GetBookResponseDto<D> {
    private boolean result;
    private String message;
    private D data;

    public static <D> GetBookResponseDto<D> setSuccess(String message, D data) {
        return GetBookResponseDto.set(true, message, data);
    }

    public static <D> GetBookResponseDto<D> setFailed(String message) {
        return GetBookResponseDto.set(false, message, null);
    }
}
