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
package tribefire.extension.library.initializer.wire.contract;

import java.util.Set;

import com.braintribe.model.accessdeployment.IncrementalAccess;
import com.braintribe.model.ddra.DdraMapping;
import com.braintribe.model.deployment.database.pool.HikariCpConnectionPool;
import com.braintribe.model.deployment.resource.sql.SqlBinaryProcessor;
import com.braintribe.model.extensiondeployment.meta.BinaryProcessWith;
import com.braintribe.model.extensiondeployment.meta.ProcessWith;
import com.braintribe.model.library.deployment.service.LibraryService;
import com.braintribe.wire.api.space.WireSpace;

import tribefire.extension.job_scheduling.deployment.model.JobScheduling;

public interface LibraryInitializerModuleContract extends WireSpace {

	HikariCpConnectionPool dbConnector();

	SqlBinaryProcessor sqlBinaryProcessor();

	IncrementalAccess libraryAccess();

	LibraryService libraryService();

	BinaryProcessWith binaryProcessWith();
	ProcessWith processWith();

	Boolean isDbAccess();

	void metaData();

	JobScheduling updateNvdMirrorScheduledJob();

	Set<DdraMapping> ddraMappings();

}
