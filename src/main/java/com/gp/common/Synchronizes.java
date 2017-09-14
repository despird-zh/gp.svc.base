package com.gp.common;

public class Synchronizes {

	public static enum SyncState{
		PENDING, // ready for further process
		SENDING, // sending data
		SENT, // be sent out
		SEND_FAIL, // fail send out
		RECEIVED, // be received 
		PROCESSED, // be handled
		PROCESS_ERROR, // be process error
	}
}
