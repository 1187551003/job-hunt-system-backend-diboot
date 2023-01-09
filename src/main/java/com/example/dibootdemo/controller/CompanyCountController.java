//package com.example.dibootdemo.controller;
//
//
//import com.diboot.core.controller.BaseCrudRestController;
//import com.diboot.core.vo.JsonResult;
//import com.diboot.core.vo.Pagination;
//import com.diboot.iam.annotation.BindPermission;
//import com.diboot.iam.annotation.Log;
//import com.diboot.iam.annotation.OperationCons;
//import com.example.dibootdemo.controller.dto.CompanyCountDTO;
//import com.example.dibootdemo.controller.vo.CompanyCountVO;
//import com.example.dibootdemo.entity.CompanyCount;
//import com.example.dibootdemo.service.CompanyCountService;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import javax.validation.Valid;
//
///**
// * (CompanyCount)表控制层
// *
// * @author 刘长卿
// * @since 2023-01-09 15:13:34
// */
//@RestController
//@RequestMapping("/companyCount")
//public class CompanyCountController extends BaseCrudRestController<CompanyCount>{
//    /**
//     * 服务对象
//     */
//    @Resource
//    private CompanyCountService companyCountService;
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
//    public JsonResult<?> getCompanyCountVOListMapping(CompanyCountDTO companyCountDto, Pagination pagination) throws Exception{
//    		return super.getViewObjectList(companyCountDto, pagination, CompanyCountVO.class);
//    }
//
//    /**
//     * 根据资源id查询ViewObject
//     *
//     * @param id ID
//     * @return 单条RecruitVO-JSON结果
//     */
//    @Log(operation = OperationCons.LABEL_DETAIL)
//    @Cacheable(cacheNames = {"CompanyCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DETAIL, code = OperationCons.CODE_READ)
//    @GetMapping("/{id}")
//    public JsonResult<?> getCompanyCountVOMapping(@PathVariable("id")Long id) throws Exception{
//        return super.getViewObject(id, CompanyCountVO.class);
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
//    public JsonResult<?> createCompanyCountMapping(@Valid @RequestBody CompanyCount companyCount) throws Exception {
//        return super.createEntity(companyCount);
//    }
//
//    /**
//     * 根据ID更新资源对象
//     *
//     * @param recruit 对象
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_UPDATE)
//    @CacheEvict(cacheNames = {"CompanyCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_UPDATE, code = OperationCons.CODE_WRITE)
//    @PutMapping("/{id}")
//    public JsonResult<?> updateCompanyCountMapping(@PathVariable("id") Long id, @Valid @RequestBody CompanyCount companyCount) throws Exception {
//        return super.updateEntity(id, companyCount);
//    }
//
//    /**
//     * 根据id删除资源对象
//     *
//     * @param id 键
//     * @return JsonResult
//     */
//    @Log(operation = OperationCons.LABEL_DELETE)
//    @CacheEvict(cacheNames = {"CompanyCount"}, key = "#id", condition = "#id != null")
//    @BindPermission(name = OperationCons.LABEL_DELETE, code = OperationCons.CODE_WRITE)
//    @DeleteMapping("/{id}")
//    public JsonResult<?> deleteCompanyCountMapping(@PathVariable("id")Long id) throws Exception {
//        return super.deleteEntity(id);
//    }
//
//
//}
