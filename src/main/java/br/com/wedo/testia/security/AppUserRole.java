package br.com.wedo.testia.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static br.com.wedo.testia.security.AppUserPermission.READ;
import static br.com.wedo.testia.security.AppUserPermission.WRITE;

public enum AppUserRole {
    DEFAULT(Sets.newHashSet(READ)),
    ADMIN(Sets.newHashSet(READ,WRITE));

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
