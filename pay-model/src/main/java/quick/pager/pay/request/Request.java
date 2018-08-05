package quick.pager.pay.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求主体基类
 * @author siguiyang
 */
@Data
public class Request implements Serializable {
    private static final long serialVersionUID = 2245472883226265132L;

    @ApiModelProperty(value = "Id")
    private Integer id;
    @ApiModelProperty(value = "起始时间")
    private long beginTime;
    @ApiModelProperty(value = "结束时间")
    private long endTime;
    @ApiModelProperty(value = "商户号")
    private String merchantNo;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "商户订单号")
    private String merchantOrderCode;
    @ApiModelProperty(value = "版本号")
    private String version;

}
