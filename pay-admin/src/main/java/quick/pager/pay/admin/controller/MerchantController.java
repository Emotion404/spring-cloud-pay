package quick.pager.pay.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.pay.admin.service.MerchantService;
import quick.pager.pay.Constants;
import quick.pager.pay.common.constants.ResponseStatus;
import quick.pager.pay.dto.admin.MerchantDto;
import quick.pager.pay.request.admin.MerchantRequest;
import quick.pager.pay.response.Response;

@RestController
@RequestMapping(Constants.ADMIN_MODULE)
@Api(description = "商户管理")
public class MerchantController {

    private MerchantService merchantService;

    @ApiModelProperty("商户列表")
    @PostMapping("/merchant/list")
    public Response queryMerchantList(MerchantRequest request) {
        MerchantDto dto = new MerchantDto();
        
        dto.setOperation(Constants.Operation.list);
        return merchantService.doService(dto);
    }

    @ApiOperation("查看商户信息")
    @PostMapping("/merchant/info")
    public Response merchantInfo(MerchantRequest request) {
        if (ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }

        MerchantDto dto = new MerchantDto();

        dto.setOperation(Constants.Operation.select);
        
        return merchantService.doService(dto);
    }

    @ApiModelProperty("新增或修改商户")
    @PostMapping("/merchant/modify")
    public Response modifyMerchant(MerchantRequest request) {
        if (ObjectUtils.isEmpty(request)) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }

        MerchantDto dto = new MerchantDto();

        dto.setOperation(Constants.Operation.update);


        return merchantService.doService(dto);
    }

    @ApiOperation("删除商户")
    @PostMapping("/merchant/delete")
    public Response deleteMerchant(MerchantRequest request) {
        if (ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }

        MerchantDto dto = new MerchantDto();

        dto.setOperation(Constants.Operation.delete);


        return merchantService.doService(dto);
    }

}
