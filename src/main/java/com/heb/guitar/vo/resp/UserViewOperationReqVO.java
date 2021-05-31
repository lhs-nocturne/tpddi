package com.heb.guitar.vo.resp;

import lombok.Data;
import java.util.List;

@Data
public class UserViewOperationReqVO {

    private String userId;

    private List<String> viewIds;

}
