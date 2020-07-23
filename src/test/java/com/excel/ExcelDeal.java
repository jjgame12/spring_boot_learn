package com.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ExcelDeal {
    public List getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    public List<String> getIndicators(InputStream in, String fileName) throws Exception {
        List<String> list = new ArrayList<>();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }

                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    if (cell == null || cell.toString().isEmpty()) {
                        log.info("row = {}, column = {}", j, y);
                        continue;
                    }
                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);//设置单元格类型为String类型
                    list.add(cell.getStringCellValue());
                }
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

    @Test
    public void testExcel() throws InterruptedException {
        ExcelDeal excelDeal = new ExcelDeal();
        String fileName = "指标.xlsx";
        File file = new File(fileName);
        if (!file.exists()) {
            log.info("no file");
            return;
        }


        List<String> list = null;
        try(InputStream is = new FileInputStream(file)) {
            list = excelDeal.getIndicators(is, fileName);
        } catch (FileNotFoundException e) {
            log.error("file not found = {}", e);
            return;
        } catch (IOException e) {
            log.error("io error = {}", e);
            return;
        } catch (Exception e) {
            log.error("exception = {}", e);
            return;
        }
        log.info("list = {}", list);
        
        Thread.sleep(10000);
    }

    private boolean customMatcher(String testStr, String regexStr){//传入待检测的字符串
        Pattern pattern=Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(testStr);
        return matcher.matches();
    }

    @Test
    public void testReg() {
        String text = "93";
        String reg = "^[0-9]2$";

        log.info("result = {}", customMatcher(text, reg));
    }
}
