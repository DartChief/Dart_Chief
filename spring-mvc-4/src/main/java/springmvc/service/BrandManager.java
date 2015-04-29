package springmvc.service;

import springmvc.model.Brand;

import java.util.LinkedList;
import java.util.List;


public class BrandManager {

    private static List<Brand> brandList;

    static {

        Brand brand1 = new Brand();

        brand1.setId((long) 1);

        brand1.setName("Mercedes");

        brand1.setCountry("Germany");

        Brand brand2 = new Brand();

        brand2.setId((long) 2);

        brand2.setName("Peugeot");

        brand2.setCountry("France");

        brandList = new LinkedList<Brand>();

        brandList.add(brand1);

        brandList.add(brand2);

    }

    public List<Brand> getBrandList() {
        return brandList;
    }
}