package com.fshop.fashionshop.validation.commons;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import com.fshop.fashionshop.validation.ValidationConstants;



import java.util.LinkedList;
import java.util.LinkedList;

public final class ImageValidator {
    public static void checkDefaultImage(Product product) {
        if (product.getImg() == null) {
            product.setImg(new LinkedList<>());
            product.getImg().add(new Image(ValidationConstants.DEFAULT_IMAGE_PATH));
        }
    }
}
