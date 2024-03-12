package UCSWorkFlow;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
public class UCSWorker {
    public static void main(String[] args) {
        //gRPC stub for connecting to local dev server
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();


        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        Worker worker = factory.newWorker(Shared.UCS_TASK_QUEUE);

        // Registering workflow and activity implementations to the worker
        worker.registerWorkflowImplementationTypes(UCSWorkFlowImpl.class);
        worker.registerActivitiesImplementations(new UCSActivitiesImpl());

        factory.start();
    }
}
