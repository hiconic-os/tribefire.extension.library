// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package com.braintribe.model.library.service;

import com.braintribe.model.accessapi.AccessDataRequest;
import com.braintribe.model.generic.annotation.meta.Confidential;
import com.braintribe.model.generic.eval.EvalContext;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;
import com.braintribe.model.service.api.ServiceRequest;

public interface SetupLibraryEnvironment extends LibraryBaseRequest, AccessDataRequest {

	final EntityType<SetupLibraryEnvironment> T = EntityTypes.T(SetupLibraryEnvironment.class);
	
	public final static String environment = "environment";

	void setEnvironment(Environment environment);
	Environment getEnvironment();
	
	void setDatabasePassword(String databasePassword);
	@Confidential
	String getDatabasePassword();
	
	@Override
	EvalContext<? extends SetupLibraryEnvironmentResult> eval(Evaluator<ServiceRequest> evaluator);

}
