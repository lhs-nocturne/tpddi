package com.heb.guitar.service.impl;

import com.heb.guitar.constants.Constant;
import com.heb.guitar.entity.DsmUserView;
import com.heb.guitar.exception.BusinessException;
import com.heb.guitar.exception.code.BaseResponseCode;
import com.heb.guitar.mapper.DsmUserViewMapper;
import com.heb.guitar.service.DsmUserViewService;
import com.heb.guitar.service.RedisService;
import com.heb.guitar.vo.resp.UserViewOperationReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DsmUserViewServiceImpl implements DsmUserViewService {

    @Resource
    private DsmUserViewMapper dsmUserViewMapper;
    @Resource
    private RedisService redisService;

    @Override
    public List<String> getViewByUserId(String userId) {
        return dsmUserViewMapper.getViewByUserId(userId);
    }

    @Override
    public void setUserOwnView(UserViewOperationReqVO vo) {
        dsmUserViewMapper.removeByUserId(vo.getUserId());
        if(redisService.hasKey(Constant.USER_VIEW_KEY+vo.getUserId())){
            redisService.delete(Constant.USER_VIEW_KEY+vo.getUserId());
        }
        if(vo.getViewIds()==null||vo.getViewIds().isEmpty()){
            return;
        }
        Date createTime=new Date();
        List<DsmUserView> list=new ArrayList<>();
        for(String viewId:vo.getViewIds()){
            DsmUserView dsmUserView = new DsmUserView();
            dsmUserView.setCreateTime(createTime);
            dsmUserView.setId(UUID.randomUUID().toString());
            dsmUserView.setUserId(vo.getUserId());
            dsmUserView.setViewId(viewId);
            list.add(dsmUserView);
        }
        int count = dsmUserViewMapper.batchUserView(list);

        if (count==0){
            throw new BusinessException(BaseResponseCode.OPERATION_ERROR);
        }
        redisService.set(Constant.USER_VIEW_KEY+vo.getUserId(),vo.getViewIds());
    }


}
