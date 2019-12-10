package com.pep.business;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 描述:
 * 转换参数 初始化
 *
 * @author zhangfz
 * @create 2019-09-02 11:09
 */
public class ConvertEntityInit {

    private static List<ConvertEntityConfig> convertEntityConfigList;

    static {
        try {
            InputStream inputStream = ConvertEntityInit.class.getResourceAsStream(StaticConstant.CONVERT_RULE);
            convertEntityConfigList = JSON.parseArray(intputStream2String(inputStream), ConvertEntityConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convertEntity(Map<String, String> sourceMap, ConvertEntityConfig convertEntityConfig) throws Exception {
        Field[] fields = Class.forName(convertEntityConfig.getTo_entity()).getDeclaredFields();
        Map<String, String> fieldMap = field2Map(fields);
        doFieldMapping(sourceMap, fieldMap, convertEntityConfig.getField_mapping(), convertEntityConfig.getAll_field_mapping());
        doFieldDefault(fieldMap, convertEntityConfig.getField_default());
        doDate2timestamp(sourceMap, fieldMap, convertEntityConfig.getDate2timestamp(), convertEntityConfig.getDate_format());
        doFieldCopy(fieldMap, convertEntityConfig.getField_copy());
        String resultJson = JSON.toJSONString(fieldMap);
        return resultJson;
    }

    public static Map<String, String> field2Map(Field[] fields) {
        Map<String, String> fieldMap = new HashMap<>();
        if (fields.length > 0) {
            for (Field field : fields) {
                fieldMap.put(field.getName(), "");
            }
        }
        return fieldMap;
    }

    /**
     * 字段映射
     *
     * @param sourceMap
     * @param fieldMap
     * @param fieldMapping
     * @return
     * @throws Exception
     */
    public static Map<String, String> doFieldMapping(Map<String, String> sourceMap, Map<String, String> fieldMap, Map<String, String> fieldMapping, Boolean flagAllFieldMapping) throws Exception {
        if (flagAllFieldMapping != null && flagAllFieldMapping == true) {
            if (sourceMap != null && fieldMap != null) {
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    String mappingFrom = entry.getKey();
                    if (sourceMap.containsKey(mappingFrom)) {
                        fieldMap.put(mappingFrom, sourceMap.get(mappingFrom));
                    }
                }
            }
            else {
                throw new Exception("sourceMap or fieldMap or fieldMapping could not be null");
            }
        }
        else {
            if (sourceMap != null && fieldMap != null && fieldMapping != null) {
                for (Map.Entry<String, String> entry : fieldMapping.entrySet()) {
                    String mappingFrom = entry.getKey();
                    String mappingTo = entry.getValue();
                    if (!sourceMap.containsKey(mappingFrom)) {
                        throw new Exception("fieldMapping key is not found");
                    }
                    if (!fieldMap.containsKey(mappingTo)) {
                        throw new Exception("fieldMapping value is not found");
                    }
                    fieldMap.put(mappingTo, sourceMap.get(mappingFrom));
                }
            }
            else {
                throw new Exception("sourceMap or fieldMap or fieldMapping could not be null");
            }
        }

        return fieldMap;
    }

    /**
     * 字段默认值赋值
     *
     * @param fieldMap
     * @param fieldDefaultMap
     * @return
     * @throws Exception
     */
    public static Map<String, String> doFieldDefault(Map<String, String> fieldMap, Map<String, String> fieldDefaultMap) throws Exception {
        if (fieldDefaultMap != null) {
            if (fieldMap != null) {
                for (Map.Entry<String, String> entry : fieldDefaultMap.entrySet()) {
                    String defaultKey = entry.getKey();
                    String defaultValue = entry.getValue();
                    if (!fieldMap.containsKey(defaultKey)) {
                        throw new Exception("default Key is not found");
                    }
                    fieldMap.put(defaultKey, defaultValue);
                }
            }
            else {
                throw new Exception("sourceMap or fieldMap or fieldMapping could not be null");
            }
        }
        return fieldMap;
    }

    /**
     * 时间字段时间戳转化
     *
     * @param sourceMap
     * @param fieldMap
     * @param date2timestamp
     * @param date_format
     * @return
     * @throws Exception
     */
    public static Map<String, String> doDate2timestamp(Map<String, String> sourceMap, Map<String, String> fieldMap, Map<String, String> date2timestamp, String date_format) throws Exception {
        if (date2timestamp != null) {
            for (Map.Entry<String, String> entry : date2timestamp.entrySet()) {
                String mappingFrom = entry.getKey();
                String mappingTo = entry.getValue();

                if (!sourceMap.containsKey(mappingFrom)) {
                    throw new Exception("fieldMapping key is not found");
                }
                if (!fieldMap.containsKey(mappingTo)) {
                    throw new Exception("fieldMapping value is not found");
                }
                SimpleDateFormat format = new SimpleDateFormat(date_format);
                String key = sourceMap.get(mappingFrom);
                String timestamp = null;
                if (key != "") {
                    timestamp = String.valueOf(format.parse(sourceMap.get(mappingFrom)).getTime());
                    fieldMap.put(mappingTo, timestamp);
                }
            }
        }
        return fieldMap;
    }

    /**
     * 字段统一
     *
     * @param fieldMap
     * @param FieldCopyMap
     * @return
     * @throws Exception
     */
    public static Map<String, String> doFieldCopy(Map<String, String> fieldMap, Map<String, String> FieldCopyMap) throws Exception {
        if (FieldCopyMap != null) {
            for (Map.Entry<String, String> entry : FieldCopyMap.entrySet()) {
                String copyFrom = entry.getKey();
                String copyTo = entry.getValue();
                if (!fieldMap.containsKey(copyFrom)) {
                    throw new Exception("copyFrom key is not found");
                }
                if (!fieldMap.containsKey(copyTo)) {
                    throw new Exception("copyTo value is not found");
                }
                fieldMap.put(copyTo, fieldMap.get(copyFrom));
            }
        }
        return fieldMap;
    }

    public static String intputStream2String(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i = -1;
        try {
            while ((i = inputStream.read()) != -1) {
                baos.write(i);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<ConvertEntityConfig> getConvertEntityConfigList() {
        return convertEntityConfigList;
    }

    public static void setConvertEntityConfigList(List<ConvertEntityConfig> convertEntityConfigList) {
        ConvertEntityInit.convertEntityConfigList = convertEntityConfigList;
    }
}
