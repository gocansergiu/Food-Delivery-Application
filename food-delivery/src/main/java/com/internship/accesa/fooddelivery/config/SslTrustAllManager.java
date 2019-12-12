package com.internship.accesa.fooddelivery.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

@Component
public class SslTrustAllManager {

    private static final Logger logger = LoggerFactory.getLogger(SslTrustAllManager.class);

    private SSLContext sslContext;

    public SslTrustAllManager(@Value("${spring.security.trust-all-certificates}") Boolean trustAll){
        if(trustAll != null && trustAll.booleanValue()){
            TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                        public void checkClientTrusted(
                                X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(
                                X509Certificate[] certs, String authType) {
                        }
                    }
            };

            try {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

                this.sslContext = sc;
            }
            catch (GeneralSecurityException e) {

                logger.warn("[EXCEPTION] - Unable to trust all SSL certs", e);
            }
        }
    }

    public SSLContext getSSLContext(){
        return this.sslContext;
    }
}
