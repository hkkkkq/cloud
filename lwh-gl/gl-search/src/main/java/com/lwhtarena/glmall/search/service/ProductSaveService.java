package com.lwhtarena.glmall.search.service;

import com.lwhtarena.common.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author liwh
 * @Title: ProductSaveService
 * @Package com.lwhtarena.glmall.search.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/4 16:06
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;

}
