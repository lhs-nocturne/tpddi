package com.heb.guitar.vo.profession.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryViewReqVO {

    @ApiModelProperty(value = "第几页")
    private int pageNum=1;
    @ApiModelProperty(value = "分页数量")
    private int pageSize=10;

    private String viewName;

}
