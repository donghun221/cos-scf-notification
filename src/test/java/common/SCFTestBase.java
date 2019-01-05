package common;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.qcloud.cos.utils.IOUtils;

import model.COSEntity;
import model.COSEntity.COSBucketEntity;
import model.COSEntity.COSObjectEntity;
import model.COSEventNotification;
import model.COSEventNotificationRecord;
import model.SCFEventEntity;
import model.SCFEventEntity.RequestParameters;
import model.SCFEventEntity.RequestParameters.RequestHeaders;

public class SCFTestBase implements TestBase {
    private String COSPutNotificationTestFilePath = "COSPutNotification";
    private String COSPutNotification_JSON;
    private COSEventNotification putNotification;
    
    // This is not an correct Regex for COS Bucket
    protected String COSBucketRegex = "[a-z0-9A-Z]{1}[a-z0-9A-Z-]{0,40}[a-z0-9A-Z]{1}";

    @Before
    public void setUp() throws Exception {
        // Initialize PUT Notification String
        COSPutNotification_JSON = IOUtils.toString(getClass().getClassLoader().getResourceAsStream(COSPutNotificationTestFilePath));
        putNotification = COSEventNotification.fromJson(COSPutNotification_JSON);
    }

    @After
    public void tearDown() throws Exception {
        // TODO
    }
    
    protected String getCOSPutNotificationTestFilePath() {
        return COSPutNotificationTestFilePath;
    }

    protected String getCOSPutNotification_JSON() {
        return COSPutNotification_JSON;
    }

    protected COSEventNotification getNotification4Put() {
        return putNotification;
    }
    
    protected List<COSEventNotificationRecord> getRecords4Put() {
        return putNotification.getRecords();
    }
    
    protected COSEventNotificationRecord getFirstRecord4Put() {
        assertNotNull(putNotification.getRecords());
        assertTrue(putNotification.getRecords().size() >= 1);
        return putNotification.getRecords().get(0);
    }
    
    protected COSEntity getCOSEntity4Put() {
        return getFirstRecord4Put().getCos();
    }
    
    protected SCFEventEntity getSCFEventEntity4Put() {
        return getFirstRecord4Put().getEvent();
    }
    
    protected COSBucketEntity getBucketEntity4Put() {
        return getCOSEntity4Put().getBucket();
    }
    
    protected COSObjectEntity getObjectEntity() {
        return getCOSEntity4Put().getObject();
    }
    
    protected RequestParameters getRequestParameters4Put() {
        return getSCFEventEntity4Put().getRequestParameters();
    }
    
    protected RequestHeaders getRequestHeaders4Put() {
        return getRequestParameters4Put().getRequestHeaders();
    }
}
