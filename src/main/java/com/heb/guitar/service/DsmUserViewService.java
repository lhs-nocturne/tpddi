package com.heb.guitar.service;

import com.heb.guitar.vo.resp.UserViewOperationReqVO;

import java.util.List;

public interface DsmUserViewService {

    List<String> getViewByUserId(String userId);

    void setUserOwnView(UserViewOperationReqVO vo);
}
