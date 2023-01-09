package com.example.dibootdemo.controller;


import com.diboot.core.controller.BaseCrudRestController;
import com.diboot.core.vo.JsonResult;
import com.diboot.iam.annotation.BindPermission;
import com.diboot.iam.annotation.Log;
import com.diboot.iam.annotation.OperationCons;
import com.example.dibootdemo.entity.CityCount;
import com.example.dibootdemo.entity.CompanyCount;
import com.example.dibootdemo.entity.KillCount;
import com.example.dibootdemo.entity.SalaryCount;
import com.example.dibootdemo.service.CityCountService;
import com.example.dibootdemo.service.CompanyCountService;
import com.example.dibootdemo.service.KillCountService;
import com.example.dibootdemo.service.SalaryCountService;
import com.example.dibootdemo.utils.ChangeType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CityCount)表控制层
 *
 * @author 刘长卿
 * @since 2023-01-09 15:12:53
 */
@RestController
@RequestMapping("/echarts")
public class CityCountController extends BaseCrudRestController<CityCount> {
    /**
     * 服务对象
     */
    @Resource
    private CityCountService cityCountService;

    @Resource
    private CompanyCountService companyCountService;

    @Resource
    private KillCountService killCountService;

    @Resource
    private SalaryCountService salaryCountService;


    @Log(operation = OperationCons.LABEL_LIST + "：city")
    @Cacheable(value = "city")
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/city")
    public JsonResult<?> getCityCountEntityListMapping() {
        List<CityCount> cityCounts = cityCountService.getEntityList(null);
        return JsonResult.OK(ChangeType.ObjectToJsonStr(cityCounts));
    }

    @Log(operation = OperationCons.LABEL_LIST + "：company")
    @Cacheable(value = "company")
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/company")
    public JsonResult<?> getCompanyCountEntityListMapping() {
        List<CompanyCount> companyCounts = companyCountService.getEntityList(null);
        return JsonResult.OK(ChangeType.ObjectToJsonStr(companyCounts));
    }

    @Log(operation = OperationCons.LABEL_LIST + "：kill")
    @Cacheable(value = "kill")
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/kill")
    public JsonResult<?> getCityKillEntityListMapping() {
        List<KillCount> killCounts = killCountService.getEntityList(null);
        return JsonResult.OK(ChangeType.ObjectToJsonStr(killCounts));
    }

    @Log(operation = OperationCons.LABEL_LIST + "：salary")
    @Cacheable(value = "salary")
    @BindPermission(name = OperationCons.LABEL_LIST, code = OperationCons.CODE_READ)
    @GetMapping("/salary")
    public JsonResult<?> getSalaryCountEntityListMapping() {
        List<SalaryCount> salaryCounts = salaryCountService.getEntityList(null);
        return JsonResult.OK(ChangeType.ObjectToJsonStr(salaryCounts));
    }

}
