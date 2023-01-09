//package com.example.dibootdemo.controller;
//
//
//import com.diboot.core.controller.BaseCrudRestController;
//import com.diboot.core.vo.JsonResult;
//import com.diboot.core.vo.Pagination;
//import com.diboot.iam.annotation.BindPermission;
//import com.diboot.iam.annotation.Log;
//import com.diboot.iam.annotation.OperationCons;
//import com.example.dibootdemo.controller.dto.SalaryCountDTO;
//import com.example.dibootdemo.controller.vo.SalaryCountVO;
//import com.example.dibootdemo.entity.SalaryCount;
//import com.example.dibootdemo.service.SalaryCountService;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * (SalaryCount)表控制层
// *
// * @author 刘长卿
// * @since 2023-01-09 15:14:03
// */
//@RestController
//@RequestMapping("/salaryCount")
//public class SalaryCountController extends BaseCrudRestController<SalaryCount>{
//    /**
//     * 服务对象
//     */
//    @Resource
//    private SalaryCountService salaryCountService;
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
//    public JsonResult<?> getSalaryCountVOListMapping(SalaryCountDTO salaryCountDto, Pagination pagination) throws Exception{
//    		return super.getViewObjectList(salaryCountDto, pagination, SalaryCountVO.class);
//    }
//
//    /**
//     * 根据资源id查询ViewObject
//     *
//     * @param id ID
//     * @return 单条RecruitVO-JSON结果
//     */
//    @Log(operation = OperationCons.LABEL_DETAIL)
//    @Cacheable(cacheNames = {"SalaryCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DETAIL, code = OperationCons.CODE_READ)
//    @GetMapping("/{id}")
//    public JsonResult<?> getSalaryCountVOMapping(@PathVariable("id")Long id) throws Exception{
//        return super.getViewObject(id, SalaryCountVO.class);
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
//    public JsonResult<?> createSalaryCountMapping(@Valid @RequestBody SalaryCount salaryCount) throws Exception {
//        return super.createEntity(salaryCount);
//    }
//
//    /**
//     * 根据ID更新资源对象
//     *
//     * @param recruit 对象
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_UPDATE)
//    @CacheEvict(cacheNames = {"SalaryCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_UPDATE, code = OperationCons.CODE_WRITE)
//    @PutMapping("/{id}")
//    public JsonResult<?> updateSalaryCountMapping(@PathVariable("id") Long id, @Valid @RequestBody SalaryCount salaryCount) throws Exception {
//        return super.updateEntity(id, salaryCount);
//    }
//
//    /**
//     * 根据id删除资源对象
//     *
//     * @param id 键
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_DELETE)
//    @CacheEvict(cacheNames = {"SalaryCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DELETE, code = OperationCons.CODE_WRITE)
//    @DeleteMapping("/{id}")
//    public JsonResult<?> deleteSalaryCountMapping(@PathVariable("id")Long id) throws Exception {
//        return super.deleteEntity(id);
//    }
//
//
//}
