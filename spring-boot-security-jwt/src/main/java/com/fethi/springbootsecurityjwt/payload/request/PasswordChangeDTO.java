package com.fethi.springbootsecurityjwt.payload.request;

import jakarta.validation.constraints.Size;

public class PasswordChangeDTO {
    @Size(min = 6, max = 40)
    private String currentPassword;
    @Size(min = 6, max = 40)
    private String newPassword;

    public PasswordChangeDTO() {

    }

    public PasswordChangeDTO(String currentPassword, String newPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
