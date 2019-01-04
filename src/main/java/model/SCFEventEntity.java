package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class SCFEventEntity {
    private final String eventName;
    private final String eventQueue;
    private final String eventSource;
    private final long eventTime;
    private final String eventVersion;
    private final String requestId;
    private final RequestParameters requestParameters;
    private final String reservedInfo;
    
    public SCFEventEntity(
            @JsonProperty(value = "eventName") String eventName,
            @JsonProperty(value = "eventQueue") String eventQueue,
            @JsonProperty(value = "eventSource") String eventSource,
            @JsonProperty(value = "eventTime") long eventTime,
            @JsonProperty(value = "eventVersion") String eventVersion,
            @JsonProperty(value = "reqid") String requestId,
            @JsonProperty(value = "requestParameters") RequestParameters requestParameters,
            @JsonProperty(value = "reservedInfo") String reservedInfo) {
        
        this.eventName = eventName;
        this.eventQueue = eventQueue;
        this.eventSource = eventSource;
        this.eventTime = eventTime;
        this.eventVersion = eventVersion;
        this.requestId = requestId;
        this.requestParameters = requestParameters;
        this.reservedInfo = reservedInfo;
    }
    
    public String getEventName() {
        return eventName;
    }

    public String getEventQueue() {
        return eventQueue;
    }

    public String getEventSource() {
        return eventSource;
    }

    public long getEventTime() {
        return eventTime;
    }

    public String getEventVersion() {
        return eventVersion;
    }

    public String getRequestId() {
        return requestId;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public String getReservedInfo() {
        return reservedInfo;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("eventName", eventName)
                .add("eventQueue", eventQueue)
                .add("eventSource", eventSource)
                .add("eventTime", eventTime)
                .add("eventVersion", eventVersion)
                .add("requestId", requestId)
                .add("requestParameters", requestParameters)
                .add("reservedInfo", reservedInfo)
                .toString();
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SCFEventEntity)) {
            return false;
        }
        
        SCFEventEntity entity = (SCFEventEntity) other;
        return new EqualsBuilder()
                .append(this.eventName, entity.eventName)
                .append(this.eventQueue, entity.eventQueue)
                .append(this.eventSource, entity.eventSource)
                .append(this.eventTime, entity.eventTime)
                .append(this.eventVersion, entity.eventVersion)
                .append(this.requestId, entity.requestId)
                .append(this.requestParameters, entity.requestParameters)
                .append(this.reservedInfo, entity.reservedInfo)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.eventName)
                .append(this.eventQueue)
                .append(this.eventSource)
                .append(this.eventTime)
                .append(this.eventVersion)
                .append(this.requestId)
                .append(this.requestParameters)
                .append(this.reservedInfo)
                .toHashCode();
    }
    
    public static class RequestParameters {
        private final RequestHeaders requestHeaders;
        private final String requestSourceIP;
        
        @JsonCreator
        public RequestParameters(
                @JsonProperty(value = "requestHeaders") RequestHeaders requestHeaders,
                @JsonProperty(value = "requestSourceIP") String requestSourceIP) {
            
            this.requestHeaders = requestHeaders;
            this.requestSourceIP = requestSourceIP;
        }
        
        public RequestHeaders getRequestHeaders() {
            return requestHeaders;
        }

        public String getRequestSourceIP() {
            return requestSourceIP;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("requestHeaders", requestHeaders)
                    .add("requestSourceIP", requestSourceIP)
                    .toString();
        }
        
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof RequestParameters)) {
                return false;
            }
            
            RequestParameters params = (RequestParameters) other;
            return new EqualsBuilder()
                    .append(this.requestHeaders, params.requestHeaders)
                    .append(this.requestSourceIP, params.requestSourceIP)
                    .isEquals();
        }
        
        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(this.requestHeaders)
                    .append(this.requestSourceIP)
                    .toHashCode();
        }
        
        public static class RequestHeaders {
            private final String authrization;
            
            @JsonCreator
            public RequestHeaders(
                    @JsonProperty(value = "Authorization") String authrization) {
                
                this.authrization = authrization;
            }

            public String getAuthrization() {
                return authrization;
            }
        
            @Override
            public String toString() {
                return MoreObjects.toStringHelper(this)
                        .add("authrization", authrization)
                        .toString();
            }
            
            @Override
            public boolean equals(Object other) {
                if (!(other instanceof RequestHeaders)) {
                    return false;
                }
                
                RequestHeaders headers = (RequestHeaders) other;
                return new EqualsBuilder()
                        .append(this.authrization, headers.authrization)
                        .isEquals();
            }
            
            @Override
            public int hashCode() {
                return new HashCodeBuilder()
                        .append(this.authrization)
                        .toHashCode();
            }
        }
    }
}
