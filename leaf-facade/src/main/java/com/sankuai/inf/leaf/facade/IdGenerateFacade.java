package com.sankuai.inf.leaf.facade;

import com.alibaba.cola.dto.SingleResponse;
import com.sankuai.inf.leaf.IdGeneratorType;

public interface IdGenerateFacade {

    SingleResponse getId(String isNamespace, IdGeneratorType type);
}
