package com.heb.guitar.vo.resp;

import com.heb.guitar.entity.DsmQueryView;
import lombok.Data;
import java.util.List;


@Data
public class UserOwnViewRespVO {

    private List<String> ownViews;

    private List<DsmQueryView>  allViews;

}
