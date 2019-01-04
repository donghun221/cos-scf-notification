package event;

import com.qcloud.cos.utils.Jackson;
import com.qcloud.scf.runtime.Context;

import model.COSEventNotification;
import model.COSEventNotificationRecord;

public class PutNotification implements RequestHandler<Object, String> {
    public String handleRequest(Object input, Context context) {        
        String json = Jackson.toJsonString(input);
        
        COSEventNotification notification = Jackson.fromJsonString(json, COSEventNotification.class);

        COSEventNotificationRecord record = notification.getRecords().get(0);
        
        System.out.println(record.getCos().getBucket());
        System.out.println(record.getCos().getObject());
        
        return "Success";
    }
}
