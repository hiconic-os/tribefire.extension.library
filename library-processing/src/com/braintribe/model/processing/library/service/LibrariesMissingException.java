// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package com.braintribe.model.processing.library.service;

import java.util.TreeSet;

public class LibrariesMissingException extends Exception {

	private static final long serialVersionUID = 1L;

	protected TreeSet<String> librariesMissing = new TreeSet<>();
	
	public LibrariesMissingException(TreeSet<String> librariesMissing) {
		super(buildMessage(librariesMissing));
		this.librariesMissing = librariesMissing;
	}
	
	public static String buildMessage(TreeSet<String> librariesMissing) {
		StringBuilder missing = new StringBuilder("Libraries missing or without license: ");
		boolean firstEntry = true;
		for (String m : librariesMissing) {
			if (!firstEntry) {
				missing.append(", ");
			} else {
				firstEntry = false;
			}
			missing.append(m);
		}
		return missing.toString();
	}

	public TreeSet<String> getLibrariesMissing() {
		return librariesMissing;
	}

}
