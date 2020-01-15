package org.example.controller;

import com.demo.mock.registration.api.TokenApi;
import com.demo.mock.registration.model.ComBawagAuthapiResourcesModelAuthenticationToken;
import org.springframework.http.ResponseEntity;

public class TokenApiController implements TokenApi {

    @Override
    public ResponseEntity<ComBawagAuthapiResourcesModelAuthenticationToken> token(String authorization,
                                                                                  String grantType,
                                                                                  String userAgent,
                                                                                  String xBawagpskVendorId,
                                                                                  String xBawagpskLanguage,
                                                                                  String username,
                                                                                  String password,
                                                                                  String refreshToken,
                                                                                  String scope,
                                                                                  String code,
                                                                                  String redirectUri,
                                                                                  String clientId) {
        return null;
    }
}
