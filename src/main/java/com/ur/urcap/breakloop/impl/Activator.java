package com.ur.urcap.breakloop.impl;

import com.ur.urcap.api.contribution.ProgramNodeService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {

		context.registerService(ProgramNodeService.class, new BreakLoopProgramNodeService(), null);

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {

	}
}
