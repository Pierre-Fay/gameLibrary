package fr.eni.gamelibrary.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private Boolean status;
    private String message;
    private T data;
}
