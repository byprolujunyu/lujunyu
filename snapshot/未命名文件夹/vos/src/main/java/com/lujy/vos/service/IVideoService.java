package com.lujy.vos.service;


import com.lujy.vos.bean.Role_List;
import com.lujy.vos.bean.TVideo;
import com.lujy.vos.result.Result;

import java.util.List;

public interface IVideoService {

    Result<?> query(String role);

    Result<?> insert(TVideo video);

    Result<?> createRole(Role_List roleName);

    Result<?> queryRoles();

    Result<?> list();

    Result<?> updateMeans(Integer id, String means);

    Result<?> saveById(Integer id);

    Result<?> deleteById(Integer id);

    Result<?> getsBySave();

    Result<?> selectBySaveId(int id);

    Result    findItemByPage(int currentPage, int pageSize);
}
