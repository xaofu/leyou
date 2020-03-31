package com.leyou.search.repository;

import com.leyou.search.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author yd
 * @version 1.0
 * @date 2020/2/22 14:06
 */
public interface GoodsReponsitory extends ElasticsearchRepository<Goods, Long> {
}
