package de.uks.beast.editor.util;

public enum ToolTips
{
	//@formatter:off
	TRANSFER_BTN_TIP			("Transfer data to the backend"),
	ATTR_0_PROP_TIP					("Configure the object with a unique IP adress"),
	ATTR_1_PROP_TIP			("Configure the server hardware. Choose the number of cpu cores"),
	NAME_TEXT_TIP				("You have to type in a name for your job. Default is 'default'"),
	
	PRIORITY_COMBO_TIP			("You habe to choose the priority of the job. Default is '0'"),
	RUN_STATE_CHECK_BTN_TIP		("You have to choose if your job shall be executed immediately or not on the virual machine"),
	JOB_FILE_BTN_TIP			("You have to choose the job file via file browser"),
	INPUT_FILE_BTN_TIP			("You have to choose the input file(s) for the job"),
	HOME_OUTPUT_FILE_BTN		("You have to choose the output file via file browser in your home location"),
	EXT_OUTPUT_FILE_TIP			("You have to type in the path from the job output file on the virtual machine"),
	JOB_TRANSFER_BTN_TIP		("You transfer the main job to the virtual machine"),
	RESET_BTN_TIP				("You can reset the input mask and set the params to default"),
	;//@formatter:on
	
	private final String	text;
	
	
	
	private ToolTips(final String text)
	{
		this.text = text;
	}
	
	
	
	/**
	 * @return the text
	 */
	public final String get()
	{
		return text;
	}
	
}
