package com.fshop.fashionshop.util;

import com.fshop.fashionshop.model.Product;
import org.apache.commons.io.FileUtils;



import java.io.File;
import java.io.IOException;

public class FileDatasource {

    private File dataFolder = null;

    public FileDatasource() {
        createDataFolder();

    }

    private void createDataFolder() {

        dataFolder = new File(new File("").getAbsolutePath() + File.separator + FileConstants.DATA_FOLDER_NAME);

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        } else if (dataFolder.exists() && !dataFolder.isDirectory()) {
            dataFolder.mkdir();
        }
    }

    public String createProductFolder(String folderName) {
        File imageFolder = new File(
                new File("").getAbsolutePath() +
                        File.separator
                        + FileConstants.DATA_FOLDER_NAME
                        + File.separator
                        + folderName);

        if (!imageFolder.exists()) {
            imageFolder.mkdir();
        }
        return imageFolder.getPath();
    }

    public   String getFolderPathByProduct(Product product){
        return dataFolder.getPath()+File.separator+product.getName()+"_"+product.getId();
    }

    public void deleteProductFolderByFolderName(String folderName){

        File imageFolder = new File(
                new File("").getAbsolutePath() +
                        File.separator
                        + FileConstants.DATA_FOLDER_NAME
                        + File.separator
                        + folderName);
        try {
            FileUtils.deleteDirectory(imageFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
