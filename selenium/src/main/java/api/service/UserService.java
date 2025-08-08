package api.service;

import api.clients.HttpClientWrapper;
import api.config.ApiEndpoints;
import api.model.UserDTO;

import java.net.http.HttpClient;
import java.util.List;

public class UserService {
    private final HttpClientWrapper httpClient;

    public UserService(HttpClientWrapper httpClient) {
        this.httpClient = httpClient;
    }

    public List<UserDTO> GetAllUser() {
        String endpoint = ApiEndpoints.User.GetAll();
        return httpClient.getList(endpoint, UserDTO.class);
    }

    public UserDTO GetUserById(String userId) {
        String endpoint = ApiEndpoints.User.GetById(userId);
        return httpClient.get(endpoint, UserDTO.class);
    }

    public UserDTO CreateUser(UserDTO newUser) {
        String endpoint = ApiEndpoints.User.CreateUser();
        return httpClient.post(endpoint, newUser, UserDTO.class);
    }

    public UserDTO UpdateUserById(String userId, UserDTO updatedUser) {
        String endpoint = ApiEndpoints.User.UpdateById(userId);
        return httpClient.put(endpoint, updatedUser, UserDTO.class);
    }
    public UserDTO DeleteUserById(String userId) {
        String endpoint = ApiEndpoints.User.DeleteById(userId);
        return httpClient.delete(endpoint, UserDTO.class);
    }
}
