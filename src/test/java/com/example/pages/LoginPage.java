// src/test/java/com/example/pages/LoginPage.java
package com.example.pages;

public class LoginPage {

    public void navigateToLogin() {
        // Code to navigate to the login page, e.g., using Selenium WebDriver
    }

    public DashboardPage login(String username, String password) {
        // Code to enter username and password and submit
        // Return a new DashboardPage object
        return new DashboardPage();
    }

    public String loginWithInvalidPassword(String username, String password) {
        // Code to enter username and invalid password and submit
        // Return the error message displayed
        return "Invalid credentials";
    }

    public String loginWithNonExistentUser(String username, String password) {
        // Code to enter non-existent username and any password and submit
        // Return the error message displayed
        return "User does not exist";
    }
}

// src/test/java/com/example/pages/DashboardPage.java
package com.example.pages;

public class DashboardPage {

    public boolean isDisplayed() {
        // Code to verify if the dashboard is displayed
        return true;
    }
}
