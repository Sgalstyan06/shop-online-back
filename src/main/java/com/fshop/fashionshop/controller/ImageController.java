package com.fshop.fashionshop.controller;

import com.fshop.fashionshop.model.Product;
import com.fshop.fashionshop.model.commons.Image;
import com.fshop.fashionshop.model.dto.responseDto.ResponseDto;
import com.fshop.fashionshop.service.ImageService;
import com.fshop.fashionshop.service.ProductService;
import com.fshop.fashionshop.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {
    private final String IMAGE_URL_MAPPING_POST_FIX = "/get";
    @Autowired
    private ImageService imageService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add/{product_id}")
    ResponseEntity<ResponseDto> addImage(@PathVariable("product_id") long productId,
                                         @RequestParam("image") MultipartFile[] multipartFile,
                                         @RequestHeader String userId) {
        if (!UserValidator.checkUserAuthorized(userId)) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "user is unauthorized, please sign in first:"
            );
        }
        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String requestMapping = this.getClass().getAnnotation(RequestMapping.class).value()[0];
        String imageMappingPath = serverUrl+ "/" +requestMapping + IMAGE_URL_MAPPING_POST_FIX;
        Product created = imageService.saveImagesToFolder(productId, multipartFile, imageMappingPath);
        ResponseDto responseDto = new ResponseDto("Image created.");
        responseDto.addInfo("productId", String.valueOf(productId));
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping(value =  "/get/{folder_name}/{img_name}")
    ResponseEntity<byte[]> getImagesByProductId(@PathVariable("folder_name") String folderName,
                                                @PathVariable("img_name") String imageName) throws IOException {

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(imageService.readByFolderNameAndImageName(folderName, imageName));
    }

    @PutMapping("/update/{product_id}")
    ResponseEntity<ResponseDto> update(@PathVariable("product_id") long productId,
                                       @RequestParam("image") MultipartFile[] images,
                                       @RequestHeader String userId){
        if (!UserValidator.checkUserAuthorized(userId)) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "user is unauthorized, please sign in first:"
            );
        }
        String serverUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        String requestMapping = this.getClass().getAnnotation(RequestMapping.class).value()[0];
        String imageMappingPath = serverUrl+ "/" +requestMapping + IMAGE_URL_MAPPING_POST_FIX;
        Image updated = imageService.update(productId, images, imageMappingPath);
        System.out.println(updated);
        ResponseDto responseDto = new ResponseDto("Image updated.");
        responseDto.addInfo("productId", String.valueOf(productId));
        return ResponseEntity.ok(responseDto);

    }

}
