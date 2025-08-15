package com.example.JournalApp.dto;

//import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty
//    @Schema(description = "The user's username", example = "john_doe")
    private String userName;

//    @Schema(description = "The user's email address", example = "john@example.com")
    private String email;

//    @Schema(description = "Whether sentiment analysis is enabled", example = "true")
    private boolean sentimentAnalysis;

    @NotEmpty
//    @Schema(description = "The user's password", example = "mypassword123")
    private String password;
}
