package tests.api.MockAPI;

import api.clients.HttpClientWrapper;
import api.config.BaseUrl;
import api.model.UserDTO;
import api.service.UserService;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.LogUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class MockUserAPI {
    public UserService userService;


    @BeforeClass
    public void setup() {
        String mockApiUrl = BaseUrl.MockAPI;
        HttpClientWrapper httpClient = new HttpClientWrapper(mockApiUrl);
        userService = new UserService(httpClient);
        LogUtils.info("✅ Initialized UserService with baseURL: " + mockApiUrl);
    }

    @Test(description = "Get All Users")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GET /user")
    public void testGetAllUsers() {
        List<UserDTO> users = userService.GetAllUser();
        LogUtils.info("⬅️ Received " + users.size() + " users from API.");
        Assert.assertNotNull(users, "User list should not be null");
        Assert.assertTrue(users.size() > 0, "User list should not be empty");

        for (UserDTO user : users) {
            LogUtils.info("👤 User: " + user.getUserId() + " - " + user.getUserName());
        }
    }

    @Test(description = "Get User By ID")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GET /user/{id}")
    public void testGetUserById() {
        String testUserId = "1";
        UserDTO user = userService.GetUserById(testUserId);
        LogUtils.info("⬅️ Received response: " + user);
        Assert.assertNotNull(user, "User should not be null");
        Assert.assertEquals(user.getUserId(), testUserId, "User ID should match");
        LogUtils.info("✅ Test passed: User info = " + user.getUserName());
    }

    @Test(description = "Create User")
    @Severity(SeverityLevel.NORMAL)
    @Story("POST /user")
    public void testCreateUser() {
        UserDTO newUser = new UserDTO();
        newUser.setUserName("Do Thuan");
        newUser.setUserEmail("dothuan@example.com");
        newUser.setUserAddress("HCM");
        newUser.setUserPhone("0123456789");
        newUser.setUserBir(System.currentTimeMillis());
        newUser.setActive(true);
        // newUser.setUserSubject(...) nếu cần

        UserDTO createdUser = userService.CreateUser(newUser);

        LogUtils.info("✅ Created user: " + createdUser);
        Assert.assertNotNull(createdUser.getUserId(), "Created user should have an ID");
        Assert.assertEquals(createdUser.getUserName(), newUser.getUserName(), "User name should match");
    }

    @Test(description = "Update User By ID")
    @Severity(SeverityLevel.NORMAL)
    @Story("PUT /user/{id}")
    public void testUpdateUserById() {
        List<UserDTO> users = userService.GetAllUser();
        Assert.assertFalse(users.isEmpty(), "User list should not be empty");
        int randomIndex = ThreadLocalRandom.current().nextInt(users.size());
        UserDTO userToBeUpdate = users.get(randomIndex);
        String userId = userToBeUpdate.getUserId();

        UserDTO updatedInfo = new UserDTO();
        updatedInfo.setUserId(userId);
        updatedInfo.setUserName("Updated Name");
        updatedInfo.setUserAddress("HCM");

        UserDTO updatedUser = userService.UpdateUserById(userId, updatedInfo);

        LogUtils.info("✅ Updated user: " + updatedUser);
        Assert.assertEquals(updatedUser.getUserId(), userId, "✅ ID sau khi cập nhật phải đúng");
        Assert.assertEquals(updatedUser.getUserName(), "Updated Name", "✅ Tên sau khi cập nhật phải đúng");
    }

    @Test(description = "Delete User By ID")
    @Severity(SeverityLevel.CRITICAL)
    @Story("DELETE /user/{id}")
    public void testDeleteUserById() {
        List<UserDTO> users = userService.GetAllUser();
        Assert.assertFalse(users.isEmpty(), "User list should not be empty");
        int randomIndex = ThreadLocalRandom.current().nextInt(users.size());
        UserDTO userToDelete = users.get(randomIndex);
        String userId = userToDelete.getUserId();
        LogUtils.info("🗑️ Deleting user with ID: " + userId);
        UserDTO deletedUser = userService.DeleteUserById(userId);
        LogUtils.info("✅ Deleted user: " + deletedUser);
        Assert.assertEquals(deletedUser.getUserId(), userId, "Deleted user ID should match");
    }
}
