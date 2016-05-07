package okhttp3;

//comp530 My Change
import org.jbehave.core.annotations.*;
import sun.security.util.PendingException;
public class SPDYserverSendsSettingsToClient {
	@Given("the server sets 10 as the maximum limit of concurrent stream")
	@Pending
	public void givenTheServerSets10AsTheMaximumLimitOfConcurrentStream(){
		 //TODO
		throw new PendingException();
	}
	@When("a client requests server for settings")
	@Pending
	public void whenAClientRequestsServerForSettings(){
		 //TODO
		throw new PendingException();
	}
	@Then("the maximum concurrent stream at a time should be 10")
	@Pending
	public void thenTheMaximumConcurrentStreamAtATimeShouldBe10(){
		 //TODO
		throw new PendingException();
	}
}