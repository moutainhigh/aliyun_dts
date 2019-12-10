package com.pep.business;

import com.alibaba.dts.formats.avro.DateTime;
import com.alibaba.dts.formats.avro.Field;
import com.alibaba.dts.formats.avro.Record;
import com.pep.canal.common.RowKeyStatic;
import common.FieldEntryHolder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import recordprocessor.FieldConverter;

import java.util.*;

import static common.Util.uncompressionObjectName;

public class MysqlRecordResolver {
    private static final Logger log = LoggerFactory.getLogger(MysqlRecordResolver.class);
    private static final FieldConverter FIELD_CONVERTER = FieldConverter.getConverter("mysql", null);

    public static String recordToMessage(Record record) throws Exception {
        StringBuilder stringBuilder = new StringBuilder(256);
        switch (record.getOperation()) {
            case DDL: {
                /*appendRecordGeneralInfo(record, stringBuilder);
                String ddl = (String) record.getAfterImages();
                stringBuilder.append("DDL [").append(ddl).append("]");*/
                break;
            }

            case DELETE: {
                List<ConvertEntityConfig> convertEntityConfigList = ConvertEntityInit.getConvertEntityConfigList();
                for (ConvertEntityConfig convertEntityConfig : convertEntityConfigList) {
                    if (record.getObjectName() != null && record.getObjectName().equals(convertEntityConfig.getFrom_db() + "." + convertEntityConfig.getFrom_table())) {
                        List<Field> fields = (List<Field>) record.getFields();
                        FieldEntryHolder[] fieldArray = getFieldEntryHolder(record);
                        Map<String, String> sourceMap = convertMap(fields, fieldArray[0], fieldArray[0]);
                        sourceMap.put(RowKeyStatic.ROW_STATUE,RowKeyStatic.ROW_STATUS_DELETE);
                        sourceMap.put(RowKeyStatic.ROW_TIMESTAMP,String.valueOf(new Date().getTime()));
                        String json = convertEntityConfig.getTo_topic() + KafkaProducerWrap.SEPARATOR + ConvertEntityInit.convertEntity(sourceMap, convertEntityConfig);
                        log.info(json);
                        KafkaSinkProcessor.toKafkaChannel.put(json);
                    }
                }
                break;
            }
            case UPDATE: {
                List<ConvertEntityConfig> convertEntityConfigList = ConvertEntityInit.getConvertEntityConfigList();
                for (ConvertEntityConfig convertEntityConfig : convertEntityConfigList) {
                    if (record.getObjectName() != null && record.getObjectName().equals(convertEntityConfig.getFrom_db() + "." + convertEntityConfig.getFrom_table())) {
                        List<Field> fields = (List<Field>) record.getFields();
                        FieldEntryHolder[] fieldArray = getFieldEntryHolder(record);
                        Map<String, String> sourceMap = convertMap(fields, fieldArray[0], fieldArray[1]);
                        sourceMap.put(RowKeyStatic.ROW_STATUE,RowKeyStatic.ROW_STATUS_INSERT);
                        sourceMap.put(RowKeyStatic.ROW_TIMESTAMP,String.valueOf(new Date().getTime()));
                        String json = convertEntityConfig.getTo_topic() + KafkaProducerWrap.SEPARATOR + ConvertEntityInit.convertEntity(sourceMap, convertEntityConfig);
                        log.info(json);
                        KafkaSinkProcessor.toKafkaChannel.put(json);
                    }
                }
                break;
            }
            case INSERT: {
                List<ConvertEntityConfig> convertEntityConfigList = ConvertEntityInit.getConvertEntityConfigList();
                for (ConvertEntityConfig convertEntityConfig : convertEntityConfigList) {
                    if (record.getObjectName() != null && record.getObjectName().equals(convertEntityConfig.getFrom_db() + "." + convertEntityConfig.getFrom_table())) {
                        List<Field> fields = (List<Field>) record.getFields();
                        FieldEntryHolder[] fieldArray = getFieldEntryHolder(record);
                        Map<String, String> sourceMap = convertMap(fields, fieldArray[0], fieldArray[1]);
                        sourceMap.put(RowKeyStatic.ROW_STATUE,RowKeyStatic.ROW_STATUS_INSERT);
                        sourceMap.put(RowKeyStatic.ROW_TIMESTAMP,String.valueOf(new Date().getTime()));
                        String json2 = ConvertEntityInit.convertEntity(sourceMap, convertEntityConfig);
                        String json = convertEntityConfig.getTo_topic() + KafkaProducerWrap.SEPARATOR + ConvertEntityInit.convertEntity(sourceMap, convertEntityConfig);
                        log.info(json);
                        KafkaSinkProcessor.toKafkaChannel.put(json);
                    }
                }
                break;
            }
            /*default: {
                List<Field> fields = (List<Field>) record.getFields();
                FieldEntryHolder[] fieldArray = getFieldEntryHolder(record);
                appendRecordGeneralInfo(record, stringBuilder);
                appendFields(fields, fieldArray[0], fieldArray[1], stringBuilder);
                break;
            }*/
        }

        return stringBuilder.toString();
    }

    private static FieldEntryHolder[] getFieldEntryHolder(Record record) {
        FieldEntryHolder[] fieldArray = new FieldEntryHolder[2];
        fieldArray[0] = new FieldEntryHolder((List<Object>) record.getBeforeImages());
        fieldArray[1] = new FieldEntryHolder((List<Object>) record.getAfterImages());
        return fieldArray;
    }

    private static Map<String, String> convertMap(List<Field> fields, FieldEntryHolder before, FieldEntryHolder after) {
        Map<String, String> result = new HashMap<>();
        if (null != fields) {
            Iterator<Field> fieldIterator = fields.iterator();
            while (fieldIterator.hasNext() && before.hasNext() && after.hasNext()) {
                Field field = fieldIterator.next();
                //Object toPrintBefore = before.take();
                Object toPrintAfter = after.take();
                if (toPrintAfter != null) {
                    result.put(field.getName(), FIELD_CONVERTER.convert(field, toPrintAfter).toString());
                } else {
                    result.put(field.getName(), "");
                }
                if (toPrintAfter instanceof DateTime) {
                    StringBuffer buf = new StringBuffer();
                    buf.append(((DateTime) toPrintAfter).getYear());
                    buf.append("-");
                    buf.append(((DateTime) toPrintAfter).getMonth());
                    buf.append("-");
                    buf.append(((DateTime) toPrintAfter).getDay());
                    buf.append(" ");
                    buf.append(((DateTime) toPrintAfter).getHour());
                    buf.append(":");
                    buf.append(((DateTime) toPrintAfter).getMinute());
                    buf.append(":");
                    buf.append(((DateTime) toPrintAfter).getSecond());
                    result.put(field.getName(), buf.toString());
                }
            }
        }
        return result;
    }

}
