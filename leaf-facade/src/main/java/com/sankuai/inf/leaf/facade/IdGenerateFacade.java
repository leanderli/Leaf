package com.sankuai.inf.leaf.facade;

import com.alibaba.cola.dto.SingleResponse;
import com.sankuai.inf.leaf.IdGeneratorType;
import com.sankuai.inf.leaf.dto.Id;

public interface IdGenerateFacade {

    SingleResponse<Id> getId(String key, IdGeneratorType type);
}
