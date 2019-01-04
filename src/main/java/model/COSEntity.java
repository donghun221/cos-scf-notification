package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

/**
 * A helper class that represents a strongly typed COSObject item
 * 
 * Reference: https://cloud.tencent.com/document/product/583/9707
 * 
 * +-------------------+-----------------------+
 * | cosSchemaVersion  | The version of schema |                                         
 * +-------------------+-----------------------+
 * |     cosBucket     | Entity of COS Bucket  |
 * +-------------------+-----------------------+
 * |     cosObject     | Entity of COS Object  |                                          
 * +-------------------+-----------------------+
 * | cosNotificationId | COS Notification ID   |                                   
 * +-------------------+-----------------------+
 * 
 * @author dongxuny
 *
 */
public class COSEntity {
    private final String cosSchemaVersion;
    private final COSBucketEntity bucket;
    private final COSObjectEntity object;
    private final String cosNotificationId;
    
    @JsonCreator
    public COSEntity(
            @JsonProperty(value = "cosNotificationId") String cosNotificationId,
            @JsonProperty(value = "cosBucket") COSBucketEntity bucket,
            @JsonProperty(value = "cosObject") COSObjectEntity object,
            @JsonProperty(value = "cosSchemaVersion") String cosSchemaVersion) {
        
        this.cosNotificationId = cosNotificationId;
        this.bucket = bucket;
        this.object = object;
        this.cosSchemaVersion = cosSchemaVersion;
    }

    public String getCosSchemaVersion() {
        return cosSchemaVersion;
    }

    public COSBucketEntity getBucket() {
        return bucket;
    }

    public COSObjectEntity getObject() {
        return object;
    }

    public String getCosNotificationId() {
        return cosNotificationId;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("cosNotificationId", cosNotificationId)
                .add("bucket", bucket)
                .add("object", object)
                .add("cosSchemaVersion", cosSchemaVersion)
                .toString();
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof COSEntity)) {
            return false;
        }
        
        COSEntity entity = (COSEntity) other;
        return new EqualsBuilder()
                .append(this.cosNotificationId, entity.cosNotificationId)
                .append(this.bucket, entity.bucket)
                .append(this.object, entity.object)
                .append(this.cosSchemaVersion, entity.cosSchemaVersion)
                .isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.cosNotificationId)
                .append(this.bucket)
                .append(this.object)
                .append(this.cosSchemaVersion)
                .toHashCode();
    }
    
    /**
     * A helper class that represents a strongly typed COSBucket item
     * 
     * Reference: https://cloud.tencent.com/document/product/583/9707
     * 
     * +--------+----------------------------------------------------------------+
     * |  name  | Name of the bucket without appId as suffix                     |                                                   |
     * +--------+----------------------------------------------------------------+
     * | appid  | appId of the bucket owner                                      |
     * +--------+----------------------------------------------------------------+
     * | region | Region where bucket belongs to which follows V4 version of COS |                                                        |
     * +--------+----------------------------------------------------------------+
     *
     * @author dongxuny
     *
     */
    public static class COSBucketEntity {
        private final String name;
        private final String appId;
        private final String region;
        
        @JsonCreator
        public COSBucketEntity(
                @JsonProperty(value = "name") String name,
                @JsonProperty(value = "appid") String appId,
                @JsonProperty(value = "region") String region) {
            
                    this.name = name;
                    this.appId = appId;
                    this.region = region;
                }

        public String getName() {
            return name;
        }

        public String getAppId() {
            return appId;
        }

        public String getRegion() {
            return region;
        }
    
        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("bucketName", name)
                    .add("appId", appId)
                    .add("region", region)
                    .toString();
        }
        
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof COSBucketEntity)) {
                return false;
            }
            
            COSBucketEntity entity = (COSBucketEntity) other;
            return new EqualsBuilder()
                    .append(this.name, entity.name)
                    .append(this.appId, entity.appId)
                    .append(this.region, entity.region)
                    .isEquals();
        }
        
        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(this.name)
                    .append(this.appId)
                    .append(this.region)
                    .toHashCode();
        }
    }

    /**
     * A helper class that represents a strongly typed COSObject item
     * 
     * Reference: https://cloud.tencent.com/document/product/583/9707
     * 
     * +--------+----------------------------------------------------------------+
     * |  name  | Name of the bucket without appId as suffix                     |                                                   |
     * +--------+----------------------------------------------------------------+
     * | appid  | appId of the bucket owner                                      |
     * +--------+----------------------------------------------------------------+
     * | region | Region where bucket belongs to which follows V4 version of COS |                                                        |
     * +--------+----------------------------------------------------------------+
     *
     * @author dongxuny
     *
     */
    public static class COSObjectEntity {
        private final String key;
        private final long size;
        private final String url;
        private final String versionId;
        private final COSObjectMetadata metadata;
        
        @JsonCreator
        public COSObjectEntity(
                @JsonProperty(value = "key") String key,
                @JsonProperty(value = "size") Long size,
                @JsonProperty(value = "url") String url,
                @JsonProperty(value = "vid") String versionId,
                @JsonProperty(value = "meta") COSObjectMetadata metadata) {
            
            this.key = key;
            this.size = size;
            this.url = url;
            this.versionId = versionId;
            this.metadata = metadata;
        }
        
        public String getKey() {
            return key;
        }

        public long getSize() {
            return size;
        }

        public String getUrl() {
            return url;
        }

        public String getVersionId() {
            return versionId;
        }

        public COSObjectMetadata getMetadata() {
            return metadata;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("key", key)
                    .add("size", size)
                    .add("url", url)
                    .add("versionId", versionId)
                    .add("metadata", metadata)
                    .toString();
        }
        
        @Override
        public boolean equals(Object other) {
            if (!(other instanceof COSObjectEntity)) {
                return false;
            }
            
            COSObjectEntity entity = (COSObjectEntity) other;
            return new EqualsBuilder()
                    .append(this.key, entity.key)
                    .append(this.size, entity.size)
                    .append(this.url, entity.url)
                    .append(this.versionId, entity.versionId)
                    .append(this.metadata, entity.metadata)
                    .isEquals();
        }
        
        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(this.key)
                    .append(this.size)
                    .append(this.url)
                    .append(this.versionId)
                    .append(this.metadata)
                    .toHashCode();
        }
        
        public static class COSObjectMetadata {
            private final String contentType;
            private final String requestId;
            
            @JsonCreator
            public COSObjectMetadata(
                    @JsonProperty(value = "contentType") String contentType,
                    @JsonProperty(value = "requestId") String requestId) {
                
                this.contentType = contentType;
                this.requestId = requestId;
            }

            public String getContentType() {
                return contentType;
            }

            public String getRequestId() {
                return requestId;
            }
        
            @Override
            public String toString() {
                return MoreObjects.toStringHelper(this)
                        .add("contentType", contentType)
                        .add("requestId", requestId)
                        .toString();
            }
            
            @Override
            public boolean equals(Object other) {
                if (!(other instanceof COSObjectMetadata)) {
                    return false;
                }
                
                COSObjectMetadata metadata = (COSObjectMetadata) other;
                return new EqualsBuilder()
                        .append(this.contentType, metadata.contentType)
                        .append(this.requestId, metadata.requestId)
                        .isEquals();
            }
            
            @Override
            public int hashCode() {
                return new HashCodeBuilder()
                        .append(this.contentType)
                        .append(this.requestId)
                        .toHashCode();
            }
        }
    }
}
