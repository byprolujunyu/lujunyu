package com.lujy.vos.dao;

import com.lujy.vos.bean.Role_List;
import com.lujy.vos.bean.TVideo;
import com.lujy.vos.bean.TVideoExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface TVideoMapper {

    int SAVE = 1;
    int REMOVE = 0;

    @Select("select * from t_video where role = #{role}")
    List<TVideo> select(@Param("role") String role);

    @Insert("INSERT INTO mydatabase.t_video (uri, `date`, flagDelete, means, imguri, md5, isNew, createtime, `role`, role_id ,uptat,isSave) VALUES(#{uri}, now(), #{flagdelete},#{means}, #{imguri}, #{md5}, 0, #{createtime}, #{role}, #{role_id},now(),0)")
    int insert(TVideo video);

    @Select("SELECT id, roleName, createAt FROM mydatabase.role_list")
    List<Role_List> getRoles();

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", resultType = int.class, before = false)
    @Insert("INSERT INTO mydatabase.role_list (roleName, createAt) VALUES(#{roleName}, now())")
    int createRoles(Role_List list);

    @Select("select * from `t_video` where flagDelete = 0 ORDER BY createtime desc ,uptat desc")
    List<TVideo> getListByTime();

    @Update("update `t_video` set  uptat = now() where id = #{id}")
    int updateTime(int id);

    @Update("update `t_video` set  means = #{means} where id = #{id}")
    int updateMeans(Integer id, String means);

    @Update("update `t_video` set isSave = #{type} where id = #{id}")
    int updateSave(@Param("id") int id, @Param("type") int type);

    @Select("select * from `t_video` where isSave = 1 and flagDelete = 0 ORDER BY createtime desc ,uptat desc")
    List<TVideo> selectBySave();

    @Select("select isSave from `t_video` where id = #{id}")
    int selectBySaveId(int id);

    @Select("select count(*) from t_video where flagDelete = 0")
    int countItem();


    @Select("select * from `t_video` where flagDelete = 0 ORDER BY createtime desc ,uptat desc limit #{offset},#{pagesize}")
    List<TVideo> queryByPage(@Param("offset") int offset, @Param("pagesize") int pagesize);

    @Select("select * from `t_video` where flagDelete = 0 ORDER BY createtime desc")
    List<TVideo> findAll();
}