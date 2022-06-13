package com.mini.babmeokeon.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mini.babmeokeon.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;


import java.util.Date;

@RequiredArgsConstructor
public final class JwtTokenUtils {



    private static final int SEC = 1;
    private static final int MINUTE = 60 * SEC;
    private static final int HOUR = 60 * MINUTE;
    private static final int DAY = 24 * HOUR;

    // JWT 토큰의 유효기간: 3일 (단위: seconds)
    private static final int Access_TOKEN_VALID_SEC = 30 * MINUTE;
    private static final int RefreshToken_VALID_SEC = 3 * DAY;
    // JWT 토큰의 유효기간: 3일 (단위: milliseconds)


    public static final String CLAIM_EXPIRED_DATE = "EXPIRED_DATE";
    public static final String CLAIM_USER_NAME = "USER_NAME";
    public static final String JWT_SECRET = "jwt_secret_!@#$%";

    public static String generateAccessToken(UserDetailsImpl userDetails) {
        String AccessTOKEN = null;
        try {
            AccessTOKEN = JWT.create()
                    .withIssuer("sparta")
                    .withClaim(CLAIM_USER_NAME, userDetails.getUsername())
                     // 토큰 만료 일시 = 현재 시간 + 토큰 유효기간)
                    .withClaim(CLAIM_EXPIRED_DATE, new Date(System.currentTimeMillis() + Access_TOKEN_VALID_SEC))
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return AccessTOKEN;
    }

    public static String generateRefreshToken(UserDetailsImpl userDetails) {
        String RefreshToken = null;
        try {
            RefreshToken = JWT.create()
                    .withIssuer("sparta")
                    // 토큰 만료 일시 = 현재 시간 + 토큰 유효기간)
                    .withClaim(CLAIM_EXPIRED_DATE, new Date(System.currentTimeMillis() + RefreshToken_VALID_SEC))
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return RefreshToken;
    }

    private static Algorithm generateAlgorithm() {
        return Algorithm.HMAC256(JWT_SECRET);
    }
}
