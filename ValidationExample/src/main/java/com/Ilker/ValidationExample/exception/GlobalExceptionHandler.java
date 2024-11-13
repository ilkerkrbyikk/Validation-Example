package com.Ilker.ValidationExample.exception;

import com.Ilker.ValidationExample.api.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue ){
        list.add(newValue);
        return list;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String, List<String>> errorsMap = new HashMap<>();
        for(ObjectError objectError: e.getBindingResult().getAllErrors()){
           String fieldName = ((FieldError)objectError).getField();
           if (errorsMap.containsKey(fieldName)){
               errorsMap.put(fieldName,addMapValue(errorsMap.get(fieldName),objectError.getDefaultMessage()));
           }else {
               errorsMap.put(fieldName,addMapValue(new ArrayList<>(),objectError.getDefaultMessage()));
           }

        }
        return ResponseEntity.badRequest().body(createApiError(errorsMap));
    }

    private ApiError createApiError(Map<String,List<String>> errors){
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
