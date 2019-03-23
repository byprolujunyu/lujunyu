package com.bm.container.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.bm.container.module.base.Entity.ContainerNoEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * 导入集装箱编号的txt文件为realm数据库
 */

public class ContainerNo extends IntentService {
    private Realm realm;

    public ContainerNo() {
        super("ContainerNo");
    }

    /**
     * 读取本地箱号文件
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        realm = Realm.getDefaultInstance();

        RealmResults<ContainerNoEntity> all1 = realm.where(ContainerNoEntity.class).findAll();
        if (all1.size() == 0) {
            try {
                InputStream is = getAssets().open("containerno.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String lineText = null;
                while ((lineText = reader.readLine()) != null) {
                    if (!lineText.isEmpty()) {
                        String temp = lineText;
                        realm = Realm.getDefaultInstance();
                        realm.executeTransaction(realm1 -> {
                            ContainerNoEntity no = realm1.createObject(ContainerNoEntity.class);
                            no.setNo(temp.split("=")[0]);
                            no.setNumber(temp.split("=")[1]);
                        });
                    }
                }
                reader.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//		RealmResults<ContainerNoEntity> all2 = realm.where(ContainerNoEntity.class).findAll();
//		RealmResults<ContainerNoEntity> all3 = realm.where(ContainerNoEntity.class).beginsWith("no", "c", Case.INSENSITIVE).findAll();
//		Log.e("箱型数据数量", "" + all2.size());
//		Log.e("试查询箱型数据C开头", "" + all3.size());

    }
}
