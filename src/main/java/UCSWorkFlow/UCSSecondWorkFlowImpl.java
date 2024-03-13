package UCSWorkFlow;
import io.temporal.activity.ActivityCancellationType;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Async;
import io.temporal.workflow.CancellationScope;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class UCSSecondWorkFlowImpl implements UCSSecondWorkFlow{

    //Specifying retry options
    RetryOptions retryOptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(5))
            .build();

    // Specifying Local activity options... Required timeouts.
    ActivityOptions activityOptions = ActivityOptions.newBuilder().
            setStartToCloseTimeout(Duration.ofSeconds(60)).setRetryOptions(retryOptions).
            setHeartbeatTimeout(Duration.ofSeconds(5)).
            setCancellationType(ActivityCancellationType.WAIT_CANCELLATION_COMPLETED).build();

    private final UCSActivities activity = Workflow.newActivityStub(UCSActivities.class,activityOptions);

    // Workflow which updates balances of student and retailer with respective admin
    @Override
    public void concurrentTransfer() {
        activity.setInitialValues();
        System.out.println("Before Transfer : " + activity.admin.getMoneyBalance());
        activity.transferCreditToMoney(50);
        activity.transferMoneyToCredit(50);
        System.out.println("After Transfer + " + activity.admin.getMoneyBalance());
    }

}
