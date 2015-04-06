/*
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.mobile.screens.viewsets.defaultviews;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;

import com.liferay.mobile.screens.viewsets.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * @author Javier Gamarra
 */
public class DefaultCrouton {

	public static int POSITION = android.R.id.content;
	public static Style INFO = new Style.Builder().setBackgroundColor(R.color.default_light_blue).build();
	public static Style ALERT  = new Style.Builder().setBackgroundColor(R.color.default_red).build();

	//FIXME this is wrong
	public static void error(Context context, String message, Exception e) {
		String error = message;
		if (e instanceof IllegalArgumentException) {
			//TODO create validation exception
			error = e.getMessage();
		}
		Activity activity = getContextFromActivity(context);


		Crouton.showText(activity, error, ALERT, POSITION);
	}

	public static void info(Context context, String message) {
		Activity activity = getContextFromActivity(context);
		Crouton.showText(activity, message, INFO, POSITION);
	}

	protected static Activity getContextFromActivity(Context context) {
		if (context instanceof Activity) {
			return (Activity) context;
		}
		else {
			Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
			return (Activity) baseContext;
		}
	}

	public static void initDefaultCroutonStyles(Style info, Style alert, Integer position) {
		if (info != null) {
			INFO = info;
		}
		if (alert != null) {
			ALERT = alert;
		}
		if (position != null) {
			POSITION = position;
		}
	}

}
