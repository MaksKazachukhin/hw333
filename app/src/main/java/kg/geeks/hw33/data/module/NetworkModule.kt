package kg.geeks.hw33.data.module

import kg.geeks.hw33.data.api.CharacterApiService
import kg.geeks.hw33.repository.CharacterRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.sin

val networkModule = module {
    single { provideLoggingInterceptor() } // Добавляем interceptor
    single { provideOkHttpClient(get()) } // Передаём interceptor в OkHttpClient
    single { provideRetrofit(get()) } // Передаём OkHttpClient в Retrofit

    single { get<Retrofit>().create(CharacterApiService::class.java) } // API сервис
    single { CharacterRepository(get()) } // Репозиторий
}

private const val TIMEOUT_DURATION = 10L

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
