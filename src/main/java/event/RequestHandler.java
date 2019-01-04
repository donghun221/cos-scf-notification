package event;

import com.qcloud.scf.runtime.Context;

/**
 * SCF request handlers implement Tencent SCF Function application logic using plain old java objects 
 * as input and output.
 * 
 * @author dongxuny
 *
 * @param <I>
 * @param <O>
 */
public interface RequestHandler<I, O> {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    public static final String FAIL = "fail";
    
    /**
     * Handles a SCF function request
     * @param input The SCF function input
     * @param context The SCF execution environment context object
     * @return The SCF function output
     */
    public O handleRequest(I input, Context context);
}
