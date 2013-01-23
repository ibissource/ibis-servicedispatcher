/*
 * $Log: DispatcherManager.java,v $
 * Revision 1.1  2007/04/25 15:38:53  europe\L190409
 * updated JavaDoc
 *
 * Revision 1.1  2006/03/20 10:05:29  europe\L190409
 * first version
 *
 */
package nl.nn.adapterframework.dispatcher;

import java.util.HashMap;

/**
 * DispatcherManager allows to register {@link RequestProcessor}s by name, and to excecute requests via them.  
 * 
 * @author  Gerrit van Brakel
 * @since   Ibis 4.4.5
 * @version $Id: DispatcherManager.java,v 1.1 2007/04/25 15:38:53 europe\L190409 Exp $
 */
public interface DispatcherManager {


	/**
	 * Execute a request on a registered {@link RequestProcessor}.
	 * 
	 * @param clientName			name of the RequestProcessor to proces the request on. Must match a name of a RequestProcessor {@link #register(String name, RequestProcessor listener) registered} with the DispatcherManager.
	 * @param correlationId			correlationId passed on to RequestProcessor. May be used to track processing of the message throug the business chain.  
	 * @param message				main message passed on to RequestProcessor. 
	 * @param requestContext		requestContext passed on to RequestProcessor. The requestContext may contain any object that is considered useful to pass on the the service called.
	 * @return						result of RequestProcessor
	 * @throws DispatcherException	thrown if RequestProcessor cannot be found, or other Dispatcher related problems.
	 * @throws RequestProcessorException
	 * 								wrapped exceptions originating from RequestProcessor.
	 */
	public String processRequest(String clientName, String correlationId, String message, HashMap requestContext) throws DispatcherException, RequestProcessorException;

	/**
	 * Execute a request on a registered {@link RequestProcessor}.
	 * The correlationId is set to null.
	 * 
	 * @see   #processRequest(String clientName, String correlationId, String message, HashMap requestContext) 
	 * 
	 * @param clientName			name of the RequestProcessor to proces the request on.
	 * @param message				main message passed on to RequestProcessor.
	 * @param requestContext		requestContext passed on to RequestProcessor.
	 * @return						result of RequestProcessor
	 * @throws DispatcherException	thrown if RequestProcessor cannot be found, or other Dispatcher related problems.
	 * @throws RequestProcessorException
	 * 								wrapped exceptions originating from RequestProcessor.
	 */
	public String processRequest(String clientName, String message, HashMap requestContext) throws DispatcherException, RequestProcessorException;

	/**
	 * Execute a request on a registered {@link RequestProcessor}. 
	 * The correlationId and requestContext are set to null.
	 * 
	 * @see   #processRequest(String clientName, String correlationId, String message, HashMap requestContext) 
	 * 
	 * @param clientName			name of the RequestProcessor to proces the request on.
	 * @param message				message passed on to RequestProcessor.
	 * @return						result of RequestProcessor.
	 * @throws DispatcherException	thrown if RequestProcessor cannot be found, or other Dispatcher related problems.
	 * @throws RequestProcessorException
	 * 								wrapped exceptions originating from RequestProcessor.
	 */
	public String processRequest(String clientName, String message) throws DispatcherException, RequestProcessorException;
	
	/**
	 * Register a {@link RequestProcessor} under a name. 
	 * @param name
	 * @param listener
	 * @throws DispatcherException
	 */
	public void register(String name, RequestProcessor listener) throws DispatcherException;
	
}