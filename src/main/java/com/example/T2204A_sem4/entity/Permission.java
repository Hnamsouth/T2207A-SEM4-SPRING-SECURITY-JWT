package com.example.T2204A_sem4.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    BDH("admin:read"),

    NHAN_VIEN_THU_VIEN("admin:update"),
    NHAN_VIEN_TUYEN_SINH("admin:create"),

    GIAO_VIEN("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
