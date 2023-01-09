package com.example.dibootdemo.controller;


import com.diboot.core.controller.BaseCrudRestController;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.Pagination;
import com.diboot.iam.annotation.BindPermission;
import com.diboot.iam.annotation.Log;
import com.diboot.iam.annotation.OperationCons;
import com.example.dibootdemo.controller.dto.RecruitDTO;
import com.example.dibootdemo.controller.vo.RecruitVO;
import com.example.dibootdemo.entity.Recruit;
import com.example.dibootdemo.service.RecruitService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * (Recruit)表控制层
 *
 * @author 刘长卿
 * @since 2023-01-07 12:32:25
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController extends BaseCrudRestController<Recruit>{
    /**
     * 服务对象
     */
    @Resource
    private RecruitService recruitService;

    
    /**
     * 查询ViewObject的分页数据
     * <p>
     * url请求参数示例: /recruit/list?field=id&pageSize=2&pageIndex=1&orderBy=id:DESC&name=java
     * </p>
     *
     * @return RecruitVO集合分页-JSON结果
     */
    @Log(operation = OperationCons.LABEL_LIST)
    @Cacheable(cacheNames = {"Recruit"}, key = "'pageSize='+#pagination.pageSize+'&pageIndex='+#pagination.pageIndex+'&positionName='+#recruitDto.positionName+'&education='+#recruitDto.education")
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/list")
    public JsonResult<?> getRecruitVOListMapping(RecruitDTO recruitDto, Pagination pagination) throws Exception{
    		return super.getViewObjectList(recruitDto, pagination, RecruitVO.class);
    } 
    
    /**
     * 根据资源id查询ViewObject
     *
     * @param id ID
     * @return 单条RecruitVO-JSON结果
     */
    @Log(operation = OperationCons.LABEL_DETAIL)
    @Cacheable(cacheNames = {"Recruit"}, key = "#id", condition = "#id != null")
    @BindPermission(name = OperationCons.LABEL_DETAIL, code = OperationCons.CODE_READ)
    @GetMapping("/{id}")
    public JsonResult<?> getRecruitVOMapping(@PathVariable("id")Long id) throws Exception{
        return super.getViewObject(id, RecruitVO.class);
    }
    
    /**
     * 创建资源对象
     *
     * @param recruit 对象
     * @return JsonResult
     */
    @Log(operation = OperationCons.LABEL_CREATE)
    @BindPermission(name = OperationCons.LABEL_CREATE, code = OperationCons.CODE_WRITE)
    @PostMapping("/")
    public JsonResult<?> createRecruitMapping(@Valid @RequestBody Recruit recruit) throws Exception {
        return super.createEntity(recruit);
    }
    
    /**
     * 根据ID更新资源对象
     *
     * @param recruit 对象
     * @return JsonResult
     */
    @Log(operation = OperationCons.LABEL_UPDATE)
    @CacheEvict(cacheNames = {"Recruit"}, key = "#id", condition = "#id != null")
    @BindPermission(name = OperationCons.LABEL_UPDATE, code = OperationCons.CODE_WRITE)
    @PutMapping("/{id}")
    public JsonResult<?> updateRecruitMapping(@PathVariable("id") Long id, @Valid @RequestBody Recruit recruit) throws Exception {
        return super.updateEntity(id, recruit);
    }
   
    /**
     * 根据id删除资源对象
     *
     * @param id 键
     * @return JsonResult
     */
    @Log(operation = OperationCons.LABEL_DELETE)
    @CacheEvict(cacheNames = {"Recruit"}, key = "#id", condition = "#id != null")
    @BindPermission(name = OperationCons.LABEL_DELETE, code = OperationCons.CODE_WRITE)
    @DeleteMapping("/{id}")
    public JsonResult<?> deleteRecruitMapping(@PathVariable("id")Long id) throws Exception {
        return super.deleteEntity(id);
    }

   
}