package driver;

import java.io.IOException;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

public class CustomRunner extends Cucumber
{
	
	@SuppressWarnings("rawtypes")
	public CustomRunner(Class clazz) throws InitializationError, IOException
	{
		super(clazz);
	}

@Override
public void run(RunNotifier notifier)
{
	notifier.addListener(new CustomListener());
	super.run(notifier);
}

}
