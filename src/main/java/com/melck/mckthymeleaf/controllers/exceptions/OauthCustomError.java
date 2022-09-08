package com.melck.mckthymeleaf.controllers.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OauthCustomError implements Serializable {

    private String error;

    @JsonProperty("error_description")
    private String errorDescription;

}
