# Basic-Temporal-Applications
A repo of basic java applications with written temporal workflows.

## Description :
All the applications and workflows wrote while learning process will be pushed into this repository branch wise. Changes done w.r.t applications will be merged in that corresponsing branch.

<br></br>

### Main Branch :
### Application : University-Credit-System.
<b> Breif : </b> A basic application where students can buy their requirements from retailer with their respective credit balance which can be recharged with actual currency through the admin.
Same applies to the retailer inorder to exchange credits with actual currency.

<b>Explored Topics of Temporal while writing workflow: </b> <br>
1. Wrote a basic workflow for reliable execution of the transaction process.
2. Leveraged the property of signal method in order to pass input dynamically.
3. Explored different ways on how we can use timeouts and retry options for both workflows and activities for durability and reliability according to our business logic.
4. Usage of cronjob inorder to manually upgrade fixed amount of credits for retailer (Periodically).
5. Usage of cronjob inorder to manually upgrade fixed amount of credits for student (Periodically).

<b>Topics to be explored : </b> <br>
1. Usage of LocalActivityOptions inorder to restrict activities inorder to execute in a single worker.

### Remarks : 


