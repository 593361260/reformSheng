package org.kevin.module.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kevin.module.comment.BaseConstant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class RetrofitFactory private constructor() {

    companion object {
        val instances by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor = Interceptor {
        it.proceed(
            it.request().newBuilder().addHeader(
                "Content-Type",
                "application/x-www-form-urlencoded"
            ).addHeader("charset", "utf-8")
                .build()
        )
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BaseConstant.PORT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    private fun initClient(): OkHttpClient {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts =
            arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate?> {
                    return arrayOfNulls(0)
                }
            })
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(
            null, trustAllCerts,
            SecureRandom()
        )
        val sslSocketFactory = sslContext
            .socketFactory



         /*TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
trustManagerFactory.init((KeyStore) null);
TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
}
X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
SSLContext sslContext = SSLContext.getInstance("SSL");
sslContext.init(null, new TrustManager[] { trustManager }, null);
SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();*/


        return OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(initLogIntercept())
            .connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS)
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
            .build()
    }

    private fun initLogIntercept(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    fun <T> create(server: Class<T>): T = retrofit.create(server)

}