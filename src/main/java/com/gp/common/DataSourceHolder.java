package com.gp.common;

/**
 * The database context holder keep the context setting(DataSource Name)
 * in the ThreadLocal variable.
 * 
 * @author diaogc
 * @version 0.1 2016-12-29
 * 
 **/
public class DataSourceHolder {

	public static final String TRNS_MGR = "gpTxManager";
	
	public static final String DATA_SRC = "gpDataSource";
	
	public static final String TRANSFER_CACHE = "fileTransferCache";
	
	public static final String SYSSETTING_CACHE = "sysSettingCache";
	
	public static final String DICTIONARY_CACHE = "dictionaryCache";
	
	/**
	 * the thread-local variable 
	 **/
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
      
    /**
     * set the database type to thread local 
     **/
    public static void setDataSourceKey(String databaseType) {  
        contextHolder.set(databaseType);  
    }  
    
    /**
     * get the database type from the thread-local 
     **/
    public static String getDataSourceKey() {  
        return contextHolder.get();  
    }  
    
    /**
     * reset the database type from thread-local 
     **/
    public static void resetDataSourceKey() {  
        contextHolder.remove();  
    }  
}
