package com.fshop.fashionshop.validation;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.validation.commons.DescriptionValidator;
import com.fshop.fashionshop.validation.commons.ImageValidator;
import com.fshop.fashionshop.validation.commons.StockValidator;

public final class ProductValidator {
    public static boolean validateUpdateProduct(Product product, String userId) {
//        ImageValidator.checkDefaultImage(product);

        if (product.getName().length() == 0 ||
                product.getPrice() < 0 ||
                !StockValidator.validateStock(product.getStock()) ||
                !DescriptionValidator.validateDescription(product.getDescription()) ||
                !UserValidator.checkUserAuthorized(userId)) {
            return false;
        }

        return true;
    }
    public static boolean validateCreateProduct(Product product, String userId){
        System.out.println(product.getStock());
        System.out.println(product.getDescription());
        return validateUpdateProduct(product, userId);
    }

    public static boolean validateDeleteProduct(String userId){
        return UserValidator.checkUserAuthorized(userId);
    }
}