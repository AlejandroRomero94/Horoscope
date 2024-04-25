package com.alejandro.horoscapp.data.network

import com.alejandro.horoscapp.BuildConfig.BASE_URL
import com.alejandro.horoscapp.data.RepositoryImpl
import com.alejandro.horoscapp.data.core.interceptors.AuthInterceptor
import com.alejandro.horoscapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit (okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
@Provides

@Singleton
fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
    val interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
   return OkHttpClient
       .Builder()
       .addInterceptor(interceptor)
       .addInterceptor(authInterceptor)
       .build()

}




    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
       return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImpl(apiService)
    }


}