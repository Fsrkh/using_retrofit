package com.example.usingretrofit.api

import com.example.usingretrofit.response.MoviesListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("movies/popular")
    fun getPopularMovie(@Query("page") page : Int) : Call<MoviesListResponse>
}

/*This code defines an interface called ApiServices which contains a single method called getPopular
Movie.

The @GET annotation is used to specify the HTTP GET request method and the URL endpoint
"movies/popular". The @Query annotation is used to specify a query parameter called "page" which
will be passed as a parameter to the method.


The method returns a Call<MoviesListResponse>, which means that it will make an asynchronous HTTP
request and receive a response of type MoviesListResponse. The MoviesListResponse is a custom class
or data model that represents the response data from the API.


Overall, this code defines a network API service method for retrieving popular movies.
It expects an integer parameter for the page number and returns a Call object that represents the
API request and response.
 */