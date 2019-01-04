package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class COSEventNotificationRecord {
    private final COSEntity cos;
    private final SCFEventEntity event;

    @JsonCreator
    public COSEventNotificationRecord(
            @JsonProperty(value = "cos") COSEntity cos,
            @JsonProperty(value = "event") SCFEventEntity event) {
        
        this.cos = cos;
        this.event = event;
    }
    
    public COSEntity getCos() {
        return cos;
    }

    public SCFEventEntity getEvent() {
        return event;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cos", cos)
                .add("event", event)
                .toString();
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof COSEventNotificationRecord)) {
            return false;
        }
        
        COSEventNotificationRecord record = (COSEventNotificationRecord) other;
        return new EqualsBuilder()
                .append(this.cos, record.cos)
                .append(this.event, record.event)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.cos)
                .append(this.event)
                .toHashCode();
    }
}
