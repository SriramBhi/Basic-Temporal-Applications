package UCSWorkFlow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface UCSSecondWorkFlow {
    @WorkflowMethod
    void concurrentTransfer();
}
