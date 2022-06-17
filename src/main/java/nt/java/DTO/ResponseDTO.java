package nt.java.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO<T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;
}
