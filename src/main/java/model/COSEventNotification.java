package model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.qcloud.cos.utils.Jackson;

/**
 * A helper class that represents a strongly typed COS EventNotification item sent
 * to SCF.
 * 
 * Reference: https://cloud.tencent.com/document/product/583/9707
 * 
 * +-----------+--------------------------------------------------------------------------------------------+
 * |  Records  | A list which contains multiple record                                                      |
 * +-----------+--------------------------------------------------------------------------------------------+
 * |   event   | Including event version, name, timestamp, source queue information, params, and request ID |
 * +-----------+--------------------------------------------------------------------------------------------+
 * |    cos    | Including COS related information                                                          |
 * +-----------+--------------------------------------------------------------------------------------------+
 * | cosBucket | Sub element of cos, including bucket information                                           |
 * +-----------+--------------------------------------------------------------------------------------------+
 * | cosObject | Sub element of cos, including object information                                           |
 * +-----------+--------------------------------------------------------------------------------------------+
 * 
 * @author dongxuny
 *
 */
public class COSEventNotification {
    private final List<COSEventNotificationRecord> records;

    @JsonCreator
    public COSEventNotification(
            @JsonProperty(value = "Records") List<COSEventNotificationRecord> records) {
        
        this.records = records;
    }
    
    public static COSEventNotification fromJson(String json) {
        return Jackson.fromJsonString(json, COSEventNotification.class);
    }
    
    public List<COSEventNotificationRecord> getRecords() {
        return records;
    }
    
    public String toJson() {
        return Jackson.toJsonString(this);
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("records", records)
                .toString();
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof COSEventNotification)) {
            return false;
        }
        
        COSEventNotification notification = (COSEventNotification) other;
        return new EqualsBuilder()
                .append(this.records, notification.records)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.records)
                .toHashCode();
    }
}
