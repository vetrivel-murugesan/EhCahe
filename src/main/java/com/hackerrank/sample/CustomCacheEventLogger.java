package com.hackerrank.sample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.event.CacheEventListener;

public class CustomCacheEventLogger implements CacheEventListener {

	 private static final Logger LOG= LoggerFactory.getLogger(CustomCacheEventLogger.class);


	 public Object clone() throws CloneNotSupportedException{
		return null;
		 
	 }

	@Override
	public void notifyRemoveAll(Ehcache cache) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementRemoved(Ehcache cache, net.sf.ehcache.Element element)
			throws net.sf.ehcache.CacheException {
		
		
	}

	@Override
	public void notifyElementPut(Ehcache cache, net.sf.ehcache.Element element) throws net.sf.ehcache.CacheException {
		LOG.info(element.getObjectValue().toString());
		
	}

	@Override
	public void notifyElementUpdated(Ehcache cache, net.sf.ehcache.Element element)
			throws net.sf.ehcache.CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementExpired(Ehcache cache, net.sf.ehcache.Element element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementEvicted(Ehcache cache, net.sf.ehcache.Element element) {
		// TODO Auto-generated method stub
		
	}
	
}