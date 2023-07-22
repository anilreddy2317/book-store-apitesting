package api;

import models.Book;
import models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface ApiEndpoints {
    // Create a new user
    @POST("Account/v1/User")
    Call<User> createUser(@Body User user);

    // Generate authentication token for the user
    @POST("Account/v1/GenerateToken")
    Call<User> generateToken(@Body User user);

    // Get the list of books
    @GET("BookStore/v1/Books")
    Call<List<Book>> getBooks(@Header("Authorization") String authToken);

    // Filter books by publisher
    @GET("BookStore/v1/Books")
    Call<List<Book>> filterBooksByPublisher(@Header("Authorization") String authToken, @Query("publisher") String publisherName);

    // Filter books by author
    @GET("BookStore/v1/Books")
    Call<List<Book>> filterBooksByAuthor(@Header("Authorization") String authToken, @Query("author") String authorName);

    // Post books to the user in context
    @POST("BookStore/v1/Books/{isbn}")
    Call<Book> postBookToUser(@Header("Authorization") String authToken, @Path("userId") String userId, @Path("isbn") String isbn);
}
