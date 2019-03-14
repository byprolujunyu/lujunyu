package com.lujy.vos.service;


import com.github.pagehelper.PageHelper;
import com.lujy.vos.bean.PageBean;
import com.lujy.vos.bean.Role_List;
import com.lujy.vos.bean.TVideo;
import com.lujy.vos.dao.TVideoMapper;
import com.lujy.vos.result.CodeMsg;
import com.lujy.vos.result.Result;
import com.lujy.vos.utils.ListPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.TypeVisitor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl implements IVideoService {

    @Autowired
    private TVideoMapper dao;


    @Override
    public Result<?> query(String role) {
        try {
            List<TVideo> tVideos = dao.select(role);
            return Result.success(tVideos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> insert(TVideo video) {
        try {
            video.setFlagdelete(video.getFlagdelete());
            video.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            dao.insert(video);
            return Result.success("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> createRole(Role_List roleName) {
        try {
            int id = dao.createRoles(roleName);
            id = roleName.getId();
            return Result.success(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> queryRoles() {
        try {
            List<Role_List> roles = dao.getRoles();
            return Result.success(roles);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> list() {
        try {
            List<TVideo> listByTime = dao.getListByTime();
            return Result.success(listByTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> updateMeans(Integer id, String means) {
        try {
            dao.updateMeans(id, means);
            dao.updateTime(id);
            return Result.success("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> saveById(Integer id) {
        try {
            dao.updateSave(id, TVideoMapper.SAVE);
            return Result.success("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> deleteById(Integer id) {
        try {
            dao.updateSave(id, TVideoMapper.REMOVE);
            return Result.success("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> getsBySave() {
        try {
            List<TVideo> tVideos = dao.selectBySave();
            //TVideoMapper.REMOVE);
            return Result.success(tVideos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @Override
    public Result<?> selectBySaveId(int id) {
        try {
            Integer i = dao.selectBySaveId(id);
            return Result.success(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(new Integer(0));
    }
    @Override
    public Result findItemByPage(int currentPage,int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
      try {
          List<TVideo> all = dao.findAll();
          ListPageUtil<TVideo> pageUtil = new ListPageUtil<>(all,currentPage,pageSize);
          return Result.success(pageUtil.getPagedList());
      }catch (Exception e){
          e.printStackTrace();
      }
      return Result.error(CodeMsg.SERVER_ERROR);
    }
}
