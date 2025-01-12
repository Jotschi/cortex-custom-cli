package io.metaloom.cortex.cli.action;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.metaloom.cortex.api.action.FilesystemAction;
import io.metaloom.cortex.api.option.CortexOptions;
import io.metaloom.cortex.common.action.AbstractActionModule;
import io.metaloom.cortex.common.option.CortexActionOptionDeserializerInfo;

@Module
public abstract class CustomActionModule extends AbstractActionModule {
	
	private static final String KEY = "custom";

	@Binds
	@IntoSet
	abstract FilesystemAction bindAction(CustomAction action);
	
	@IntoSet
	@Provides
	public static CortexActionOptionDeserializerInfo optionInfo() {
		return new CortexActionOptionDeserializerInfo(CustomActionOptions.class, CustomActionOptions.KEY);
	}
	
	@Provides
	public static CustomActionOptions options(CortexOptions options) {
		return actionOptions(options, KEY, new CustomActionOptions());
	}
}
