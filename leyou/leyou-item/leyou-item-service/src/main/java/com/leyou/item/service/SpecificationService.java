package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author yd
 * @version 1.0
 * @date 2020/2/2 15:50
 */
    @Service
    public class SpecificationService {

        @Autowired
        private SpecGroupMapper groupMapper;

        @Autowired
        private SpecParamMapper paramMapper;
        /**
         * 根据分类id查询分组
         * @param cid
         * @return
         */
        public List<SpecGroup> queryGroupsByCid(Long cid) {
            SpecGroup specGroup = new SpecGroup();
            specGroup.setCid(cid);
            return this.groupMapper.select(specGroup);
        }

    /**
     * 根据gid查询规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        List<SpecParam> params = this.paramMapper.select(record);
        //System.out.println(params);
        return params;
    }

    public List<SpecGroup> querySpecsByCid(Long cid) {
        // 查询规格组
        List<SpecGroup> groups = this.queryGroupsByCid(cid);
        groups.forEach(g -> {
            // 查询组内参数
            g.setParams(this.queryParams(g.getId(), null, null, null));
        });
        return groups;
    }
    }


