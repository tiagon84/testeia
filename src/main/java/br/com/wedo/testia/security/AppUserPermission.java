package br.com.wedo.testia.security;

public enum AppUserPermission {
    READ("read"),
    WRITE("write");

    private final String permission;

    AppUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
