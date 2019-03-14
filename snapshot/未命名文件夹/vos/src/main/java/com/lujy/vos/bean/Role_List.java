package com.lujy.vos.bean;

import java.util.Date;

public class Role_List {
    int id;
    String roleName;
    Date createAt;

    public Role_List(String roleName) {
        this.roleName = roleName;
    }

    public Role_List() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
