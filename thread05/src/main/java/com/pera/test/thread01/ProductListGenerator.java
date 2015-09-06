package com.pera.test.thread01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csq on 2015/8/17.
 */
public class ProductListGenerator{

    public List<Product> generate(int size){
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product product = new Product("product"+i,10);
            ret.add(product);
        }

        return ret;
    }
}
