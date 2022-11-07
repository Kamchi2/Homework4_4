package com.example.homework4_4.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter("key", "AIzaSyAdk0LAFlO0HpgBeP89iF-fKSk6KEkL4P4").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}