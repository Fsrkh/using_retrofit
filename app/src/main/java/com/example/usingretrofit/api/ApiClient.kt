package com.example.usingretrofit.api

import com.example.usingretrofit.utils.Constants.API_KEY
import com.example.usingretrofit.utils.Constants.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit: Retrofit

    private val requestInterceptor = Interceptor{chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return@Interceptor chain.proceed(request)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(requestInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
    fun getClient(): Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}
/*This code defines a class called `ApiClient`. This class is responsible for creating and
configuring a Retrofit client that can be used to make HTTP requests to a web API.

The class has a private property `retrofit` which is of type `Retrofit`. It is initially declared
with the `lateinit` modifier, which means that the property will be assigned a value later on before
 it is accessed.

There is also a private property `requestInterceptor` which is an HTTP interceptor. Interceptors can
 modify the request before it is sent or the response before it is received. In this case, the
 interceptor adds a query parameter, `api_key`, to the URL and builds a new request with the
 modified URL.

The code defines an `okHttpClient` property, which is an instance of `OkHttpClient.Builder`.
This is a HTTP client that is responsible for making the actual HTTP requests. The builder is
configured with the `requestInterceptor`, a connection timeout of 60 seconds, and then builds an
instance of `OkHttpClient`.

Finally, the class has a `getClient()` function that returns an instance of `Retrofit`. It uses the
`retrofit` property to check if `Retrofit` has already been initialized. If not, it creates a new
instance of `Retrofit`. The `retrofit` instance is configured with the base URL of the API, the
`okHttpClient` instance, and a `GsonConverterFactory` to convert the JSON response to objects.
The function then returns the `retrofit` instance.

Overall, this code sets up an `ApiClient` class that can be used to create an instance of `Retrofit`
, which can be used to make API requests with the provided base URL and API key.
 */