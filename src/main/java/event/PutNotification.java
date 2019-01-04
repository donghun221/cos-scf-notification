package event;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qcloud.cos.utils.Jackson;
import com.qcloud.scf.runtime.Context;

import model.COSEventNotification;
import model.COSEventNotificationRecord;
import utils.Utils;

import static utils.Utils.INFO;
import static utils.Utils.DEBUG;
import static utils.Utils.WARN;
import static utils.Utils.TRACE;
import static utils.Utils.ERROR;

/**
 * Receives COS notification of PUT request
 * 
 * SCF does not support Logging output yet, using system.out instead
 * 
 * @author dongxuny
 *
 */
public class PutNotification implements RequestHandler<Object, String> {
    public static void main(String args[]) {
        PutNotification put = new PutNotification();
        put.handleRequest(null, null);
    }
    
    private static Logger LOGGER = LoggerFactory.getLogger(PutNotification.class);
    
    public String handleRequest(Object input, Context context) {
        // LOGGER.info("Received Notification with requestId:{}", context.getRequestId());
        System.out.println(String.format("%s Received Notification with requestId:[%s]", Utils.getLoggerPrefix(INFO), context.getRequestId()));
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
            System.out.println(String.format("%s Unable to parse input LinkedHashMap to json string, stop function...\n %s", Utils.getLoggerPrefix(INFO), e));
            return ERROR;
        }
        
        // LOGGER.info("Parsing input object to JSON string success...");
        System.out.println(String.format("%s Parsing input object to JSON string success...", Utils.getLoggerPrefix(INFO)));
        // LOGGER.info("Json String:\n{}", new JSONObject(json).toString(4));
        System.out.println(String.format("%s Json String:\n{}", Utils.getLoggerPrefix(DEBUG), new JSONObject(json).toString(4)));

        try {
            COSEventNotification notification = Jackson.fromJsonString(json, COSEventNotification.class);
            if (notification.getRecords().size() < 1) {
                //LOGGER.warn("No record exists, stop function...");
                System.out.println(String.format("%s No record exists, stop function...", Utils.getLoggerPrefix(WARN)));
                return FAIL;
            }
            
            for (COSEventNotificationRecord record : notification.getRecords()) {
                printCOSEventNotificationRecord(record);
            }
        } catch (Exception e) {
            // LOGGER.error("Parsing JSON string to COSEventNotification failed...\n {}", e);
            System.out.println(String.format("%s Parsing JSON string to COSEventNotification failed...\\n %s", Utils.getLoggerPrefix(WARN), e));

            return ERROR;
        }
        
        return SUCCESS;
    }
    
    private void printCOSEventNotificationRecord(COSEventNotificationRecord record) {
        // Log general information
        // LOGGER.info("NotificationId:[{}]", record.getCos().getCosNotificationId());
        System.out.println(String.format("%s NotificationId:[%s]", Utils.getLoggerPrefix(INFO), record.getCos().getCosNotificationId()));

        // LOGGER.info("COSSchemaVersion:[{}]", record.getCos().getCosSchemaVersion());
        System.out.println(String.format("%s COSSchemaVersion:[%s]", Utils.getLoggerPrefix(INFO), record.getCos().getCosSchemaVersion()));

        // Log COS related information
        // LOGGER.info("COSBucket:\n{}", new JSONObject(record.getCos().getBucket()).toString(4));
        System.out.println(String.format("%s COSBucket:\n%s", Utils.getLoggerPrefix(INFO), new JSONObject(record.getCos().getBucket()).toString(4)));

        // LOGGER.info("COSObject:\n{}", new JSONObject(record.getCos().getObject()).toString(4));
        System.out.println(String.format("%s COSObject:\n%s", Utils.getLoggerPrefix(INFO), new JSONObject(record.getCos().getObject()).toString(4)));

        // Log Request related information
        // LOGGER.info("RequestId:[{}]", record.getEvent().getRequestId());
        System.out.println(String.format("%s RequestId:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getRequestId()));

        // LOGGER.info("RequestParameters:\n{}", new JSONObject(record.getEvent().getRequestParameters()).toString(4));
        System.out.println(String.format("%s RequestParameters:\n%s", Utils.getLoggerPrefix(INFO), new JSONObject(record.getEvent().getRequestParameters()).toString(4)));

        // Log Event related information
        // LOGGER.info("EventName:[{}]", record.getEvent().getEventName());
        System.out.println(String.format("%s EventName:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getEventName()));

        // LOGGER.info("EventQueue:[{}]", record.getEvent().getEventQueue());
        System.out.println(String.format("%s EventQueue:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getEventQueue()));

        // LOGGER.info("EventSource:[{}]", record.getEvent().getEventSource());
        System.out.println(String.format("%s EventSource:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getEventSource()));

        // LOGGER.info("EventTime:[{}]", record.getEvent().getEventTime());
        System.out.println(String.format("%s EventTime:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getEventTime()));

        // LOGGER.info("EventVersion:[{}]", record.getEvent().getEventVersion());
        System.out.println(String.format("%s EventVersion:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getEventVersion()));

        // LOGGER.info("ReservedInfo:[{}]", record.getEvent().getReservedInfo());
        System.out.println(String.format("%s ReservedInfo:[%s]", Utils.getLoggerPrefix(INFO), record.getEvent().getReservedInfo()));
    }
}
