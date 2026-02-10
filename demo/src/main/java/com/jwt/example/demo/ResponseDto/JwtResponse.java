package com.jwt.example.demo.ResponseDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {

    private String username;

    private String jwtToken;
}
