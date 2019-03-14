package com.bm.container.module.base.Entity;

import io.realm.RealmObject;

/**
 * Created by nfmomo on 17/3/31.
 */

public class ContainerNoEntity extends RealmObject {

    private String no;
    private String number;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
