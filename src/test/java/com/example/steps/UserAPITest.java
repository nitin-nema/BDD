package com.example.steps;

public class UserAPITest {

    private UserAPI userapi = new UserAPI();

    @Test
    public void testGetUser(){
        Response response = userAPI.getRequest("http://api.example.com/user");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testCreateUser(){
        String payload = "{\"name\":\"John\"}";
        Response response = userAPI.postRequest("http://api.example.com/user");
        Assert.assertEquals(201, response.getStatusCode());
    }


}
