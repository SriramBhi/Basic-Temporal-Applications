package UCSWorkFlow;

import io.temporal.activity.Activity;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowExecutionAlreadyStarted;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import java.util.Scanner;

import java.time.Duration;

public class UCSStarter {
    public static void main(String[] args){
        //gRPC stub for establishing connection with local dev server
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client = WorkflowClient.newInstance(service);

        final String WORKFLOW_ID = "UCS";

//        Workflow options for the first workflow
//        WorkflowOptions options = WorkflowOptions.newBuilder().setWorkflowId(WORKFLOW_ID)
//                .setTaskQueue(Shared.UCS_TASK_QUEUE)
//                .setWorkflowExecutionTimeout(Duration.ofMinutes(1)).build();

        // WorkFlow options for setting Cron job
        WorkflowOptions options_cron = WorkflowOptions.newBuilder().setWorkflowId(WORKFLOW_ID).setTaskQueue(Shared.UCS_TASK_QUEUE).
                setCronSchedule("* * * * *").build();

        //gRPC stub for the first workflow
//        UCSWorkFlow ucs = client.newWorkflowStub(UCSWorkFlow.class,options);

        //gRPC stub for the second workflow
        UCSSecondWorkFlow ucsSecond = client.newWorkflowStub(UCSSecondWorkFlow.class,options_cron);


//        Scanner sc = new Scanner(System.in);

        System.out.println("WorkFlow Started....");

        // First WorkFlow -- Transaction
//        WorkflowClient.start(ucs::transaction);
//        ucs.inputs(20,20);

//      Second Workflow - Concurrent recharge
        try {
            System.out.println("Concurrent Transfer Started....");
            ucsSecond.concurrentTransfer();
        }catch(WorkflowExecutionAlreadyStarted e){
            throw Activity.wrap(e);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }
}
