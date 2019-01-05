package event;

import org.json.JSONObject;

import com.qcloud.cos.utils.Jackson;
import com.qcloud.scf.runtime.Context;

import logger.CustomLogger;
import model.COSEventNotification;
import model.COSEventNotificationRecord;

/**
 * Receives COS notification of PUT request
 * 
 * SCF does not support Logging output yet, using system.out instead
 * 
 * @author dongxuny
 *
 */
public class COSNotification implements RequestHandler<Object, String> {
    // private static Logger LOGGER = LoggerFactory.getLogger(PutNotification.class);
    private static CustomLogger LOGGER = new CustomLogger(COSNotification.class.getSimpleName());
    
    public String handleRequest(Object input, Context context) {
        // LOGGER.info("Received Notification with requestId:{}", context.getRequestId());
        LOGGER.info("Received Notification with requestId:%s", context.getRequestId());
        
        /*
         * By default, the input object is LinkedHashMap, we will convert it to JSON string 
         * and parse it with COSEventNotification.
         * 
         * Why?
         * 
         * Because, LinkedHashMap is not a good way of passing as parameter for Serverless function call
         * and I am assuming it will be replaced by JSON.
         */
        String json = new String();
        try {
            json = Jackson.toJsonString(input);
        } catch (IllegalStateException e) {
            // LOGGER.error("Unable to parse input LinkedHashMap to json string, stop function...\n {}", e);
            LOGGER.error("Unable to parse input LinkedHashMap to json string, stop function...\n ", e);
            return ERROR;
        }
        
        // LOGGER.info("Parsing input object to JSON string success...");
        LOGGER.info("Parsing input object to JSON string success...");
        // LOGGER.debug("Json String:\n{}", new JSONObject(json).toString(4));
        LOGGER.debug("Json String:\n%s", new JSONObject(json).toString(4));

        try {
            COSEventNotification notification = Jackson.fromJsonString(json, COSEventNotification.class);
            if (notification.getRecords().size() < 1) {
                //LOGGER.warn("No record exists, stop function...");
                LOGGER.warn("No record exists, stop function...");
                return FAIL;
            }
            
            for (COSEventNotificationRecord record : notification.getRecords()) {
                printCOSEventNotificationRecord(record);
            }
        } catch (Exception e) {
            // LOGGER.error("Parsing JSON string to COSEventNotification failed...\n {}", e);
            LOGGER.error("Parsing JSON string to COSEventNotification failed...\n %s", e);
            return ERROR;
        }
        
        return SUCCESS;
    }
    
    private void printCOSEventNotificationRecord(COSEventNotificationRecord record) {
        // Log general information
        // LOGGER.info("NotificationId:[{}]", record.getCos().getCosNotificationId());
        LOGGER.info("NotificationId:%s", record.getCos().getCosNotificationId());

        // LOGGER.info("COSSchemaVersion:[{}]", record.getCos().getCosSchemaVersion());
        LOGGER.info("COSSchemaVersion:%s", record.getCos().getCosSchemaVersion());

        // Log COS related information
        // LOGGER.info("COSBucket:\n{}", new JSONObject(record.getCos().getBucket()).toString(4));
        LOGGER.info("COSBucket:\n%s", new JSONObject(record.getCos().getBucket()).toString(4));

        // LOGGER.info("COSObject:\n{}", new JSONObject(record.getCos().getObject()).toString(4));
        LOGGER.info("COSObject:\n%s", new JSONObject(record.getCos().getObject()).toString(4));

        // Log Request related information
        // LOGGER.info("RequestId:[{}]", record.getEvent().getRequestId());
        LOGGER.info("RequestId:%s", record.getEvent().getRequestId());

        // LOGGER.info("RequestParameters:\n{}", new JSONObject(record.getEvent().getRequestParameters()).toString(4));
        LOGGER.info("RequestParameters:\n%s", new JSONObject(record.getEvent().getRequestParameters()).toString(4));

        // Log Event related information
        // LOGGER.info("EventName:[{}]", record.getEvent().getEventName());
        LOGGER.info("EventName:%s", record.getEvent().getEventName());

        // LOGGER.info("EventQueue:[{}]", record.getEvent().getEventQueue());
        LOGGER.info("EventQueue:%s", record.getEvent().getEventQueue());

        // LOGGER.info("EventSource:[{}]", record.getEvent().getEventSource());
        LOGGER.info("EventSource:%s", record.getEvent().getEventSource());

        // LOGGER.info("EventTime:[{}]", record.getEvent().getEventTime());
        LOGGER.info("EventTime:%s", record.getEvent().getEventTime());

        // LOGGER.info("EventVersion:[{}]", record.getEvent().getEventVersion());
        LOGGER.info("EventVersion:%s", record.getEvent().getEventVersion());

        // LOGGER.info("ReservedInfo:[{}]", record.getEvent().getReservedInfo());
        LOGGER.info("ReservedInfo:%s", record.getEvent().getReservedInfo());
    }
}
