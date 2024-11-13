package com.Ilker.ValidationExample.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private String id;
    private Date errorTime;
    private Map<String, List<String>> errors;


}
