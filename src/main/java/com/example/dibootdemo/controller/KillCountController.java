//package com.example.dibootdemo.controller;
//
//
//import com.diboot.core.controller.BaseCrudRestController;
//import com.diboot.core.vo.JsonResult;
//import com.diboot.core.vo.Pagination;
//import com.diboot.iam.annotation.BindPermission;
//import com.diboot.iam.annotation.Log;
//import com.diboot.iam.annotation.OperationCons;
//import com.example.dibootdemo.controller.dto.KillCountDTO;
//import com.example.dibootdemo.controller.vo.KillCountVO;
//import com.example.dibootdemo.entity.KillCount;
//import com.example.dibootdemo.service.KillCountService;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * (KillCount)表控制层
// *
// * @author 刘长卿
// * @since 2023-01-09 15:13:48
// */
//@RestController
//@RequestMapping("/killCount")
//public class KillCountController extends BaseCrudRestController<KillCount>{
//    /**
//     * 服务对象
//     */
//    @Resource
//    private KillCountService killCountService;
//
//
//    /**
//     * 查询ViewObject的分页数据
//     * <p>
//     * url请求参数示例: /recruit/list?field=id&pageSize=2&pageIndex=1&orderBy=id:DESC&name=java
//     * </p>
//     *
//     * @return RecruitVO集合分页-JSON结果
//     */
//    @Log(operation = OperationCons.LABEL_LIST)
//    @Cacheable(cacheNames = {"Recruit"}, key = "#pagination.pageSize+'&'+#pagination.pageIndex+'&'")
//    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
//    @GetMapping("/list")
//    public JsonResult<?> getKillCountVOListMapping(KillCountDTO killCountDto, Pagination pagination) throws Exception{
//    		return super.getViewObjectList(killCountDto, pagination, KillCountVO.class);
//    }
//
//    /**
//     * 根据资源id查询ViewObject
//     *
//     * @param id ID
//     * @return 单条RecruitVO-JSON结果
//     */
//    @Log(operation = OperationCons.LABEL_DETAIL)
//    @Cacheable(cacheNames = {"KillCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DETAIL, code = OperationCons.CODE_READ)
//    @GetMapping("/{id}")
//    public JsonResult<?> getKillCountVOMapping(@PathVariable("id")Long id) throws Exception{
//        return super.getViewObject(id, KillCountVO.class);
//    }
//
//    /**
//     * 创建资源对象
//     *
//     * @param recruit 对象
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_CREATE)
//    @BindPermission(name = OperationCons.LABEL_CREATE, code = OperationCons.CODE_WRITE)
//    @PostMapping("/")
//    public JsonResult<?> createKillCountMapping(@Valid @RequestBody KillCount killCount) throws Exception {
//        return super.createEntity(killCount);
//    }
//
//    /**
//     * 根据ID更新资源对象
//     *
//     * @param recruit 对象
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_UPDATE)
//    @CacheEvict(cacheNames = {"KillCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_UPDATE, code = OperationCons.CODE_WRITE)
//    @PutMapping("/{id}")
//    public JsonResult<?> updateKillCountMapping(@PathVariable("id") Long id, @Valid @RequestBody KillCount killCount) throws Exception {
//        return super.updateEntity(id, killCount);
//    }
//
//    /**
//     * 根据id删除资源对象
//     *
//     * @param id 键
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_DELETE)
//    @CacheEvict(cacheNames = {"KillCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DELETE, code = OperationCons.CODE_WRITE)
//    @DeleteMapping("/{id}")
//    public JsonResult<?> deleteKillCountMapping(@PathVariable("id")Long id) throws Exception {
//        return super.deleteEntity(id);
//    }
//
//
//}
