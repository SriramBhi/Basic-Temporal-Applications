package UCSWorkFlow;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.failure.ApplicationFailure;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class UCSWorkFlowImpl implements UCSWorkFlow{

    // Required data points to store dynamic inputs
    private int creditsToBeTransferred;
    private int price;

    //Specifying retry options
    RetryOptions retryOptions = RetryOptions.newBuilder().setInitialInterval(Duration.ofSeconds(5))
            .build();

    // Specifying Local activity options... Required timeouts.
    ActivityOptions activityOptions = ActivityOptions.newBuilder().
            setStartToCloseTimeout(Duration.ofSeconds(60)).setRetryOptions(retryOptions).build();

    private final UCSActivities activity = Workflow.newActivityStub(UCSActivities.class,activityOptions);

    @Override
    public int transaction() {

        // Assigning pre-requisite data
        activity.setInitialValues();
        //Input Check
        boolean inputCheck = Workflow.await(Duration.ofSeconds(10),()->(this.creditsToBeTransferred != 0) && (this.price != 0));


        if(inputCheck)
          return activity.transactionStuToRet(creditsToBeTransferred,price);
        else
            throw ApplicationFailure.newFailure(
                    "Signal is not received within 10 seconds.", "signal-timeout");
    }

    // Passing input to the running instance of the workflow
    @Override
    public void inputs(int creditsToBeTransferred, int price) {
        this.creditsToBeTransferred = creditsToBeTransferred;
        this.price = price;
    }
}
