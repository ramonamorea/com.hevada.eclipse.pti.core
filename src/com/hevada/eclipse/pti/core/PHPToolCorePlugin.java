/*******************************************************************************
 * Copyright (c) 2009, 2010 Sven Kiera
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package com.hevada.eclipse.pti.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class PHPToolCorePlugin extends AbstractPHPToolPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.hevada.eclipse.pti.core";

	public static final String IMG_PHPSRC = "IMG_PHPSRC";
	public static final String IMG_ACTIVITY = "IMG_ACTIVITY";
	public static final String IMG_OVERLAY_ERROR = "IMG_OVERLAY_ERROR";
	public static final String IMG_OVERLAY_WARNING = "IMG_OVERLAY_WARNING";
	public static final String IMG_IMAGE_FIT = "IMG_IMAGE_FIT";
	public static final String IMG_IMAGE_ORIGINAL = "IMG_IMAGE_ORIGINAL";
	public static final String IMG_IMAGE_ZOOM_IN = "IMG_IMAGE_ZOOM_IN";
	public static final String IMG_IMAGE_ZOOM_OUT = "IMG_IMAGE_ZOOM_OUT";

	// The shared instance
	private static PHPToolCorePlugin plugin;

	/**
	 * The constructor
	 */
	public PHPToolCorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	protected void initializeImageRegistry(ImageRegistry registry) {
		registry
				.put(IMG_PHPSRC, ImageDescriptor.createFromURL(resolvePluginResourceURL("icons/full/obj16/phpsrc.gif")));
		registry.put(IMG_ACTIVITY, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/obj16/activity.gif")));
		registry.put(IMG_OVERLAY_ERROR, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/ovr16/error_co.gif")));
		registry.put(IMG_OVERLAY_WARNING, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/ovr16/warning_co.gif")));
		registry.put(IMG_IMAGE_FIT, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/elcl16/image_fit.gif")));
		registry.put(IMG_IMAGE_ORIGINAL, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/elcl16/image_original.gif")));
		registry.put(IMG_IMAGE_ZOOM_IN, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/elcl16/image_zoomin.gif")));
		registry.put(IMG_IMAGE_ZOOM_OUT, ImageDescriptor
				.createFromURL(resolvePluginResourceURL("icons/full/elcl16/image_zoomout.gif")));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static PHPToolCorePlugin getDefault() {
		return plugin;
	}

	public IPath[] getPluginIncludePaths(IProject project) {
		return new IPath[0];
	}

	/**
	 * Returns the active workbench window
	 * 
	 * @return the active workbench window
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}

	/**
	 * Returns the active workbench shell or <code>null</code> if none
	 * 
	 * @return the active workbench shell or <code>null</code> if none
	 */
	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}
}