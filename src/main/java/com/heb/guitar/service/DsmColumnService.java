package com.heb.guitar.service;

import com.heb.guitar.entity.DsmColumn;
import java.util.List;

public interface DsmColumnService {

    List<DsmColumn> selectByDatasetId(DsmColumn dsmColumn);

    int syncColumns(DsmColumn dsmColumn);

    int batchDeleteColumns(List<DsmColumn> list);

}
