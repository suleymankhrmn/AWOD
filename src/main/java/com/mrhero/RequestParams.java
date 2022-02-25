package com.mrhero;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestParams {
    private String url;
    private String method;
}
