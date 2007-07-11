package com.itmill.toolkit.terminal.gwt.client.ui;

import com.google.gwt.user.client.Command;
import com.itmill.toolkit.terminal.gwt.client.Client;

/**
 *
 */
public abstract class IAction implements Command {
	
	protected IActionOwner owner;
	
	protected String iconUrl = null;
	
	protected String caption = "";
	
	public IAction(IActionOwner owner) {
		this.owner = owner;
	}
	
	/**
	 * Executed when action fired
	 */
	public abstract void execute();
	
	public String getHTML() {
		StringBuffer sb = new StringBuffer();
		if(getIconUrl() != null) {
			sb.append("<img src=\""+getIconUrl()+"\" alt=\"icon\" />");
		}
		sb.append(getCaption());
		return sb.toString();
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getIconUrl() {
		return iconUrl;
	}
}

/**
 * Action owner must provide a set of actions for context menu
 * and IAction objects.
 */
interface IActionOwner {
	
	/**
	 * @return Array of IActions
	 */
	public IAction[] getActions();

	public Client getClient();
	
	public String getPaintableId();
}