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
package com.braintribe.model.library.service.vulnerabilities;

import com.braintribe.model.accessapi.AccessDataRequest;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.eval.EvalContext;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;
import com.braintribe.model.library.service.ArtifactReferences;
import com.braintribe.model.library.service.LibraryBaseRequest;
import com.braintribe.model.service.api.ServiceRequest;

public interface CheckVulnerabilities extends LibraryBaseRequest, AccessDataRequest, ArtifactReferences {

	final EntityType<CheckVulnerabilities> T = EntityTypes.T(CheckVulnerabilities.class);

	public final static String title = "title";
	public final static String reportFormat = "reportFormat";

	String getTitle();
	void setTitle(String title);

	@Initializer("enum(com.braintribe.model.library.service.vulnerabilities.ReportFormat,HTML)")
	ReportFormat getReportFormat();
	void setReportFormat(ReportFormat reportFormat);

	@Override
	EvalContext<? extends Vulnerabilities> eval(Evaluator<ServiceRequest> evaluator);

}
