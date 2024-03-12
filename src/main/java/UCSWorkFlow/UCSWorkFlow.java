package UCSWorkFlow;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
@WorkflowInterface
public interface UCSWorkFlow {
   @WorkflowMethod
   int transaction();

   @SignalMethod
   void inputs(int creditsToBeTransferred,int price);
}
