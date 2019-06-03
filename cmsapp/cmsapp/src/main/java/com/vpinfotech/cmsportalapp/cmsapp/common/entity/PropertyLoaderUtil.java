package com.vpinfotech.cmsportalapp.cmsapp.common.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyLoaderUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertyLoaderUtil.class);
	/**
	 * Loads a String property from the given property file. 
	 * Returns empty null and logs error to console in case of exceptions.
	 * 
	 * @param propertiesFileName
	 *            the tenant whose properties bundle should be used
	 * @return Properties of the provided propertiesFileName
	 */
	public static Properties getProperties(String propertiesFileName) {

			InputStream propsIn = null;
			Properties props = new Properties();

			try {
				propsIn = PropertyLoaderUtil.class.getClassLoader().getResourceAsStream(propertiesFileName);
				props.load(propsIn);
			} catch (IOException e) {
				logger.error("Could not load properties file " + propertiesFileName + ".");
				e.printStackTrace();
			} finally {
				if (propsIn != null) {
					try {
						propsIn.close();
					} catch (IOException e) {
						logger.warn("Could not close stream of properties file " + propertiesFileName + ".");
						e.printStackTrace();
					}
				}
			}
			
			return props;
	}
}
