package UCSWorkFlow;

import io.temporal.client.WorkflowClient;
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

        WorkflowOptions options = WorkflowOptions.newBuilder().setWorkflowId(WORKFLOW_ID)
                .setTaskQueue(Shared.UCS_TASK_QUEUE)
                .setWorkflowExecutionTimeout(Duration.ofMinutes(2)).build();

        UCSWorkFlow ucs = client.newWorkflowStub(UCSWorkFlow.class,options);

        Scanner sc = new Scanner(System.in);

        System.out.println("WorkFlow Started....");
        WorkflowClient.start(ucs::transaction);
        ucs.inputs(20,20);

    }
}
