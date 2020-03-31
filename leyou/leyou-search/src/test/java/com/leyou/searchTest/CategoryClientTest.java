package com.leyou.searchTest;

import com.leyou.search.client.CategoryClient;
import com.leyou.search.leyouSearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

/**
 * @author yd
 * @version 1.0
 * @date 2020/2/22 14:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = leyouSearchApplication.class)
public class CategoryClientTest {

    @Autowired
    private CategoryClient categoryClient;

    @Test
    public void testQueryCategories() {
        List<String> names = this.categoryClient.queryNameByIds(Arrays.asList(1L, 2L, 3L));
        names.forEach(System.out::println);
    }
}
