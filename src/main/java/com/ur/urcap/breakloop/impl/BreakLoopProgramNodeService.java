package com.ur.urcap.breakloop.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.ProgramNodeService;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;

import java.io.InputStream;

public class BreakLoopProgramNodeService implements ProgramNodeService {

	@Override
	public String getId() {
		return "BreakLoop";
	}

	@Override
	public boolean isDeprecated() {
		return false;
	}

	@Override
	public boolean isChildrenAllowed() {
		return false;
	}

	@Override
	public String getTitle() {

		return "Break Loop";
	}

	@Override
	public InputStream getHTML() {

		return this.getClass().getResourceAsStream("/com/ur/urcap/breakloop/impl/BreakLoopProgramNode_en.html");

	}

	@Override
	public ProgramNodeContribution createNode(URCapAPI api, DataModel model) {
		return new BreakLoopProgramNodeContribution(api, model);
	}
}
