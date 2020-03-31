package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface BrandMapper extends Mapper<Brand> {

    @Insert("insert into tb_category_brand(category_id, brand_id) VALUES(#{cid},#{bid})")
    void insertBrandAndCatagory(@Param("cid") Long cid,@Param("bid") Long bid);

    @Select("SELECT b.* from tb_brand b INNER JOIN tb_category_brand cb on b.id=cb.brand_id where cb.category_id=#{cid}")
    List<Brand> selectBrandByCid(Long cid);
    /**
     * @author yd
     * @version 1.0
     * @date 2020/2/2 15:58
     */
    class SpecParamMapper {


    }
}