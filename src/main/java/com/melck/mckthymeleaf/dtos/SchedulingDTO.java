package com.melck.mckthymeleaf.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingDTO {


    @NotBlank(message = "the scheduleDate field cannot be empty")
    @Future(message = "type a valid date")
    @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss")
    private String schedulingTime;
    private Long userId;
    private Long doctorId;
    private String schedulingDate;

}
