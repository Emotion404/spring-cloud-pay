package quick.pager.pay.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.pay.admin.service.ChannelCenterService;
import quick.pager.pay.admin.service.ChannelService;
import quick.pager.pay.admin.service.ChannelTypeService;
import quick.pager.pay.Constants;
import quick.pager.pay.common.constants.ResponseStatus;
import quick.pager.pay.dto.admin.ChannelDto;
import quick.pager.pay.request.admin.ChannelRequest;
import quick.pager.pay.response.Response;

@RestController
@RequestMapping(Constants.ADMIN_MODULE)
@Api(description = "渠道管理")
public class ChannelController {
    
    @Autowired
    private ChannelService channelService;
    @Autowired
    private ChannelCenterService channelCenterService;
    @Autowired
    private ChannelTypeService channelTypeService;

    @ApiOperation("支付中心列表")
    @PostMapping("/channel/center/list")
    public Response channelCenterList(ChannelRequest request) {
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setChannelCenterName(request.getChannelCenterName());
        dto.setOperation(Constants.Operation.list);
        return channelCenterService.doService(dto);
    }

    @ApiOperation("获取channel payType支付类型")
    @PostMapping("/channel/payType")
    public Response channelPayType(ChannelRequest request) {
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setOperation(Constants.Operation.list);
        return channelTypeService.doService(dto);
    }

    @ApiOperation("支付中心信息")
    @PostMapping("/channel/center/info")
    public Response channelCenterInfo(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }

        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setOperation(Constants.Operation.select);
        return channelCenterService.doService(dto);
    }

    @ApiOperation("修改支付中心配置")
    @PostMapping("/channel/center/modify")
    public Response modifyChannelCenter(ChannelRequest request) {

        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setOperation(Constants.Operation.update);

        return channelCenterService.doService(dto);
    }

    @ApiOperation("删除支付中心")
    @PostMapping("/channel/center/delete")
    public Response deleteChannelCenter(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }

        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setOperation(Constants.Operation.delete);

        return channelCenterService.doService(dto);
    }

    @ApiOperation("查询支付配置列表")
    @PostMapping("/channel/list")
    public Response channelList(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setChannelCenterName(request.getChannelCenterName());
        dto.setOperation(Constants.Operation.list);
        return channelService.doService(dto);

    }


    @ApiOperation("查看支付渠道信息")
    @PostMapping("/channel/info")
    public Response channelInfo(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setChannelCenterName(request.getChannelCenterName());
        dto.setOperation(Constants.Operation.select);
        return channelService.doService(dto);
    }

    @ApiOperation("支付配置修改")
    @PostMapping("/channel/modify")
    public Response channelModify(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request)) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setChannelCenterName(request.getChannelCenterName());
        dto.setOperation(Constants.Operation.update);
        return channelService.doService(dto);
    }

    @ApiOperation("删除支付配置")
    @PostMapping("/channel/delete")
    public Response deleteChannel(ChannelRequest request) {
        if (ObjectUtils.isEmpty(request) || ObjectUtils.isEmpty(request.getId())) {
            return new Response(ResponseStatus.PARAMETER_ERROR.code, ResponseStatus.PARAMETER_ERROR.msg);
        }
        ChannelDto dto = new ChannelDto();
        dto.setAppId(request.getAppId());
        dto.setChannelCenterName(request.getChannelCenterName());
        dto.setOperation(Constants.Operation.delete);
        return channelService.doService(dto);
    }

}
