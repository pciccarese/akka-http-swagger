package com.perkinelmer.signals.project

import com.perkinelmer.signals.dataset.model.Dataset

class ProjectService() {

	def getProject(descriptorId: String): Project = {
		return new Project("x.1", "x", "mock project")
	}
}