package tests;

import api.ApiClient;
import api.ApiEndpoints;
import com.google.gson.stream.JsonReader;
import models.Book;
import models.User;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import utils.TestData;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookStoreTest {
    private final ApiEndpoints apiService = ApiClient.getApiService();

    @Test
    public void testBookstoreBackend() throws IOException {
        // Create a new user
        User newUser = new User(TestData.USERNAME, TestData.PASSWORD);
        System.out.println("newUser Response: " + newUser);
        Call<User> createUserCall = apiService.createUser(newUser);
        System.out.println("createUserCall Response: " + createUserCall);
        Response<User> createUserResponse = createUserCall.execute();
        System.out.println("createUserResponse Response: " + createUserResponse);
        assertTrue(createUserResponse.isSuccessful());
        User createdUser = createUserResponse.body();

        // Generate authentication token for the user
        Call<User> generateTokenCall = apiService.generateToken(newUser);
        Response<User> generateTokenResponse = generateTokenCall.execute();

        assertTrue(generateTokenResponse.isSuccessful());
        assert generateTokenResponse.body() != null;
        String authToken = generateTokenResponse.body().getAuthToken();

        // Get the list of books
        Call<List<Book>> getBooksCall = apiService.getBooks(authToken);
        Response<List<Book>> getBooksResponse = getBooksCall.execute();
        System.out.println("JSON Response: " + getBooksResponse.body());
        assertTrue(getBooksResponse.isSuccessful());
        List<Book> books = getBooksResponse.body();

        // Filter books by publisher
        String publisherName = TestData.PUBLISHER_NAME;
        Call<List<Book>> filterBooksByPublisherCall = apiService.filterBooksByPublisher(authToken, publisherName);
        Response<List<Book>> filterBooksByPublisherResponse = filterBooksByPublisherCall.execute();

        assertTrue(filterBooksByPublisherResponse.isSuccessful());
        List<Book> booksFilteredByPublisher = filterBooksByPublisherResponse.body();

        // Filter books by author
        String authorName = TestData.AUTHOR_NAME;
        Call<List<Book>> filterBooksByAuthorCall = apiService.filterBooksByAuthor(authToken, authorName);
        Response<List<Book>> filterBooksByAuthorResponse = filterBooksByAuthorCall.execute();

        assertTrue(filterBooksByAuthorResponse.isSuccessful());
        List<Book> booksFilteredByAuthor = filterBooksByAuthorResponse.body();

        // Post books to the user in context (add books to the user's collection)
        for (Book book : books) {
            Call<Book> postBookCall = apiService.postBookToUser(authToken, createdUser.getUserId(), book.getIsbn());
            Response<Book> postBookResponse = postBookCall.execute();

            assertTrue(postBookResponse.isSuccessful());
            Book postedBook = postBookResponse.body();
            assert postedBook != null;
            assertEquals(book.getIsbn(), postedBook.getIsbn());
            // Add more verifications if needed
        }
    }
}
