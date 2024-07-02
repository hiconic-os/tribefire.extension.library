// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
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
package com.braintribe.model.processing.library.service.expert;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.braintribe.logging.Logger;
import com.braintribe.utils.StringTools;

public class LibraryTools {

	private final static Logger logger = Logger.getLogger(LibraryTools.class);

	public static TreeSet<String> splitDependencyList(Set<String> ownLibraryGroups, List<String> dependencyList) {
		TreeSet<String> dependencySet = new TreeSet<>();
		for (String listItem : dependencyList) {
			if (!StringTools.isEmpty(listItem)) {
				List<String> linesList = StringTools.getLines(listItem);
				for (String line : linesList) {
					if (!StringTools.isEmpty(line)) {
						String[] parts = StringTools.splitSemicolonSeparatedString(line, true);
						if (parts != null) {
							for (String part : parts) {
								if (!StringTools.isEmpty(part)) {
									boolean ownLib = false;
									if (ownLibraryGroups != null) {
										for (String own : ownLibraryGroups) {
											if (part.startsWith(own)) {
												ownLib = true;
												break;
											}
										}
									}
									if (!ownLib) {
										dependencySet.add(part);
									} else {
										logger.debug(() -> "Ignoring library " + part);
									}
								}
							}
						}
					}
				}
			}
		}
		return dependencySet;
	}
}
