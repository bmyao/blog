package com.oneself.blog.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Describe zip压缩util
 * @Author: liangjiayao
 * @Date: 2019/6/6 13:47
 * @Version 1.0
 */
public class ZipUtils {

    private static final int  BUFFER_SIZE = 2 * 1024;


    /**
     * 生成zip压缩包
     * @param srcFiles 待压缩的文件
     * @param zipFilePath zip路径
     * */
    public static void fileListToZip(List<File> srcFiles , String zipFilePath){
        ZipOutputStream zos = null ;
        try {
            File zipFile = new File(zipFilePath);
            FileOutputStream out = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[BUFFER_SIZE];
                // 防止文件重名导致压缩失败
                String fileName = srcFile.getName();
                zos.putNextEntry(new ZipEntry(fileName));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1){
                    zos.write(buf, 0, len);
                }
                zos.closeEntry();
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(zos != null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        String filePath="E:/a1.zip";
        File file1 = new File("E:/a1.txt");
        File file2 = new File("E:/a2.txt");
        List<File> srcFiles = new ArrayList<>();
        srcFiles.add(file1);
        srcFiles.add(file2);
        fileListToZip( srcFiles , filePath);
        /**
         *         List<TransportFeeInfoVO> transportFeeInfoVOS = transportFeeService.queryTransportFeeListById(list);
         *         List<File> excelFileList = new ArrayList<>();
         *         transportFeeInfoVOS.forEach(transportFeeInfoVO->{
         *             List<TransportFeeDetailExportVO> dtos = MapperUtils.mapperList(transportFeeInfoVO.getFeeDetailList(), TransportFeeDetailExportVO.class);
         *             String filename = "费用明细"+transportFeeInfoVO.getFeeCode()+"-"+System.currentTimeMillis();
         *             String suffixes=".xlsx";
         *             File file;
         *             try {
         *                 ExcelExporter export = PoiExcelExporter.newInstance().addMetaData(dtos, TransportFeeDetailExportVO.class,"费用明细"+ transportFeeInfoVO.getFeeCode());
         *                 file = File.createTempFile(filename,suffixes);
         *                 FileOutputStream fos = new FileOutputStream(file);
         *                 export.createExcel().export2Stream(fos);
         *                 excelFileList.add(file);
         *             } catch (IOException e) {
         *                 e.printStackTrace();
         *             }
         *         });
         *         File downLoadFile;
         *         if(excelFileList.size() == 1){
         *             downLoadFile = excelFileList.get(0);
         *         }else{
         *             SimpleDateFormat timeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
         *             String fileName = "费用明细"+timeFormat.format(new Date())+".zip";
         *             //获取存放目录路径
         *             String filenamePath = FileUtils.getExcelExportPath();
         *             //创建目录
         *             FileUtils.isNewFolder(filenamePath);
         *             //文件完整路径
         *             String zipFilenamePath = filenamePath+"/"+fileName;
         *             ZipUtils.fileListToZip(excelFileList,zipFilenamePath);
         *             downLoadFile = new File(zipFilenamePath);
         *         }
         *         HttpServletDownloadUtils.downloadFile(response, new FileInputStream(downLoadFile), downLoadFile.getName());
         **/
    }
}
