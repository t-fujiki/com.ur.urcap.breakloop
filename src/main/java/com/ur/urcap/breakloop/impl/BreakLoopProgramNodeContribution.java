package com.ur.urcap.breakloop.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.ui.annotation.Input;
import com.ur.urcap.api.ui.component.*;
import com.ur.urcap.api.ui.component.InputEvent.EventType;

public class BreakLoopProgramNodeContribution implements ProgramNodeContribution {

	private final URCapAPI api;
	private final DataModel model;

	@Input(id = "inputNodeTitle")
	private InputTextField inputNodeTitle;

	@Input(id = "inputNodeTitle")
	private void onInputNodeTitle(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			if (!inputNodeTitle.getText().isEmpty()) {
				model.set("inputNodeTitle", inputNodeTitle.getText());
				this.getTitle();
			} else
				model.remove("inputNodeTitle");

	}

	public BreakLoopProgramNodeContribution(URCapAPI api, DataModel model) {
		this.api = api;
		this.model = model;

	}

	@Override
	public void openView() {
		inputNodeTitle.setText(model.get("inputNodeTitle", ""));

	}

	@Override
	public void closeView() {

	}

	@Override
	public String getTitle() {

		String color = "#800080";

		String htmlStart = "<html><span style='font-weight:bold; color:" + color + ";'>" + "break:";
		String htmlEnd = "</span></html>";

		return htmlStart + model.get("inputNodeTitle", "") + htmlEnd;

	}

	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public void generateScript(ScriptWriter writer) {
		writer.appendLine("break");
	}

}