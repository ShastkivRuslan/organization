package com.project.opportunities.dto.user;

import com.project.opportunities.validation.matcher.PasswordMatcher;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

@PasswordMatcher
public record UserRegistrationRequestDto(
        @NotBlank
        @Email
        @Length(min = 5, max = 50)
        String email,
        @NotBlank
        @Length(min = 8, max = 30)
        String password,
        @NotBlank
        @Length(min = 8, max = 30)
        String repeatPassword,
        @NotBlank
        @Length(max = 30)
        String firstName,
        @NotBlank
        @Length(max = 30)
        String lastName,
        @NotBlank
        @Length(max = 30)
        String middleName,
        MultipartFile avatar) {
}
