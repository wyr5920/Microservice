package com.user.entity;

import lombok.Data;

import java.util.List;

@Data
public class UserAuthoritiesInfo extends User{

    List<Authorities> PermissionList;
}
