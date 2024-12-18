package com.project.opportunities.controller.quest;

import com.project.opportunities.dto.user.UserLoginRequestDto;
import com.project.opportunities.dto.user.UserLoginResponseDto;
import com.project.opportunities.dto.user.UserRegistrationRequestDto;
import com.project.opportunities.dto.user.UserResponseDto;
import com.project.opportunities.security.AuthenticationService;
import com.project.opportunities.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication",
        description = "Endpoints for managing members authentication and registration")
@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @Operation(
            summary = "Register a new team member",
            description = "This endpoint registers a new team member by "
            + "providing the registration details."
    )
    @PostMapping(value = "/registration", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserResponseDto register(@ModelAttribute @Valid UserRegistrationRequestDto requestDto) {
        return userService.register(requestDto);
    }

    @Operation(
            summary = "Login team member",
            description = "This endpoint allows team member to "
            + "login by providing their credentials."
    )
    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }
}
