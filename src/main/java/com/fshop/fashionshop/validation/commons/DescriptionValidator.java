package com.fshop.fashionshop.validation.commons;

import com.fshop.fashionshop.model.commons.Description;
import com.fshop.fashionshop.validation.ValidationConstants;

public final class DescriptionValidator {
    public static boolean validateDescription(Description description) {
        return description.getComment().length() > ValidationConstants.PRODUCT_DESCRIPTION_MIN_LENGTH &&
                description.getComment().length() < ValidationConstants.PRODUCT_DESCRIPTION_MAX_LENGTH;
    }
}
