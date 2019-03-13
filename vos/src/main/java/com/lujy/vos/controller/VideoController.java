package com.lujy.vos.controller;

import com.lujy.vos.bean.Role_List;
import com.lujy.vos.bean.TVideo;
import com.lujy.vos.dao.TVideoMapper;
import com.lujy.vos.result.CodeMsg;
import com.lujy.vos.result.Result;
import com.lujy.vos.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @GetMapping("/video/query/{role}")
    public Result<?> query(@PathVariable("role") String role) {
        return videoService.query(role);
    }

    @GetMapping("/video/query/roles")
    public Result<?> queryRoles() {
        return videoService.queryRoles();
    }

    @PostMapping("/video/add")
    public Result<?> insert(TVideo video) {
        return videoService.insert(video);
    }

    @GetMapping("/video/query")
    public Result<?> queryList() {
        return videoService.list();
    }

    @PostMapping("/video/add/role")
    public Result<?> insert(Role_List roleName) {
        return videoService.createRole(roleName);
    }

    @PostMapping("/video/save/{id}/{type}")
    public Result<?> saveById(@PathVariable("id") int id, @PathVariable("type") int type) {
        Result result = null;
        switch (type) {
            case TVideoMapper
                    .SAVE:
                result = videoService.saveById(id);
                break;

            case TVideoMapper.REMOVE:
                result = videoService.deleteById(id);
                break;

            default:
                result = Result.error(CodeMsg.SERVER_ERROR);
                break;
        }

        return result;

    }

    @GetMapping("/video/is/save/{id}")
    public Result<?> saveById(@PathVariable("id") int id) {
        return videoService.selectBySaveId(id);
    }

    @GetMapping("/video/query/save")
    public Result<?> queryBySave() {
        return videoService.getsBySave();
    }

    @GetMapping("/video/update/{id}/{means}")
    public Result<?> updatemeans(@PathVariable("id") Integer id, @PathVariable("means") String means) {
        return videoService.updateMeans(id, means);
    }

    /**
     * 商品分页功能(集成mybatis的分页插件pageHelper实现)
     *
     * @param currentPage :当前页数
     * @param pageSize    :每页显示的总记录数
     * @return
     */
    @RequestMapping("/video/page/{currentPage}/{pageSize}")
    public Result itemsPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize) {
        return videoService.findItemByPage(currentPage, pageSize);
    }
}
